/*
 * Copyright (c) 2021 J`Han, private. All rights reserved.
 */
package me.jhan.seckill.sample.constant;

/**
 * 消息队列的主题枚举类
 * <li>{@link #SECKILL_TOPIC}</li>
 * <li>{@link #PAYMENT_TOPIC}</li>
 * @author J`Han
 * @since 2021/3/11-2:10 下午
 */
public enum RabbitMqTopics {
    /**
     * 用于处理秒杀的队列
     */
    SECKILL_TOPIC("seckill"),
    /**
     * 用于处理支付的队列
     */
    PAYMENT_TOPIC("payment");
    private String topic;

    RabbitMqTopics(String topic) {
        this.topic = topic;
    }

    public String getTopic() {
        return topic;
    }
}