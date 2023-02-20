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
import org.LearnersAcademy.entities.AcademicClass;
import org.LearnersAcademy.entities.Subject;
import org.LearnersAcademy.service.AcademicClassService;
import org.LearnersAcademy.service.AcademicClassServiceImpl;
import org.LearnersAcademy.service.SubjectService;
import org.LearnersAcademy.service.SubjectServiceImpl;

@WebServlet("/mapToAcademicClass")
public class AcademicClassMappingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
		private AcademicClassService academicClassService=new AcademicClassServiceImpl();
		private SubjectService subjectService=new SubjectServiceImpl();
		private SubjectDao subjectDao=new SubjectDaoImpl();
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String semester=request.getParameter("semester");// getting semester from client, from site
		HttpSession session=request.getSession();//creating session object for communicating with user
		int id=(int)session.getAttribute("sid");//using HttpSession method getAttribute to get sid from table
		AcademicClass academicClass=academicClassService.getAcademicClass(semester);//creating object and storing AcademicClass (getting it  by semester object)
		Subject subject=subjectDao.get(id);//using get method from subjectDao object above to get subject by id and storing it in subject object
		Set<Subject> subjectSet=new HashSet<>();
		subjectSet.add(subject);
		academicClass.setSubjects(subjectSet);//using setSubjects method from AcademicClass entity with academicClass object and passing subjectSet object to it
		Set<AcademicClass> academciClassSet=new HashSet<>();
		academciClassSet.add(academicClass);
		subject.setClasses(academciClassSet);//using setClasses method from Subject entity with subject object and passing academicClassSet object to it
		academicClassService.addAcademicClass(academicClass);
		subjectService.addSubject(subject);
		RequestDispatcher rd=request.getRequestDispatcher("home.jsp");
		rd.forward(request, response);
	}

}
