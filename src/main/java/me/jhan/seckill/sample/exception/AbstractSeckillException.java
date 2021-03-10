/*
 * Copyright (c) 2021 J`Han, private. All rights reserved.
 */
package me.jhan.seckill.sample.exception;

/**
 * @author J`Han
 * @since 2021/3/9-10:49 上午
 */
public abstract class AbstractSeckillException extends RuntimeException{
    private String msg;
    protected AbstractSeckillException(String msg) {
        super(msg);
    }
    protected AbstractSeckillException(Throwable cause, String msg) {
        super(msg, cause);
    }
}