package com.nowanuj.dataredis.dataredis.respo;

import com.nowanuj.dataredis.dataredis.model.User;

import java.util.List;
import java.util.Map;

public interface UserRepo {

    public void save(User user);

    Map<String, User> findAll();

    User findById(String id);

    void update(User user);

    void delete(String id);
}
