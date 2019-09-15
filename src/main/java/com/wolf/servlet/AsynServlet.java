package com.wolf.servlet;

import java.io.IOException;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="asynServlet", urlPatterns= {"/asynServlet"}, asyncSupported=true)
public class AsynServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(Thread.currentThread() + "do get start...");
		AsyncContext ac = req.startAsync();
		ac.start(new Runnable() {
			@Override
			public void run() {
				System.out.println(Thread.currentThread() + "start....");
				try {
					for (int i = 0; i < 10; i++) {
						Thread.sleep(1000);
					}
					System.out.println(Thread.currentThread() + "end....");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		System.out.println(Thread.currentThread() + "do get end...");
		ServletRequest request = (ServletRequest)req; 
		ServletResponse response = (ServletResponse)resp;
		request.getRequestDispatcher("/home.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
