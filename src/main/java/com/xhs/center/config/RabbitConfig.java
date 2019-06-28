package com.xhs.center.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @projectName RabbitMQ
 * @Author 常冬军
 * @Date 2019/6/28 0028下午 15:33
 * @title: RabbitConfig
 * @ToDo 队列配置
 */
@Configuration
public class RabbitConfig {
    // one - one
    @Bean
    public Queue Queue() {
        return new Queue("hello");
    }

    // one - many
    @Bean
    public Queue Queue1() {
        return new Queue("neo");
    }

    // many - many
    @Bean
    public Queue Queue2() {
        return new Queue("many_many");
    }

    //object  必须序列化
    @Bean
    public Queue Queue3() {
        return new Queue("object_user");
    }
}
