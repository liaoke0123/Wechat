package com.wechat.friends.dto;


import io.swagger.annotations.ApiModelProperty;

public class RepliesDTO {
	
    private String replyContent;
    
    private String comment_id;
    
    private String replier_id;
	
	@ApiModelProperty(hidden = true)
    private String reply_id;
	
	@ApiModelProperty(hidden = true)
	private String commentator;
	
	@ApiModelProperty(hidden = true)
	private String commentator_id;
	
	@ApiModelProperty(hidden = true)
	private String replier;
	
	
	public String getReplyContent () {
		return replyContent;
	}
	
	public void setReplyContent (String replyContent) {
		this.replyContent = replyContent;
	}
	
	public String getComment_id () {
		return comment_id;
	}
	
	public void setComment_id (String comment_id) {
		this.comment_id = comment_id;
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
	
	public String getCommentator () {
		return commentator;
	}
	
	public void setCommentator (String commentator) {
		this.commentator = commentator;
	}
	
	public String getReplier () {
		return replier;
	}
	
	public void setReplier (String replier) {
		this.replier = replier;
	}
	
	public String getCommentator_id () {
		return commentator_id;
	}
	
	public void setCommentator_id (String commentator_id) {
		this.commentator_id = commentator_id;
	}
}
