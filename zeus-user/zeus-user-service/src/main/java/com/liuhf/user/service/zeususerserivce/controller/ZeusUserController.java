package com.liuhf.user.service.zeususerserivce.controller;

import com.liuhf.common.lang.result.Result;
import com.liuhf.common.lang.ZPage;
import com.liuhf.user.api.dto.ZeusRoleDto;
import com.liuhf.user.api.dto.ZeusUserDto;
import com.liuhf.user.service.zeususerserivce.entity.ZeusRole;
import com.liuhf.user.service.zeususerserivce.entity.ZeusUser;
import com.liuhf.user.service.zeususerserivce.entity.vo.*;
import com.liuhf.user.service.zeususerserivce.service.ZeusUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


/**
 * 用户相关接口
 *
 * @author liuhf
 * @date 2023/4/12
 * @since 1.0
 */
@RestController
@RequestMapping("user")
public class ZeusUserController {

    @Autowired
    private ZeusUserService service;


    /**
     * 保存
     *
     * @param entity
     * @return
     */
    @PostMapping("save")
    public Result<Boolean> save(@RequestBody ZeusUserSaveVo entity) {
        return Result.success(service.save(entity.convertZeusUser()));
    }

    /**
     * 修改
     *
     * @param entity
     * @return
     */
    @PutMapping("modify")
    public Result<Boolean> modify(@RequestBody ZeusUserModifyVo entity) {
        return Result.success(service.modifyById(entity.convertZeusUser()));
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @DeleteMapping("delete/{id}")
    public Result<Boolean> delete(@PathVariable Long id) {
        return Result.success(service.deleteById(id));
    }

    /**
     * 查询
     *
     * <p>精准查询</p>
     *
     * @param id
     * @return
     */
    @GetMapping("find-one/{id}")
    public Result<ZeusUser> findOneById(@PathVariable Long id) {
        return Result.success(service.findOneById(id));
    }


    /**
     * 条件查询
     * <p>条件查询,并分页</p>
     *
     * @param username
     * @param realName
     * @param page
     * @param pageSize
     * @return
     */
    @GetMapping("find-any")
    public Result<ZPage<ZeusUserVo>> findAny(
            @RequestParam(value = "username", required = false) String username,
            @RequestParam(value = "realName", required = false) String realName,
            @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
            @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize
    ) {
        Page<ZeusUser> res = this.service.findAny(username, realName, page, pageSize);
        return Result.success(res.getContent(), res.getTotalElements(), ZeusUserVo.class);
    }

    /**
     * 通过用户名查询用户
     * <p>主要用作登录</p>
     *
     * @param username 用户名
     * @return ZeusUserDto
     */
    @GetMapping("fu")
    public ZeusUserDto findByUsername(String username) {
        return this.service.findOneByUsername(username);
    }

    /**
     * 用户授权
     *
     * @param ur
     * @return
     */
    @PostMapping("auth")
    public Result<Boolean> auth(@RequestBody UserRoleAuthVo ur) {
        return Result.success(this.service.userAuthorization(ur.getUid(), ur.getRids()));
    }

    /**
     * 查询用户拥有的角色
     *
     * @param uid
     * @return
     */
    @GetMapping("urou/{uid}")
    public Result<List<ZeusRoleVo>> findZeusUserRoleOfUser(@PathVariable Long uid) {
        return Result.success(this.service.findZeusUserRoleOfUser(uid), ZeusRoleVo.class);
    }
}