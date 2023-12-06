<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<!-- include libraries(jQuery, bootstrap) -->
<link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script> 
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script> 
<!-- include summernote css/js-->
<link href="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.11/summernote-bs4.css" rel="stylesheet">
<script src="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.11/summernote-bs4.js"></script>
<!-- include summernote-ko-KR -->
<script src="/resources/summernote/summernote-ko-KR.js"></script>
<script src="/resources/summernote/summernote-lite.js"></script>
<link rel="stylesheet" href="/resources/summernote/summernote-lite.css">
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
<h2 style="text-align: center;">글 작성</h2><br><br><br>

<div style="width: 60%; margin: auto;">
	<form method="post" action="/board/write">
		<input type="text" style="width: 20%;" placeholder="작성자"  readonly="readonly" 
			value="<sec:authentication property="principal.member.membername"/>" /><br>
		<input type="text" name="btitle" style="width: 40%;" placeholder="제목"/>
		<br><br> 
		<textarea id="summernote" name="bcontent"></textarea>
		<button id='regBtn' type="button">등록</button>
		<button type="submit" data-oper='list' >목록</button>
		<input type="hidden" name="memberid" value="<sec:authentication property="principal.member.memberid"/>"/>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	</form>
</div>

</body>
</html>
<script type="text/javascript">
$(document).ready(function(){
    var formObj = $("form");

    $('button').on("click", function(e){
        e.preventDefault();

        var operation = $(this).data("oper");

        if(operation == 'list'){
            formObj.attr("method", "get");
            formObj.attr("action", "/board/list");            
        } 
        
        formObj.submit();
    });	 

   
</script>