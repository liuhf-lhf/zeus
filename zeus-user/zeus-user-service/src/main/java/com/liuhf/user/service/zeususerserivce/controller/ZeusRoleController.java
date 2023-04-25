package com.liuhf.user.service.zeususerserivce.controller;

import com.liuhf.common.lang.ZPage;
import com.liuhf.common.lang.result.Result;
import com.liuhf.user.service.zeususerserivce.entity.ZeusRole;
import com.liuhf.user.service.zeususerserivce.entity.vo.ZeusRoleModifyVo;
import com.liuhf.user.service.zeususerserivce.entity.vo.ZeusRoleSaveVo;
import com.liuhf.user.service.zeususerserivce.entity.vo.ZeusRoleVo;
import com.liuhf.user.service.zeususerserivce.entity.vo.ZeusRoleSearchVo;
import com.liuhf.user.service.zeususerserivce.service.ZeusRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

/**
 * 角色相关接口
 *
 * @author liuhf
 * @date 2023/4/24
 * @since 1.0
 */
@RestController
@RequestMapping("role")
public class ZeusRoleController {


    private ZeusRoleService service;

    @Autowired
    public void setZeusRoleService(ZeusRoleService zeusRoleService) {
        this.service = zeusRoleService;
    }

    /**
     * 新增
     *
     * @param role 新增实体
     * @return
     */
    @PostMapping("save")
    public Result<Boolean> save(@RequestBody ZeusRoleSaveVo role) {
        return Result.success(this.service.save(role.convertZeusRole()));
    }

    /**
     * 修改
     *
     * @param role 修改实体
     * @return
     */
    @PutMapping("modify")
    public Result<Boolean> modify(@RequestBody ZeusRoleModifyVo role) {
        return Result.success(this.service.modifyById(role.convertZeusRole()));
    }

    /**
     * 删除
     *
     * @param id 主键
     * @return
     */
    @DeleteMapping("delete/{id}")
    public Result<Boolean> delete(@PathVariable Integer id) {
        return Result.success(this.service.deleteById(id));
    }

    /**
     * 精准查询
     *
     * @param id 主键
     * @return
     */
    @GetMapping("get-one/{id}")
    public Result<ZeusRoleVo> findOneById(@PathVariable Integer id) {
        return Result.success(this.service.findOneById(id), ZeusRoleVo.class);
    }

    /**
     * 条件查询，并且分页
     *
     * @return
     */
    @GetMapping("get-any")
    public Result<ZPage<ZeusRoleVo>> findAny(ZeusRoleSearchVo role) {
        Page<ZeusRole> any = this.service.findAny(role.convertZeusRole(), role.getPage(), role.getPageSize());
        return Result.success(any.getContent(), any.getTotalElements(), ZeusRoleVo.class);
    }
}