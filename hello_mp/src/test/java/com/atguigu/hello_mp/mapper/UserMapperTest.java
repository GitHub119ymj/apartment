package com.atguigu.hello_mp.mapper;

import com.atguigu.hello_mp.HelloMpApplication;
import com.atguigu.hello_mp.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testList(){
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }
    @Test
    public void testSelectById(){
        User user = userMapper.selectById(1);
        System.out.println(user);
    }

    @Test
    public void testInsert(){
        User user = new User();
        user.setName("xiaofu");
        user.setAge(20);
        user.setEmail("fufufu@fu.com");
        userMapper.insert(user);
    }

    @Test
    public void testUpdateById(){
        User user = userMapper.selectById(1);
        user.setName("xiaoyang");
        userMapper.updateById(user);
    }
    @Test
    public void testDeleteById(){
        userMapper.deleteById(1);
    }

}