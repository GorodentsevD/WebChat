package ru.eltex.WebChat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebChatApplication {
	public static void main(String[] args) {
		SpringApplication.run(WebChatApplication.class, args);
	}
}

/**TODO LIST:
 * 1) css
 * 2) для удобства разбить index.html на login.html и chat.html
 * 3) аннотации на main.js и chatController, прописать @version
 * 4) mysql/mongodb
 * 5) websecurity
 * * */