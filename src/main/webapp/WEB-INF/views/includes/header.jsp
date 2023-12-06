<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" type="text/css" href="/resources/css/reset.css">
<link rel="stylesheet" type="text/css" href="/resources/css/header.css">
<!-- <script type="text/javascript" src="/resources/script/header.js"></script> -->

<!-- <html lang="en">
<head> -->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>도서상세정보</title>

    <!-- <link rel="stylesheet" type="text/css" href="/resources/css/reset.css"> -->
    <link rel="stylesheet" type="text/css" href="/resources/css/bookDetailView.css">
    
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

	<!-- Bootstrap Core JavaScript -->
    <script src="/resources/vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="/resources/vendor/metisMenu/metisMenu.min.js"></script>

    <!-- DataTables JavaScript -->
    <script src="/resources/vendor/datatables/js/jquery.dataTables.min.js"></script>
    <script src="/resources/vendor/datatables-plugins/dataTables.bootstrap.min.js"></script>
    <script src="/resources/vendor/datatables-responsive/dataTables.responsive.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="/resources/dist/js/sb-admin-2.js"></script>
    
    
    <!-- Bootstrap Core CSS -->
    <link href="/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="/resources/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- DataTables CSS -->
    <link href="/resources/vendor/datatables-plugins/dataTables.bootstrap.css" rel="stylesheet">

    <!-- DataTables Responsive CSS -->
    <link href="/resources/vendor/datatables-responsive/dataTables.responsive.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="/resources/dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="/resources/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    
    
<!-- </head> -->

<!-- <header> -->
	<!-- headerTop -->
	<div class="headerTopWrap">
		<div class="logo">
			<a href="index.jsp"><img src="/resources/image/logo.png" alt="logoImg"></a>
		</div>
		<div class="headerSerchWrap">
			<div class="headerSerchBox">
				<form action="/book/bookSearchList" method="get"
				name="frm" class="searchWordWrap">
					<div class="headerSerch">
						<input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum }">
                    	<input type="hidden" name="amount" value="${pageMaker.cri.amount }">
                    	<input type="hidden" name="type" value="TCA">
						<input type="text" name="keyword" class="searchWord" placeholder="검색어를 입력하세요.(도서명, 작가, 출판사 등)"
							value="${pageMaker.cri.keyword }" >
					</div>
					<div class="headerSerchBtn">
						<button type="submit">
							<img src="/resources/image/serch.jpg" alt="serchIcon">
						</button>
					</div>
				</form>
			</div>
		</div>
		<div class="headerNav1">
			<c:choose>
				<c:when test="${not empty loginUser}">
					<!-- 사용자가 로그인한 경우 -->
					<ul>
						<li><a href="BookServlet?command=logout-form">로그아웃</a></li>
						<li>|</li>
						<li><a href="passCheck.jsp">정보수정</a></li>
						<li>|</li>
						<li><a href="sitemap.jsp">사이트맵</a></li>
					</ul>
					<a>안녕하세요, ${loginUser.membername}님!</a>
				</c:when>
				<c:otherwise>
					<!-- 사용자가 로그인하지 않은 경우 -->
					<ul>
						<li><a href="BookServlet?command=login-form">로그인</a></li>
						<li>|</li>
						<li><a href="BookServlet?command=agree-from">회원가입</a></li>
						<li>|</li>
						<li><a href="sitemap.jsp">사이트맵</a></li>
					</ul>
				</c:otherwise>
			</c:choose>
		</div>
	</div>

	<!-- headerBottom -->
	<div class="headerBottomWrap">
		<div class="headerNav2">
			<nav>
				<ul>
					<li>도서관 안내
						<ul>
							<li><a href="#">회원 가입 안내</a></li>
							<li><a href="#">도서 대여 안내</a></li>
						</ul>
					</li>
					<li>도서검색
						<ul>
							<li><a href="#">통합도서 검색</a></li>
							<li><a href="/book/bookRecentList">신간도서 조회</a></li>
							<li><a href="/book/bookPopularList">인기도서 조회</a></li>
						</ul>
					</li>
					<li>열린마당
						<ul>
							<li><a href="#">공지사항</a></li>
							<li><a href="#">Q&A</a></li>
							<li><a href="#">독후감</a></li>
						</ul>
					</li>
					<li>내 서재
						<ul>
							<li><a href="#">나의정보</a></li>
							<li><a href="#">구독내역 조회</a></li>
							<li><a href="#">대여내역 조회</a></li>
							<li><a href="#">반납현황 조회</a></li>
							<c:choose>
							    <c:when test="${loginUser.memberflag == null}">
							        <li><a onclick="alert('로그인이 필요합니다.');">나만의 책장</a></li>
							    </c:when>
							    <c:otherwise>
							        <li><a href="BookServlet?command=wish_lists" >나만의 책장</a></li>
							    </c:otherwise>
							</c:choose>
						</ul>
					</li>
					<c:if test="${loginUser.memberflag == 01}">
						<li class="hiddenNav"><a href="BookServlet?command=admin_main">관리자 페이지</a>
							<ul>
								<li><a href="BookServlet?command=book_insert_form">도서관리</a></li>
								<li><a href="BookServlet?command=subscr_list">구독권관리</a></li>
							</ul>
						</li>
					</c:if>
				</ul>
			</nav>
		</div>
	</div>
<!-- </header> -->

<!-- <body> -->