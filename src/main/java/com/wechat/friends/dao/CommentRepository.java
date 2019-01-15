package com.wechat.friends.dao;

import com.wechat.friends.entity.Comment;
import com.wechat.friends.entity.Image;
import com.wechat.friends.fenum.CommentState;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment,String>,JpaSpecificationExecutor<CommentRepository>{
	
	Optional<Comment> findByIdAndCommentState(String id, CommentState commentState);
	
	Page<Comment> findAllByCommentStateAndFriend_Id(@Param("commentState")CommentState commentState, @Param("friend_id")String friend_id, Pageable pageable);

}
