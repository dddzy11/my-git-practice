package com.springboot.keyan.exception;
import com.springboot.keyan.comm.ResultEnum;
import lombok.Getter;

//自定义异常类
@Getter
public class MyException extends RuntimeException {

    private ResultEnum resultEnum;

    public MyException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.resultEnum = resultEnum;
    }

    public MyException(ResultEnum resultEnum, String message) {
        super(resultEnum.getMsg() + message);
        this.resultEnum = resultEnum;
    }


}
