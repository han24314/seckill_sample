/*
 * Copyright (c) ${YEAR} J`Han, private. All rights reserved.
 */
package me.jhan.seckill.sample.instruct;

import java.util.EventObject;

/** 自定义事件抽象类，用于统一管理自定义事件
 * @author J`Han
 * @since 2021/3/9-10:40 上午
 */
public abstract class AbstractSeckillEventInstruct extends EventObject {
    /**
     * 事件源构造器
     * @param source 事件源对象.
     * @throws IllegalArgumentException 事件源为空时抛出非法参数异常.
     */
    public AbstractSeckillEventInstruct(Object source) {
        super(source);
    }
}