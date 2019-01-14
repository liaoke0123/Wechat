package com.wechat.friends.entity;

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
}