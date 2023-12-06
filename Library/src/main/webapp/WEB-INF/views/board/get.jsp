<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!-- include libraries(jQuery, bootstrap) -->
<link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script> 
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script> 
<!-- include summernote css/js-->
<link href="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.11/summernote-bs4.css" rel="stylesheet">
<script src="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.11/summernote-bs4.js"></script>
<!-- include summernote-ko-KR -->
<script src="/resources/summernote/summernote-ko-KR.js"></script>
<title>공지사항 등록</title>

<script>
$(document).ready(function() {
	  $('#summernote').summernote({
 	    	placeholder: 'content',
	        minHeight: 370,
	        maxHeight: null,
	        focus: true, 
	        lang : 'ko-KR'
	  });
	});
	

</script>
</head>
<body>
<form action="/board/modify" method="get">
<input type='hidden' name='pageNum' value="${cri.pageNum}">
<input type='hidden' name='amount' value="${cri.amount}">
<input type='hidden' name='keyword' value="${cri.keyword}">
<input type='hidden' name='type' value="${cri.type}">
<input type='hidden' name="boardid" value="${board.boardid}">

<div>
<label>작성자</label>
<input value="${board.memberid}" readonly="readonly">
</div>

<div>
<label>작성일</label>
<input value="${board.createdate}" readonly="readonly">
</div>

<div>
<label>제목</label>
<input value="${board.btitle}" readonly="readonly">
</div>

<div>
<label>조회수</label>
<input value="${board.readcnt}" readonly="readonly">
</div>

<div>
<label>첨부파일</label>
<input value="" readonly="readonly">
</div>


<div style="width: 60%; margin: auto;">
		<textarea id="summernote" name="bcontent" readonly="readonly">${board.bcontent}</textarea>
</div>

<button type="submit" data-oper='modify'>수정</button>
<button type="submit" data-oper='list' >목록</button>

</form>

</body>
</html>
<script type="text/javascript">
 $(document).ready(function(){

	 var formObj = $("form");
	 
	 $('button').on("click", function(e){
		 e.preventDefault();
		 
		 var operation = $(this).data("oper");

		 if(operation == 'list'){
			 formObj.attr("action", "/board/list");
			
		 }
		 formObj.submit();
	 });
	 
	
	 
 });

</script>

