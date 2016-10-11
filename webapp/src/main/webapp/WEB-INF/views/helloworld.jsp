<%@ page language="java" pageEncoding="UTF-8" session="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="prefix" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>Dashboard EHR</title>
	</head>
	<body>
		<h2>Hello World</h2>
		<h2>
			${message} ${name}
		</h2>
	</body>
</html>