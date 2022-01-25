package fr.lernejo.chat;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

@SpringBootApplication
public class Launcher {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Launcher.class);
        RabbitTemplate publisher = context.getBean(RabbitTemplate.class);

        Scanner in = new Scanner(System.in);
        while (true){
            System.out.print("Input a message, we will sent it for you (q for quit) \n");
            String input = in.nextLine();
            if(input.equals("q")){
                System.out.print("Bye");
                break;
            }
            publisher.convertAndSend("chat_messages", input);
        }
    }
}
