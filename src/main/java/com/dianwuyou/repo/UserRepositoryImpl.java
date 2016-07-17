package com.dianwuyou.repo;

import com.dianwuyou.model.Task;
import com.dianwuyou.model.User;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

/**
 * Created by hebowei on 16/6/10.
 */
@Transactional
@Repository("userRepo")
public class UserRepositoryImpl extends AbstractDao<Integer, User> implements UserRepository{
    public User getById(int id) {
        return getByKey(id);
    }

    public User getByEmail(String email) {
        return (User)createEntityCriteria()
                .add(Restrictions.eq("email", email))
                .uniqueResult();
    }

    public void saveUser(User user) {
        persist(user);
    }

    public void updateUser(User user){
        saveOrUpdate(user);
    }

    public User getByInviteCode(String inviteCode) {
        return (User)createEntityCriteria()
                .add(Restrictions.eq("inviteCode", inviteCode))
                .uniqueResult();
    }

    @Deprecated
    public List<User> getEligibleForTask(Task task, Map<String, ?> otherEqCriteria) {
        Criteria criteria = createEntityCriteria()
                .add(Restrictions.eq("type", User.USERTYPE_WORKER))
                .add(Restrictions.eq("userValidationState", User.VERIFY_STATE_SUCCEEDED))
                .add(Restrictions.eq("taobaoRank", task.getBuyerRank()));
        if(otherEqCriteria != null)
            criteria.add(Restrictions.allEq(otherEqCriteria));
        return criteria.list();
    }

    public List<User> getEligibleUsers(Task task){
        String queryString = "from User as user where user.id not in " +
                "(select usertask.userId from UserTask as usertask where " +
                "usertask.taskOwnerId!=:ownerId and usertask.claimDate>=:claimDate)" +
                "and user.type=1 and user.taobaoRank=:tbRank and user.userValidationState=2" +
                "and user.age<=:ageMax and user.age>=:ageMin";
        if(task.getBuyerGender() != null){
            queryString += " and user.gender=:gender";
        }
        if(task.getBuyerLocation() != null){
            queryString += " and user.province=:location";
        }

        Query query = getSession().createQuery(queryString);
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -1);
        query.setDate("claimDate", calendar.getTime());
        query.setInteger("ownerId", task.getOwnerId());
        query.setInteger("tbRank", task.getBuyerRank());
        if(task.getBuyerGender() != null)
            query.setString("gender", task.getBuyerGender());
        if(task.getBuyerLocation() != null)
            query.setString("location", task.getBuyerLocation());
        int ageMin = 0, ageMax = 150;
        if(task.getBuyerAgeLow() != null)
            ageMin = task.getBuyerAgeLow();
        if(task.getBuyerAgeHigh() != null)
            ageMax = task.getBuyerAgeHigh();
        query.setInteger("ageMin", ageMin);
        query.setInteger("ageMax", ageMax);

        return query.list();
    }
}
