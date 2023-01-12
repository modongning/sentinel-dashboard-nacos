package com.alibaba.csp.sentinel.dashboard.rule.nacos;

import com.alibaba.csp.sentinel.dashboard.config.nacos.NacosProperties;
import com.alibaba.csp.sentinel.dashboard.rule.DynamicRuleProvider;
import com.alibaba.csp.sentinel.datasource.Converter;
import com.alibaba.csp.sentinel.util.StringUtil;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.nacos.api.config.ConfigService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * 抽象公用Nacos配置持有者
 *
 * 用于从nacos中获取配置
 *
 * @author modongning
 * @createDate 2022/11/14
 */
@Slf4j
@Component
public abstract class AbstractNacosProvider<T> implements DynamicRuleProvider<T> {
    @Autowired
    private ConfigService nacosConfigService;
    @Autowired
    private Converter<String, T> converter;
    @Autowired
    private NacosProperties nacosProperties;

    @Override
    public T getRules(String appName) throws Exception {
        log.info("appName: {}", appName);
        log.info("Nacos Properties: {}", JSONObject.toJSONString(nacosProperties));

        String dataId = appName + this.getDataIdPostfix();
        String groupId = nacosProperties.getGroupId();

        String rules = nacosConfigService.getConfig(dataId, groupId, 3000);

        log.info("getRules; dataId: {},groupId: {},rules: {}",dataId,groupId,rules);

        if (StringUtil.isEmpty(rules)) {
            return (T) new ArrayList();
        }
        return converter.convert(rules);
    }

    /**
     * 获取datId的文件后缀
     * @return
     */
    protected abstract String getDataIdPostfix();
}
