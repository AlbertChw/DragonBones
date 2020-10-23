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

import java.util.LinkedHashMap;
import java.util.concurrent.TimeUnit;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class SpringBootRedisApplicationTests {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringBootRedisApplicationTests.class);


    @Autowired
    @Qualifier("redisTemplate")
    private RedisTemplate<String, String> redisTemplate;


    @Test
    public void setAndGet() {

        redisTemplate.opsForValue().set("test_1123", "123");
        redisTemplate.expire("test_1123", 1, TimeUnit.MINUTES);

        System.out.println(redisTemplate.opsForValue().get("test_1123"));
    }
    

    @Test
    public void test () {
        LinkedHashMap<String, Double> temp = new LinkedHashMap<>();
        temp.put("0,3",1.15);
        temp.put("4,9",1.25);
        temp.put("10,15",1.35);
        temp.put("16,20",1.45);



        int price = 2;
        temp.entrySet().stream().peek(x->{
            String[] arr = x.getKey().split(",");
            if (price >Integer.parseInt(arr[0]) && price <= Integer.parseInt(arr[1])) {
                System.out.println(x.getValue());
            }

        });
    }
}