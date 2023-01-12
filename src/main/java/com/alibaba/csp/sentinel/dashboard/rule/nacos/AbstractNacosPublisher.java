package com.alibaba.csp.sentinel.dashboard.rule.nacos;

import com.alibaba.csp.sentinel.dashboard.config.nacos.NacosProperties;
import com.alibaba.csp.sentinel.dashboard.datasource.entity.gateway.GatewayFlowRuleEntity;
import com.alibaba.csp.sentinel.dashboard.rule.DynamicRulePublisher;
import com.alibaba.csp.sentinel.datasource.Converter;
import com.alibaba.csp.sentinel.util.AssertUtil;
import com.alibaba.nacos.api.config.ConfigService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 抽象公用Nacos规则发布者
 *
 * 用于把配置发布到nacos保存
 *
 * @author modongning
 * @createDate 2022/11/14
 */
@Slf4j
@Component
public abstract class AbstractNacosPublisher<T> implements DynamicRulePublisher<T> {

    @Autowired
    private ConfigService nacosConfigService;
    @Autowired
    private Converter<T, String> converter;
    @Autowired
    private NacosProperties nacosProperties;

    @Override
    public void publish(String app, T rules) throws Exception {
        AssertUtil.notEmpty(app, "app name cannot be empty");
        if (rules == null) {
            return;
        }

        String dataId = app + this.getDataIdPostfix();
        String groupId = nacosProperties.getGroupId();

        log.info("publish; dataId: {},groupId: {},rules: {}",dataId,groupId,rules);

        nacosConfigService.publishConfig(dataId,groupId, converter.convert(rules));
    }

    /**
     * 获取datId的文件后缀
     * @return
     */
    protected abstract String getDataIdPostfix();
}
