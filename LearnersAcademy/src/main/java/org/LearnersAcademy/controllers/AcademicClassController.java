package org.LearnersAcademy.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.LearnersAcademy.entities.AcademicClass;
import org.LearnersAcademy.service.AcademicClassService;
import org.LearnersAcademy.service.AcademicClassServiceImpl;

@WebServlet("/addAcademicClass")
public class AcademicClassController extends HttpServlet {
	private static final long serialVersionUID = 1L;
		private AcademicClassService academicClassService=new AcademicClassServiceImpl();
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String semester=request.getParameter("semester");
		AcademicClass academicClass=new AcademicClass();
		academicClass.setSemester(semester);
		academicClassService.addAcademicClass(academicClass);
		RequestDispatcher rd=request.getRequestDispatcher("home.jsp");
		rd.forward(request, response);
	}

}
