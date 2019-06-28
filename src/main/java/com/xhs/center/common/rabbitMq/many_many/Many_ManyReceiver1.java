package com.xhs.center.common.rabbitMq.many_many;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @projectName RabbitMQ
 * @Author 常冬军
 * @Date 2019/6/28 0028下午 15:36
 * @title: HelloReceiver
 * @ToDo  接收者
 */
@Component
@RabbitListener(queues = "many_many")
public class Many_ManyReceiver1 {

    @RabbitHandler
    public void process(String neo) {
        System.out.println("Receiver1  : " + neo);
    }

}
