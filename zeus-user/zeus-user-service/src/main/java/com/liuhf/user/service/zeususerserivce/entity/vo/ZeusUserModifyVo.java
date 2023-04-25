package com.liuhf.user.service.zeususerserivce.entity.vo;

import com.liuhf.user.service.zeususerserivce.entity.ZeusUser;

/**
 * 修改用户实体
 */
public class ZeusUserModifyVo {

    /**
     * 用户主键
     */
    private Long id;

    /**
     * 用户头像
     */
    private String headImg;

    /**
     * 用户姓名
     */
    private String realName;

    /**
     * 用户手机号
     */
    private String phone;

    /**
     * 用户邮箱
     */
    private String email;

    /**
     * 用户锁定状态 0未锁定 1已锁定
     */
    private Integer lock;

    public ZeusUser convertZeusUser() {
        ZeusUser user = new ZeusUser();
        user.setId(this.id);
        user.setHeadImg(this.getHeadImg());
        user.setRealName(this.getRealName());
        user.setPhone(this.getPhone());
        user.setEmail(this.getEmail());
        user.setLock(this.lock);
        return user;
    }


    public Integer getLock() {
        return lock;
    }

    public void setLock(Integer lock) {
        this.lock = lock;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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


}