<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="/StudentManagement/URLToReachResourcesFolder/css/addStudent.css">
<link rel="stylesheet" type="text/css" href="/StudentManagement/URLToReachResourcesFolder/css/my-style-sheet.css"/>

<style type="text/css"> 
	h3{color:red;}
</style>
</head>
<body>

<div  class="container">
	<!-- <h1 align="center">Student</h1> -->
	<h2 align="center" style="color:red">Student Details</h2>
	<!-- <h3 align="center">Student DB</h3>
	<h3 align="center">TestColor CSS</h3>
	 -->
	<form action="addStudent">
			<input type="submit" value="ADD"  class="btn btn-success" />
		</form>
	
		<table class="table table-dark table-striped" border="1">
			<thead>r
				<tr>
				<td>ID</td>
				<td>Name</td>
				<td>Mobile</td>
				<td>Country</td>
				</tr>
			</thead>
			<c:forEach var="student" items="${students}">
				<tr>
						<td>${student.id}</td>
						<td>${student.name}</td>
						<td>${student.mobile}</td>
						<td>${student.country}</td>
						<td><a href="/StudentManagement/updateStudent?userId=${student.id}">Update</a></td>
						<td><a href="/StudentManagement/deleteStudent?userId=${student.id}" onClick="if(!(confirm('Are you sure you want to delete this student?'))) return false">Delete</a></td>
						</br>
				</tr>
			</c:forEach>
			
		</table>
		
		<img alt="student image" src="/StudentManagement/URLToReachResourcesFolder/images/Student.png"/>
	
</div>

</body>
</html>