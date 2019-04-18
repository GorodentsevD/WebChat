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
 *  2) фикс того, что новый юзер видит всю историю сообщений
 *  3) обработчик событий конекта и дизконекта
 * */

//TODO:	 4) WebSecutiry
//TODO:  5) Show History
//TODO:  6*) редактирование сообщения