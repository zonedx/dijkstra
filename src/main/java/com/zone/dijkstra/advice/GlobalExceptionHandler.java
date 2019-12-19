package com.zone.dijkstra.advice;

import com.zone.dijkstra.vo.ServerResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author duanxin
 * @className: GlobalExceptionHandler 全局异常处理
 * @date 2019-12-19 16:18
 **/

@ControllerAdvice
public class GlobalExceptionHandler {


    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity errorHandler(HttpServletRequest request,Exception ex){
        ServerResponse<String> response = ServerResponse.error();
        response.setMessage(ex.getMessage());
        response.setData(request.getRequestURL().toString());
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
