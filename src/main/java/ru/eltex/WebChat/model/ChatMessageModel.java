package ru.eltex.WebChat.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Класс {@code ChatMessageModel} описывает модель сообщения
 * @author Дмитрий Городенцев
 * */

@Entity
public class ChatMessageModel {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String text;
    private String author;
    private Date createDate;

    public ChatMessageModel() {}

    public ChatMessageModel(String text, String author, Date createDate) {
        this.text = text;
        this.author = author;
        this.createDate = createDate;
    }

    public String getAuthor() { return author; }

    public void setAuthor(String author) { this.author = author; }

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
}