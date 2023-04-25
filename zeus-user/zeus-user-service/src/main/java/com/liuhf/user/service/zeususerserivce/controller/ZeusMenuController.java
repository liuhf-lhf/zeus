package com.liuhf.user.service.zeususerserivce.controller;

import com.liuhf.common.lang.ZPage;
import com.liuhf.common.lang.result.Result;
import com.liuhf.user.service.zeususerserivce.entity.ZeusMenu;
import com.liuhf.user.service.zeususerserivce.entity.vo.ZeusMenuModifyVo;
import com.liuhf.user.service.zeususerserivce.entity.vo.ZeusMenuSaveVo;
import com.liuhf.user.service.zeususerserivce.entity.vo.ZeusMenuVo;
import com.liuhf.user.service.zeususerserivce.entity.vo.ZeusMenuSearchVo;
import com.liuhf.user.service.zeususerserivce.service.ZeusMenuService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 菜单相关接口
 *
 * @author liuhf
 * @date 2023/4/24
 * @since 1.0
 */
@RestController
@RequestMapping("menu")
public class ZeusMenuController {

    @Resource
    private ZeusMenuService service;


    /**
     * 保存
     *
     * @param menu
     * @return
     */
    @PostMapping("save")
    public Result<Boolean> save(@RequestBody ZeusMenuSaveVo menu) {
        return Result.success(this.service.save(menu.covertZeusMenu()));
    }

    /**
     * 修改
     *
     * @param menu
     * @return
     */
    @PutMapping("modify")
    public Result<Boolean> modify(@RequestBody ZeusMenuModifyVo menu) {
        return Result.success(this.service.modifyById(menu.covertZeusMenu()));
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @DeleteMapping("delete/{id}")
    public Result<Boolean> modify(@PathVariable Integer id) {
        return Result.success(this.service.deleteById(id));
    }

    /**
     * 精准查询
     *
     * @param id 主键
     * @return
     */
    @GetMapping("get-one/{id}")
    public Result<ZeusMenuVo> findById(@PathVariable Integer id) {
        return Result.success(this.service.findById(id), ZeusMenuVo.class);
    }

    /**
     * 条件查询
     *
     * @return
     */
    @GetMapping("get-any")
    public Result<ZPage<ZeusMenuVo>> findAny(ZeusMenuSearchVo menu) {
        Page<ZeusMenu> page = this.service.findAny(menu.covertZeusMenu(), menu.getPage(), menu.getPageSize());
        return Result.success(page.getContent(), page.getTotalElements(), ZeusMenuVo.class);
    }
}