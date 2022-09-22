package com.nowcoder.community.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

@Configuration
public class RedisConfig {

    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
        //将连接给RedisTemplate以具备连接数据库的能力
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(factory);

        //设置key的序列化的方式
        template.setKeySerializer(RedisSerializer.string());
        //设置value的序列化的方式
        template.setValueSerializer(RedisSerializer.json());
        //设置value的hash的key的序列化的方式
        template.setHashKeySerializer(RedisSerializer.string());
        //设置value的hash的value的序列化方式
        template.setHashValueSerializer(RedisSerializer.json());

        //配置生效
        template.afterPropertiesSet();
        return template;
    }
}
