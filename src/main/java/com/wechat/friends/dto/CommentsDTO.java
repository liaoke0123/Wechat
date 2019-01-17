package com.wechat.friends.dto;


import io.swagger.annotations.ApiModelProperty;

public class CommentsDTO {
    
    private String commentContent;
	
    private String friend_id;
    
    private String commentator_id;
    
	@ApiModelProperty(hidden = true)
	private String comment_id;
	
	@ApiModelProperty(hidden = true)
	private String commentator;
	
	
	
	public String getCommentContent () {
		return commentContent;
	}
	
	public void setCommentContent (String commentContent) {
		this.commentContent = commentContent;
	}
	
	public String getFriend_id () {
		return friend_id;
	}
	
	public void setFriend_id (String friend_id) {
		this.friend_id = friend_id;
	}
	
	public String getCommentator_id () {
		return commentator_id;
	}
	
	public void setCommentator_id (String commentator_id) {
		this.commentator_id = commentator_id;
	}
	
	public String getComment_id () {
		return comment_id;
	}
	
	public void setComment_id (String comment_id) {
		this.comment_id = comment_id;
	}
	
	public String getCommentator () {
		return commentator;
	}
	
	public void setCommentator (String commentator) {
		this.commentator = commentator;
	}
}
