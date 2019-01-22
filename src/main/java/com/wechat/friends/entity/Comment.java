package com.wechat.friends.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wechat.friends.fenum.CommentState;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="wechat_comment")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
@EntityListeners(AuditingEntityListener.class) //JPA自动生成时间等字段
public class Comment {
	
	@Id
	@GeneratedValue(generator = "jpa-uuid")
	@Column(length = 32)
	private String id;
	
	@CreatedDate //创建时间
	@Column(updatable = false) // 默认不修改此数据
	private Date createdDate;
	
	@LastModifiedDate //最后修改时间
	private Date LastModifiedDate;
	
	@Column(name="commentContent",nullable = false,columnDefinition = "text",length = 2000)
	private String commentContent;
	
	@Column(name="commentState",nullable = false,length = 30 )
	private CommentState commentState; //评论状态
	
	//***************associated*************** //关联表处理
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="user_id")
	private User user;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="friend_id")
	private Friend friend;
	
	
	
	public Comment () {
	}
	
	public String getId () {
		return id;
	}
	
	public void setId (String id) {
		this.id = id;
	}
	
	public Date getCreatedDate () {
		return createdDate;
	}
	
	public void setCreatedDate (Date createdDate) {
		this.createdDate = createdDate;
	}
	
	public Date getLastModifiedDate () {
		return LastModifiedDate;
	}
	
	public void setLastModifiedDate (Date lastModifiedDate) {
		LastModifiedDate = lastModifiedDate;
	}
	
	public String getCommentContent () {
		return commentContent;
	}
	
	public void setCommentContent (String commentContent) {
		this.commentContent = commentContent;
	}
	
	public CommentState getCommentState () {
		return commentState;
	}
	
	public void setCommentState (CommentState commentState) {
		this.commentState = commentState;
	}
	
	public User getUser () {
		return user;
	}
	
	public void setUser (User user) {
		this.user = user;
	}
	
	public Friend getFriend () {
		return friend;
	}
	
	public void setFriend (Friend friend) {
		this.friend = friend;
	}

}
