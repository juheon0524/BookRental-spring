<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/css/reset.css">
<link rel="stylesheet" type="text/css" href="/css/memberCancle.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<c:if test="${su == -1}">
	<script type="text/javascript">
		alert("비밀번호가 틀렸습니다.")
	</script>
</c:if>
<title>회원탈퇴</title>
</head>
<body>
	<%@ include file="includes/header.jsp"%>
	<div class="shareContainer">
		<div class="shareImg" style="background: url(image/svisual_img.png);"></div>
		<div class="shareContentWrap">
			<div class="shareNav">
				<ul>
					<li class="navTitle">회원정보</li>
					<li><span><a href="passCheck.jsp">개인정보수정</a></span></li>
					<li><span><a href="pwupdate.jsp">비밀번호변경</a></span></li>
					<li><span class="keyword"><a href="delete.jsp">회원탈퇴</a></span></li>
				</ul>
			</div>
			<div class="shareContentBox">
				<div class="shareContentTitle">
					<div class="contentTitle">회원탈퇴</div>
					<div class="contentNav">
						<span>홈</span> <i class="arrow"
							style="background: url(image/ico_naviArrow.png) 0 50% no-repeat"></i>
						<span>회원정보</span> <i class="arrow"
							style="background: url(image/ico_naviArrow.png) 0 50% no-repeat"></i>
						<span>회원탈퇴</span>
					</div>
				</div>

				<div class="shareContent">
					<div>
						<h2>홈페이지회원 탈퇴</h2>
						<P>
							· 회원탈퇴 후 동일한 아이디의 재가입은 불가능 하며 이전의 신청정보는 확인할 수 없습니다.<br /> · 준회원은
							회원정보가 영구적으로 삭제됩니다.<br /> · 비밀번호를 입력하시고 홈페이지회원 탈퇴하기 버튼을 클릭하시면
							탈퇴처리가 완료됩니다.<br />
						</P>
					</div>
					<form class="memberCancleForm"
						action="BookServlet?command=deleteCheck" method="post" name="frm">
						<table>
							<tr>
								<th>성명</th>
								<td>${loginUser.membername}</td>
							</tr>
							<tr>
								<th>아이디</th>
								<td>${loginUser.memberid}</td>
							</tr>
							<tr>
								<th>비밀번호 확인</th>
								<td><input type="password" id="passcode" name="passcode"
									placeholder="비밀번호 입력"></td>
							</tr>
						</table>
						<input type="submit" value="홈페이지 회원 탈퇴하기"
							onclick="return deletecheck()">
					</form>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript">
		function deletecheck() {
	
			if (document.frm.passcode.value.length == 0) {
				alert("비밀번호를 입력해주세요.");
				frm.passcode.focus();
				return false;
			}
			var confirmed = confirm("정말로 탈퇴하시겠습니까?");
			if (confirmed) {
				// 사용자가 "예"를 선택한 경우 서버로 비밀번호 확인 요청을 보낼 수 있습니다.
				// 예를 들어, AJAX 요청을 사용하여 서버와 통신할 수 있습니다.
				// 이 예제에서는 서버로의 요청을 보내지는 않지만, 여기에 필요한 코드를 추가할 수 있습니다.
				return true;
			} else {
				// 사용자가 "아니오"를 선택한 경우 동작을 취소합니다.
				return false;
			}
		}
	</script>

	<%@ include file="includes/footer.jsp"%>
</body>
</html>