/*
 * Copyright (c) ${YEAR} J`Han, private. All rights reserved.
 */
package me.jhan.seckill.sample.constant;

/**
 * @author J`Han
 * @date Created at 2021/3/9
 **/
public enum StatusCode {
    /**
     * SUCCESS 表示操作成功，FAILURE 表示操作失败
     */
    SUCCESS(1001,"交易成功"),FAILURE(1011,"交易失败");

    private String description;
    private int code;
    StatusCode(int code, String description) {
        this.code = code;
        this.description = description;
    }
}
