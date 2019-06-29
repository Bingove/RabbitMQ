package com.xhs.center.test;

import com.xhs.center.common.rabbitMq.fanout_Exchange.FanoutSender;
import com.xhs.center.common.rabbitMq.many_many.Many_ManySender1;
import com.xhs.center.common.rabbitMq.many_many.Many_ManySender2;
import com.xhs.center.common.rabbitMq.object.ObjectSender;
import com.xhs.center.common.rabbitMq.object.User;
import com.xhs.center.common.rabbitMq.one_many.One_ManySender;
import com.xhs.center.common.rabbitMq.one_one.HelloReceiver;
import com.xhs.center.common.rabbitMq.one_one.HelloSender;
import com.xhs.center.common.rabbitMq.topic_Exchange.TopicSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @projectName RabbitMQ
 * @Author 常冬军
 * @Date 2019/6/28 0028下午 15:38
 * @title: RabbitMqHelloTest
 * @ToDo
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMqHelloTest {

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
    @Autowired
    private FanoutSender fanoutSender;

    @Test
    public void one_one() throws Exception {
        helloSender.send();
    }

    @Test
    public void one_many() throws Exception {
        for (int i = 0; i < 20; i++) {
            one_manySender.send(i);
        }
    }

    @Test
    public void many_many() throws Exception {
        for (int i = 0; i < 20; i++) {
            many_manySender1.send(i);
            many_manySender2.send(i);
            System.out.println("**************************************** " + i + " ******************************");
        }
    }

    @Test
    public void object() throws Exception {
        //  对象必须序列化
        User user = new User("张丽", "123", "河南郑州");
        objectSender.send(user);
    }

    @Test
    public void topic() throws Exception {
        // topicSender.send1();   // 两个队列都能收到
        topicSender.send2();   //  只用 2 能收到
    }

    @Test
    public void fanout() throws Exception {

       fanoutSender.send();
    }

}
