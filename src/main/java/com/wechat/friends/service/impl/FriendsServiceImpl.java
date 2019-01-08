package com.wechat.friends.service.impl;


import com.wechat.friends.dao.FriendRepository;
import com.wechat.friends.dao.ImageRepository;
import com.wechat.friends.entity.Friend;
import com.wechat.friends.exception.BusinessException;
import com.wechat.friends.fenum.FriendState;
import com.wechat.friends.fenum.FriendsContentType;
import com.wechat.friends.service.FriendsService;
import com.wechat.friends.service.ImagesService;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service("FriendsService")
public class FriendsServiceImpl implements FriendsService {
	
	@Resource
	FriendRepository friendRepository;
	
	@Resource
	ImageRepository imageRepository;
	
	@Resource
	ImagesService imagesService;
	
	@Override
	@Transactional
	public Friend createOneMoment (String content,List<String> ids) throws BusinessException {
		//create friend in db
		Friend friend=new Friend();
		friend.setTextContent(content);
		friend.setContentType(FriendsContentType.NORMAL);
		friend.setFriendState(FriendState.EXIST);
		Friend friendIndb = friendRepository.saveAndFlush(friend);
		//refresh img in db
		for(String id:ids){
			imagesService.refreshImgFriend(id,friendIndb);
		}
		
		return friend;
	}
	
	@Override
	public Friend getOneMoment (String id,FriendState friendState) throws BusinessException {
		Optional<Friend> friend=friendRepository.findById(id,friendState);
		if(!friend.isPresent()){
			throw new BusinessException("moment is not existed",0,404);
		}
		return friend.get();
	}
	
	@Override
	public Page<Friend> getAllMoments (FriendState friendState) throws BusinessException {
		Page<Friend> result = friendRepository.findAllByFriendState(friendState, PageRequest.of(0, 10));
		return result;
	}
	
	@Override
	@Transactional
	public void deleteOneMoment (String id) throws BusinessException {
		Optional<Friend> friend=friendRepository.findById(id);
		if(!friend.isPresent()){
			throw new BusinessException("moment is not existed",0,404);
		}
		friend.get().setFriendState(FriendState.DELETED);
	}
	
}
