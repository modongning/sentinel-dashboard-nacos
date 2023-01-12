package com.alibaba.csp.sentinel.dashboard.rule.nacos.gateway;

import com.alibaba.csp.sentinel.dashboard.datasource.entity.gateway.GatewayFlowRuleEntity;
import com.alibaba.csp.sentinel.dashboard.rule.nacos.AbstractNacosPublisher;
import com.alibaba.csp.sentinel.dashboard.rule.nacos.NacosConfigUtil;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 网关流控规则Nacos发布者
 *
 * @author modongning
 * @createDate 2022/11/14
 */
@Component("gatewayFlowRuleNacosPublisher")
public class GatewayFlowRuleNacosPublisher extends AbstractNacosPublisher<List<GatewayFlowRuleEntity>> {

    @Override
    protected String getDataIdPostfix() {
        return NacosConfigUtil.GW_FLOW_DATA_ID_POSTFIX;
    }
}
