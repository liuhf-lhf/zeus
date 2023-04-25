package com.liuhf.user.service.zeususerserivce.service.impl;

import cn.hutool.core.util.StrUtil;
import com.liuhf.common.lang.exception.BusinessException;
import com.liuhf.common.lang.enums.Status;
import com.liuhf.user.api.dto.ZeusUserDto;
import com.liuhf.user.service.zeususerserivce.entity.ZeusUser;
import com.liuhf.user.service.zeususerserivce.service.ZeusUserService;
import com.liuhf.user.service.zeususerserivce.repository.ZeusUserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.persistence.criteria.Predicate;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * @author liuhf
 * @date 2023/4/12
 * @since 1.0
 */
@Service
public class ZeusUserServiceImpl implements ZeusUserService {

    @Resource
    private ZeusUserRepository repository;

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
    public ZeusUser findOneByUsername(String username) {
        return repository.findByUsernameAndLock(username).orElseThrow(()->new BusinessException(Status.NO_DATA));
    }
}