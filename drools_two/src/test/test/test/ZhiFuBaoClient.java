package test;

import cn.edu.zua.drools.credit.card.model.PointDomain;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * Created by ascend on 2017/2/10 9:51.
 */
public class ZhiFuBaoClient {
    public static void main(String[] args) {
        try {
            System.setProperty("drools.dateformat","yyyy-MM-dd HH:mm:ss");
            // load up the knowledge base
            KieServices kieServices = KieServices.Factory.get();
            KieContainer kieClasspathContainer = kieServices.getKieClasspathContainer();
            KieSession kieSession = kieClasspathContainer.newKieSession("ksession-point");
//            KieSession kieSession = kieClasspathContainer.newKieSession();

            // go
            PointDomain pointDomain = new PointDomain();
            pointDomain.setUserName("adeng");
            pointDomain.setBackMoney(100);
            pointDomain.setBuyMoney(500);

            System.out.println("pointDomain = " + pointDomain);
            kieSession.insert(pointDomain);
            kieSession.fireAllRules();

            System.out.println("执行完毕BillThisMonth："+pointDomain.getBillThisMonth());
            System.out.println("执行完毕BuyMoney："+pointDomain.getBuyMoney());
            System.out.println("执行完毕BuyNums："+pointDomain.getBuyNums());

            System.out.println("执行完毕规则引擎决定发送积分："+pointDomain.getPoint());
            System.out.println("pointDomain = " + pointDomain);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
