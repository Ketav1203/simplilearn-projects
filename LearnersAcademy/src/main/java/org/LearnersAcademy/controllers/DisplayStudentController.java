package org.LearnersAcademy.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.LearnersAcademy.dao.StudentDao;
import org.LearnersAcademy.dao.StudentDaoImpl;
import org.LearnersAcademy.entities.Student;

@WebServlet("/displayStudent")
public class DisplayStudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentDao dao=new StudentDaoImpl();	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Student> students=dao.getAll();
		request.setAttribute("students", students);
		RequestDispatcher rd=request.getRequestDispatcher("displayStudents.jsp");
		rd.forward(request, response);
	}

}
