package ru.eltex.WebChat.model;

import lombok.*;
import javax.persistence.*;
import java.util.Date;

/**
 * Класс {@code ChatMessageModel} описывает модель сообщения
 * @author Дмитрий Городенцев
 * */

@Entity
@NoArgsConstructor
@Data
public class ChatMessageModel {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    public Integer id;

    @NonNull private String text;
    @NonNull private String author;
    @NonNull private Date createDate;
    @NonNull private String type;

    public ChatMessageModel(String text, String author, Date createDate, String type) {
        this.text = text;
        this.author = author;
        this.createDate = createDate;
        this.type = type;
    }



    @Override
    public String toString() {
        return "[{" +
                "\"id\":\"" + id + '\"' +
                ",\"text\":\"" + text + '\"' +
                ",\"author\":\"" + author + '\"' +
                ",\"createDate\":\"" + createDate + "\"" +
                ",\"type\":\"" + type + "\"" +
                "}]";
    }
}