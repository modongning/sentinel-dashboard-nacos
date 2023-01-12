package com.alibaba.csp.sentinel.dashboard.config.nacos;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Nacos配置
 */
@Data
@ConfigurationProperties(prefix = "sentinel.nacos")
public class NacosProperties {
    /**
     * 服务地址
     */
    private String serverAddr;
    /**
     * 分组ID
     */
    private String groupId;
    /**
     * 命名空间
     */
    private String namespace;
}
