package com.atguigu.hello_mp.wrapper;

import com.atguigu.hello_mp.entity.User;
import com.atguigu.hello_mp.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class LambdaWrapperTest {

    @Autowired
    private UserService userService;

    @Test
    public void testLambdaQueryWrapper(){
        //查询name=Tom的所有用户
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(User::getName, "Tom");

        List<User> list = userService.list(lambdaQueryWrapper);
        list.forEach(System.out::println);
    }

    @Test
    public void testLambdaUpdateWrapper() {
        //将name=Tom的用户的邮箱改为Tom@tom.com
        LambdaUpdateWrapper<User> lambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        lambdaUpdateWrapper.eq(User::getName, "Tom");
        lambdaUpdateWrapper.set(User::getEmail, "Tom@Tom.com");

        userService.update(lambdaUpdateWrapper);
    }

}
