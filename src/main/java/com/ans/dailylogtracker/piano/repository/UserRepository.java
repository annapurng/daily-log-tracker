package com.ans.dailylogtracker.piano.repository;

import com.ans.dailylogtracker.piano.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String>{
    public User findByUserId(String userId);

    public User deleteByUserId(String userId);
}
