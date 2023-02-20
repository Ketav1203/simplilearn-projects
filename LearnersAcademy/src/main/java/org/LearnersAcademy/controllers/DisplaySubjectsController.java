package org.LearnersAcademy.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.LearnersAcademy.entities.Subject;
import org.LearnersAcademy.service.SubjectService;
import org.LearnersAcademy.service.SubjectServiceImpl;


@SuppressWarnings("serial")
@WebServlet("/displaySubjects")
public class DisplaySubjectsController extends HttpServlet {
	private SubjectService service=new SubjectServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Subject> subjects=service.getSubjects();
		req.setAttribute("subjects", subjects);
		RequestDispatcher rd=req.getRequestDispatcher("displaySubjects.jsp");
		rd.forward(req, resp);
	}
}
