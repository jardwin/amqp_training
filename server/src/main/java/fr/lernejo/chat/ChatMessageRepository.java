package fr.lernejo.chat;

import java.util.ArrayDeque;
import java.util.List;

public class ChatMessageRepository {
    private ArrayDeque<String> registry = new ArrayDeque<String>(10);
    public void addChatMessage(String message){
        if (registry.size() == 10){
            registry.removeLast();
        }
        registry.addFirst(message);
    }
    public List<String> getLastTenMessages(){
        return registry.stream().toList();
    }
}
