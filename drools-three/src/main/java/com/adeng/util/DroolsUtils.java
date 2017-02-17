package com.adeng.util;

import org.kie.api.KieServices;
import org.kie.api.builder.KieScanner;
import org.kie.api.builder.ReleaseId;
import org.kie.api.runtime.KieContainer;

/**
 * Created by ascend on 2017/2/17 17:54.
 */
public class DroolsUtils {
    public static KieContainer kieContainer;
    public static KieScanner kieScanner;
    static{
        KieServices ks = KieServices.Factory.get();
        ReleaseId releaseId = ks.newReleaseId("com.test", "drools-message", "1.0-SNAPSHOT");
//        KieContainer kContainer = ks.getKieClasspathContainer();
        kieContainer = ks.newKieContainer(releaseId);
        kieScanner = ks.newKieScanner(kieContainer);
        kieScanner.start(5000);
    }


}

