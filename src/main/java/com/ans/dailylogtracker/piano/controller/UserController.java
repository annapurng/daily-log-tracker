package com.ans.dailylogtracker.piano.controller;

import com.ans.dailylogtracker.piano.exception.LogTrackerException;
import com.ans.dailylogtracker.piano.repository.UserRepository;
import com.ans.dailylogtracker.piano.utils.PracticeDateHelpers;
import com.ans.dailylogtracker.piano.api.UserApi;
import com.ans.dailylogtracker.piano.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.time.DayOfWeek;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController implements UserApi {

    @Autowired
    private UserRepository userRepository;

    @Override
    @PostMapping(produces="application/json", consumes="application/json")
    public User createUser(@RequestBody User user) {
        validate(user);
        user.setDateJoined(PracticeDateHelpers.todaysDate());
        user.setLastLoginTime(PracticeDateHelpers.timeNow());
        if (user.getLogStartDay() == null) {
            user.setLogStartDay(DayOfWeek.SATURDAY);
        }
        if (user.getProgram() == null ||
                user.getLevel() == null) {
            throw new LogTrackerException("Incomplete User Object");
        }
        return userRepository.save(user);
    }

    @Override
    @PutMapping(value="/{userId}", produces="application/json", consumes = "application/json")
    public User updateUser(User user) {
        validate(user);
        return userRepository.save(user);
    }

    @Override
    @GetMapping(value="/{userId}", produces="application/json")
    public User getUser(@PathVariable String userId) {
        return userRepository.findByUserId(userId);
    }

    @Override
    @GetMapping(produces ="application/json")
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUser(@PathVariable String userId) {
        userRepository.deleteByUserId(userId);
    }

    private void validate(User user) {
        if((StringUtils.isEmpty(user.getFirstName()))
                || StringUtils.isEmpty(user.getLastName())
                || StringUtils.isEmpty(user.getUserId())
                || StringUtils.isEmpty(user.getProgram())
                || StringUtils.isEmpty(user.getLevel())) {
            throw new IllegalArgumentException("User object is not valid");
        }
    }

}
