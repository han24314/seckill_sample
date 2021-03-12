/*
 * Copyright (c) 2021 J`Han, private. All rights reserved.
 */
package me.jhan.seckill.sample.controller;

import me.jhan.seckill.sample.constant.RabbitMqTopics;
import me.jhan.seckill.sample.mq.SeckillMqContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 测试rabbitmq的controller
 *
 * @author J`Han
 * @since 2021/3/12-9:08 上午
 */
@RestController
public class RabbitMqTestController {
    @Autowired
    private SeckillMqContainer container;
    @GetMapping("/msg")
    public void sendMessageToMq() {
        container.seckillTopicMessage("(*´▽｀)ノノ", RabbitMqTopics.PAYMENT_TOPIC);
    }
}