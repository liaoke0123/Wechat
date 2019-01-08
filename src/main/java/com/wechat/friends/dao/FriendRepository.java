package com.wechat.friends.dao;

import com.wechat.friends.entity.Friend;
import com.wechat.friends.fenum.FriendState;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface FriendRepository extends JpaRepository<Friend,String>,JpaSpecificationExecutor<FriendRepository>{

	@Query("select f from Friend as f where f.id=:id and f.friendState=:friendState")
	Optional<Friend> findById(@Param("id")String id, @Param("friendState") FriendState friendState);
	
	Page<Friend> findAllByFriendState(@Param("friendState")FriendState friendState,Pageable pageable);
	
}
