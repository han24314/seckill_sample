/*
 * Copyright (c) 2021 J`Han, private. All rights reserved.
 */
package me.jhan.seckill.sample.exception.sub;

import me.jhan.seckill.sample.exception.AbstractSeckillException;

/**
 * @author J`Han
 * @since 2021/3/9-10:54 上午
 */
public class NotEnoughAmountExceptionAbstract extends AbstractSeckillException {
    public NotEnoughAmountExceptionAbstract(String message, String msg) {
        super(msg);
    }
    public NotEnoughAmountExceptionAbstract(String message, Throwable cause, String msg) {
        super(cause, msg);
    }
}