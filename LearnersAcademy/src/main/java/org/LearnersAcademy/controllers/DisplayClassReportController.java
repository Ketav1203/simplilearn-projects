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
import org.LearnersAcademy.dao.SubjectDao;
import org.LearnersAcademy.dao.SubjectDaoImpl;
import org.LearnersAcademy.dao.TeacherDao;
import org.LearnersAcademy.dao.TeacherDaoImpl;
import org.LearnersAcademy.entities.Student;
import org.LearnersAcademy.entities.Subject;
import org.LearnersAcademy.entities.Teacher;

@WebServlet("/displayClassReport")
public class DisplayClassReportController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentDao studentDao=new StudentDaoImpl();
	private SubjectDao subjectDao=new SubjectDaoImpl();
	private TeacherDao teacherDao=new TeacherDaoImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Student> students=studentDao.getAll();
		request.setAttribute("students", students);
		List<Subject> subjects=subjectDao.getAll();
		request.setAttribute("subjects1", subjects);
		RequestDispatcher rd=request.getRequestDispatcher("displayClassReport.jsp");
		rd.forward(request, response);
	}

}
