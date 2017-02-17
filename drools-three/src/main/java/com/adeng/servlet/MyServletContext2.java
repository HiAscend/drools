package com.adeng.servlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by ascend on 2017/2/17 17:34.
 */
public class MyServletContext2 implements ServletContextListener {
    /**
     * Receives notification that the web application initialization
     * process is starting.
     * <p>
     * <p>All ServletContextListeners are notified of context
     * initialization before any filters or servlets in the web
     * application are initialized.
     *
     * @param sce the ServletContextEvent containing the ServletContext
     *            that is being initialized
     */
    public void contextInitialized(ServletContextEvent sce) {

    }

    /**
     * Receives notification that the ServletContext is about to be
     * shut down.
     * <p>
     * <p>All servlets and filters will have been destroyed before any
     * ServletContextListeners are notified of context
     * destruction.
     *
     * @param sce the ServletContextEvent containing the ServletContext
     *            that is being destroyed
     */
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("MyServletContext2.contextDestroyed");
    }
}
