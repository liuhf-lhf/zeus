package com.liuhf.user.service.zeususerserivce.entity.vo;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Arrays;

/**
 * 用户授权交互实体
 *
 * @author liuhf
 * @date 2023/4/25
 * @since 1.0
 */
public class UserRoleAuthVo {
    @NotNull(message = "用户id不能为空")
    private Long uid;
    @NotNull(message = "角色不能为空")
    @NotEmpty(message = "角色未选择")
    private Integer[] rids;

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Integer[] getRids() {
        return rids;
    }

    public void setRids(Integer[] rids) {
        this.rids = rids;
    }

    @Override
    public String toString() {
        return "UserRoleAuthVo{" +
                "uid=" + uid +
                ", rids=" + Arrays.toString(rids) +
                '}';
    }
}
