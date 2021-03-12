/*
 * Copyright (c) 2021 J`Han, private. All rights reserved.
 */
package me.jhan.seckill.sample.mq_test;

import me.jhan.seckill.sample.constant.RabbitMqTopics;
import me.jhan.seckill.sample.mq.SeckillMqContainer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * 测试rabbitmq的controller
 *
 * @author J`Han
 * @since 2021/3/12-9:08 上午
 */
@RestController
@SpringBootTest
public class RabbitMqTestController {
    @Autowired
    private SeckillMqContainer container;
    @Test
    @GetMapping("/msg")
    public void sendMessageToMq() throws IOException {
        container.seckillTopicMessage("(*´▽｀)ノノ", RabbitMqTopics.PAYMENT_TOPIC);
    }
}