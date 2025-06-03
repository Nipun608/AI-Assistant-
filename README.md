<h1 align="center">🤖 AI Assistant</h1>
<p align="center"><b>A Spring Boot-Based AI Assistant integrating OpenAI API</b></p>

<p align="center">
  <img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white"/>
  <img src="https://img.shields.io/badge/SpringBoot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white"/>
  <img src="https://img.shields.io/badge/OpenAI-412991?style=for-the-badge&logo=openai&logoColor=white"/>
  <img src="https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white"/>
</p>

---

AI Assistant is a backend project built with **Spring Boot** that connects to the **OpenAI API** to provide intelligent, AI-driven responses. Designed as a modular and scalable RESTful service, it demonstrates integrating external AI models in Java.

---

### 🔧 Technologies Used

| Tool | Description |
|------|-------------|
| 💻 **Java 17+** | Core programming language |
| 🌱 **Spring Boot** | Application framework and dependency injection |
| 🤖 **OpenAI API** | AI text generation and assistant features |
| 📦 **Maven** | Project build and dependency management |

---

### 💡 Features

- 🤖 Integration with OpenAI API for AI responses  
- ⚙️ RESTful endpoint(s) to ask questions or send prompts  
- 🔐 Configuration management via `application.properties` (keep secrets out of version control!)  
- 🧱 Modular Java service structure with clear separation of concerns  

---

### 📦 How It Works

```text
1. Client sends a request to the REST API with a prompt.
2. Spring Boot backend forwards the prompt to the OpenAI API.
3. The AI processes and returns a response.
4. Backend returns the AI-generated response to the client.
