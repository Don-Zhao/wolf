package com.wolf.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyContextListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("contextInitialized ... ");
		ServletContext ctx = sce.getServletContext();
		ctx.addServlet("myServlet", "com.wolf.servlet.MyServlet");
		ctx.addServlet("myServlet", "com.wolf.servlet.UpdateServlet");
		ctx.addServlet("asynServlet", "com.wolf.servlet.AsynServlet");
		ctx.addFilter("encodingFilter", "com.wolf.filter.EncodingFilter");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("contextDestroyed ... ");
	}

}
