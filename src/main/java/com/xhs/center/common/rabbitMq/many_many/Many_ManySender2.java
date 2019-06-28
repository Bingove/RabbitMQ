package com.xhs.center.common.rabbitMq.many_many;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @projectName RabbitMQ
 * @Author 常冬军
 * @Date 2019/6/28 0028下午 15:36
 * @title: HelloSender
 * @ToDo   发送者
 */
@Component
public class Many_ManySender2 {

    @Autowired
    private AmqpTemplate rabbitTemplate;


    public void send(int i) {
        String context = "many_many " + i;
        System.out.println("Sender 2 : " + context);
        this.rabbitTemplate.convertAndSend("many_many", context);
    }

}
