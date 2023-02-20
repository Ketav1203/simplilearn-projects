<%@page import="org.LearnersAcademy.entities.Teacher"%>
<%@page import="org.LearnersAcademy.entities.Subject"%>
<%@page import="org.LearnersAcademy.entities.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		List<Student> students=(List<Student>)request.getAttribute("students");
		List<Subject> subjects1=(List<Subject>)request.getAttribute("subjects1");

	%>
		<h3>Students List</h3>
		<%
			for(Student student:students)
			{
		%>
				<ul>
					<li><%=student.getName()%></li>
				</ul>
		<%	
			}
		%>
		<h3>Subjects List</h3>
		
		<%
			for(Subject subject:subjects1)
			{
		%>
				<ul>
					<li><%=subject.getName()%></li>
				</ul>
		<%	
			}
		%>
</body>
</html>