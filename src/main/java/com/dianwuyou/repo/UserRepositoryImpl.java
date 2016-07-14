package com.dianwuyou.repo;

import com.dianwuyou.model.Task;
import com.dianwuyou.model.User;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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

    public List<User> getEligibleForTask(Task task, Map<String, ?> otherEqCriteria) {
        Criteria criteria = createEntityCriteria()
                .add(Restrictions.eq("type", User.USERTYPE_WORKER))
                .add(Restrictions.eq("userValidationState", User.VERIFY_STATE_SUCCEEDED))
                .add(Restrictions.eq("taobaoRank", task.getBuyerRank()));
        if(otherEqCriteria != null)
            criteria.add(Restrictions.allEq(otherEqCriteria));
        return criteria.list();
    }
}
