<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<link rel="stylesheet" type="text/css" href="/resources/css/reset.css">
<link rel="stylesheet" type="text/css" href="/resources/css/header.css">

<header>
	<!-- headerTop -->
	<div class="headerTopWrap">
		<div class="logo">
			<a href=""><img src="/resources/image/logo.png" alt="logoImg"></a>
		</div>
		<div class="headerSerchWrap">
			<div class="headerSerchBox">
				<form id='actionform' action="BookServlet?command=book_slist" method="post"
					name="frm" class="searchWordWrap">
					<div class="headerSerch">
						<input type="text" name="searchWord" class="searchWord"
							placeholder="검색어를 입력하세요.(도서명, 작가, 출판사 등)">
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
			<sec:authorize access="isAnonymous()">
			<!-- 사용자가 로그인하지 않은 경우 -->
				<ul>
					<li><a href="/customLogin">로그인</a></li>
					<li>|</li>
					<li>
						<form action="/member/join" method="get">
							<button>회원가입</button>
						</form>
					</li>
					<li>|</li>
					<li><a href="">사이트맵</a></li>
				</ul>
			</sec:authorize>
	
			<sec:authorize access="isAuthenticated()">
			<!-- 사용자가 로그인한 경우 -->
		            <ul>
		                <li>
		                    <form action="/logout" method="post">
		                        <button>로그아웃</button>
		                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		                    </form>
		                </li>
		                <li>|</li>
		                <li><button id='regBtn' type="button">정보 수정</button></li>
		                <li>|</li>
		                <li><a href="">사이트맵</a></li>
		            </ul>
		            <a>안녕하세요, <sec:authentication property="principal.member.membername"/>님!</a> 
			</sec:authorize>
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
							<li><a href="BookServlet?command=book_dlist">신간도서 조회</a></li>
							<li><a href="BookServlet?command=book_plist">인기도서 조회</a></li>
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
									<li><a href="BookServlet?command=wish_lists">나만의 책장</a></li>
								</c:otherwise>
							</c:choose>
						</ul>
					</li>
					<c:if test="${loginUser.memberflag == 01}">
						<li class="hiddenNav"><a
							href="BookServlet?command=admin_main">관리자 페이지</a>
							<ul>
								<li><a href="BookServlet?command=book_insert_form">도서관리</a></li>
								<li><a href="BookServlet?command=subscr_list">구독권관리</a></li>
							</ul></li>
					</c:if>
				</ul>
			</nav>
		</div>
	</div>


	<script type="text/javascript">
		$(document).ready(function() {
			// 각 항목에 대한 이벤트 핸들링
			$('.headerNav2 nav ul li').mouseover(function() {
				// 마우스 오버 시 실행되는 코드
				$('.headerNav2 nav ul li ul').css('display', 'block');
			}).mouseleave(function() {
				// 마우스 아웃 시 실행되는 코드
				$('.headerNav2 nav ul li ul').css('display', 'none');
			});
		});
		$(document).ready(function() {
			// 각 항목에 대한 이벤트 핸들링
			$('.headerNav2 nav ul li').hover(function() {
				// 마우스 오버 시 실행되는 코드
				$(this).find('ul').css('background-color', '#eee');
			}, function() {
				// 마우스 아웃 시 실행되는 코드
				$(this).find('ul').css('background-color', ''); // 기본 배경색으로 변경
			});
		});
		
		//등록하기 버튼누르면 register페이지로 이동
		$("#regBtn").on("click", function(){
			self.location ="/member/modify";
		})
		
		//로고 누르면 메인화면으로 리다이렉트
		var actionForm = $("#actionform");
		 $(document).ready(function() {
		        $(".logo").on("click", function(e) {
		            e.preventDefault();
		            
		            var actionForm = $('<form>', {
		                'action': '/member/main',
		                'method': 'post'
		            });
		            
		            actionForm.append('<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">');

		            $('body').append(actionForm);
		            actionForm.submit();
		        });
		    });
		
	</script>

</header>