package com.wolf.config;

import java.util.Set;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import com.wolf.listener.MyContextListener;

public class MyServletContextInitializer implements ServletContainerInitializer {

	@Override
	public void onStartup(Set<Class<?>> c, ServletContext ctx) throws ServletException {
//		ctx.addServlet("myServlet", "com.wolf.servlet.MyServlet");
//		ctx.addFilter("encodingFilter", "com.wolf.filter.EncodingFilter");
//		ctx.addListener(MyContextListener.class);
	}

}
