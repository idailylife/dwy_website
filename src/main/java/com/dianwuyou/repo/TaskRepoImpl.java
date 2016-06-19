package com.dianwuyou.repo;

import com.dianwuyou.model.Task;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by hebowei on 16/6/19.
 */
@Transactional
@Repository("taskRepository")
public class TaskRepoImpl extends AbstractDao<Integer, Task> implements TaskRepository{
    public Task getTaskById(int id) {
        return getByKey(id);
    }

    @SuppressWarnings("unchecked")
    public List<Task> getByIds(List<Integer> ids) {
        Query query = getSession().createQuery("FROM Tasks WHERE id IN (:ids)");
        query.setParameterList("ids", ids);
        return query.list();
    }

    @SuppressWarnings("unchecked")
    public List<Task> getByOwnerId(int ownerId) {
        return createEntityCriteria().add(Restrictions.eq("ownerId", ownerId))
                .list();
    }

    public List<Task> getPagedTasks(int pageNo, int pageSize){
        return getPagedTasks(pageNo, pageSize, false);
    }

    @SuppressWarnings("unchecked")
    public List<Task> getPagedTasks(int pageNo, int pageSize, boolean showFutureTasks) {
        Criteria criteria =  createEntityCriteria().addOrder(Order.desc("id"))
                .setFirstResult(pageNo * pageSize)
                .setMaxResults(pageSize);
        if(!showFutureTasks){
            Date date = new Date();
            criteria.add(Restrictions.le("startTime", date));
        }
        return criteria.list();
    }

    public void saveTask(Task task) {
        persist(task);
    }

    public void updateTask(Task task) {
        saveOrUpdate(task);
    }

    public void deleteTaskById(int id) {
        Query query = getSession().createSQLQuery("DELETE FROM Task WHERE id= :id");
        query.setInteger("id", id);
        query.executeUpdate();
    }

    public Long getTaskCount() {
        return (Long) createEntityCriteria().setProjection(Projections.rowCount()).uniqueResult();
    }
}
