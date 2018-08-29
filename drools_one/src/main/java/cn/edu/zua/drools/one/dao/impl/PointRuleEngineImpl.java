package cn.edu.zua.drools.one.dao.impl;

import cn.edu.zua.drools.one.dao.PointRuleEngine;
import cn.edu.zua.drools.one.model.rules.PointDomain;
import cn.edu.zua.drools.one.util.RuleBaseFactory;
import org.drools.RuleBase;
import org.drools.StatefulSession;
import org.drools.compiler.PackageBuilder;
import org.drools.rule.Package;
import org.drools.spi.Activation;
import org.drools.spi.AgendaFilter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

/**
 * 规则接口实现类
 * Created by ascend on 2017/2/9 14:31.
 */
public class PointRuleEngineImpl implements PointRuleEngine {
    private RuleBase ruleBase;

    /**
     * 初始化规则引擎
     */
    public void initEngine() {
        //设置时间格式
        System.setProperty("drools.dateformat","yyyy-MM-dd HH:mm:ss");
        ruleBase = RuleBaseFactory.getRuleBase();
        try {
            PackageBuilder packageBuilder = getPackageBuilderFromDrlFile();
            ruleBase.addPackage(packageBuilder.getPackage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 刷新规则引擎中的规则
     */
    public void refreshEngineRule() {
        ruleBase = RuleBaseFactory.getRuleBase();
        Package[] packages = ruleBase.getPackages();
        for (Package aPackage : packages) {
            ruleBase.removePackage(aPackage.getName());
        }
        initEngine();
    }

    /**
     * 执行规则引擎
     *
     * @param pointDomain 积分Fact
     */
    public void executeRuleEngine(PointDomain pointDomain) {
        if (ruleBase.getPackages()==null||ruleBase.getPackages().length==0) {
            return;
        }
        StatefulSession statefulSession = ruleBase.newStatefulSession();
        statefulSession.insert(pointDomain);

        // fire
        statefulSession.fireAllRules(new AgendaFilter() {
            public boolean accept(Activation activation) {
                return !activation.getRule().getName().contains("_test");
            }
        });
    }

    /**
     * 从Drl规则文件中读取规则
     * @return PackageBuilder
     */
    private PackageBuilder getPackageBuilderFromDrlFile() throws Exception {
        // 获取测试脚本文件
        List<String> drlFilePath = getTestDrlFile();
        // 装载测试脚本文件
        List<Reader> readers = readRuleFromDrlFile(drlFilePath);
        PackageBuilder backageBuilder = new PackageBuilder();
        for (Reader reader : readers) {
            backageBuilder.addPackageFromDrl(reader);
        }
        // 检查脚本是否有问题
        if(backageBuilder.hasErrors()) {
            throw new Exception(backageBuilder.getErrors().toString());
        }
        return backageBuilder;
    }

    /**
     * @param drlFilePath 脚本文件路径
     * @return
     * @throws FileNotFoundException
     */
    private List<Reader> readRuleFromDrlFile(List<String> drlFilePath) throws FileNotFoundException {
        if (null == drlFilePath || 0 == drlFilePath.size()) {
            return null;
        }
        List<Reader> readers = new ArrayList<Reader>();
        for (String ruleFilePath : drlFilePath) {
            readers.add(new FileReader(new File(ruleFilePath)));
        }
        return readers;
    }

    /**
     * 获取测试规则文件
     *
     * @return
     */
    private List<String> getTestDrlFile() {
        List<String> drlFilePath = new ArrayList<String>();
        drlFilePath.add("D:\\tool\\myOwnWorkspace\\drools\\drools_one\\src\\main\\resources\\rules1\\addpoint.drl");
        drlFilePath.add("D:\\tool\\myOwnWorkspace\\drools\\drools_one\\src\\main\\resources\\rules1\\subpoint.drl");
        return drlFilePath;
    }
}
