package com.springboot.keyan.comm;

import lombok.Getter;

/**
 * 枚举类
 */
@Getter
public enum DictionaryEnum {

    /**
     * 删除枚举类
     */
    IS_DEL_N(1, "未删除"),
    IS_DEL_Y(2, "已删除"),

    /**
     * 启用禁用枚举类
     */
    IS_ENABLE_N(1, "启用"),
    IS_ENABLE_Y(2, "禁用"),

    /**
     * 启用禁用枚举类
     */
    IS_BINDING_Y(1, "绑定"),
    IS_BINDING_N(2, "未绑定");


    /**
     * 状态码
     */
    private int code;
    /**
     * 状态名称
     */
    private String name;

    DictionaryEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }


}
