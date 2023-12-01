<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="/css/reset.css">
<link rel="stylesheet" type="text/css" href="/css/join.css">
<title>Document</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script
	src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
</head>
<body>
	<%@ include file="includes/header.jsp"%>
	<div class="shareContainer">
		<div class="shareImg" style="background: url(image/svisual_img.png);"></div>
		<div class="shareContentWrap">
			<div class="shareNav">
				<ul>
					<li class="navTitle">회원정보</li>
					<li><span class="keyword"><a href="passCheck.jsp">개인정보수정</a></span></li>
					<li><span><a href="pwupdate.jsp">비밀번호변경</a></span></li>
					<li><span><a href="delete.jsp">회원탈퇴</a></span></li>
				</ul>
			</div>
			<div class="shareContentBox">
				<div class="shareContentTitle">
					<div class="contentTitle">개인정보수정</div>
					<div class="contentNav">
						<span>홈</span> <i class="arrow"
							style="background: url(image/ico_naviArrow.png) 0 50% no-repeat;"></i>
						<span>회원정보</span> <i class="arrow"
							style="background: url(image/ico_naviArrow.png) 0 50% no-repeat;"></i>
						<span>개인정보수정</span>
					</div>
				</div>

				<div class="shareContent">
					<div class="joinTitle">
						<p>*표시가 있는 항목은 필수 입력 항목입니다.</p>
					</div>
					<form action="BookServlet" method="post" name="frm">
						<input type="hidden" name="command" value="update_success">
						<table>
							<tr>
								<th>아이디(ID)</th>
								<td><input type="text" id="memberid" name="memberid"
									value="${loginUser.memberid}" readonly="readonly"></td>
							</tr>
							<tr>
								<th>이름</th>
								<td><input type="text" id="membername" name="membername"
									value="${loginUser.membername}"></td>
							</tr>
							<tr>
								<th>우편번호</th>
								<td><input type="text" id="postalcode" name="postalcode"
									value="${loginUser.postalcode}" readonly="readonly"> <input
									class="joinBtn" type="button" value="검색" id="btn"></td>
							</tr>
							<tr>
								<th>주소</th>
								<td><input type="text" id="postaladdress"
									name="postaladdress" value="${loginUser.postaladdress}"
									readonly="readonly"></td>
							</tr>
							<tr>
								<th>상세주소</th>
								<td><input type="text" id="detailaddress"
									name="detailaddress" value="${loginUser.detailaddress}">
								</td>
							</tr>
							<tr>
								<th>전화번호</th>
								<td><input type="text" id="mphone" name="mphone"
									value="${loginUser.mphone}"></td>
							</tr>
							<tr>
								<th>생년월일</th>
								<td><input type="text" id="birthdate" name="birthdate"
									placeholder="예시:'1971-08-08'" value=${loginUser.birthdate} >
								</td>
							</tr>
							<tr>
								<th>이메일</th>
								<td><input type="email" id="email" name="email"
									value="${loginUser.email}"></td>
							</tr>
						</table>
						<input class="joinCheck" type="submit" value="수정 확인"
							onclick="return loginCheck3()"> <input class="joinCancel"
							type="reset" value="취소">
					</form>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
    function loginCheck3() {
    	if (document.frm.membername.value.length == 0) {
    		alert("이름을 입력해주세요.");
    		frm.membername.focus();
    		return false;
    	}
    	if (document.frm.postalcode.value.length == 0) {
    		alert("우편번호를 입력해주세요.");
    		frm.postalcode.focus();
    		return false;
    	}
    	if (document.frm.postaladdress.value.length == 0) {
    		alert("주소를 입력해주세요.");
    		frm.postaladdress.focus();
    		return false;
    	}
    	if (document.frm.detailaddress.value.length == 0) {
    		alert("상세주소를 입력해주세요.");
    		frm.detailaddress.focus();
    		return false;
    	}
    	if (document.frm.mphone.value.length == 0) {
    		alert("전화번호를 입력해주세요.");
    		frm.mphone.focus();
    		return false;
    	}
    	var birthdate = document.frm.birthdate.value;
    	if (!isValidDate(birthdate)) {
    		alert("올바른 생년월일 형식(YYYY-MM-DD)을 입력해주세요.");
    		frm.birthdate.focus();
    		return false;
    	}
    	if (document.frm.email.value.length == 0) {
    		alert("이메일을 입력해주세요.");
    		frm.email.focus();
    		return false;
    	}

    	alert("정보가 수정되었습니다.");
    	return true;
    }

    function isValidDate(dateString) {
    	// 생년월일의 유효한 형식을 정의
    	var regex = /^\d{4}-\d{2}-\d{2}$/;
    	return regex.test(dateString);
    }
    
    const btn = document.querySelector("#btn");
    btn.addEventListener("click", () =>{
    	   new daum.Postcode({
    	        oncomplete: function(data) {
    	        	console.log(data);
    	        	let fullAddr = '';
    	        	let extraAddr = '';
    	        	if(data.userSelectedType == 'R'){
    	        		fullAddr = data.roadAddress;
    	        	}else{
    	        		fullAddr = data.jibunAddress;
    	        	}
    	        	
    	        	if(data.userSelectedType == 'R'){
    	        		if(data.bname !== ''){
    	        			extraAddr += data.bname;
    	        		}
    	        		if(data.buildingName !== ' '){
    	        			extraAddr += (extraAddr !== ''?', '+ data.buildingName : data.buildingName);
    	        		} 
    	        		fullAddr += (extraAddr !== '' ? ' (' + extraAddr + ')' : '');	
    	        	}
    	        	
    	        	
    	        	document.getElementsByName("postaladdress")[0].value = fullAddr;
    	        	document.getElementsByName("postalcode")[0].value = data.zonecode;
    	        	// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
    	            // 예제를 참고하여 다양한 활용법을 확인해 보세요.
    	            document.getElementsByName("detailaddress")[0].focus();
    	        }
    	    }).open();	
    })
    </script>

	<%@ include file="includes/footer.jsp"%>
</body>
</html>