package com.xhs.center.common.rabbitMq.one_many;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @projectName RabbitMQ
 * @Author 常冬军
 * @Date 2019/6/28 0028下午 15:36
 * @title: HelloSender
 * @ToDo   发送者
 */
@Component
public class One_ManySender {

    @Autowired
    private AmqpTemplate rabbitTemplate;


    public void send(int i) {
        String context = "neo " + i;
        System.out.println("Sender : " + context);
        this.rabbitTemplate.convertAndSend("neo", context);
    }

}
