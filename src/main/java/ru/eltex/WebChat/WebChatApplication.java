package ru.eltex.WebChat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebChatApplication {
	public static void main(String[] args) {
		SpringApplication.run(WebChatApplication.class, args);
	}
}

//TODO:  1) подправить css
//TODO:	 2) WebSecutiry
//TODO:  3) Show History
//TODO:  4*) редактирование сообщения
//TODO:  5) Исправить баг с отправкой пустых сообщений | DONE