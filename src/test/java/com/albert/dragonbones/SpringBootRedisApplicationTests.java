package com.albert.dragonbones;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class SpringBootLettuceRedisApplicationTests {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringBootLettuceRedisApplicationTests.class);


    @Autowired
    @Qualifier("redisTemplate")
    private RedisTemplate<String, String> redisTemplate;


    @Test
    public void setAndGet() {

        redisTemplate.opsForValue().set("test_1123", "123");
        redisTemplate.expire("test_1123", 1, TimeUnit.MINUTES);

        System.out.println(redisTemplate.opsForValue().get("test_1123"));
    }
    

    
}