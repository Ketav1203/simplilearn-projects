<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h4>Hi,${sessionScope.user.username} welcome to Learning Management System</h4>
	<a href="addSubject.jsp">Add Subject</a>| <a href="addTeacher.jsp">Add Teacher</a> |
	<a href="addAcademicClass.jsp">Add Academic Class</a> | <a href="addStudent.jsp">Add Student</a> |
	<a href="./displaySubjects">Display Subjects</a> | <a href="./displayStudent">Display Students</a> | <a href="enterClassSemester.jsp">Display Class Report</a> 
	
</body>
</html>