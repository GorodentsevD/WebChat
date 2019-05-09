package ru.eltex.WebChat.model;

import lombok.*;
import javax.persistence.*;
import java.util.Date;

/**
 * Класс ChatMessageModel описывает модель сообщения
 * */

@Entity
@NoArgsConstructor
@Data
public class ChatMessageModel {

    /** Идентификатор сообщения */
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    public Integer id;

    /** Текст сообщения */
    @NonNull private String text;

    /** Атор сообщения */
    @NonNull private String author;

    /** Дата отправки сообщения */
    @NonNull private Date createDate;

    /** Тип сообщения */
    @NonNull private String type;

    /**
     * Конструктор - создание нового объекта(сообщения) с определенными значениями
     * @param text - текст сообщения
     * @param author - автор сообщения
     * @param createDate - дата отправки сообшения
     * @param type - тип сообщения
     * */
    public ChatMessageModel(String text, String author, Date createDate, String type) {
        this.text = text;
        this.author = author;
        this.createDate = createDate;
        this.type = type;
    }

    @Override
    public String toString() {
        return "[{" +
                "\"id\":\"" + getId() + '\"' +
                ",\"text\":\"" + getText() + '\"' +
                ",\"author\":\"" + getAuthor() + '\"' +
                ",\"createDate\":\"" + getCreateDate() + "\"" +
                ",\"type\":\"" + getType() + "\"" +
                "}]";
    }
}