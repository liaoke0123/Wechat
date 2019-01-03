package com.wechat.friends.dao;

import com.wechat.friends.entity.Friend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface FriendRepository extends JpaRepository<Friend,String>,JpaSpecificationExecutor<FriendRepository>{


}
