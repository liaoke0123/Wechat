package com.wechat.friends.web;

import com.wechat.friends.dto.UserDTO;
import com.wechat.friends.entity.User;
import com.wechat.friends.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by share on 2019/1/8.
 */
@RestController
@RequestMapping("/user")
@Api(description = "用户")
public class UserController {
    @Autowired
    UserService userService;

    public static final String s = "liaoke";

    @PostMapping(value = "addUser")
    public void add(@RequestBody(required = false) UserDTO userDTO){
        User user = userService.addUser(userDTO.getName(),userDTO.getPassword());
    }
}
