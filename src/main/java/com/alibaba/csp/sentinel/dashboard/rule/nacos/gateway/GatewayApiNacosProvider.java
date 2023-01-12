package com.alibaba.csp.sentinel.dashboard.rule.nacos.gateway;

import com.alibaba.csp.sentinel.dashboard.datasource.entity.gateway.ApiDefinitionEntity;
import com.alibaba.csp.sentinel.dashboard.rule.nacos.AbstractNacosProvider;
import com.alibaba.csp.sentinel.dashboard.rule.nacos.NacosConfigUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 网关api分组规则Nacos持有者；从naocs获取到配置
 * @author modongning
 * @createDate 2022/11/14
 */
@Slf4j
@Component
public class GatewayApiNacosProvider extends AbstractNacosProvider<List<ApiDefinitionEntity>> {
    @Override
    protected String getDataIdPostfix() {
        return NacosConfigUtil.API_DATA_ID_POSTFIX;
    }
}
