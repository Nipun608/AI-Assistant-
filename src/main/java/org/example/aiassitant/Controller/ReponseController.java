package org.example.aiassitant.Controller;

import org.example.aiassitant.DTO.AIRequest;
import org.example.aiassitant.service.AIService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ReponseController {

    private final AIService aiService = new AIService();

    @PostMapping("/api/ai/ask")
    public String ask(@RequestBody AIRequest request) {
        String prompt = request.getQuestion();
        if (prompt == null || prompt.isEmpty()) {
            return "Please provide a question.";
        }
        return aiService.getAIResponse(prompt);
    }

}
