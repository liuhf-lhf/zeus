package com.liuhf.user.service.zeususerserivce.entity.vo;

import com.liuhf.user.service.zeususerserivce.entity.ZeusUser;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * A DTO for the {@link ZeusUser} entity
 */
public class ZeusUserVo implements Serializable {
    private Long id;
    private String username;
    private String password;
    private String headImg;
    private String realName;
    private String phone;
    private String email;
    private Integer lock;
    private Date createTime;
    private Date updateTime;

    public Long getId() {
        return id;
    }

    public ZeusUserVo setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public ZeusUserVo setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public ZeusUserVo setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getHeadImg() {
        return headImg;
    }

    public ZeusUserVo setHeadImg(String headImg) {
        this.headImg = headImg;
        return this;
    }

    public String getRealName() {
        return realName;
    }

    public ZeusUserVo setRealName(String realName) {
        this.realName = realName;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public ZeusUserVo setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public ZeusUserVo setEmail(String email) {
        this.email = email;
        return this;
    }

    public Integer getLock() {
        return lock;
    }

    public ZeusUserVo setLock(Integer lock) {
        this.lock = lock;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public ZeusUserVo setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public ZeusUserVo setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ZeusUserVo entity = (ZeusUserVo) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.username, entity.username) &&
                Objects.equals(this.password, entity.password) &&
                Objects.equals(this.headImg, entity.headImg) &&
                Objects.equals(this.realName, entity.realName) &&
                Objects.equals(this.phone, entity.phone) &&
                Objects.equals(this.email, entity.email) &&
                Objects.equals(this.lock, entity.lock) &&
                Objects.equals(this.createTime, entity.createTime) &&
                Objects.equals(this.updateTime, entity.updateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, headImg, realName, phone, email, lock, createTime, updateTime);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "username = " + username + ", " +
                "password = " + password + ", " +
                "headImg = " + headImg + ", " +
                "realName = " + realName + ", " +
                "phone = " + phone + ", " +
                "email = " + email + ", " +
                "lock = " + lock + ", " +
                "createTime = " + createTime + ", " +
                "updateTime = " + updateTime + ")";
    }
}