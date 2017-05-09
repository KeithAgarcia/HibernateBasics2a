package com.theironyard.charlotte;

import javax.persistence.*;

/**
 * Created by Keith on 5/9/17.
 */
@Entity
@Table(name = "messages")
public class Message {
    @Id
    @GeneratedValue
    private int id;


    @Column(nullable = false)
    private String messageText;

    public Message(){

    }


    public Message(String messageText) {
        this.messageText = messageText;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }
}