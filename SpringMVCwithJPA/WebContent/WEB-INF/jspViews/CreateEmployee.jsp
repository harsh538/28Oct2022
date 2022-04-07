<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
		<h1>Add Employee Page</h1>
		<form:form action="saveEmployee.html" method="GET" modelAttribute="empobj">
			<table border="2px">
				<tr>
					<td>Enter Employee Name</td>
					<td><form:input path="name" />
				</tr>
				<tr>
					<td>Enter Employee Designation</td>
					<td><form:input path="designation" />
				</tr>
				<tr>
					<td>Enter Employee Salary</td>
					<td><form:input path="salary" />
				</tr>
				<tr>
					<td>Enter Employee DOJ</td>
					<td><form:input path="DOJ" />
				</tr>
				<tr>
					<td><input type="submit" value="Register" /></td>
				</tr>
			</table>
		</form:form>


	</center>
</body>
</html>