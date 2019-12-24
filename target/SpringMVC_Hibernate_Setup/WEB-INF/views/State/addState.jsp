<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>${headerMessage}</h1>
	<form:form method="POST" action="addState" modelAttribute="State">
		<table>
                <tr>
                    <td><form:label path="description_state">Nombre del Estado</form:label></td>
                    <td><form:input path="description_state"/></td>
                </tr>
                <tr>
                    <td><form:label path="shipping_zone">Ubicacion</form:label></td>
                    <td><form:input path="shipping_zone"/></td>
                </tr>

                <tr>
                    <td><input type="submit" value="Submit"/></td>
                </tr>
            </table>
	</form:form>
</body>
</html>