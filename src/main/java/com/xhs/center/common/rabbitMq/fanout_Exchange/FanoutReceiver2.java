package com.xhs.center.common.rabbitMq.fanout_Exchange;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @projectName RabbitMQ
 * @Author 常冬军
 * @Date 2019/6/28 0028下午 16:39
 * @title: TopicReceiver1
 * @ToDo
 */
@Component
@RabbitListener(queues = "fanout.B")
public class FanoutReceiver2 {
    @RabbitHandler
    public void process(String hello) {
        System.out.println("Receiver B  : " + hello);
    }
}
