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
	%>
	<table border="1">
		<tr>
			<td>Id</td>
			<td>Name</td>
			<td>Address</td>
			<td>Action1</td>
		</tr>
		<%
			for(Student student:students)
			{
		%>
				<tr>
					<td><%=student.getStuId()%></td>
					<td><%=student.getName()%></td>
					<td><%=student.getAddress()%></td>
					<%
						session.setAttribute("stuId", student.getStuId());
					%>
					<td><a href="academicClass_Student.jsp">Map to AcademicClass</a></td>
				</tr>
		<%	
			}
		%>
	</table>
</body>
</html>