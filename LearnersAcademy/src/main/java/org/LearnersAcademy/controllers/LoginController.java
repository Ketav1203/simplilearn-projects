package org.LearnersAcademy.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.LearnersAcademy.entities.User;
import org.LearnersAcademy.service.UserService;
import org.LearnersAcademy.service.UserServiceImpl;


@SuppressWarnings("serial")
@WebServlet("/login")
public class LoginController extends HttpServlet{
	private UserService userService=new UserServiceImpl();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		User user=userService.get(username, password);
		if(user!=null)
		{
			HttpSession session=req.getSession();
			session.setAttribute("user", user);
			RequestDispatcher rd=req.getRequestDispatcher("home.jsp");
			rd.forward(req, resp);
		}
		else
		{
			req.setAttribute("msg", "Username/Password is invalid");
			RequestDispatcher rd=req.getRequestDispatcher("index.jsp");
			rd.forward(req, resp);
		}
	}
}
