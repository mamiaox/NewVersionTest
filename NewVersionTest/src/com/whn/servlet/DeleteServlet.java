package com.whn.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.whn.domain.Person;
import com.whn.service.PersonService;

public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ShowServlet qs = new ShowServlet();
		// 接收请求的参数
		System.out.println("进入了DeleteServlet的doGet方法");
		request.setCharacterEncoding("UTF-8");
		PersonService personService = new PersonService();
		Person p = new Person();
		String sid = request.getParameter("id");
		int id = Integer.valueOf(sid);
		p.setId(id);
		try {
			// 调用业务层
			personService.delete(p);
			// 通过qs对象调用查询的doPost()方法，实现页面的刷新
			qs.doPost(request, response);
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
