package com.wechat.friends.service.impl;


import com.wechat.friends.dao.CommentRepository;
import com.wechat.friends.dao.FriendRepository;
import com.wechat.friends.dao.UserRepository;
import com.wechat.friends.entity.Comment;
import com.wechat.friends.entity.Friend;
import com.wechat.friends.entity.User;
import com.wechat.friends.exception.BusinessException;
import com.wechat.friends.fenum.CommentState;
import com.wechat.friends.service.CommentsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Optional;

@Service("CommentsService")
public class CommentsServiceImpl implements CommentsService {

	@Resource
	UserRepository userRepository;
	
	@Resource
	FriendRepository friendRepository;
	
	@Resource
	CommentRepository commentRepository;
	
	
	@Override
	@Transactional(rollbackFor = Exception.class)
	public Comment createOneCommentByUser (String content, String user_id, String friend_id) throws BusinessException {
		Comment comment = new Comment();
		comment.setCommentState(CommentState.EXIST);
		comment.setCommentContent(content);
		commentRepository.saveAndFlush(comment);
		
		Optional<User> user=userRepository.findById(user_id);
		if(!user.isPresent()){
			throw new BusinessException("id is not existed",0,404);
		}
		comment.setUser(user.get());
		
		Optional<Friend> friend=friendRepository.findById(friend_id);
		if(!friend.isPresent()){
			throw new BusinessException("id is not existed",0,404);
		}
		comment.setFriend(friend.get());
		
		return comment;
	}
	
}
