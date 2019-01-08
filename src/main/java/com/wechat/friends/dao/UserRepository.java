package com.wechat.friends.dao;

import com.wechat.friends.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

/**
 * Created by share on 2019/1/8.
 */
@Transactional
public interface UserRepository  extends JpaRepository<User,Integer> {
    @Modifying
    @Query(value = "update wechat_user set name=:name,password=:password where id =:id",nativeQuery = true)
    public void queryById(@Param("id") int id, @Param("name") String name, @Param("password") String password);
}
