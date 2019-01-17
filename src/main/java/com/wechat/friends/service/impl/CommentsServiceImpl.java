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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
			throw new BusinessException("user is not existed",0,404);
		}
		comment.setUser(user.get());
		
		Optional<Friend> friend=friendRepository.findById(friend_id);
		if(!friend.isPresent()){
			throw new BusinessException("moment is not existed",0,404);
		}
		comment.setFriend(friend.get());
		
		return comment;
	}
	
	@Override
	public Comment getOneComment (String id, CommentState commentState) throws BusinessException {
		Optional<Comment> comment=commentRepository.findByIdAndCommentState(id,commentState);
		if(!comment.isPresent()){
			throw new BusinessException("comment is not existed",0,404);
		}
		return comment.get();
	}
	
	@Override
	public Page<Comment> getAllComments (CommentState commentState, String friend_id, int pageSize, int pageNum) throws BusinessException {
		Page<Comment> result = commentRepository.findAllByCommentStateAndFriend_Id(commentState, friend_id, PageRequest.of(pageNum,pageSize) );
		return result;
	}
	
	@Override
	@Transactional
	public void deleteOneComment (String id) throws BusinessException {
		Optional<Comment> comment=commentRepository.findById(id);
		if(!comment.isPresent()){
			throw new BusinessException("moment is not existed",0,404);
		}
		comment.get().setCommentState(CommentState.DELETED);
	}
	
}
