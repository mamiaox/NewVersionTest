package com.whn.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.whn.domain.Person;
import com.whn.service.PersonService;

public class ShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ShowServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 接收请求的参数
		System.out.println("进入了QueryServlet的doGet方法");
		request.setCharacterEncoding("UTF-8");
		PersonService personService = new PersonService();
		try {
			// 调用业务层
			ArrayList<Person> aList = personService.show();
			// request对象中封装获得的person类型集合，传到jsp页面
			request.setAttribute("aList", aList);
			// 重定向
			request.getRequestDispatcher("/jsp/show.jsp").forward(request, response);
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
