package org.LearnersAcademy.controllers;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.LearnersAcademy.dao.SubjectDao;
import org.LearnersAcademy.dao.SubjectDaoImpl;
import org.LearnersAcademy.entities.Subject;
import org.LearnersAcademy.entities.Teacher;
import org.LearnersAcademy.service.SubjectService;
import org.LearnersAcademy.service.SubjectServiceImpl;
import org.LearnersAcademy.service.TeacherService;
import org.LearnersAcademy.service.TeacherServiceImpl;


@WebServlet("/mapToTeacher")
public class TeacherMappingController extends HttpServlet {
	private TeacherService teacherService=new TeacherServiceImpl();
	private SubjectService subjectService=new SubjectServiceImpl();
	private SubjectDao subjectDao=new SubjectDaoImpl();

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		HttpSession session=req.getSession();
		int id=(int) session.getAttribute("sid");
		Teacher teacher=teacherService.getTeacher(name);
		Subject subject=subjectDao.get(id);
		Set<Subject> subjectSet=new HashSet<>();
		subjectSet.add(subject);
		teacher.setSubjects(subjectSet);
		subject.setTeacher(teacher);
		teacherService.addTeacher(teacher);
		subjectService.addSubject(subject);
		RequestDispatcher rd=req.getRequestDispatcher("home.jsp");
		rd.forward(req, resp);
	}
}
