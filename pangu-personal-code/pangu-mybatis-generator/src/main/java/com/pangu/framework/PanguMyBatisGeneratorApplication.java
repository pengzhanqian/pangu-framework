package com.pangu.framework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * springboot 启动类
 *
 * @author qianpengzhan
 * @date 2022/5/1815:12
 * @return null
 */
@SpringBootApplication(scanBasePackages = {"com.pangu.framework"})
public class PanguMyBatisGeneratorApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(PanguMyBatisGeneratorApplication.class);
    }
}
