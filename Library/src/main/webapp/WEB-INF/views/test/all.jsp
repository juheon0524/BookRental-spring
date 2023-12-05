<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>/test/all page</h1>

<!--익명의 사용자일 경우  필요할 거 같진 않음.-->
<sec:authorize access="isAnonymous()">
	<a href="/customLogin">로그인</a>
</sec:authorize>
<!--인증된 사용자일 경우  안 필요함..-->
<sec:authorize access="isAuthenticated()">
	<form action="/Logout" method="post">

		<button>로그아웃</button>

		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
	</form>
</sec:authorize>

</body>
</html>