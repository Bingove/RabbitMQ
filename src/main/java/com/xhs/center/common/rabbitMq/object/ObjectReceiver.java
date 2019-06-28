package com.xhs.center.common.rabbitMq.object;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @projectName RabbitMQ
 * @Author 常冬军
 * @Date 2019/6/28 0028下午 16:13
 * @title: ObjectReceiver
 * @ToDo
 */
@Component
@RabbitListener(queues = "object_user")
public class ObjectReceiver {
    @RabbitHandler
    public void process(User user) {
        System.out.println("Object_Receiver  : " + user.toString());
    }
}
