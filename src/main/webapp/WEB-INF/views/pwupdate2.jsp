<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<link rel="stylesheet" type="text/css" href="/css/reset.css">
<link rel="stylesheet" type="text/css" href="/css/pwUpdate.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<title>회원정보 수정</title>
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
					<li><span class="keyword"><a href="pwupdate.jsp">비밀번호변경</a></span></li>
					<li><span><a href="delete.jsp">회원탈퇴</a></span></li>
				</ul>
			</div>
			<div class="shareContentBox">
				<div class="shareContentTitle">
					<div class="contentTitle">비밀번호변경</div>
					<div class="contentNav">
						<span>홈</span> <i class="arrow"
							style="background: url(image/ico_naviArrow.png) 0 50% no-repeat"></i>
						<span>회원정보</span> <i class="arrow"
							style="background: url(image/ico_naviArrow.png) 0 50% no-repeat"></i>
						<span>비밀번호변경</span>
					</div>
				</div>

				<div class="shareContent">
					<div class="pwUpdateWrap">
						<form class="pwUpdateForm"
							action="BookServlet?command=pwupdate_success" method="post"
							name="frm">
							<div class="pwUpdateInputWrap">
								<div>
									<input type="password" id="passcode" name="passcode" placeholder="새 비밀번호 입력"> 
									<input type="password" id="passcode2" name="passcode2" placeholder="새 비밀번호 확인">
								</div>
								<button type="submit" onclick="return passEqualCheck()">
									비밀번호<br>재발급
								</button>
							</div>
						</form>
						<p>※ 10~20자리의 영문,숫자,특수문자(단, &<>"' 제외)를 모두 포함하여 입력해 주세요.</p>

					</div>
				</div>
			</div>
		</div>
	</div>
	
	<script type="text/javascript">
	function passEqualCheck() {
		console.log("Function called")
		var passcode = document.getElementById("passcode").value;
		var passcode2 = document.getElementById("passcode2").value;

		if (document.frm.passcode.value.length == 0) {
			alert("비밀번호를 입력해주세요.");
			frm.passcode.focus();
			return false;
		}

		if (document.frm.passcode2.value.length == 0) {
			alert("비밀번호를 입력해주세요.");
			frm.passcode2.focus();
			return false;
		}

		if (passcode !== passcode2) {
			alert("비밀번호가 일치하지 않습니다.");
			document.getElementById("passcode").focus();
			return false;
		}
		alert("변경되었습니다.");
		return true;
	}
	</script>
	
	<%@ include file="includes/footer.jsp"%>
</body>
</html>