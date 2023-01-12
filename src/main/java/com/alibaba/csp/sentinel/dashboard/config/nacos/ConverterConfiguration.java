package com.alibaba.csp.sentinel.dashboard.config.nacos;

import com.alibaba.csp.sentinel.dashboard.datasource.entity.gateway.ApiDefinitionEntity;
import com.alibaba.csp.sentinel.dashboard.datasource.entity.gateway.GatewayFlowRuleEntity;
import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.FlowRuleEntity;
import com.alibaba.csp.sentinel.datasource.Converter;
import com.alibaba.fastjson.JSON;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ConverterConfiguration {
    /**
     * 普通服务流控规则编码解码器
     * @return
     */
    @Bean
    public Converter<List<FlowRuleEntity>, String> flowRuleEntityEncoder() {
        return JSON::toJSONString;
    }
    @Bean
    public Converter<String, List<FlowRuleEntity>> flowRuleEntityDecoder() {
        return s -> JSON.parseArray(s, FlowRuleEntity.class);
    }
    /**
     * 网关流控规则编码解码器
     * @return
     */
    @Bean
    public Converter<List<GatewayFlowRuleEntity>, String> gatewayFlowRuleEntityEncoder() {
        return JSON::toJSONString;
    }
    @Bean
    public Converter<String, List<GatewayFlowRuleEntity>> gatewayFlowRuleEntityDecoder() {
        return s -> JSON.parseArray(s, GatewayFlowRuleEntity.class);
    }
    /**
     * 网关api分组配置编码解码器
     */
    @Bean
    public Converter<List<ApiDefinitionEntity>, String> gatewayApiEntityEncoder() {
        return JSON::toJSONString;
    }
    @Bean
    public Converter<String, List<ApiDefinitionEntity>> gatewayApiEntityDecoder() {
        return s -> JSON.parseArray(s, ApiDefinitionEntity.class);
    }
}
