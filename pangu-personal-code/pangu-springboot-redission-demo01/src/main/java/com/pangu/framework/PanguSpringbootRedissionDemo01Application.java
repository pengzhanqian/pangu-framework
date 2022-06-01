package com.pangu.framework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * springboot 启动类
 *
 * @author pengzhan.qian
 * @date 2022/5/24 10:15
 */
@SpringBootApplication(scanBasePackages = {"com.pangu.framework"})
public class PanguSpringbootRedissionDemo01Application {
    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(PanguSpringbootRedissionDemo01Application.class);
    }
}
