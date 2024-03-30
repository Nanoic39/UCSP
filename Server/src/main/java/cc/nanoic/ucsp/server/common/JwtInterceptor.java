package cc.nanoic.ucsp.server.common;

import cc.nanoic.ucsp.server.entity.User;
import cc.nanoic.ucsp.server.exception.ServiceException;
import cc.nanoic.ucsp.server.mapper.UserMapper;
import cn.hutool.core.util.StrUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * @Description:
 * @Author: Nanoic
 * @Date: 2024-03-30
 * @FileName: JwtInterceptor
 **/

public class JwtInterceptor implements HandlerInterceptor {
    @Resource
    private UserMapper userMapper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String token = request.getHeader("token");
        String uuid = request.getHeader("uuid");

        if (StrUtil.isBlank(token)) {
            token = request.getParameter("token");
        }
        if (StrUtil.isBlank(uuid)) {
            uuid = request.getParameter("uuid");
        }
        /* 如果有注解直接绕过Token检测 */
        if (handler instanceof HandlerMethod) {
            AuthAccess annotation = ((HandlerMethod) handler).getMethodAnnotation(AuthAccess.class);
            if (annotation != null) {
                return true;
            }
        }
        if (StrUtil.isBlank(token)) {
            throw new ServiceException("401", "请先登录! [错误码：Jx01]");
        }
        String userId;
        try {
            userId = JWT.decode(token).getAudience().get(0);
        } catch (JWTDecodeException j) {
            throw new ServiceException("401", "JWT解码失败! [错误码：Jx02]");
        }
        User user = userMapper.selectById(Integer.valueOf(userId));
        if (user == null) {
            throw new ServiceException("401", "JWT异常! [错误码：Jx03]");
        }
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(user.getPassword())).build();
        try {
            //验证Token
            jwtVerifier.verify(token);
        } catch (JWTVerificationException j) {
            throw new ServiceException("401", "JWT异常! [错误码：Jx04]");
        }
        if (!userId.equals(uuid)) {
            throw new ServiceException("401", "JWT异常！这可能不是您的token... [错误码：Jx05]");
        }
        return true;
    }
}
