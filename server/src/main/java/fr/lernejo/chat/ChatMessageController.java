package fr.lernejo.chat;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ChatMessageController {
    private ChatMessageRepository repository;

    public ChatMessageController(ChatMessageRepository repo){
        repository = repo;
    }

    @GetMapping("/api/message")
    public List<String> GetLastMessage(){
        return repository.getLastTenMessages();
    }

}
