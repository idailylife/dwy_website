package com.dianwuyou.service;

import com.dianwuyou.model.Message;

import java.util.List;

/**
 * Created by hebowei on 16/7/9.
 */
public interface MessageService {


    Message getById(int id);
    List<Message> getByReceiver(int receiverId, int page);
    void setRead(Message message);
    void delete(Message message);
    void save(Message message);
    long getPageCount(int receiverId);
}
