package com.zone.dijkstra.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author duanxin
 * @className: ServerResponse 统一响应对象
 * @date 2019-12-19 16:28
 **/
@Data
public class ServerResponse<T> implements Serializable {

    private int code;
    private String message;
    private T data;

    public ServerResponse() {
    }

    public ServerResponse(int code) {
        this.code = code;
    }

    public ServerResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public ServerResponse(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ServerResponse(int code, T data) {
        this.code = code;
        this.data = data;
    }

    public static <T> ServerResponse<T> success() {
        return new ServerResponse<>(ResponseCode.SUCCESS.getCode(),ResponseCode.SUCCESS.getDesc());
    }

//    public static <T> ServerResponse<T> success(String message) {
//        return new ServerResponse<>(ResponseCode.SUCCESS.getCode(), message);
//    }

    public static <T> ServerResponse<T> success(T data) {
        return new ServerResponse<>(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getDesc(),data);
    }

    public static <T> ServerResponse<T> success(String message, T data) {
        return new ServerResponse<>(ResponseCode.SUCCESS.getCode(), message, data);
    }

    public static <T> ServerResponse<T> error() {
        return new ServerResponse<>(ResponseCode.ERROR.getCode());
    }

    public static <T> ServerResponse<T> error(String message) {
        return new ServerResponse<>(ResponseCode.ILLEGAL_ARGUMENT.getCode(), message);
    }

    public static <T> ServerResponse<T> error(String message,T data) {
        return new ServerResponse<>(ResponseCode.ILLEGAL_ARGUMENT.getCode(), message,data);
    }

    public static <T> ServerResponse<T> error(int code, String message) {
        return new ServerResponse<>(code, message);
    }

    public static <T> ServerResponse<T> error(int code, String message, T data) {
        return new ServerResponse<>(code, message, data);
    }

}
