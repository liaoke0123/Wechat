package com.wechat.friends.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import java.util.List;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class FriendsDTO{
    
    //    @ApiModelProperty(value="ids",required=true)
    //    @NotBlank  // 朋友圈图片id
    private List<String> imageIds;
    
    //    @ApiModelProperty(value="content",required=true)
    //    @NotBlank
    private String content;
    
    private String user_id;
    
    @ApiModelProperty(hidden = true)
    private String friend_id;
    
    
    public List<String> getImageIds () {
        return imageIds;
    }
    
    public void setImageIds (List<String> imageIds) {
        this.imageIds = imageIds;
    }
    
    public String getContent () {
        return content;
    }
    
    public void setContent (String content) {
        this.content = content;
    }
    
    public String getUser_id () {
        return user_id;
    }
    
    public void setUser_id (String user_id) {
        this.user_id = user_id;
    }
    
    public String getFriend_id () {
        return friend_id;
    }
    
    public void setFriend_id (String friend_id) {
        this.friend_id = friend_id;
    }
}