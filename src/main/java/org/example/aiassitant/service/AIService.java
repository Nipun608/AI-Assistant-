package org.example.aiassitant.service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONObject;

public class AIService {

   private final String OPENAI_API_KEY = "your-openai-api-key";
//    @Value("${openai.api.key}")
//    private String OPENAI_API_KEY;

    public String getAIResponse(String prompt) {
        try {
            HttpClient client = HttpClient.newHttpClient();

            // Build JSON body for chat completion
            JSONObject messageUser = new JSONObject()
                    .put("role", "user")
                    .put("content", prompt);

            JSONArray messages = new JSONArray()
                    .put(new JSONObject()
                            .put("role", "system")
                            .put("content", "You are a helpful assistant."))
                    .put(messageUser);

            JSONObject requestBody = new JSONObject()
                    .put("model", "gpt-3.5-turbo")
                    .put("messages", messages);

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://api.openai.com/v1/chat/completions"))
                    .header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + OPENAI_API_KEY)
                    .POST(HttpRequest.BodyPublishers.ofString(requestBody.toString()))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            String responseBody = response.body();

            JSONObject responseJson = new JSONObject(responseBody);

            // Check for API errors
            if (responseJson.has("error")) {
                String errorMessage = responseJson.getJSONObject("error").getString("message");
                throw new RuntimeException("OpenAI API Error: " + errorMessage);
            }

            // Parse the assistant's reply
            JSONArray choices = responseJson.getJSONArray("choices");
            String aiReply = choices.getJSONObject(0)
                    .getJSONObject("message")
                    .getString("content");

            return aiReply.trim();

        } catch (Exception e) {
            throw new RuntimeException("Failed to get AI response", e);
        }
    }
}
