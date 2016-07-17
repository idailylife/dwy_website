package com.dianwuyou.repo;

import com.dianwuyou.model.Task;
import com.dianwuyou.model.User;

import javax.validation.constraints.DecimalMax;
import java.util.List;
import java.util.Map;

/**
 * Created by hebowei on 16/6/10.
 */
public interface UserRepository {
    User getById(int id);
    User getByEmail(String email);
    User getByInviteCode(String inviteCode);
    void saveUser(User user);
    void updateUser(User user);
    @Deprecated
    List<User> getEligibleForTask(Task task, Map<String, ?> otherEqCriteria);
    List<User> getEligibleUsers(Task task);
}
