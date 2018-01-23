package com.whn.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.whn.domain.Person;
import com.whn.service.PersonService;

public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdateServlet() {
		super();
	}

	// 用来传递参数，不能定义在doGet和doPost方法中，不然会被释放，在update中接收不到参数
	Person p = new Person();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 接收请求的参数
		System.out.println("进入了UpdateServlet的doGet方法");
		String sid = request.getParameter("id");
		int id = Integer.valueOf(sid);
		p.setId(id);

		try {
			// 重定向
			request.getRequestDispatcher("/jsp/update.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.getRequestDispatcher("/jsp/error.jsp").forward(request, response);
		}

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("进入了UpdateServlet的doPost方法");
		request.setCharacterEncoding("UTF-8");
		PersonService personService = new PersonService();
		p.setName(request.getParameter("name"));
		p.setIdnumber(request.getParameter("idnumber"));
		p.setSex(request.getParameter("sex"));
		p.setBirth(request.getParameter("birth"));
		p.setMarrage(request.getParameter("marrage"));
		p.setMatename(request.getParameter("matename"));
		try {
			// 调用业务层
			personService.update(p);
			// 重定向
			request.getRequestDispatcher("/jsp/success.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.getRequestDispatcher("/jsp/error.jsp").forward(request, response);
		}
	}

}
