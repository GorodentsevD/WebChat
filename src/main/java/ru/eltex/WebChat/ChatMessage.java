package ru.eltex.WebChat;

import org.springframework.data.annotation.Id;

import java.util.Date;

/**
 * Класс {@code ChatMessage} описывает модель сообщения
 * @author Aleksey Gromov
 * */

public class ChatMessage {
    @Id
    private String id;

    private String text;
    private String author;
    private Date createDate;

// блок кода из старого класса, оставил, тк в WebSocketEventListener у сообщения просится тип

    public enum MessageType {
        CHAT,
        JOIN,
        LEAVE
    }

    private MessageType type;

    public MessageType getType() {
        return type;
    }

    public void setType(MessageType type) {
        this.type = type;
    }

//конец блока

    public ChatMessage() {
    }

    public ChatMessage(String text, String author, Date createDate) {
        this.text = text;
        this.author = author;
        this.createDate = createDate;
    }



    public String getAuthor() { return author; }

    public void setAuthor(String author) { this.author = author; }


/* неиспользуемые методы (для работы с БД?)

    public String getText() { return text; }

    public void setText(String text) { this.text = text; }

    public Date getCreateDate() { return createDate; }

    public void setCreateDate(Date createDate) { this.createDate = createDate; }

    @Override
    public String toString() {
        return "{" +
                "\"id\":\"" + id + '\"' +
                ",\"text\":\"" + text + '\"' +
                ",\"author\":\"" + author + '\"' +
                ",\"createDate\":\"" + createDate + "\"" +
                '}';
    }
*/

}