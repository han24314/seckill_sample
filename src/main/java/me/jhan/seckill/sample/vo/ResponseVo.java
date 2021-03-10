/*
 * Copyright (c) ${YEAR} J`Han, private. All rights reserved.
 */
package me.jhan.seckill.sample.vo;

import me.jhan.seckill.sample.constant.StatusCode;

/**
 * 此类是用于返回前端的vo类, CODE 枚举状态码, msg 附带传递信息
 * @author J`Han
 * @since 2021/3/9-9:50 上午
 */
public class ResponseVo {

    private  StatusCode code;
    private String msg;

    public StatusCode getCode() { return code; }
    public void setCode(StatusCode code) { this.code = code; }
    public String getMsg() { return msg; }
    public void setMsg(String msg) { this.msg = msg; }

    private ResponseVo(StatusCode code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static ResponseVo getInstance(StatusCode code, String msg){
        return new ResponseVo(code, msg);
    }

}