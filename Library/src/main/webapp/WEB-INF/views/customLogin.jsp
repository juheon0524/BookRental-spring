<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="/resources/css/reset.css">
<link rel="stylesheet" type="text/css" href="/resources/css/login.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<title>로그인 창</title>
<style>
    .myModal {
        position: absolute;
        display: none;
        justify-content: center;
        align-items: center;
        top: 0;
        left: 0;
        width: 100%;
        height: 100%;
        background-color: rgba(0, 0, 0, 0.4);
    }

    .modal-body {
        position: relative;
        width: 400px;
        height: 200px;
        padding: 20px;
        text-align: center;
        background-color: rgb(255, 255, 255);
        border-radius: 10px;
        box-shadow: 0 2px 3px 0 rgba(34, 36, 38, 0.15);
    }

</style>
</head>
<body>
	<%@ include file="includes/header.jsp"%>
	<div class="shareContainer">
		<div class="shareImg" style="background: url(/resources/image/svisual_img.png);"></div>
		<div class="shareContentWrap">
			<div class="shareNav">
				<ul>
					<li class="navTitle">회원정보</li>
					<li><span class="keyword"><a href="login.jsp">로그인</a></span></li>
					<li><span><a href="agree.jsp">회원가입</a></span></li>
				</ul>
			</div>
			<div class="shareContentBox">
				<div class="shareContentTitle">
					<div class="contentTitle">로그인</div>
					<div class="contentNav">
						<span>홈</span> <i class="arrow"
							style="background: url(/resources/image/ico_naviArrow.png) 0 50% no-repeat"></i>
						<span>회원정보</span> <i class="arrow"
							style="background: url(/resources/image/ico_naviArrow.png) 0 50% no-repeat"></i>
						<span>로그인</span>
					</div>
				</div>

				<div class="shareContent">
					<div class="loginWrap">
						<form class="loginForm" action="/login"
							method="post" name="frm">
							<div class="loginBox">
								<div class="loginImgBox">
									<img src="/resources/image/login.jpg" alt="login">
								</div>
								<div class="loginInputBox">
									<div class="loginId">
										<img src="/resources/image/ico_loginID.png" alt="idicon"> <input
											type="text" name="username"
											placeholder="아이디 입력란">
									</div>
									<div class="loginPw">
										<img src="/resources/image/ico_loginPW.png" alt="pwicon"> <input
											type="password"  name="password"
											placeholder="비밀번호 입력란">
									</div>
									<div class="loginSub">
										<ul>
											<li>아이디 찾기</li>
											<li>|</li>
											<li>비밀번호 재설정</li>
											<li>|</li>
											<li><a href="joinselect.jsp">회원가입</a></li>
										</ul>
									</div>
									<div>
										<input type="checkbox" name="remember-me">Remember Me
									</div>
								</div>
								<div class="loginBtnBox">
									<input class="loginBtn" type="submit" value="로그인"
										onclick="return loginCheck()">
								</div>
							</div>
							<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
						</form>
						
							<a href="/login/kakao">
						    <img alt="카카오로그인" src="/resources/image/kakao_login_logo.png" >
							</a>
						<div class="loginDesc">
							<ul>
								<li>※ 로그인이 안되시는 경우 한/영 키와 Caps Lock 키가 눌러져 있지 않은지 확인하세요.</li>
								<li>※ 계속해서 로그인이 안되시는 경우 관리자에게 문의하시기 바랍니다.</li>
							</ul>
						</div>
					</div>

				</div>
			</div>
		</div>
	</div>
	
	 <!-- 모달창 -->
    <div class="myModal">
        <div class="modal-body">
            <span class="close_button" onclick="closeModal()">&times;</span>
            회원가입이 완료되었습니다.<br>
            로그인 해주세요.
        </div>
    </div>
    <!-- 모달창 -->

	<%@ include file="includes/footer.jsp"%>
</body>
</html>

	<script type="text/javascript">
		function loginCheck() {
			if (document.frm.memberid.value.length == 0) {
				alert("아이디를 입력해주세요.");
				frm.memberid.focus();
				return false;
			}

			if (document.frm.passcode.value.length == 0) {
				alert("비밀번호를 입력해주세요.");
				frm.passcode.focus();
				return false;
			}

			return true;
		}
		
		 $(document).ready(function(){
		        var result = '<c:out value="${result}"/>';

		        checkModal(result);
		        
		        //result값 보고 모달창 띄우기
		        function checkModal(a){
		            if (a === ''){
		                return;
		            }
		            if (parseInt(a)>0){
		                $(".myModal").css("display", "flex");
		            }
		        }

		        // 닫기 버튼을 누를 때 모달을 숨깁니다.
		        window.closeModal = function() {
		            $(".myModal").css("display", "none");
		        };

		    });
	</script>
ㄴ