package com.xhs.center.common.rabbitMq.fanout_Exchange;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @projectName RabbitMQ
 * @Author 常冬军
 * @Date 2019/6/28 0028下午 16:33
 * @title: TopicSender
 * @ToDo
 */
@Component
public class FanoutSender {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    /**
     * Fanout Exchange 消息广播的模式，
     * 不管路由键或者是路由模式，
     * 会把消息发给绑定给它的全部队列，
     * 如果配置了routing_key会被忽略
     */
    public void send() {
        String context = "今天要回家啦";
        System.out.println("Sender : " + context);
        this.rabbitTemplate.convertAndSend("fanoutExchange", "", context);  // 写不写都一样，只要绑定之后都能收到
    }
}
