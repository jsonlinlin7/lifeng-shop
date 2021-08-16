package com.lifeng.shopserver.common;

import lombok.Data;

/**
 * Restfull统一返回风格
 * html状态代码 http://yige.org/tags/ref_httpmessages.php
 */
@Data
public class R<T> {
    private Integer code;
    private String message;
    private T data;

    public R(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public R(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}