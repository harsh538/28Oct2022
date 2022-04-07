<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
.error {
	color: #ff0000;
	font-style: italic;
}
</style>
</head>
<body>
	<center>
		<h1 style="color: blue; background-color: gray">Employee Details</h1>
		<br>
		<form:form>
			<c:if test="${not empty emplist}">
				<table border="2">

					<tr>
						<th>EmployeeID</th>
						<th>EmployeeName</th>
						<th>Role</th>
						<th>Salary</th>
						<th>EmpDate</th>
					</tr>
					<c:forEach var="var" items="${emplist}">
						<tr>
							<td>${var.id}</td>
							<td>${var.name}</td>
							<td>${var.designation}</td>
							<td>${var.salary}</td>
							<td>${var.DOJ}</td>
						</tr>
					</c:forEach>
				</table>
			</c:if>
			<c:if test="${empty emplist}">

				<h2>No Employees Available</h2>

			</c:if>
		</form:form>

	</center>
</body>
</html>