<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

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

    .close_button {
        position: absolute;
        top: 10px;
        right: 10px;
        cursor: pointer;
    }
    
        div ul li {
        list-style: none;
        padding: 0;
        margin: 0;
        float : left;
        margin-left : 20px;
    }
    
    .paginate_button.active a {
	    font-weight: bold;
	    text-decoration:none;
		}
</style>

</head>

<body>
	<div><h1>목록 페이지</h1>
	<button id='regBtn' type="button">등록</button>
	</div>
    

    <table>
        <tr>
            <td>*</td>
            <td>제목</td>
            <td>첨부</td>
            <td>작성일</td>
            <td>조회수</td>
        </tr>

        <c:forEach items="${list}" var="board">
            <tr>
             	<td><a>★</a></td>
                <td><a class='move' href='${board.boardid}'><c:out value="${board.btitle}"/></a></td>
                 <td><a>첨부</a></td>
				<td><c:out value="${board.createdate}"/></td>
                <td><c:out value="${board.readcnt}"/></td>
            </tr>
        </c:forEach>
    </table>
    <div>
	    <ul >
		    <c:if test="${pageMaker.prev}">
		    	<li class="paginate_button previous"><a href="${pageMaker.startPage -1}">Previous</a></li>
		    </c:if>
		    
		    <c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
		    	<li class="paginate_button ${pageMaker.cri.pageNum == num ? "active":""}"><a href="${num}">${num}</a></li>
		    </c:forEach>
		    
		    <c:if test="${pageMaker.next}">
		    	<li class="paginate_button next"><a href="${pageMaker.endPage +1}">Next</a></li>
		    </c:if>
	    </ul>
	    
	    <form id='actionform' action="/board/list" method="get">
	    <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	    	<select name='type'>
	    		<option value="" ${pageMaker.cri.type == null ? 'selected' : '' }>--</option>
	    		<option value="N" ${pageMaker.cri.type eq 'N' ? 'selected' : '' }>제목</option>
	    		<option value="A" ${pageMaker.cri.type eq 'A' ? 'selected' : '' }>내용</option>
	    		<option value="NA" ${pageMaker.cri.type eq 'NA' ? 'selected' : '' }>제목 또는 내용</option>
	    	</select>
	    	<input type='text' name='keyword' value="${pageMaker.cri.keyword}"/>
	    	
	    	<input type="hidden" name="pageNum" value= "${pageMaker.cri.pageNum}"/>  
	    	<input type="hidden" name="amount" value= "${pageMaker.cri.amount}"/>  
	    	
	    	<button>검색</button>
	    </form>
	</div>
    <!-- 모달창 -->
    <div class="myModal">
        <div class="modal-body">
            <span class="close_button" onclick="closeModal()">&times;</span>
            게시글 "${result}" 번이 등록되었습니다.
        </div>
    </div>
    <!--  -->
    
</body>
</html>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script type="text/javascript">
    $(document).ready(function(){
        var result = '<c:out value="${result}"/>';

        checkModal(result);
        
        //result값 보고 모달창 띄우기
        function checkModal(a){
            if (result === ''){
                return;
            }
            if (parseInt(result)>0){
                $(".myModal").css("display", "flex");
            }
        }

        // 닫기 버튼을 누를 때 모달을 숨깁니다.
        window.closeModal = function() {
            $(".myModal").css("display", "none");
        };
        
        
        //등록하기 버튼누르면 register페이지로 이동
        $("#regBtn").on("click", function(){
        	self.location ="/board/register";
        })
        
        //페이지 이동 구현.
        var actionForm = $("#actionform");
        
        $(".paginate_button a").on("click", function(e){
        	e.preventDefault();
        	actionForm.find("input[name='pageNum']").val($(this).attr("href"));
        	actionForm.submit();
        });
        
        //조회페이지로 갈 때 URL에 pageNum과 amount가 필요해서 action을 바꾸는 방법을 선택.
        $(".move").on("click", function(e){
        	
        	e.preventDefault();
        	actionForm.append("<input type='hidden' name='boardid' value='"+$(this).attr("href")+"'>");
        	actionForm.attr("action", "/board/get");
        	actionForm.submit();
        });
        
        $("#actionform button").on("click", function(e){
        	
        	if(!actionForm.find("option:selected").val()){
        		alert("검색종류를 선택하세요.");
        		return false;
        	}
        	if(!actionForm.find("input[name='keyword']").val()){
        		alert("키워드를 입력하세요");
        		return false;
        	}
        	
        	actionForm.find("input[name='pageNum']").val("1");
        	e.preventDefault();
        	actionForm.submit();
        });
    });
</script>
