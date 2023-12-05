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
<h1>/test/admin page</h1>
<form action="/Logout" method="post">

		<button>로그아웃</button>

		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

<p>principal : <sec:authentication property="principal"/></p>
<p>MemberVO : <sec:authentication property="principal.member"/></p>
<p>사용자 이름 : <sec:authentication property="principal.member.name"/></p> 
<p>사용자 아이디 : <sec:authentication property="principal.member.id"/></p> 
<p>사용자 권한 리스트 : <sec:authentication property="principal.member.auth"/></p>
<p>meberflag : <sec:authentication property="principal.member.memberflag"/></p>


</body>
</html>