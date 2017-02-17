package com.test.model;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import java.io.PrintStream;

/**
 * Created by ascend on 2017/2/16 15:56.
 */
public class DefaultMessageExample {
    public void go(PrintStream out) {
        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.getKieClasspathContainer();
        KieSession kSession = kContainer.newKieSession("ksession-hello-world");
        kSession.setGlobal("out", out);
        kSession.insert(new Message("Dave", "Hello"));
        kSession.fireAllRules();
    }

    public static void main(String[] args) {
        new DefaultMessageExample().go(System.out);
    }
}
