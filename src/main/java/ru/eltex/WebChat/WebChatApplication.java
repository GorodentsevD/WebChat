package ru.eltex.WebChat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.eltex.WebChat.model.ChatMessageModel;

/**
 * Cтартовый класс приложения
 */

@SpringBootApplication
public class WebChatApplication {
	public static void main(String[] args) { SpringApplication.run(WebChatApplication.class, args); }
}