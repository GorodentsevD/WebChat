package ru.eltex.WebChat.model;

import lombok.*;
import javax.persistence.*;
import java.util.Date;

/**
 * Класс {@code ChatMessageModel} описывает модель сообщения
 * @author Дмитрий Городенцев
 * */

@Entity
@Data
@NoArgsConstructor
public class ChatMessageModel {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    public Integer id;

    @NonNull private String text;
    @NonNull private String author;
    @NonNull private Date createDate;

    public ChatMessageModel(String text, String author, Date createDate) {
        this.text = text;
        this.author = author;
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "[{" +
                "\"id\":\"" + id + '\"' +
                ",\"text\":\"" + text + '\"' +
                ",\"author\":\"" + author + '\"' +
                ",\"createDate\":\"" + createDate + "\"" +
                "}]";
    }
}