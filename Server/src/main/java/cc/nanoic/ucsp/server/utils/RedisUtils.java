package cc.nanoic.ucsp.server.utils;

import cc.nanoic.ucsp.server.entity.entityRequest.ReqRedis;
import cc.nanoic.ucsp.server.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
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
public class RedisUtils {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * Redis插入数据
     *
     * @param KeyName  键名
     * @param KeyValue 键值
     */
    public void set(String KeyName, String KeyValue) {
        try {
            stringRedisTemplate.opsForValue().set(KeyName, KeyValue);
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

    /**
     * 查询键数据
     * @param KeyName 键名
     * @return {name:键名,value:键值}
     */
    public Object get(String KeyName) {
        ReqRedis reqRedis = new ReqRedis();
        reqRedis.setName(KeyName);
        String value = stringRedisTemplate.opsForValue().get(KeyName);
        if(Objects.isNull(value)) {
            throw new ServiceException("没有查询到数据,可能是键不存在");
        }
        reqRedis.setValue(stringRedisTemplate.opsForValue().get(KeyName));
        return reqRedis;
    }

    /**
     * 删除键
     * @param KeyName 键名
     */
    public void delete(String KeyName) {
        String value = stringRedisTemplate.opsForValue().get(KeyName);
        if(Objects.isNull(value)) {
            throw new ServiceException("没有查询到数据,可能是键不存在");
        }
        stringRedisTemplate.delete(KeyName);
    }




}
