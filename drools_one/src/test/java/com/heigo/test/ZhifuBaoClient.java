package com.heigo.test;

import com.heigo.dao.PointRuleEngine;
import com.heigo.dao.impl.PointRuleEngineImpl;
import com.heigo.model.rules.PointDomain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * 网站伴随业务产生而进行的积分发放操作。比如支付宝信用卡还款奖励积分等
 * Created by ascend on 2017/2/9 16:20.
 */
public class ZhifuBaoClient {
    public static void main(String[] args) throws IOException {
        System.out.println("ZhifuBaoClient.main");
        PointRuleEngine pointRuleEngine = new PointRuleEngineImpl();
        while (true) {
            InputStream is = System.in;
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String input = br.readLine();

            if (input != null && "s".equals(input)) {
                System.out.println("初始化规则引擎...");
                pointRuleEngine.initEngine();
                System.out.println("初始化规则引擎结束...");
            } else if ("e".equals(input)) {
                PointDomain pointDomain = new PointDomain();
                pointDomain.setUserName("adeng");
                pointDomain.setBackMoney(100);
                pointDomain.setBuyMoney(500);

                pointRuleEngine.executeRuleEngine(pointDomain);

                System.out.println("执行完毕BillThisMonth："+pointDomain.getBillThisMonth());
                System.out.println("执行完毕BuyMoney："+pointDomain.getBuyMoney());
                System.out.println("执行完毕BuyNums："+pointDomain.getBuyNums());

                System.out.println("执行完毕规则引擎决定发送积分："+pointDomain.getPoint());
            } else if ("r".equals(input)) {
                System.out.println("刷新规则文件...");
                pointRuleEngine.refreshEngineRule();
                System.out.println("刷新规则文件结束.");
            }
        }
    }
}
