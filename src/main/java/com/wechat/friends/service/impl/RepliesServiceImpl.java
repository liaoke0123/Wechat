package com.wechat.friends.service.impl;

import com.wechat.friends.dao.CommentRepository;
import com.wechat.friends.dao.FriendRepository;
import com.wechat.friends.dao.ReplyRepository;
import com.wechat.friends.dao.UserRepository;
import com.wechat.friends.entity.Friend;
import com.wechat.friends.entity.Reply;
import com.wechat.friends.entity.User;
import com.wechat.friends.exception.BusinessException;
import com.wechat.friends.fenum.ReplyState;
import com.wechat.friends.service.RepliesService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Optional;


@Service("ReplysService")
public class RepliesServiceImpl implements RepliesService {
	
	@Resource
	ReplyRepository replyRepository;
	
	@Resource
	FriendRepository friendRepository;
	
	@Resource
	UserRepository userRepository;
	
	@Override
	@Transactional
	public Reply createOneReplyByUser (String content, String myUser_id,String replier_id,String friend_id) throws BusinessException {
		Reply reply=new Reply();
		reply.setReplyState(ReplyState.EXIST);
		reply.setReplyContent(content);
		reply.setMyUserId(myUser_id);
		replyRepository.saveAndFlush(reply);
		
		Optional<Friend> friend=friendRepository.findById(friend_id);
		if(!friend.isPresent()){
			throw new BusinessException("comment is not existed",0,404);
		}
		reply.setFriend(friend.get());
		
		Optional<User> user=userRepository.findById(replier_id);
		if(!user.isPresent()){
			throw new BusinessException("user is not existed",0,404);
		}
		reply.setUser(user.get());
		return reply;
	}
	
	@Override
	public Reply getOneReply (String id, ReplyState replyState) throws BusinessException {
		Optional<Reply> reply=replyRepository.findByIdAndReplyState(id,replyState);
		if(!reply.isPresent()){
			throw new BusinessException("reply is not existed",0,404);
		}
		return reply.get();
	}
	
	@Override
	public Page<Reply> getAllReplys (ReplyState replyState, String friend_id, int pageSize, int pageNum) throws BusinessException {
		Page<Reply> result=replyRepository.findAllByReplyStateAndFriend_Id(replyState,friend_id, PageRequest.of(pageNum,pageSize) );
		return result;
	}
	
	@Override
	@Transactional
	public void deleteOneReply (String id) throws BusinessException {
		Optional<Reply> reply=replyRepository.findById(id);
		if(!reply.isPresent()){
			throw new BusinessException("reply is not existed",0,404);
		}
		reply.get().setReplyState(ReplyState.DELETED);
	}
}
