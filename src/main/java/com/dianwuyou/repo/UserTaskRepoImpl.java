package com.dianwuyou.repo;

import com.dianwuyou.model.UserTask;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by hebowei on 16/7/14.
 */
@Repository("userTaskRepo")
public class UserTaskRepoImpl extends AbstractDao<Integer, UserTask> implements UserTaskRepository {
    public UserTask getById(int id) {
        return getByKey(id);
    }

    public void save(UserTask userTask) {
        persist(userTask);
    }

    public void update(UserTask userTask) {
        saveOrUpdate(userTask);
    }

    /**
     *
     * @param userId
     * @param page page starts from 0
     * @param itemsPerPage
     * @return
     */
    public List<UserTask> getUserTasks(int userId, int page, int itemsPerPage) {
        List<UserTask> userTasks = createEntityCriteria()
                .add(Restrictions.eq("userId", userId))
                .setFirstResult(page * itemsPerPage)
                .setMaxResults(itemsPerPage)
                .addOrder(Order.desc("id")).list();
        return userTasks;
    }
}
