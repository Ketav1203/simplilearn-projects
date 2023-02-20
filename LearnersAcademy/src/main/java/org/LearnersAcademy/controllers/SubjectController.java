package org.LearnersAcademy.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.LearnersAcademy.entities.Subject;
import org.LearnersAcademy.service.SubjectService;
import org.LearnersAcademy.service.SubjectServiceImpl;


@WebServlet("/addSub")
public class SubjectController extends HttpServlet{
	private SubjectService service=new SubjectServiceImpl();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String subject=req.getParameter("subject");
		Subject subject2=new Subject();
		subject2.setName(subject);
		service.addSubject(subject2);
		RequestDispatcher rd=req.getRequestDispatcher("home.jsp");
		rd.forward(req, resp);
	}
}
