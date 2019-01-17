package com.wechat.friends.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by share on 2019/1/8.
 */
@Entity
@Table(name="wechat_user")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class User {
    @Id
    @GeneratedValue(generator = "jpa-uuid")
    @Column(length = 32)
    private String id;
    @Column(name="name",nullable = true,length = 50)
    private String name;
    @Column(name="password",nullable = true,length = 50)
    private String password;
    
    //***************associated*************** //关联表处理
    @OneToMany(mappedBy="user",cascade=CascadeType.ALL) //PERSIST 创建朋友圈的时
    private Set<Comment> comments;
    
    @OneToMany(mappedBy="user",cascade=CascadeType.ALL) //PERSIST 创建朋友圈的时
    private Set<Friend> friends;
	
	@OneToMany(mappedBy="user",cascade=CascadeType.ALL) //PERSIST 创建朋友圈的时
	private Set<Reply> replies;

    public User() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
	
	public Set<Comment> getComments () {
		return comments;
	}
	
	public void setComments (Set<Comment> comments) {
		this.comments = comments;
	}
	
	public Set<Friend> getFriends () {
		return friends;
	}
	
	public void setFriends (Set<Friend> friends) {
		this.friends = friends;
	}
	
	public Set<Reply> getReplies () {
		return replies;
	}
	
	public void setReplies (Set<Reply> replies) {
		this.replies = replies;
	}
}