package com.test;

import com.test.model.Person;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ascend on 2017/2/22 16:27.
 */
public class PersonTest {
    @Test
    public void testRuleName(){
        System.setProperty("drools.dateformat","yyyy-MM-dd HH:mm:ss");
        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.getKieClasspathContainer();
        KieSession kSession = kContainer.newKieSession("ksession-hello-world");
        List<Person> list = new ArrayList<Person>();

        Person person1 = new Person("person1", 28);
        List p1Songs = new ArrayList(Arrays.asList("i","am","a","student"));
        person1.setSongs(p1Songs);
        list.add(person1);
        list.add(new Person("person2",27));
        list.add(new Person("person3",26));
        FactHandle ruleA = kSession.insert(list);
        kSession.fireAllRules();
        kSession.dispose();

    }

    @Test
    public void testPerson(){
        System.setProperty("drools.dateformat","yyyy-MM-dd HH:mm:ss");
        KieServices kieServices = KieServices.Factory.get();
        KieContainer container = kieServices.getKieClasspathContainer();
        KieSession kieSession = container.newKieSession("ksession-hello-world");
        Person p1 = new Person("白展堂", 68);
        Person p2 = new Person("李大嘴", 32);
        Person p3 = new Person("佟湘玉", 18);
        Person p4 = new Person("郭芙蓉", 8);

        System.out.println("before p1 : " + p1);
        System.out.println("before p2 : " + p2);
        System.out.println("before p3 : " + p3);
        System.out.println("before p4 : " + p4);

        kieSession.insert(p1);
        kieSession.insert(p2);
        kieSession.insert(p3);
        kieSession.insert(p4);
        int count = kieSession.fireAllRules();
        System.out.println("总执行了"+count+"条规则");
        System.out.println("after p1 : " + p1);
        System.out.println("after p2 : " + p2);
        System.out.println("after p3 : " + p3);
        System.out.println("after p4 : " + p4);
        kieSession.dispose();
    }
}
