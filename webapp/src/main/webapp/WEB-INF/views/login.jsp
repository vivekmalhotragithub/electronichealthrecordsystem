<%@ page language="java" pageEncoding="UTF-8" session="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="prefix" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Login to EHR</title>
<link type="text/css" rel="stylesheet"
	href="${prefix}/resources/css/bootstrap.css" />
<link type="text/css" rel="stylesheet"
	href="${prefix}/resources/css/style.css" />
<!-- load Dojo -->
<style type="text/css">
@import
	"http://ajax.googleapis.com/ajax/libs/dojo/1.5/dijit/themes/claro/claro.css"
	;
</style>
<script
	src="http://ajax.googleapis.com/ajax/libs/dojo/1.6/dojo/dojo.xd.js"></script>
<script>
	
</script>
</head>
<body>
	<div class="container">
		<div class="login-container">
			<div id="output"></div>
			<div class="avatar"></div>
			<div class="form-box">
				<form:form name="loginForm" action="login" method="POST">
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
					<input name="username" type="text" />
					<input type="password" />
					<button class="btn btn-info btn-block login" type="submit">Login</button>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>