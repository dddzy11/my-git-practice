package com.springboot.keyan.comm;

import lombok.Getter;

/**
 *
 * 自定义参数枚举
 *
 **/
@Getter
public enum ResultEnum {

    CODE_1(1, "成功"),
    CODE_2(2, "ERROR "),
    CODE_3(3, ""),

    CODE_401(401, "账号或者密码错误！"),
    CODE_403(403, "没有获取授权！"),
    CODE_404(404, "找不到该路径！"),
    CODE_405(405, "请求方式错误！"),
    CODE_406(406, "Not Acceptable"),
    CODE_415(415, "请求参数格式错误！"),
    CODE_500(500, "网络连接超时,请稍后再试！");

    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
