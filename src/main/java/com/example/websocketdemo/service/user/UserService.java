package com.example.websocketdemo.service.user;

import com.example.websocketdemo.domain.User;

import java.util.List;

public interface UserService {

    public User add(User user);

    public User getByEmail(String email);

    public List<User> getUsers(int pageNumber, int pageSize);
}
