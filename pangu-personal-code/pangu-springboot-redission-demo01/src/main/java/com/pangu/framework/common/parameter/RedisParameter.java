package com.pangu.framework.common.parameter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.context.annotation.Configuration;

/**
 * redis相关的配置参数
 *
 * @author pengzhan.qian
 * @date 2022/5/31 17:41
 */
@Configuration
public class RedisParameter {

    /**
     * redis主机节点地址
     */
    @Value("${spring.redis.host}")
    public String host;
    /**
     * redis主机节点
     */
    @Value("${spring.redis.port}")
    public String port;
    @Value("${spring.redis.password}")
    public String password;
    @Value("${spring.redis.database}")
    public int database;
    public RedisProperties.Cluster cluster;
}
