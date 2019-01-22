package com.wechat.friends.dto;


import io.swagger.annotations.ApiModelProperty;

public class RepliesDTO {
	
    private String replyContent;
    
    private String myUser_id;
    
    private String replier_id;
    
    private String friend_id;
	
	@ApiModelProperty(hidden = true)
    private String reply_id;
	
	@ApiModelProperty(hidden = true)
	private String replier;
	
	@ApiModelProperty(hidden = true)
	private String myName;
	
	
	public String getReplyContent () {
		return replyContent;
	}
	
	public void setReplyContent (String replyContent) {
		this.replyContent = replyContent;
	}
	
	public String getMyUser_id () {
		return myUser_id;
	}
	
	public void setMyUser_id (String myUser_id) {
		this.myUser_id = myUser_id;
	}
	
	public String getReplier_id () {
		return replier_id;
	}
	
	public void setReplier_id (String replier_id) {
		this.replier_id = replier_id;
	}
	
	public String getReply_id () {
		return reply_id;
	}
	
	public void setReply_id (String reply_id) {
		this.reply_id = reply_id;
	}
	
	public String getReplier () {
		return replier;
	}
	
	public void setReplier (String replier) {
		this.replier = replier;
	}
	
	public String getMyName () {
		return myName;
	}
	
	public void setMyName (String myName) {
		this.myName = myName;
	}
	
	public String getFriend_id () {
		return friend_id;
	}
	
	public void setFriend_id (String friend_id) {
		this.friend_id = friend_id;
	}
}
