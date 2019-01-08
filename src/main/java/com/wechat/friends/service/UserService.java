package com.wechat.friends.service;

import com.wechat.friends.entity.User;

/**
 * Created by share on 2019/1/8.
 */
public interface UserService {
    User addUser(String name, String password);
}
