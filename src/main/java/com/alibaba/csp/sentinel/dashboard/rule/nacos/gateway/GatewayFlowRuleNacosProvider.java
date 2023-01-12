package com.alibaba.csp.sentinel.dashboard.rule.nacos.gateway;

import com.alibaba.csp.sentinel.dashboard.datasource.entity.gateway.GatewayFlowRuleEntity;
import com.alibaba.csp.sentinel.dashboard.rule.nacos.AbstractNacosProvider;
import com.alibaba.csp.sentinel.dashboard.rule.nacos.NacosConfigUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 网关流控规则Nacos持有者
 * @author modongning
 * @createDate 2022/11/14
 */
@Slf4j
@Component
public class GatewayFlowRuleNacosProvider extends AbstractNacosProvider<List<GatewayFlowRuleEntity>> {

    @Override
    protected String getDataIdPostfix() {
        return NacosConfigUtil.GW_FLOW_DATA_ID_POSTFIX;
    }
}
