/*
 * Copyright (c) 2021 J`Han, private. All rights reserved.
 */
package me.jhan.seckill.sample.mq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import lombok.extern.slf4j.Slf4j;
import me.jhan.seckill.sample.constant.RabbitMqTopics;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

/**
 * 整个秒杀系统的队列
 * @author J`Han
 * @since 2021/3/11-2:19 下午
 */
@Slf4j
@Component
public class SeckillMqContainer {
    private static final String TOPIC = "topic";
    private static final String ROUTING_KEY = "";
    private ConnectionFactory factory;
    private Channel seckillChannel;
    private Channel paymentChannel;

     {
        // 标记初始化状态
        boolean isInitialized = true;
        factory = new ConnectionFactory();
        // 设置rabbitmq的ip和端口
        factory.setHost("localhost");
        try {
            seckillChannel = initSeckillMq();
            log.info("seckillChannel:{}",seckillChannel);
            paymentChannel = initPaymentMq();
            initSeckillConsumer();
            initPaymentConsumer();
        } catch (IOException e) {
            e.printStackTrace();
            log.error("Error:初始化信道失败，发生IO异常：{}",e.getMessage());
            isInitialized = false;
        } catch (TimeoutException e) {
            e.printStackTrace();
            log.error("Error:初始化信道失败，连接超时：{}",e.getMessage());
            isInitialized = false;
        }
        if(isInitialized){
            log.info("INFO：交换机、信道初始化完毕。");
        }
    }

    /**
     * 向指定信道发送消息的方法
     * @param msg 发送的消息内容
     * @param topic 指定的信道主题
     */
    public void seckillTopicMessage(String msg, RabbitMqTopics topic) {
        if(RabbitMqTopics.SECKILL_TOPIC.getTopic()
                .equals(topic.getTopic())){
            try {
                seckillChannel.basicPublish(RabbitMqTopics.SECKILL_TOPIC.getTopic(),ROUTING_KEY,null, msg.getBytes(StandardCharsets.UTF_8));
            } catch (IOException e) {
                e.printStackTrace();
                log.error("Error:秒杀消息发送失败，发生IO异常：{}",e.getMessage());
            }
            return;
        }
        try {
            paymentChannel.basicPublish(RabbitMqTopics.PAYMENT_TOPIC.getTopic(),ROUTING_KEY,null, msg.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
            log.error("Error:支付消息发送失败，发生IO异常：{}",e.getMessage());
        }
    }
    /**
     * 关闭资源
     */
    public void close(){
        try{
            seckillChannel.close();
            paymentChannel.close();
        }catch (TimeoutException | IOException exception){
            log.error("关闭资源异常：{}",exception.getMessage());
        }
    }

    /**
     * 初始化秒杀信道消费者
     * @throws IOException
     * TODO 完整这个方法
     */
    private void initSeckillConsumer() throws IOException {
        String queueName = seckillChannel.queueDeclare().getQueue();
        seckillChannel.queueBind(queueName, RabbitMqTopics.SECKILL_TOPIC.getTopic(), ROUTING_KEY);
        seckillChannel.basicConsume(queueName, false,(consumeTag, message)->{
            log.info("RECEIVED：consumeTag:{},message:{}",consumeTag,message);
        },consumerTag -> {
            log.info("CANCLED:{}",consumerTag);
        });

    }
    /**
     * 初始化支付信道消费者
     * @throws IOException
     * TODO 完整这个方法
     */
    private void initPaymentConsumer() throws IOException {
        String queueName = paymentChannel.queueDeclare().getQueue();
        paymentChannel.queueBind(queueName, RabbitMqTopics.PAYMENT_TOPIC.getTopic(), ROUTING_KEY);
        paymentChannel.basicConsume(queueName, false,(consumeTag, message)->{
            log.info("RECEIVED：consumeTag:{},message:{}",consumeTag,message);
        },consumerTag -> {
            log.info("CANCLED:{}",consumerTag);
        });

    }

    /**
     * 初始化秒杀消息处理队列
     * @return 生成的秒杀信道
     * @throws IOException 底层抛出异常
     * @throws TimeoutException 底层抛出异常
     */
    private Channel initSeckillMq() throws IOException, TimeoutException {
        Connection connection = null;
        Channel channel = null;
        try {
            connection = factory.newConnection();
            channel = connection.createChannel();
            channel.exchangeDeclare(RabbitMqTopics.SECKILL_TOPIC.getTopic(), TOPIC);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } catch (TimeoutException exception) {
            exception.printStackTrace();
        }
        return channel;
    }
    /**
     * 初始化支付消息处理队列
     * @return 生成的支付信道
     * @throws IOException 底层抛出异常
     * @throws TimeoutException 底层抛出异常
     */
    private Channel initPaymentMq() throws IOException, TimeoutException {
        Connection connection = null;
        Channel channel = null;
        try {
            connection = factory.newConnection();
            channel = connection.createChannel();
            channel.exchangeDeclare(RabbitMqTopics.PAYMENT_TOPIC.getTopic(), TOPIC);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } catch (TimeoutException exception) {
            exception.printStackTrace();
        }
        return channel;
    }

}