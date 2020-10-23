package com.albert.config;
import io.lettuce.core.resource.ClientResources;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.io.Serializable;

/**
 * RedisTemplate的配置
 */
@Configuration
@AutoConfigureAfter(RedisAutoConfiguration.class)
public class RedisCacheAutoConfiguration {


    @Bean("redisTemplate")
    public RedisTemplate<String, String> redisCacheTemplate(JedisConnectionFactory redisConnectionFactory) {
        
        RedisTemplate<String, String> template = new RedisTemplate<>();
        // 设置 key 序列化方式，StringRedisSerializer的序列化方式，如果没有设置，key前面会有一段字节。
//        template.setKeySerializer(new StringRedisSerializer());
//        // 设置 value 序列化方式，序列化为 json。
//        template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        // 设置连接池
        template.setConnectionFactory(redisConnectionFactory);
        return template;
    }

    @Bean
    public JedisConnectionFactory jedisConnectionFactory () {
        JedisConnectionFactory factory = new JedisConnectionFactory();
        factory.setHostName("192.168.199.100");//预发 10.100.2.117
        factory.setPort(6390);

        return factory;
    }
}