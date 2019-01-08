package com.wechat.friends.service;

import com.wechat.friends.entity.Friend;
import com.wechat.friends.exception.BusinessException;
import com.wechat.friends.fenum.FriendState;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface FriendsService {

   Friend createOneMoment(String content,List<String> ids) throws BusinessException;
   
   Friend getOneMoment(String id, FriendState friendState) throws BusinessException;
   
   Page<Friend> getAllMoments(FriendState friendState) throws BusinessException;
   
   void deleteOneMoment(String id) throws BusinessException;
    
}
