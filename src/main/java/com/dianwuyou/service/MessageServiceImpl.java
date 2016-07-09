package com.dianwuyou.service;

import com.dianwuyou.model.Message;
import com.dianwuyou.repo.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by hebowei on 16/7/9.
 */
@Transactional
@Service("messageService")
public class MessageServiceImpl implements MessageService{
    int NUM_MESSAGE_PER_PAGE = 20;  //Retrieve 20 messages on each page

    @Autowired
    MessageRepository messageRepository;

    public Message getById(int id) {
        return messageRepository.getById(id);
    }

    public List<Message> getByReceiver(int receiverId, int page) {
        return messageRepository.getPagedMessages(receiverId, page, NUM_MESSAGE_PER_PAGE);
    }

    public void setRead(Message message) {
        message.setRead(true);
        messageRepository.updateMessage(message);
    }

    public void delete(Message message) {
        messageRepository.deleteMessage(message);
    }

    public void save(Message message) {
        messageRepository.saveMessage(message);
    }

    public long getPageCount(int receiverId) {
        return (messageRepository.getMessageCount(receiverId) - 1)/ (long)NUM_MESSAGE_PER_PAGE + 1;
    }
}
