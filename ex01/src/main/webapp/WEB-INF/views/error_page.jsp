<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h4>�� �������� ���� ���Դϴ�.!!!!!!!!!!!!!</h4>
<h4> <c:out value="${exception.getMessage()}" /></h4>
<ul>
	<c:forEach var="stack" items="${ exception.getStackTrace() }">
		<li> <c:out value="${stack }"/></li>
	</c:forEach>
</ul>
</body>
</html>