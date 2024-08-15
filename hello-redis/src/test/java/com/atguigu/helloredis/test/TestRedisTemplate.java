package com.atguigu.helloredis.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestRedisTemplate {
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void testSet() {
        redisTemplate.opsForValue().set("k1","value");
    }

    @Test
    public void testGet() {
        String result = (String)redisTemplate.opsForValue().get("k1");
        System.out.println(result);
    }

    @Test
    public void testDel() {
        redisTemplate.delete("k1");

    }
}
