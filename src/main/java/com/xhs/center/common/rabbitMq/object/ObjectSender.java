package com.xhs.center.common.rabbitMq.object;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @projectName RabbitMQ
 * @Author 常冬军
 * @Date 2019/6/28 0028下午 16:08
 * @title: ObjectSender
 * @ToDo
 */
@Component
public class ObjectSender {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(User user) {
        System.out.println(user.toString());
        this.rabbitTemplate.convertAndSend("object_user",user);
    }
}
