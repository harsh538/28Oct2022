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
		<form:form action="loadDetailsByid2.html" method="POST"
			modelAttribute="empobj">
			<table border="2">
				<tr>
					<td>Find by id:</td>
					<td><form:input path="id" onchange="submit" /></td>
				</tr>
			</table>
		</form:form>

		<form:form modelAttribute="empobj2" method="GET">
		<hr>
		<c:if test="${not empty empobj2}">
<h1 style="color: blue;">Employee Details with Id: <c:out value="${empobj2.id}" /></h1>
			
				<table border="2px">
					<tr>
						<th>Empid</th>
						<th>EmpName</th>
						<th>Empdesignation</th>
						<th>Empsalary</th>
						<th>EmpDOJ</th>
					</tr>
					<tr>
						<td>${empobj2.id}</td>
						<td>${empobj2.name}</td>
						<td>${empobj2.designation}</td>
						<td>${empobj2.salary}</td>
						<td>${empobj2.DOJ}</td>
					</tr>
				</table>
				</c:if>
		</form:form>
		
		
		<form:form>
		<h1><c:out value="${msg}"/></h1>		
		</form:form>
		<a href="index.jsp">HOME</a>
	</center>

</body>
</html>