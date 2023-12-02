<%@page import="com.ezen.domain.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="/resources/css/reset.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/bookDetailView.css">
    <script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.4.0.min.js"></script>
    <title>도서상세정보</title>
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
<%@ include file="../includes//header.jsp" %>
    <div class="shareContainer">
        <div class="shareImg" style="background: url(/resources/image/svisual_img.png);"></div>
        <div class="shareContentWrap">
            <div class="shareNav">
                <ul>
                    <li class="navTitle">도서검색</li>
                    <li><span>통합검색</span></li>
                    <li><span><a href="/book/bookRecentList">신간도서 조회</a></span></li>
                    <li><span><a href="/book/bookPopularList">인기도서 조회</a></span></li>
                    <li><span class="keyword">도서 상세 페이지</span></li>
                </ul>
            </div>
            <div class="shareContentBox">
                <div class="shareContentTitle">
                    <div class="contentTitle">도서 상세 페이지</div>
                    <div class="contentNav">
                        <span>홈</span>
                        <i class="arrow" style="background: url(/resources/image/ico_naviArrow.png)0 50% no-repeat;"></i>
                        <span>도서검색</span>
                        <i class="arrow" style="background: url(/resources/image/ico_naviArrow.png)0 50% no-repeat;"></i>
                        <span>도서 상세 페이지</span>
                    </div>
                </div>

                <div class="shareContent">
                    <form class="bookDetailWrap">
                        <div class="bookDetailBox">
                            <div class="bookDetailImgBox">
                    			<c:choose>
								<c:when test="${empty bookVO.bookimgurl }">
									<img src="/resources/image/noimage.gif" >
								</c:when>
								<c:when test="${fn:contains(bookVO.bookimgurl, 'https')}">
						            <!-- If bookimgurl contains 'https', specify a different image URL -->
						            <img src="${bookVO.bookimgurl }" alt="#">
						        </c:when>
								<c:otherwise>
									<img src="/resources/image/${bookVO.bookimgurl }" alt="책이미지">
								</c:otherwise>
								</c:choose>
                            </div>
                            <div class="bookDetailInfoBox">
                                <ul>
                                	<li><span>${bookVo.title }</span></li>
                                    <li><span>ISBN</span> : ${bookVO.isbn }</li>
                                    <li><span>작가</span> : ${bookVO.author }</li>
                                    <li><span>출판사</span> : ${bookVO.publisher }</li>
                                    <li><span>출간일</span> : ${bookVO.publisheddate }</li>
                                    <li><span>도서분류</span> : ${bookVO.genrecrawled }</li>
                                    <li><span>독자평점</span> : ${bookVO.score }</li>
                                    <li><span>누적대여횟수</span> : ${bookVO.cumrentalcnt }</li>
                                    <li><span>대여가능수량</span> : ${bookVO.curbookcnt }</li>
                                </ul>
                            </div>
                        </div>

                        <div class="bookDetailIntro">
                            <div class="bookDetailIntroTitle">
                                <h2>책소개</h2>
                            </div>
                            <p>${bookVO.bookcontent }</p>
                        </div>
                        <div class="bookDetailReview">
                            <div class="bookDetailReviewTitle">
                                <h2>독자후기</h2>
                            </div>
                             <%--<c:forEach var="ratings" items="${ ratingsList }">
	                            <h3>${ratings.memberid}, ${ratings.writedate}, ${ratings.score}</h3>
	                            <p>${ratings.content}</p>
                            </c:forEach> --%>
                        </div>


						<!--         댓글          -->
						
						    <div class="row">
						        <div class="col-lg-12">
						            <div class="panel panel-default">
						                <div class="panel-heading">
						                    <i class="fa fa-comments fa-fw"></i>
						                    
						                    <!-- <sec:authorize access="isAuthenticated()">
							                    <button id="addReplyBtn" class="btn btn-primary btn-xs pull-right">New Reply</button>
						                    </sec:authorize> -->
						                    
						                </div>
						                <!-- /.panel-heading -->
						                <div class="panel-body">
											<ul class="chat">
												<li class="left clearfix" data-ratingsid='12'>
													<div>
														<div class="header">
															<br>
															<strong class="primary-font">user00</strong>&nbsp;&nbsp;,
															<strong class="primary-font">5</strong>&nbsp;&nbsp;,
															<small class="pull-right text-muted">2023-11-16 11:20</small>
														</div>
														<p>Goog job!</p>
													</div>
												</li>
											</ul>	
						                </div>
						                <!-- /.panel-body -->
						                
						                <div class="panel-footer">
						                
						                </div>
						                
						            </div>
						            <!-- /.panel -->
						        </div>
						        <!-- /.col-lg-12 -->
						    </div>
						<!--         /댓글          -->




                        <div class="bookDetailBtnBox">
                        
                        <c:choose>
                        	<c:when test="${loginUser.memberflag == null}">
	                            <input type="button" value="위시리스트"  onclick="alert('로그인이 필요합니다.');">
	                            <input type="button" value="대여신청"> 
                            </c:when>
                            	<c:otherwise>
	                            	<input type="button" value="위시리스트" onclick="location.href='BookServlet?command=wish_upload&isbn=${bookVo.isbn}&value=3'">
		                            <input type="button" value="대여신청">
                            	</c:otherwise>       
						</c:choose>
                            <c:if test= "${sessionScope.loginUser.memberflag eq '01'}">
                            	<input type="button" value="도서정보수정" onclick="location.href='BookServlet?command=book_update_form&isbn=${bookVo.isbn }';">
                           	</c:if>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
    
<script type="text/javascript" src="/resources/js/ratings.js"></script>    
<script>

 	var isbnValue = '${bookVO.isbn}';
	var ratingsUL = $(".chat");
	
	console.log("isbnValue : " + isbnValue);

	showList(1);
	function showList(page){
		
		ratingsService.getList({isbn:isbnValue, page: page||1 }, function(ratingsCnt, list){
			
			if(page === -1) {
				pageNumber = Math.ceil(ratingsCnt / 10.0);
				showList(pageNum);
				return;
			}
			
			var str="";
			
			if(list == null || list.length==0) {
				ratingsUL.html("");
				return;
			}
			
			for(var i=0, len=list.length || 0; i<len; i++){
				
				str += "<li class='left clearfix' data-ratingsid='"+list[i].ratingsid +"'>";
				str += "<div><div class='header'>";
				str += "<strong class='primary-font'>"+ list[i].memberid +"</strong>";
				str += "<strong class='primary-font'>"+ list[i].score +"</strong>";
				str += "<small class='pull-right text-muted'>"+ ratingsService.displayTime(list[i].writedate) +"</small><br>";
				str += "</div><p>"+ list[i].content +"</p>";
				str += "<br><br></div></li>";
			}
			ratingsUL.html(str);
			
			showReplyPage(ratingsCnt);
			
		}); //end function
		
	} //end showList
	
	var modal = $(".modal");
	var modalInputReply = modal.find("input[name='reply']");
	var modalInputReplyer = modal.find("input[name='replyer']");
	var modalInputReplyDate = modal.find("input[name='replyDate']");
	
	var modalRegisterBtn = $("#modalRegisterBtn");
	var modalModBtn = $("#modalModBtn");
	var modalRemoveBtn = $("#modalRemoveBtn");
	var modalCloseBtn = $("#modalCloseBtn");
	
	var replyer = null;
	
/* 	<sec:authorize access="isAuthenticated()">
		replyer = '<sec:authentication property="principal.username" />';
	</sec:authorize> */
		
	var csrfHeaderName = "${_csrf.headerName }";
	var csrfTokenValue = "${_csrf.token }";
	
	//댓글창 보이기
	$("#addReplyBtn").on("click", function(e){
		
		modal.find("input").val("");
		modal.find("input[name='replyer']").val(replyer);
		modalInputReplyDate.closest("div").hide();
		modal.find("button[id != 'modalCloseBtn']").hide();
		modalRegisterBtn.show();
		
		/* modalInputReplyer.val("").removeAttr("readonly"); */
		$(".modal").modal("show");
	});
	
	$(document).ajaxSend(function(e, xhr, options){
		xhr.setRequestHeader(csrfHeaderName, csrfTokenValue);
	});
	
	//댓글 등록
	modalRegisterBtn.on("click",function(e){
		var reply = {
				bno : bnoValue,
				reply : modalInputReply.val(),
				replyer : modalInputReplyer.val()
		};
		
		replyService.add(reply, function(result){
			alert(result);
			modal.find("input").val();
			modal.modal("hide");
			
			showList(pageNum); //댓글 내용 새로 고침
		});
	});
	
	//댓글 조회 클릭 이벤트 처리
	$(".chat").on("click","li",function(e){
		var rno = $(this).data("rno");
		//console.log("rno >> " + rno);
		
		replyService.get(rno, function(reply){
			modalInputReply.val(reply.reply);
			modalInputReplyer.val(reply.replyer).attr("readonly","readonly");
			modalInputReplyDate.val(replyService.displayTime(reply.replyDate)).attr("readonly","readonly");
			
			modal.data("rno", reply.rno);
			
			modal.find("button[id != 'modalCloseBtn']").hide();
			modalModBtn.show();
			modalRemoveBtn.show();
			
			$(".modal").modal("show");
		});
	});
	
	//댓글 수정
	modalModBtn.on("click",function(e){

		var originalReplyer = modalInputReplyer.val();
		
		var reply = {
				rno: modal.data("rno"),
				reply: modalInputReply.val(),
				replyer: originalReplyer
		}
		
		if(!replyer) {
			alert("로그인후 수정 가능합니다.");
			modal.modal("hide");
			return;
		}
		
		if(replyer != originalReplyer) {
			alert("자신이 작성한 댓글만 수정 가능합니다.");
			modal.modal("hide");
			return;
		}
		
		replyService.update(reply, function(result){
			alert(result);
			modal.modal("hide");
			console.log("reply mod pageNum >> " + pageNum)
			showList(pageNum);
		});
	});
	
	//댓글 삭제
	modalRemoveBtn.on("click",function(e){
		var rno = modal.data("rno");
		
		if(!replyer) {
			alert("로그인후 삭제 가능합니다.");
			modal.modal("hide");
			return;
		}
		
		var originalReplyer = modalInputReplyer.val();
		if(replyer != originalReplyer) {
			alert("자신이 작성한 댓글만 삭제 가능합니다.");
			modal.modal("hide");
			return;
		}
		
		replyService.remove(rno, originalReplyer, function(result) {
			alert(result);
			modal.modal("hide");
			showList(pageNum);
		});
	});
	
	var pageNum = 1;
	var replyPageFooter = $(".panel-footer");
	
	function showReplyPage(replyCnt){
		
		var endNum = Math.ceil(pageNum / 10.0) * 10;
		var startNum = endNum - 9;
		
		var prev = startNum != 1;
		var next = false;
		
		if(endNum * 10 >= replyCnt) {
			endNum = Math.ceil(replyCnt/10.0);
		}
		if(endNum * 10 < replyCnt) {
			next = true;
		}
		var str = "<ul class='pagination pull-right'>";
		if(prev) {
			str += "<li class='page-item'><a class='page-link' href='"+(startNum - 1)+"'>Previous</a></li>";
		}
		
		for(var i= startNum; i <= endNum; i++) {
			var active = pageNum == i ? "active" : "" ;
			
			/* str += "<li class='page-item "+active+"'><a class='page-link' href='"+i+"'>"+i+"</a></li>"; */
			str += "<li class='page-item "+active+"'><a class='page-link' href='"+i+"'>"+i+"</a></li>";
		}
		
		if(next){
			str += "<li class='page-item'><a class='page-link' href='"+(endNum + 1)+"'>Next</a></li>";
			
		}
		
		str += "</ul>";
		console.log("str >>> " + str);
		
		replyPageFooter.html(str);
		
	}

	//댓글 페이지 이벤트 처리
	replyPageFooter.on("click", "li a", function(e){
		e.preventDefault();
		
		var targetPageNum = $(this).attr("href");
		console.log("targetPageNum >>> " + targetPageNum);
		
		pageNum = targetPageNum;
		showList(pageNum);
	});
	
	
</script>

<script type="text/javascript">
	$(document).ready(function(){
		var operForm = $("#operForm");
		
		$("button[data-oper = 'modify']").on("click", function(e){
			operForm.attr("action","/board/modify").submit();
		});

		$("button[data-oper = 'list']").on("click", function(e){
			operForm.find("#bno").remove();
			operForm.attr("action","/board/list").submit();
		});
	});

</script>    
    
<%@ include file = "../includes/footer.jsp"%>
</body>
</html>