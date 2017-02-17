package com.adeng.servlet;

import com.adeng.model.PointDomain;
import com.adeng.util.DroolsUtils;
import com.test.model.Message;
import org.kie.api.KieServices;
import org.kie.api.builder.KieScanner;
import org.kie.api.builder.ReleaseId;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by ascend on 2017/2/14 10:59.
 */
@WebServlet(urlPatterns = "/servlet/HelloServlet")
public class HelloServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("HelloServlet.doGet");

        testMessage(req,System.out);
//        testCredit(req);
        super.doGet(req, resp);
    }



    private void testMessage(HttpServletRequest req, PrintStream out){

        KieSession kSession = DroolsUtils.kieContainer.newKieSession("ksession-hello-world");
        kSession.setGlobal("out", out);
        kSession.insert(new Message("Dave", "Hello"));
        kSession.fireAllRules();
    }

    private void testCredit(HttpServletRequest req){
        try {
            System.setProperty("drools.dateformat","yyyy-MM-dd HH:mm:ss");
            // load up the knowledge base
            KieServices kieServices = KieServices.Factory.get();
            ReleaseId releaseId = kieServices.newReleaseId("com.heigo", "credit-card", "1.0-SNAPSHOT");
            KieContainer kieContainer = kieServices.newKieContainer(releaseId);
//            KieScanner kieScanner = kieServices.newKieScanner(kieContainer);
//            kieScanner.start(2000);
            KieSession kieSession = kieContainer.newKieSession("ksession-point");
//            KieSession kieSession = kieClasspathContainer.newKieSession();
            // go
            PointDomain pointDomain = new PointDomain();
            pointDomain.setUserName(req.getParameter("name"));
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
}
