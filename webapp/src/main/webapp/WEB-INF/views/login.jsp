<%@ page language="java" pageEncoding="UTF-8" session="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="prefix" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Login to EHR</title>
<link type="text/css"  rel="stylesheet" href="${prefix}/resources/css/bootstrap.css" />
<link type="text/css" rel="stylesheet" href="${prefix}/resources/css/style.css" />
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
				<form action="" method="">
					<input name="user" type="text" placeholder="username"> <input
						type="password" placeholder="password">
					<button class="btn btn-info btn-block login" type="submit">Login</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>