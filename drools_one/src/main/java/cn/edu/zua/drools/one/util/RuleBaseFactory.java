package cn.edu.zua.drools.one.util;

import org.drools.RuleBase;

/**
 * 单实例RuleBase生成工具
 * Created by ascend on 2017/2/9 15:12.
 */
public class RuleBaseFactory {
    private static RuleBase ruleBase = org.drools.RuleBaseFactory.newRuleBase();
    public static RuleBase getRuleBase(){
        return ruleBase;
    }
}
