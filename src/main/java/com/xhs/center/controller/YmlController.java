package com.xhs.center.controller;

import com.xhs.center.common.rabbitMq.many_many.Many_ManySender1;
import com.xhs.center.common.rabbitMq.many_many.Many_ManySender2;
import com.xhs.center.common.rabbitMq.object.ObjectSender;
import com.xhs.center.common.rabbitMq.one_many.One_ManySender;
import com.xhs.center.common.rabbitMq.one_one.HelloReceiver;
import com.xhs.center.common.rabbitMq.one_one.HelloSender;
import com.xhs.center.common.rabbitMq.topic_Exchange.TopicSender;
import com.xhs.center.config.Read_Yml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @projectName RabbitMQ
 * @Author 常冬军
 * @Date 2019/6/27 0027上午 11:06
 * @title: YmlController
 * @ToDo
 */
@RestController
public class YmlController {

    /*
    *
    *   opsForValue： 对应 String（字符串）
        opsForZSet： 对应 ZSet（有序集合）
        opsForHash： 对应 Hash（哈希）
        opsForList： 对应 List（列表）
        opsForSet： 对应 Set（集合）
    *
    * */
    @Autowired
    private RedisTemplate redisTemplate;
    @Resource
    Read_Yml read_yml;
    @Autowired
    private HelloSender helloSender;
    @Autowired
    private HelloReceiver helloReceiver;
    @Autowired
    private One_ManySender one_manySender;
    @Autowired
    private Many_ManySender1 many_manySender1;
    @Autowired
    private Many_ManySender2 many_manySender2;
    @Autowired
    private ObjectSender objectSender;
    @Autowired
    private TopicSender topicSender;

    @GetMapping("/a1")
    public String ge() {

        String address = read_yml.getAddress();
        ZSetOperations zSetOperations = redisTemplate.opsForZSet();
        HashOperations hashOperations = redisTemplate.opsForHash();
        ValueOperations valueOperations = redisTemplate.opsForValue();
        valueOperations.set("keya", "s");
        Boolean add = zSetOperations.add("keys", "s", 500);
        System.out.println(add);
        //HSET
        hashOperations.put("aa", "name", "cdj");

        Object o = hashOperations.get("aa", "name");
        System.out.println(o);
        return address;
    }

    @GetMapping("/a")
    public String ge1() {
        helloSender.send();
        return "￥￥￥";
    }
}
