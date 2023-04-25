package com.liuhf.user.service.zeususerserivce.service.impl;

import cn.hutool.core.util.StrUtil;
import com.liuhf.common.lang.enums.Status;
import com.liuhf.common.lang.exception.BusinessException;
import com.liuhf.user.service.zeususerserivce.entity.ZeusMenu;
import com.liuhf.user.service.zeususerserivce.repository.ZeusMenuRepository;
import com.liuhf.user.service.zeususerserivce.service.ZeusMenuService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author liuhf
 * @date 2023/4/24
 * @since 1.0
 */
@Service
public class ZeusMenuServiceImpl implements ZeusMenuService {

    @Resource
    private ZeusMenuRepository repository;

    @Override
    public boolean save(ZeusMenu entity) {
        try {
            this.repository.saveAndFlush(entity);
        } catch (Exception e) {
            throw new BusinessException(e, Status.SAVE_ERROR);
        }
        return true;
    }

    @Override
    public boolean deleteById(Integer id) {
        try {
            this.repository.deleteById(id);
        } catch (Exception e) {
            throw new BusinessException(e, Status.DELETE_ERROR);
        }
        return true;
    }

    @Override
    public boolean modifyById(ZeusMenu entity) {
        Optional.ofNullable(entity.getId()).orElseThrow(() -> new BusinessException(Status.NULL));
        return this.save(entity);
    }

    @Override
    public ZeusMenu findById(Integer id) {
        return this.repository.findById(id).orElseThrow(() -> new BusinessException(Status.NO_DATA));
    }

    @Override
    public Page<ZeusMenu> findAny(ZeusMenu menu, int page, int pageSize) {
        return this.repository.findAll((root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();
            String menuCode = menu.getMenuCode();
            String menuName = menu.getMenuName();
            String component = menu.getComponent();
            String leadPath = menu.getLeadPath();
            String backPath = menu.getBackPath();
            String redirectPath = menu.getRedirectPath();
            String menuIcon = menu.getMenuIcon();
            Integer type = menu.getType();
            Integer status = menu.getStatus();
            Integer parentId = menu.getParentId();

            if (StrUtil.isNotBlank(menuCode)) {
                predicates.add(builder.like(root.get("menuCode"), menuCode + "%"));
            }
            if (StrUtil.isNotBlank(menuName)) {
                predicates.add(builder.like(root.get("menuName"), menuName + "%"));
            }
            if (StrUtil.isNotBlank(component)) {
                predicates.add(builder.like(root.get("component"), component + "%"));
            }
            if (StrUtil.isNotBlank(leadPath)) {
                predicates.add(builder.like(root.get("leadPath"), leadPath + "%"));
            }
            if (StrUtil.isNotBlank(backPath)) {
                predicates.add(builder.like(root.get("backPath"), backPath + "%"));
            }
            if (StrUtil.isNotBlank(redirectPath)) {
                predicates.add(builder.like(root.get("redirectPath"), redirectPath + "%"));
            }
            if (StrUtil.isNotBlank(menuIcon)) {
                predicates.add(builder.like(root.get("menuIcon"), menuIcon + "%"));
            }
            if (type != null) {
                predicates.add(builder.equal(root.get("type"), type));
            }
            if (status != null) {
                predicates.add(builder.equal(root.get("status"), status));
            }
            if (parentId != null) {
                predicates.add(builder.equal(root.get("parentId"), parentId));
            }
            return builder.and(predicates.toArray(new Predicate[0]));
        }, PageRequest.of(--page, pageSize));
    }
}