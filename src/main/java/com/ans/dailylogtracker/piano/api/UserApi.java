package com.ans.dailylogtracker.piano.api;

import com.ans.dailylogtracker.piano.model.User;

import java.util.List;

public interface UserApi {
    User createUser(User user);
    User updateUser(User user);
    User getUser(String userId);
    List<User> getUsers();
    void deleteUser(String userId);

}
