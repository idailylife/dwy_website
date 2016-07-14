package com.dianwuyou.repo;

import com.dianwuyou.model.Message;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by hebowei on 16/7/9.
 */
@Transactional
@Repository("messageRepository")
public class MessageRepoImpl extends AbstractDao<Integer, Message> implements MessageRepository {
    public Message getById(int id) {
        return getByKey(id);
    }

    public void updateMessage(Message message) {
        saveOrUpdate(message);
    }

    public void saveMessage(Message message) {
        persist(message);
    }

    public void deleteMessage(Message message) {
        delete(message);
    }

    /**
     *
     * @param receiverId id of receiver
     * @param page page number starts from 1
     * @param pageSize size of items to fetch per page
     * @return
     */
    public List<Message> getPagedMessages(int receiverId, int page, int pageSize) {
        return getPagedMessages(receiverId, page, pageSize, true);
    }

    public long getMessageCount(int receiverId) {
        return (Long) createEntityCriteria().add(Restrictions.eq("receiverId", receiverId))
                .setProjection(Projections.rowCount())
                .uniqueResult();
    }

    public List<Message> getPagedMessages(int receiverId, int page, int pageSize, boolean getNormal) {
        Criteria criteria = createEntityCriteria()
                .add(Restrictions.eq("receiverId", receiverId))
                .addOrder(Order.desc("id"))
                .setFirstResult((page - 1)*pageSize)
                .setMaxResults(pageSize);
        if(getNormal){
            criteria.add(Restrictions.ne("type", Message.TYPE_NEW_TASK));
        } else {
            criteria.add(Restrictions.eq("type", Message.TYPE_NEW_TASK));
        }
        return criteria.list();
    }
}
