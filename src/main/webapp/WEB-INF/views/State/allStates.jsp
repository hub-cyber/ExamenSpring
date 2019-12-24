<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All States</title>
<title>Insert title here</title>
</head>
<body>
	
	<h3>List of all States</h3>
	<br>
		<a href="${pageContext.request.contextPath }/home" > <input type="Submit" name="" value="home"> </a>
		<br>
		<br>
		<a href="${pageContext.request.contextPath }/addState"><input type="Submit" name="" value="addState"></a>
	<br>
	<br>
	
	<table border="1px" cellpadding="0" cellspacing="0">
		<thead>
			<tr>
				<th>Id</th>
				<th>Description</th>
				<th>Shipping_Zone</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="State" items="${stateList}">
				<tr>
					<td>${State.state_id}</td>
					<td>${State.description_state}</td>
					<td>${State.shipping_zone }</td>
					<td><a href="${pageContext.request.contextPath }/editState/${State.state_id}">Edit</a></td>
					<td><a href="${pageContext.request.contextPath }/deleteState/${State.state_id}">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>