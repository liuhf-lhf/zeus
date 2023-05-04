package com.liuhf.user.service.zeususerserivce.service.impl;

import cn.hutool.core.util.StrUtil;
import com.liuhf.common.lang.enums.Status;
import com.liuhf.common.lang.exception.BusinessException;
import com.liuhf.user.api.dto.ZeusRoleDto;
import com.liuhf.user.api.dto.ZeusUserDto;
import com.liuhf.user.service.zeususerserivce.entity.ZeusRole;
import com.liuhf.user.service.zeususerserivce.entity.ZeusUser;
import com.liuhf.user.service.zeususerserivce.entity.ZeusUserRole;
import com.liuhf.user.service.zeususerserivce.entity.ZeusUserRoleId;
import com.liuhf.user.service.zeususerserivce.repository.ZeusRoleRepository;
import com.liuhf.user.service.zeususerserivce.repository.ZeusUserRepository;
import com.liuhf.user.service.zeususerserivce.repository.ZeusUserRoleRepository;
import com.liuhf.user.service.zeususerserivce.service.ZeusUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.persistence.criteria.Predicate;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author liuhf
 * @date 2023/4/12
 * @since 1.0
 */
@Service
public class ZeusUserServiceImpl implements ZeusUserService {

    @Resource
    private ZeusUserRepository repository;

    private ZeusUserRoleRepository userRoleRepository;


    private ZeusRoleRepository roleRepository;

    @Autowired
    public void setZeusRoleRepository(ZeusRoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Autowired
    public void setZeusUserRoleRepository(ZeusUserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public boolean save(ZeusUser entity) {
        try {
            Optional.ofNullable(entity.getPassword()).ifPresent(p -> entity.setPassword(PasswordEncoderFactories.createDelegatingPasswordEncoder().encode(p)));
            this.repository.saveAndFlush(entity);
        } catch (Exception e) {
            throw new BusinessException(e, Status.SAVE_ERROR);
        }
        return true;
    }

    @Override
    public boolean deleteById(Long id) {
        try {
            this.repository.deleteById(id);
        } catch (Exception e) {
            throw new BusinessException(e, Status.DELETE_ERROR);
        }
        return true;
    }

    @Override
    public boolean modifyById(ZeusUser entity) {
        Optional.ofNullable(entity.getId()).orElseThrow(() -> new NullPointerException("主键不能为空!!!"));
        return save(entity);
    }

    @Override
    public ZeusUser findOneById(Long id) {
        return this.repository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<ZeusUser> findAny(String username, String realName, Integer page, Integer pageSize) {
        return this.repository.findAll((root, query, builder) -> {
            List<Predicate> predicates = new LinkedList<>();
            if (StrUtil.isNotBlank(username)) {
                predicates.add(builder.like(root.get("username"), username + "%"));
            }
            if (StrUtil.isNotBlank(realName)) {
                predicates.add(builder.like(root.get("realName"), realName + "%"));
            }
            return builder.and(predicates.toArray(new Predicate[0]));
        }, PageRequest.of(--page, pageSize));
    }

    @Override
    @Transactional(readOnly = true)
    public ZeusUserDto findOneByUsername(String username) {
        ZeusUser user = repository.findZeusUserByUsername(username).orElseThrow(() -> new BusinessException(Status.NULL));
        Set<ZeusRoleDto> roleDtos = user.getZeusRoles().stream().map(r -> new ZeusRoleDto(r.getId(), r.getRoleCode(), r.getRoleName(), r.getStatus(), r.getCreateTime(), r.getUpdateTime())).collect(Collectors.toSet());
        return new ZeusUserDto(user.getId(),
                user.getUsername(),
                user.getPassword(),
                user.getHeadImg(),
                user.getRealName(),
                user.getPhone(),
                user.getEmail(),
                user.getLock(),
                user.getCreateTime(),
                user.getUpdateTime(),
                roleDtos);
    }

    @Override
    public boolean userAuthorization(long uid, Integer[] rids) {
        try {
            userRoleRepository.deleteById_UserId(uid);

            List<ZeusUserRole> list = Arrays.stream(rids).map(r -> {
                ZeusUserRole ur = new ZeusUserRole();
                ZeusUserRoleId id = new ZeusUserRoleId();
                id.setUserId(uid);
                id.setRoleId(r);
                ur.setId(id);

                ZeusUser user = new ZeusUser();
                user.setId(uid);
                ZeusRole role = new ZeusRole();
                role.setId(r);

                ur.setUser(user);
                ur.setRole(role);

                return ur;
            }).toList();

            userRoleRepository.saveAllAndFlush(list);
        } catch (Exception e) {
            throw new BusinessException(e, Status.SAVE_ERROR);
        }
        return true;
    }

    @Override
    public List<ZeusRole> findZeusUserRoleOfUser(Long uid) {
        return roleRepository.findRoleByUsers_Id(uid, 0);
    }
}