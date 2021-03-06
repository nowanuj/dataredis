package com.nowanuj.dataredis.dataredis.respo;

import com.nowanuj.dataredis.dataredis.model.User;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import javax.jws.soap.SOAPBinding;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepoImpl implements UserRepo{

    private RedisTemplate<String, User> redisTemplate;

    private HashOperations hashOperations;

    public UserRepoImpl(RedisTemplate<String, User> redisTemplate) {
        this.redisTemplate = redisTemplate;
        this.hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public void save(User user) {
       hashOperations.put("USER", user.getId(), user);
    }

    @Override
    public Map<String,User> findAll() {
        return hashOperations.entries("USER");

    }

    @Override
    public User findById(String id) {
        return (User) hashOperations.get("USER", id);
    }

    @Override
    public void update(User user) {
        save(user);
    }

    @Override
    public void delete(String id) {
        hashOperations.delete("USER", id);
    }
}
