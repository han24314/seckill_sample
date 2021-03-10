/*
 * Copyright (c) 2021 J`Han, private. All rights reserved.
 */
package me.jhan.seckill.sample.exception.sub;

import me.jhan.seckill.sample.exception.AbstractSeckillException;

/**
 * @author J`Han
 * @since 2021/3/9-10:51 上午
 */
public class NotOnTimeExceptionAbstract extends AbstractSeckillException {
    public NotOnTimeExceptionAbstract(String message, String msg) {
        super(msg);
    }
    public NotOnTimeExceptionAbstract(String message, Throwable cause, String msg) {
        super(cause, msg);
    }
}