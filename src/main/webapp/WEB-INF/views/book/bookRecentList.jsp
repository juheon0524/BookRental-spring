<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>신간도서조회</title>
    
    <link rel="stylesheet" type="text/css" href="/resources/css/reset.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/list.css">
    
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
    
</head>
<c:if test="${wishSu == 1}">
		<script type="text/javascript">
			alert("이미 추가하신 도서입니다.")
		</script>
	
</c:if>
<c:if test="${wishSu == 2}">
	<script type="text/javascript">
        var confirmResponse = confirm("추가하셨습니다. 내 서재로 이동하시겠습니까?");
        if (confirmResponse) {
            // 이동할 페이지의 URL을 여기에 입력
            window.location.href = "BookServlet?command=wish_lists";
        }
    </script>
</c:if>
<body>
<%@ include file="../includes/header.jsp"%>
    <div class="shareContainer">
        <div class="shareImg" style="background: url(/resources/image/svisual_img.png)"></div>
        <div class="shareContentWrap">
            <div class="shareNav">
                <ul>
                    <li class="navTitle">도서검색</li>
                    <li><span>통합도서 검색</span></li>
                    <li><span class="keyword"><a href="/book/bookRecentList">신간도서 조회</a></span></li>
                    <li><span><a href="/book/bookPopularList">인기도서 조회</a></span></li>
                    <li><span>도서 상세 페이지</span></li>
                </ul>
            </div>
            <div class="shareContentBox">
                <div class="shareContentTitle">
                    <div class="contentTitle">신간도서 조회</div>
                    <div class="contentNav">
                        <span>홈</span>
                        <i class="arrow" style=" background: url(/resources/image/ico_naviArrow.png)0 50% no-repeat;"></i>
                        <span>도서검색</span>
                        <i class="arrow" style=" background: url(/resources/image/ico_naviArrow.png)0 50% no-repeat;"></i>
                        <span>신간도서 조회</span>
                    </div>
                </div>

                <div class="shareContent">
                    <c:forEach var="book" items="${ bookRecentList }">
                    <div class="listWrap">
                        <div class="listImgBox">
	                        <c:choose>
								<c:when test="${empty book.bookimgurl }">
									<img src="/resources/image/noimage.gif"  alt="신간도서">
								</c:when>
								<c:when test="${fn:contains(book.bookimgurl, 'https')}">
						            <!-- If bookimgurl contains 'https', specify a different image URL -->
						            <img src="${book.bookimgurl }" alt="신간도서">
						        </c:when>
								<c:otherwise>
									<img src="/resources/image/${book.bookimgurl }" alt="신간도서">
								</c:otherwise>
							</c:choose>
                        </div>
                        <div class="listContentBox">
                            <h2><a href="/book/bookDetail?isbn=${book.isbn}">${book.title }</a></h2>
                            <h3>${book.author }, ${book.publisher }, ${book.publisheddate }</h3>
                            <p>누적대여 횟수 : ${book.cumrentalcnt }, 대여가능 수량 : ${book.curbookcnt }, 구독자 평점 : ${book.score }</p>
                            <!-- 본문 내용추가 원하면 여기에 추가 -->
                        </div>
                        <c:choose>
							    <c:when test="${loginUser.memberflag == null}">
							       <div class="listBtnBox">
			                            <input type="button" value="위시리스트"  onclick="alert('로그인이 필요합니다.');">
			                            <input type="button" value="대여하기">
                       				</div>
							    </c:when>
								<c:otherwise>
							    	 <div class="listBtnBox">
			                            <input type="button" value="위시리스트"  onclick="location.href='BookServlet?command=wish_upload&isbn=${book.isbn}&value=1'">
			                            <input type="button" value="대여하기">
                       				</div>
							    </c:otherwise>
						</c:choose>
                    </div>
                	</c:forEach>
                	
                 	<!-- 페이징 처리  -->
					<div class="pull-right">
					  <ul class="pagination">
					  	
					  	<c:if test="${pageMaker.prev}">
					    	<li class="page-item"><a class="page-link" href="${pageMaker.startPage-1}">Previous</a></li>
					    </c:if>
					   
					    <c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
					    	<li class="page-item  ${pageMaker.cri.pageNum == num ? "active" : ""}" >
					    		<a class="page-link" href="${num}">${num}</a>
					    	</li>
					    </c:forEach>
					  
					    <c:if test="${pageMaker.next}">
					   	 <li class="page-item"><a class="page-link" href="${pageMaker.endPage+1 }">Next</a></li>
					    </c:if>
					  </ul>
					</div>


                    <!-- /페이징 처리  -->
                    
                    <form id="actionForm" action="/book/bookPopularList" method="get">
                    	<input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum }">
                    	<input type="hidden" name="amount" value="${pageMaker.cri.amount }">
                    	<input type="hidden" name="type" value="${pageMaker.cri.type }">
                    	<input type="hidden" name="keyword" value="${pageMaker.cri.keyword }">
                    </form>               	
                	

                </div>
            </div>
        </div>
    </div>

<script>
	$(document).ready(function(){
		var result = '<c:out value="${result}"/>';
		//var result = "${result}";
		
		/* checkModal(result);
		
		history.replaceState({},null,null);
		
		//Modal 창
		function checkModal(result){
			if(result === "" || history.state ) {
				return;
			}
			if(parseInt(result) > 0 ) {
				$(".modal-body").html("게시글 " + parseInt(result) +" 번이 등록되었습니다.")
			}
			
			$("#myModal").modal("show");
		}
		
		//register 호출
		$("#regBtn").on("click", function(){
			self.location = "/board/register";
		}); */
		
		//페이지 버튼 클릭 이동
		var actionForm = $("#actionForm");
		$(".page-item a").on("click",function(e){
			e.preventDefault();
			
			actionForm.find("input[name='pageNum']").val($(this).attr("href"));
 			actionForm.submit(); 
		});
		
		//조회하고 리스트 화면으로 이동할 때 기본 pagenum 유지
		$(".move").on("click", function(e){
			e.preventDefault();
			actionForm.append("<input type='hidden' name='isbn' value='" + $(this).attr("href")+ "'>");
			actionForm.attr("action", "/book/get");
			actionForm.submit();
		});
		
		//검색버튼 이벤트 처리
/* 		var searchForm = $("#searchForm");
		$("#searchForm button").on("click", function(e){
			if(!searchForm.find("option:selected").val()){
				alert("검색종류를 선택하세요");
				return false;
			}
			if(!searchForm.find("input[name='keyword']").val()){
				alert("키워드를 입력하세요");
				return false;
			}
			serachForm.find("input[name='pageNum']").val("1");
			e.prevendDefault();
			
			searchForm.submit();
		}); */
		
		//selected check
		var select = "${pageMaker.cri.type}";
		if(select != ""){
			$('#type option[value= '+ select + ']').prop("selected", true);
		};
		
		
		
	});
</script>  
    
    
<%@ include file="../includes/footer.jsp"%>
</body>
</html>