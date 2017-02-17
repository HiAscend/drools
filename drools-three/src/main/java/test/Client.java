package test;

import com.adeng.model.PointDomain;
import com.test.model.Message;
import org.kie.api.KieServices;
import org.kie.api.builder.KieScanner;
import org.kie.api.builder.ReleaseId;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * Created by ascend on 2017/2/14 17:17.
 */
public class Client {
    public static void main(String[] args) {
        try {
            System.setProperty("drools.dateformat","yyyy-MM-dd HH:mm:ss");
            // load up the knowledge base
            KieServices kieServices = KieServices.Factory.get();
//            KieContainer kieContainer = kieServices.newKieContainer(releaseId, CreditClient.class.getClassLoader());
            KieContainer kieContainer = kieServices.newKieClasspathContainer();
//            KieScanner kieScanner = kieServices.newKieScanner(kieContainer);
//            kieScanner.start(2000);
            KieSession kieSession = kieContainer.newKieSession("ksession-point");
//            KieSession kieSession = kieContainer.newKieSession();

            // go
            PointDomain pointDomain = new PointDomain();
            pointDomain.setUserName("adeng");
            pointDomain.setBackMoney(500);
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

//    @org.junit.Test
    public void test(){
        KieServices ks = KieServices.Factory.get();
        ReleaseId releaseId = ks.newReleaseId("com.test", "drools-message", "1.0-SNAPSHOT");
//        KieContainer kContainer = ks.getKieClasspathContainer();
        KieContainer kContainer = ks.newKieContainer(releaseId);
        KieScanner kieScanner = ks.newKieScanner(kContainer);
        kieScanner.start(8000);
        KieSession kSession = kContainer.newKieSession("ksession-hello-world");
        kSession.insert(new Message("Dave", "Hello"));
        kSession.fireAllRules();
    }
}
