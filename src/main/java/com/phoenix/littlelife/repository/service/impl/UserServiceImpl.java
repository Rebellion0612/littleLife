package com.phoenix.littlelife.repository.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.phoenix.littlelife.repository.entity.User;
import com.phoenix.littlelife.repository.service.UserService;
import com.phoenix.littlelife.repository.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
implements UserService{

}




