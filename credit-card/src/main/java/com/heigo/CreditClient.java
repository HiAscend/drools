package com.heigo;

import com.heigo.model.PointDomain;
import org.kie.api.KieServices;
import org.kie.api.builder.KieScanner;
import org.kie.api.builder.ReleaseId;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * Hello world!
 *
 */
public class CreditClient {
    public static void main( String[] args ){
        new CreditClient().execute(new PointDomain("adeng",500));
    }



    public void execute(PointDomain pointDomain){
        try {
            System.setProperty("drools.dateformat","yyyy-MM-dd HH:mm:ss");
            // load up the knowledge base
            KieServices kieServices = KieServices.Factory.get();
            KieContainer kieClasspathContainer = kieServices.newKieClasspathContainer();
            KieSession kieSession = kieClasspathContainer.newKieSession("ksession-point");
//            KieSession kieSession = kieClasspathContainer.newKieSession();

            // go
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
