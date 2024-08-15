package com.atguigu.hello_mp.service.impl;

import com.atguigu.hello_mp.entity.User;
import com.atguigu.hello_mp.mapper.UserMapper;
import com.atguigu.hello_mp.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
