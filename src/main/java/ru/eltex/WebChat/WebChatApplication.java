package ru.eltex.WebChat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebChatApplication {
	public static void main(String[] args) {
		SpringApplication.run(WebChatApplication.class, args);
	}
}

/**
 * TODO LIST:
 *  1) нормальный css
 *  2) обработчик событий конекта и дизконекта
 *  4) WebSecurity
 *  5) Show History
 *  6*) редактирование, удаление сообщения
 *  7*) отправка картинок
 */