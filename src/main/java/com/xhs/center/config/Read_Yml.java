package com.xhs.center.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * @projectName RabbitMQ
 * @Author 常冬军
 * @Date 2019/6/27 0027上午 11:15
 * @title: config
 * @ToDo
 */
@Data
//@Configuration
//@PropertySource(value = "classpath:config.yml",encoding = "utf-8",factory = MyPropertySourceFactory.class)
//@ConfigurationProperties()

//@Component
@Configuration
//@PropertySource("classpath:config.yml")
@PropertySource(value = "classpath:config.properties",encoding = "UTF-8")
public class Read_Yml {
    @Value("${Bingove.username}")
    private String username;
    @Value("${Bingove.password}")
    private String password;
    @Value("${Bingove.address}")
    private String address;
}
