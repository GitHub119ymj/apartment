package com.atguigu.hello_mp.mapper;

import com.atguigu.hello_mp.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    IPage<User> selectUserPage(IPage<User> page);

}
