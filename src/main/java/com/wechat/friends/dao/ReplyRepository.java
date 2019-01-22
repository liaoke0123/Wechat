package com.wechat.friends.dao;

import com.wechat.friends.entity.Reply;
import com.wechat.friends.fenum.ReplyState;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ReplyRepository extends JpaRepository<Reply,String>,JpaSpecificationExecutor<ReplyRepository>{
	
	Optional<Reply> findByIdAndReplyState (String id, ReplyState replyState);
	
	Page<Reply> findAllByReplyStateAndFriend_Id (@Param("replyState") ReplyState replyState, @Param("friend_id") String friend_id, Pageable pageable);

}
