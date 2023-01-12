/*
 * Copyright 1999-2018 Alibaba Group Holding Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alibaba.csp.sentinel.dashboard.config.nacos;

import com.alibaba.csp.sentinel.dashboard.datasource.entity.gateway.GatewayFlowRuleEntity;
import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.FlowRuleEntity;
import com.alibaba.csp.sentinel.datasource.Converter;
import com.alibaba.fastjson.JSON;
import com.alibaba.nacos.api.PropertyKeyConst;
import com.alibaba.nacos.api.config.ConfigFactory;
import com.alibaba.nacos.api.config.ConfigService;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Properties;

/**
 * @author Eric Zhao
 * @since 1.4.0
 */
@Configuration
//只有存在NacosProperties实体的时候才启用
@EnableConfigurationProperties(NacosProperties.class)
public class NacosConfig {
    private final NacosProperties nacosProperties;

    public NacosConfig(NacosProperties nacosProperties) {
        this.nacosProperties = nacosProperties;
    }

    @Bean
    public ConfigService nacosConfigService() throws Exception {
        String serverAddr = nacosProperties.getServerAddr();
        String namespace = nacosProperties.getNamespace();

        Properties properties = new Properties();
        //设置nacos服务地址
        properties.put(PropertyKeyConst.SERVER_ADDR, serverAddr);
        //设置nacos命名空间
        properties.put(PropertyKeyConst.NAMESPACE, namespace);

        return ConfigFactory.createConfigService(properties);
    }
}
