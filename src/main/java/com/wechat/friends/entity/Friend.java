package com.wechat.friends.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wechat.friends.fenum.FriendState;
import com.wechat.friends.fenum.FriendsContentType;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="wechat_friend")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
@EntityListeners(AuditingEntityListener.class) //JPA自动生成时间等字段
public class Friend{

    @Id
    @GeneratedValue(generator = "jpa-uuid")
    @Column(length = 32)
    private String id;

    @CreatedDate //创建时间
    @Column(updatable = false) // 默认不修改此数据
    private Date createdDate;

    @LastModifiedDate //最后修改时间
    private Date LastModifiedDate;

    @Column(name="title",nullable = true,length = 50)
    private String title;

    @Column(name="contentType",nullable = false,length = 30)
    private FriendsContentType contentType;

    @Column(name="textContent",nullable = false,columnDefinition = "text",length = 2000)
    private String textContent;
    
    @Column(name="friendState",nullable = true,length = 30 )
    private FriendState friendState; //朋友圈状态

    /**
     * https://www.jianshu.com/p/e8caafce5445
     */
    @OneToMany(mappedBy="friend",cascade=CascadeType.ALL) //PERSIST 创建朋友圈的时
    private Set<Image> images;
    
    @OneToMany(mappedBy="friend",cascade=CascadeType.ALL) //PERSIST 创建朋友圈的时
    private Set<Comment> comments;
    
    @OneToMany(mappedBy="friend",cascade=CascadeType.ALL)
    private Set<Reply> replies;
	
    @JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="user_id")
	private User user;


    //TODO 评论 点赞
    

    public Friend () {
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastModifiedDate() {
        return LastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        LastModifiedDate = lastModifiedDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public FriendsContentType getContentType() {
        return contentType;
    }

    public void setContentType(FriendsContentType contentType) {
        this.contentType = contentType;
    }

    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

    public Set<Image> getImages() {
        return images;
    }

    public void setImages(Set<Image> images) {
        this.images = images;
    }
    
    public FriendState getFriendState () {
        return friendState;
    }
    
    public void setFriendState (FriendState friendState) {
        this.friendState = friendState;
    }
	
	public Set<Comment> getComments () {
		return comments;
	}
	
	public void setComments (Set<Comment> comments) {
		this.comments = comments;
	}
	
	public User getUser () {
		return user;
	}
	
	public void setUser (User user) {
		this.user = user;
	}
    
    public Set<Reply> getReplies () {
        return replies;
    }
    
    public void setReplies (Set<Reply> replies) {
        this.replies = replies;
    }
    
    @Override
    public String toString () {
        return "Friend{" +
                "id='" + id + '\'' +
                ", createdDate=" + createdDate +
                ", LastModifiedDate=" + LastModifiedDate +
                ", title='" + title + '\'' +
                ", contentType=" + contentType +
                ", textContent='" + textContent + '\'' +
                ", friendState=" + friendState +
                ", images=" + images +
                '}';
    }
}
