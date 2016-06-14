package com.dianwuyou.repo;

import com.dianwuyou.model.User;

/**
 * Created by hebowei on 16/6/10.
 */
public interface UserRepository {
    User getById(int id);
    User getByEmail(String email);
    void saveUser(User user);
    void updateUser(User user);
}
