package cc.nanoic.ucsp.server.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description: 统一返回消息
 * @Author: Nanoic
 * @Date: 2024-03-30
 * @FileName: Result
 **/


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Result {
    /**
     * 200: 成功
     * 404: 未找到对应资源
     * 500: 服务器内部错误
     * 422: 参数错误
     */
    public static final String CODE_SUCCESS = "200";
    public static final String CODE_ERROR_NOTFOUND = "404";
    public static final String CODE_ERROR_SYSTEM = "500";
    public static final String CODE_ERROR_PARAM = "422";

    private String statusCode;
    private String msg;
    private Object data;

    public static Result success(){
        return new Result(CODE_SUCCESS, "请求成功", null);
    }
    public static Result success(String msg){
        return new Result(CODE_SUCCESS, msg, null);
    }
    public static Result success(Object data){
        return new Result(CODE_SUCCESS, "请求成功", data);
    }
    public static Result error(String msg){
        return new Result(CODE_ERROR_SYSTEM, msg, null);
    }
    public static Result error(String code,String msg){
        return new Result(code, msg, null);
    }
    public static Result error(){
        return new Result(CODE_ERROR_SYSTEM, "系统错误", null);
    }

}
