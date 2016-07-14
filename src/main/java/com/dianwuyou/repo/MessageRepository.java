package com.dianwuyou.repo;

import com.dianwuyou.model.Message;

import java.util.List;

/**
 * Created by hebowei on 16/7/7.
 */
public interface MessageRepository {
    Message getById(int id);
    List<Message> getPagedMessages(int receiverId, int page, int pageSize);
    List<Message> getPagedMessages(int receiverId, int page, int pageSize, boolean getNormal);
    void updateMessage(Message message);
    void saveMessage(Message message);
    void deleteMessage(Message message);
    long getMessageCount(int receiverId);
}
