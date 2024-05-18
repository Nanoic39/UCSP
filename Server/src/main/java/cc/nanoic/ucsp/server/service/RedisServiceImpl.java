package cc.nanoic.ucsp.server.service;

/**
 * @FileName RedisServiceImpl
 * @Description
 * @Author fazhu
 * @date 2024-05-13
 **/
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class RedisServiceImpl implements  RedisService{
    @Autowired
    private StringRedisTemplate stringRedisTemplate;



    @Override
    public void set(String key, String value) {

       stringRedisTemplate.opsForValue().set(key, value);

    }

    @Override
    public String get(String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }

    @Override
    public boolean expire(String key, long expire) {
        return stringRedisTemplate.expire(key, expire, TimeUnit.SECONDS);
    }

    @Override
    public void remove(String key) {
        stringRedisTemplate.delete(key);
    }

    @Override

    public Long increment(String key, int delta) {

        return stringRedisTemplate.opsForValue().increment(key,delta);
    }

}