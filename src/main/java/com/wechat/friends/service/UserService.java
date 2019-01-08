package com.wechat.friends.service;

import com.wechat.friends.dto.UserDTO;
import com.wechat.friends.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by share on 2019/1/8.
 */
public interface UserService {
    User addUser(String name, String password);

    void delUser(int id);

    Page<User> listAllUser(Pageable pageable);

    void updateUser(int id,String name,String password);
}
