package com.liuhf.user.service.zeususerserivce.service.impl;

import cn.hutool.core.util.StrUtil;
import com.liuhf.common.lang.enums.Status;
import com.liuhf.common.lang.exception.BusinessException;
import com.liuhf.user.service.zeususerserivce.entity.ZeusRole;
import com.liuhf.user.service.zeususerserivce.repository.ZeusRoleRepository;
import com.liuhf.user.service.zeususerserivce.service.ZeusRoleService;
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
public class ZeusRoleServiceImpl implements ZeusRoleService {

    @Resource
    private ZeusRoleRepository repository;

    @Override
    public boolean save(ZeusRole entity) {
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
    public boolean modifyById(ZeusRole entity) {
        Optional.ofNullable(entity.getId()).orElseThrow(() -> new BusinessException(Status.NULL));
        return this.save(entity);
    }

    @Override
    public ZeusRole findOneById(Integer id) {
        return this.repository.findById(id).orElseThrow(() -> new BusinessException(Status.NO_DATA));
    }

    @Override
    public Page<ZeusRole> findAny(ZeusRole zeusRole, int page, int pageSize) {
        return this.repository.findAll((root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();
            String roleCode = zeusRole.getRoleCode();
            String roleName = zeusRole.getRoleName();
            Integer status = zeusRole.getStatus();

            if (StrUtil.isNotBlank(roleCode)) {
                predicates.add(builder.like(root.get("roleCode"), roleCode + "%"));
            }
            if (StrUtil.isNotBlank(roleName)) {
                predicates.add(builder.like(root.get("roleName"), roleName + "%"));
            }
            if (status != null) {
                predicates.add(builder.equal(root.get("status"), status));
            }

            return builder.and(predicates.toArray(new Predicate[0]));
        }, PageRequest.of(--page, pageSize));
    }
}