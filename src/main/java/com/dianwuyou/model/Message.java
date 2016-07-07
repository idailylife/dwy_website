package com.dianwuyou.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;

/**
 * Created by hebowei on 16/7/7.
 */
@Entity
@Table(name = "message")
public class Message {
    public static final int TYPE_SYSTEM_MSG = 0;    //系统消息
    public static final int TYPE_NEW_TASK = 1;      //新任务
    public static final int TYPE_USER_MESSAGE = 2;  //用户消息

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Integer id;

    @Column(name = "senderId")
    private Integer senderId;     //null as system message

    @Column(name = "receiverId", nullable = false)
    private Integer receiverId;

    @Column(name = "type", nullable = false)
    private Integer type;

    @Column(name = "content")
    private String content;

    @Column(name = "href")
    private String href;

    @Column(name = "read")
    @Type(type = "yes_no")
    private Boolean read;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public Integer getSenderId() {
        return senderId;
    }

    public void setSenderId(Integer senderId) {
        this.senderId = senderId;
    }

    public Integer getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Integer receiverId) {
        this.receiverId = receiverId;
    }

    public Boolean getRead() {
        return read;
    }

    public void setRead(Boolean read) {
        this.read = read;
    }
}
