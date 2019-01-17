package com.wechat.friends.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wechat.friends.fenum.ReplyState;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="wechat_reply")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
@EntityListeners(AuditingEntityListener.class) //JPA自动生成时间等字段
public class Reply {
	
	@Id
	@GeneratedValue(generator = "jpa-uuid")
	@Column(length = 32)
	private String id;
	
	@CreatedDate //创建时间
	@Column(updatable = false) // 默认不修改此数据
	private Date createdDate;
	
	@LastModifiedDate //最后修改时间
	private Date LastModifiedDate;
	
	@Column(name="replyContent",nullable = false,columnDefinition = "text",length = 2000)
	private String replyContent;
	
	@Column(name="commentState",nullable = false,length = 30 )
	private ReplyState replyState; //回复状态
	
	//***************associated*************** //关联表处理
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="comment_id")
	private Comment comment;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="ReplyUser_id")
	private User user;
	
	
	
	public Reply () {
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
	
	public String getReplyContent () {
		return replyContent;
	}
	
	public void setReplyContent (String replyContent) {
		this.replyContent = replyContent;
	}
	
	public ReplyState getReplyState () {
		return replyState;
	}
	
	public void setReplyState (ReplyState replyState) {
		this.replyState = replyState;
	}
	
	public Comment getComment () {
		return comment;
	}
	
	public void setComment (Comment comment) {
		this.comment = comment;
	}
	
	public User getUser () {
		return user;
	}
	
	public void setUser (User user) {
		this.user = user;
	}
}
