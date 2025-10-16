package cs544.schedule.controller;


import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {


    @Autowired
    private ChatClient chatClient;

    @GetMapping("/chat")
    public String getResponse(@RequestParam String prompt) {

       ChatResponse response = chatClient.prompt(prompt).call().chatResponse();

        // Return the output text
        return response.getResult().getOutput().getText();
    }
}
