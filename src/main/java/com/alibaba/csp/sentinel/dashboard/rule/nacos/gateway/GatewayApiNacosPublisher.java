package com.alibaba.csp.sentinel.dashboard.rule.nacos.gateway;

import com.alibaba.csp.sentinel.dashboard.datasource.entity.gateway.ApiDefinitionEntity;
import com.alibaba.csp.sentinel.dashboard.rule.nacos.AbstractNacosPublisher;
import com.alibaba.csp.sentinel.dashboard.rule.nacos.NacosConfigUtil;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 网关api分组规则Nacos发布者
 */
@Component
public class GatewayApiNacosPublisher extends AbstractNacosPublisher<List<ApiDefinitionEntity>> {

    @Override
    protected String getDataIdPostfix() {
        return NacosConfigUtil.API_DATA_ID_POSTFIX;
    }
}
