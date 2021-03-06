package com.wechat.friends.service;

import com.wechat.friends.entity.Friend;
import com.wechat.friends.exception.BusinessException;
import com.wechat.friends.fenum.FriendState;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface FriendsService {

   Friend createOneMoment(String content,List<String> ids) throws BusinessException;     //此接口将被弃用，不建议使用
   
   Friend createOneMomentByUser(String content,List<String> ids,String user_id) throws BusinessException;
   
   Friend getOneMoment(String id, FriendState friendState) throws BusinessException;
   
   Page<Friend> getAllMoments(FriendState friendState, int pageSize,int pageNum) throws BusinessException;
   
   void deleteOneMoment(String id) throws BusinessException;
    
}
