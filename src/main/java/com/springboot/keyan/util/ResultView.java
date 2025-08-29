package com.springboot.keyan.util;

import com.springboot.keyan.comm.ResultEnum;
import lombok.Data;

import java.io.Serializable;

/**
 *
 * restFul自定义响应类
 *
 **/
@Data
public class ResultView<T> implements Serializable {

    private Integer code;

    private String msg;

    private T data;

    private long time;

    public static ResultView ok(int code, String msg) {
        return new ResultView(code, msg);
    }

    public static <T> ResultView<T> ok(T data) {
        return new ResultView(data);
    }

    public static <T> ResultView<T> ok() {
        return new ResultView();
    }

    public static <T> ResultView<T> error(String errMsg) {
        return new ResultView(errMsg);
    }

    public static ResultView error(ResultEnum resultEnum) {
        return new ResultView(resultEnum.getCode(), resultEnum.getMsg());
    }

    public static <T> ResultView<T> okCode(int code, T data) {
        return new ResultView(code, data);
    }


    public static ResultView error(Integer code, String errMsg) {
        return new ResultView(code, errMsg);
    }

    private ResultView() {
        this.data = data;
        this.code = 1;
        this.msg = "成功";
        this.time = System.currentTimeMillis();
    }

    private ResultView(T data) {
        this.data = data;
        this.code = 1;
        this.msg = "成功";
        this.time = System.currentTimeMillis();
    }

    private ResultView(String msg) {
        this.data = data;
        this.code = 2;
        this.msg = msg;
        this.time = System.currentTimeMillis();
    }

    private ResultView(int code, T data) {
        this.data = data;
        this.code = code;
        this.msg = "成功";
        this.time = System.currentTimeMillis();
    }

    private ResultView(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
        this.time = System.currentTimeMillis();
    }

}
