package cc.nanoic.ucsp.server.common;

import java.lang.annotation.*;

/**
 * 接口访问频率注解，默认一分钟只能访问5次
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface InterfaceLimit {
    long time() default 60000; // 限制时间 单位：毫秒(默认值：一分钟）

    int value() default 3; // 允许请求的次数(默认值：3次）
}