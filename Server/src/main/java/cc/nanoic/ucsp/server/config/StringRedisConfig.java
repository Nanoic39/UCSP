package cc.nanoic.ucsp.server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;

/**
 * @Description:
 * @Author: Nanoic
 * @Date: 2024-05-25
 * @FileName: redisTemplate
 **/
@EnableRedisRepositories
public class StringRedisConfig {

    @Bean
    public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory redisConnectionFactory){
        StringRedisTemplate stringRedisTemplate = new StringRedisTemplate();
        //设置redis连接工厂对象
        stringRedisTemplate.setConnectionFactory(redisConnectionFactory);
        //创建Json序列化工具
        GenericJackson2JsonRedisSerializer genericJackson2JsonRedisSerializer = new GenericJackson2JsonRedisSerializer();
        //redis中的key序列化器
        stringRedisTemplate.setKeySerializer(RedisSerializer.string());
        stringRedisTemplate.setHashKeySerializer(RedisSerializer.string());
        //redis中的Object序列化器
        stringRedisTemplate.setValueSerializer(genericJackson2JsonRedisSerializer);
        stringRedisTemplate.setHashValueSerializer(genericJackson2JsonRedisSerializer);
        return stringRedisTemplate;
    }
}