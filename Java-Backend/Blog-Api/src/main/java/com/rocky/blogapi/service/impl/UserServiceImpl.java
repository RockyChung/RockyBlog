package com.rocky.blogapi.service.impl;

import com.rocky.blogapi.entity.User;
import com.rocky.blogapi.mapper.UserMapper;
import com.rocky.blogapi.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Rocky
 * @since 2025-11-29
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
