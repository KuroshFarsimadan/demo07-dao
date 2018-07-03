<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Persons</title>
</head>
<body>
	<table>
		<caption>Persons</caption>
		<thead>
			<tr>
				<td>ID</td>
				<td>FIRSTNAME</td>
				<td>LASTNAME</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${persons}" var="pers">
				<tr>
					<td><c:out value="${pers.id}" /></td>
					<td><c:out value="${pers.firstname}" /></td>
					<td><c:out value="${pers.lastname}" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>