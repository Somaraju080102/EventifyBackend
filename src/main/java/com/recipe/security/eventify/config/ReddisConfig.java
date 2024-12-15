package com.recipe.security.eventify.config;


import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.serializer.StringRedisSerializer;


@Configuration
public class ReddisConfig {
	
	@Bean
	public JedisConnectionFactory jedisConnectionFactory(){
		
		RedisStandaloneConfiguration redisStandaloneConfiguration =new RedisStandaloneConfiguration("redis-10936.c301.ap-south-1-1.ec2.redns.redis-cloud.com",10936);
		
		redisStandaloneConfiguration.setUsername("default");
		redisStandaloneConfiguration.setPassword("HG92CHslbUcrYaRVgzNFoTd7tBKpzV7q");
		
		JedisClientConfiguration jedisClientConfiguration =JedisClientConfiguration.builder().build();
		
		
		return new JedisConnectionFactory(redisStandaloneConfiguration,jedisClientConfiguration);
		
		
		
	}
    @Bean
    public RedisTemplate<String, String> redisTemplate() {
        RedisTemplate<String, String> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(jedisConnectionFactory());
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new StringRedisSerializer());
        return redisTemplate;
    }


}
