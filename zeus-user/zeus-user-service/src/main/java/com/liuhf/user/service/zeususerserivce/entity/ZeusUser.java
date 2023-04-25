package com.liuhf.user.service.zeususerserivce.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "zeus_user")
public class ZeusUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "username", nullable = false, length = 20)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "head_img", nullable = false)
    private String headImg;

    @Column(name = "real_name", nullable = false, length = 5)
    private String realName;

    @Column(name = "phone", nullable = false, length = 11)
    private String phone;

    @Column(name = "email", length = 50)
    private String email;

    @Column(name = "`lock`", nullable = false,insertable = false)
    private Integer lock;

    @Column(name = "create_time", nullable = false,insertable = false,updatable = false)
    private Date createTime;

    @Column(name = "update_time",insertable = false,updatable = false)
    private Date updateTime;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "zeus_user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<ZeusRole> zeusRoles = new LinkedHashSet<>();




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getLock() {
        return lock;
    }

    public void setLock(Integer lock) {
        this.lock = lock;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Set<ZeusRole> getZeusRoles() {
        return zeusRoles;
    }

    public void setZeusRoles(Set<ZeusRole> zeusRoles) {
        this.zeusRoles = zeusRoles;
    }

    @Override
    public String toString() {
        return "ZeusUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", headImg='" + headImg + '\'' +
                ", realName='" + realName + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", lock=" + lock +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", zeusRoles=" + zeusRoles +
                '}';
    }
}