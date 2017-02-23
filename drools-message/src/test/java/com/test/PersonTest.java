package com.test;

import com.test.model.Person;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;

import java.util.ArrayList;
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
        list.add(new Person("person1",18));
        list.add(new Person("person2",22));
        list.add(new Person("person3",27));
        FactHandle ruleA = kSession.insert(list);
        kSession.fireAllRules();
        kSession.dispose();

    }
}
