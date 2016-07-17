package com.dianwuyou.repo;

import com.dianwuyou.model.UserTask;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.Calendar;
import java.util.Date;
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

    /**
     * 统计一个月内用户申领某商家任务的次数
     * @param userId
     * @param taskOwnerId
     * @return
     */
    public int getUserTaskOwnerCoOccuranceCount(int userId, int taskOwnerId) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -1);

        return (Integer)createEntityCriteria().add(Restrictions.eq("userId", userId))
                .add(Restrictions.eq("taskOwnerId", taskOwnerId))
                .add(Restrictions.ge("claimDate", calendar.getTime()))
                .setProjection(Projections.rowCount())
                .uniqueResult();
    }

    /**
     * 当日(24h内)用户接单数量
     * @param userId
     * @return
     */
    public int getUserTaskCountToday(int userId) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1);
        Date yesterday = calendar.getTime();

        return (Integer)createEntityCriteria().add(Restrictions.eq("userId", userId))
                .add(Restrictions.gt("claimDate", yesterday))
                .setProjection(Projections.rowCount())
                .uniqueResult();
    }
}
