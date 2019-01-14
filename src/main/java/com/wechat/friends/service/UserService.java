package com.wechat.friends.service;

import com.wechat.friends.dto.UserDTO;
import com.wechat.friends.entity.User;
import com.wechat.friends.exception.BusinessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by share on 2019/1/8.
 */
public interface UserService {
    User addUser(String name, String password) throws BusinessException;

    void delUser(String id) throws BusinessException;

    Page<User> listAllUser(Pageable pageable) throws BusinessException;

    void updateUser(String id,String name,String password) throws BusinessException;
}
