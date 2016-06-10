package com.dianwuyou.repo;

import com.dianwuyou.model.User;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 * Created by hebowei on 16/6/10.
 */
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
}
