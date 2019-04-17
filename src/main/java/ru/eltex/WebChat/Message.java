package ru.eltex.WebChat;

/**
 * Класс {@code ChatMessageModel} формирует сообщение
 * @author Дмитрий Городенцев
 * */

public class Message {

    private String message;

    public Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
