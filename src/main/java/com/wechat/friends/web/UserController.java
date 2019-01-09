package com.wechat.friends.web;

import com.wechat.friends.dto.UserDTO;
import com.wechat.friends.entity.User;
import com.wechat.friends.exception.BusinessException;
import com.wechat.friends.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;
import java.util.List;


/**
 * Created by share on 2019/1/8.
 */
@RestController
@RequestMapping("/user")
@Api(description = "用户")
public class UserController {
    @Autowired
    UserService userService;

    //add a user
    @PostMapping(value = "addUser")
    public String add(@RequestBody(required = false) UserDTO userDTO) throws BusinessException {
        userService.addUser(userDTO.getName(),userDTO.getPassword());
        return "successfully added";
    }
    //delete a user by id
    @PostMapping(value = "delUser")
    public String delete(int id) throws BusinessException {
        userService.delUser(id);
        return "successfully deleted";
    }
    //update a user
    @PostMapping(value = "updateUser")
    public String update(User user) throws BusinessException {
        userService.updateUser(user.getId(),user.getName(),user.getPassword());
        return "successfully updated";
    }

    //list all users
    @PostMapping(value = "listAllUser")
    public Page<User> listAll(Integer page , Integer size) throws BusinessException {
        //sort by id in asc
        Sort sort = new Sort(Sort.Direction.ASC,"id");

        Pageable pageable = new PageRequest(page-1,size,sort);

        Page<User> pages = userService.listAllUser(pageable);
        return pages;
    }

}
