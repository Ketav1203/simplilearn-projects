package org.LearnersAcademy.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.LearnersAcademy.dao.AcademicClassDao;
import org.LearnersAcademy.dao.AcademicClassDaoImpl;
import org.LearnersAcademy.dao.StudentDao;
import org.LearnersAcademy.dao.StudentDaoImpl;
import org.LearnersAcademy.entities.AcademicClass;
import org.LearnersAcademy.entities.Student;

@WebServlet("/mapToAcademicClass1")
public class AcademicClass1MappingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AcademicClassDao acaDao=new AcademicClassDaoImpl();
	private StudentDao stuDao=new StudentDaoImpl();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String semester=request.getParameter("semester");
		HttpSession session=request.getSession();
		int id=(int) session.getAttribute("stuId");
		AcademicClass academicclass=acaDao.get(semester);
		Student student=stuDao.get(id);
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		Set<Student> studentSet=new HashSet<>();
		studentSet.add(student);
		academicclass.setStudents(studentSet);
		student.setAcademicClass(academicclass);
		acaDao.insert(academicclass);
		stuDao.insert(student);
		RequestDispatcher rd=request.getRequestDispatcher("home.jsp");
		rd.forward(request, response);
	}

}
