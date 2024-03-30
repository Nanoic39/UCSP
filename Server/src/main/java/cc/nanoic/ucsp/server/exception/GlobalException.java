package cc.nanoic.ucsp.server.exception;

import cc.nanoic.ucsp.server.common.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description:
 * @Author: Nanoic
 * @Date: 2023-12-25
 * @FileName: GlobalException
 **/
@ControllerAdvice
public class GlobalException {

    @ExceptionHandler(ServiceException.class)
    @ResponseBody
    public Result serviceExcepiton(ServiceException e){
        return Result.error(e.getCode(), e.getMessage());
    }

}
