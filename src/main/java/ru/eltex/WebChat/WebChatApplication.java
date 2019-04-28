package ru.eltex.WebChat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.eltex.WebChat.model.ChatMessageModel;

@SpringBootApplication
public class WebChatApplication {
	public static void main(String[] args) { SpringApplication.run(WebChatApplication.class, args); }
}

/**
 * TODO LIST:
 * 	1) Придумать что-то с обновлением страницы. Варианты: заблочить обновление страницы, to be continued
 *  2) Show History написать отдельную страницу, или оставить все как есть
 *  3) Покрыть тестами
 *  4) Аннотации
 *  
 *  Если останется время
 *  1) WebSecurity
 *  2) Заюзать ajax?
 *  3****) редактирование, удаление сообщения
 *  4****) отправка картинок
 */