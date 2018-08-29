package cn.edu.zua.drools.one.dao;

import cn.edu.zua.drools.one.model.rules.PointDomain;

/**
 * 规则接口
 * Created by ascend on 2017/2/9 14:27.
 */
public interface PointRuleEngine {
    /**
     * 初始化规则引擎
     */
    void initEngine();

    /**
     * 刷新规则引擎中的规则
     */
    void refreshEngineRule();

    /**
     * 执行规则引擎
     * @param pointDomain   积分Fact
     */
    void executeRuleEngine(final PointDomain pointDomain);

}
