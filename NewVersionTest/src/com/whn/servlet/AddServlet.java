package com.whn.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.whn.domain.Person;
import com.whn.service.PersonService;

public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 接收请求的参数
		System.out.println("进入了AddServlet的doGet方法");
		request.setCharacterEncoding("UTF-8");
		PersonService personService = new PersonService();
		Person p = new Person();
		p.setName(request.getParameter("name"));
		p.setIdnumber(request.getParameter("idnumber"));
		p.setSex(request.getParameter("sex"));
		p.setBirth(request.getParameter("birth"));
		p.setMarrage(request.getParameter("marrage"));
		p.setMatename(request.getParameter("matename"));
		try {
			// 调用业务层
			personService.add(p);
			// 重定向
			request.getRequestDispatcher("/jsp/success.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.getRequestDispatcher("/jsp/error.jsp").forward(request, response);
		}

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
