package org.LearnersAcademy.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.LearnersAcademy.entities.User;
import org.LearnersAcademy.service.UserService;
import org.LearnersAcademy.service.UserServiceImpl;


@SuppressWarnings("serial")
@WebServlet("/register")
public class UserController extends HttpServlet{
	private UserService userService=new UserServiceImpl();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		User user=new User();
		user.setUsername(username);
		user.setPassword(password);
		userService.insert(user);
		req.setAttribute("msg", "User registered Successfully");
		RequestDispatcher rd=req.getRequestDispatcher("index.jsp");
		rd.forward(req, resp);
	}
}
