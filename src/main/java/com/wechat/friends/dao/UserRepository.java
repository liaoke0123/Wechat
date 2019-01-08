package com.wechat.friends.dao;

import com.wechat.friends.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by share on 2019/1/8.
 */
public interface UserRepository  extends JpaRepository<User,String> {
}
