package com.test.model;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import java.io.PrintStream;

/**
 * Created by ascend on 2017/2/16 15:56.
 */
public class DefaultMessageExample {
//    @org.junit.Test
    public void go(PrintStream out) {
        System.setProperty("drools.dateformat","yyyy-MM-dd HH:mm:ss");
        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.getKieClasspathContainer();
        KieSession kSession = kContainer.newKieSession("ksession-hello-world");
        kSession.setGlobal("out", out);
        Message message = new Message("adeng", "Hello");
        kSession.insert(message);
        kSession.fireAllRules();
//        kSession.fireUntilHalt();
        System.out.println("message = " + message);
//        System.out.println("message = " + message);
    }

    public static void main(String[] args) {
        new DefaultMessageExample().go(System.out);
    }



}
