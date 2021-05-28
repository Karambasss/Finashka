package com.example.sweater2.domain;

import javax.persistence.*;

@Entity //Cущность
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // сам будет генерить
    private Integer id;
    private String text;
    private String tag;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;

    /**
     * <p>Это кноструктор</p>
     * @param text текст
     * @param tag тэг
     * @param user пользователь
     */
    public Message(String text,String tag, User user){
        this.author = user;
        this.text = text;
        this.tag = tag;
    }

    public Message(){

    }

    public String getAuthorName(){
        return author != null ? author.getUsername() : "<none>";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
}
