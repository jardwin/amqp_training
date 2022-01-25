package fr.lernejo.chat;

import org.springframework.stereotype.Component;

@Component
public class ChatMessageListener {
    private ChatMessageRepository repository;

    public ChatMessageListener(ChatMessageRepository repo){
        repository = repo;
    }

    public void onMessage(String message){
        repository.addChatMessage(message);
    }

}
