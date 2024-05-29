package cc.nanoic.ucsp.server.utils;

import cc.nanoic.ucsp.server.entity.entityRequest.ReqRedis;
import cc.nanoic.ucsp.server.exception.ServiceException;
import jakarta.annotation.Resource;
import org.bouncycastle.cert.ocsp.Req;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author: Nanoic
 * @Date: 2024-05-20
 * @FileName: RedisUtils
 **/

@Component
@EnableRedisRepositories
public class RedisUtils {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    public StringRedisTemplate getStringRedisTemplate(int index) {
        return (StringRedisTemplate) getTemplate(stringRedisTemplate, index);
    }

    public RedisTemplate getTemplate(RedisTemplate redisTemplate, int index) {
        LettuceConnectionFactory lettuceConnectionFactory = (LettuceConnectionFactory) redisTemplate.getConnectionFactory();
        lettuceConnectionFactory.setDatabase(index);
        redisTemplate.setConnectionFactory(lettuceConnectionFactory);
        return redisTemplate;
    }


    /**
     * Redis插入数据
     *
     * @param KeyName  键名
     * @param KeyValue 键值
     */
    public void set(String KeyName, String KeyValue) {
        try {
            getStringRedisTemplate(0).opsForValue().set(KeyName, KeyValue);
        } catch (Exception e) {
            throw new ServiceException(e.getMessage());
        }

    }

    /**
     * Redis插入数据
     *
     * @param KeyName  键名
     * @param KeyValue 键值
     * @param timeout  超时时间(单位:秒)
     */
    public void set(String KeyName, String KeyValue, long timeout) {
        TimeUnit unit = TimeUnit.SECONDS;
        stringRedisTemplate.opsForValue().set(KeyName, KeyValue, timeout, unit);
    }

    /**
     * Redis插入数据
     *
     * @param KeyName  键名
     * @param KeyValue 键值
     * @param timeout  超时时间
     * @param unit     时间单位(TimeUnit类型)
     */
    public void set(String KeyName, String KeyValue, long timeout, TimeUnit unit) {
        stringRedisTemplate.opsForValue().set(KeyName, KeyValue, timeout, unit);
    }

    public void set(String KeyName, String KeyValue, long timeout, TimeUnit unit, int index) {
        getStringRedisTemplate(index).opsForValue().set(KeyName, KeyValue, timeout, unit);
    }

    /**
     * Redis插入多个键
     *
     * @param KeyList 数据列表 {KeyName:KeyValue,...}
     */
    public void set(List<ReqRedis> KeyList) {
        for (ReqRedis Key : KeyList) {
            try {
                stringRedisTemplate.opsForValue().set(Key.getName(), Key.getValue());
            } catch (Exception e) {
                throw new ServiceException(e.getMessage());
            }
        }
    }

    public void set(List<ReqRedis> KeyList, int index) {
        for (ReqRedis Key : KeyList) {
            try {
                getStringRedisTemplate(index).opsForValue().set(Key.getName(), Key.getValue());
            } catch (Exception e) {
                throw new ServiceException(e.getMessage());
            }
        }
    }

    /**
     * Redis插入多个键
     *
     * @param KeyList 数据列表 {KeyName:KeyValue,...}
     * @param timeout 超时时间(单位:秒)
     */
    public void set(List<ReqRedis> KeyList, long timeout) {
        for (ReqRedis Key : KeyList) {
            try {
                stringRedisTemplate.opsForValue().set(Key.getName(), Key.getValue(), timeout);
            } catch (Exception e) {
                throw new ServiceException(e.getMessage());
            }
        }
    }

    public void set(List<ReqRedis> KeyList, long timeout, int index) {
        for (ReqRedis Key : KeyList) {
            try {
                getStringRedisTemplate(index).opsForValue().set(Key.getName(), Key.getValue(), timeout);
            } catch (Exception e) {
                throw new ServiceException(e.getMessage());
            }
        }
    }

    /**
     * Redis插入多个键
     *
     * @param KeyList 数据列表 {KeyName:KeyValue,...}
     * @param timeout 超时时间
     * @param unit    时间单位(TimeUnit类型)
     */
    public void set(List<ReqRedis> KeyList, long timeout, TimeUnit unit) {
        for (ReqRedis Key : KeyList) {
            try {
                stringRedisTemplate.opsForValue().set(Key.getName(), Key.getValue(), timeout, unit);
            } catch (Exception e) {
                throw new ServiceException(e.getMessage());
            }
        }
    }

    public void set(List<ReqRedis> KeyList, long timeout, TimeUnit unit, int index) {
        for (ReqRedis Key : KeyList) {
            try {
                getStringRedisTemplate(index).opsForValue().set(Key.getName(), Key.getValue(), timeout, unit);
            } catch (Exception e) {
                throw new ServiceException(e.getMessage());
            }
        }
    }

    /**
     * 查询键数据
     *
     * @param KeyName 键名
     * @return {name:键名,value:键值}
     */
    public ReqRedis get(String KeyName) {
        ReqRedis reqRedis = new ReqRedis();
        reqRedis.setName(KeyName);
        String value = stringRedisTemplate.opsForValue().get(KeyName);
        if (Objects.isNull(value)) {
            throw new ServiceException("没有查询到数据,可能是键不存在");
        }
        reqRedis.setValue(stringRedisTemplate.opsForValue().get(KeyName));
        return reqRedis;
    }

    public ReqRedis get(String KeyName, int index) {
        ReqRedis reqRedis = new ReqRedis();
        reqRedis.setName(KeyName);
        String value = getStringRedisTemplate(index).opsForValue().get(KeyName);
        if (Objects.isNull(value)) {
            throw new ServiceException("没有查询到数据,可能是键不存在");
        }
        reqRedis.setValue(getStringRedisTemplate(index).opsForValue().get(KeyName));
        return reqRedis;
    }

    /**
     * 删除键
     *
     * @param KeyName 键名
     */
    public void delete(String KeyName) {
        String value = stringRedisTemplate.opsForValue().get(KeyName);
        if (Objects.isNull(value)) {
            throw new ServiceException("没有查询到数据,可能是键不存在");
        }
        stringRedisTemplate.delete(KeyName);
    }

    public void delete(String KeyName, int index) {
        String value = getStringRedisTemplate(index).opsForValue().get(KeyName);
        if (Objects.isNull(value)) {
            throw new ServiceException("没有查询到数据,可能是键不存在");
        }
        getStringRedisTemplate(index).delete(KeyName);
    }


}
