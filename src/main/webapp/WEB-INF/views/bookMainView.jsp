<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<link rel="stylesheet" type="text/css" href="/css/reset.css">
<link rel="stylesheet" type="text/css" href="/css/main.css">
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.4.0.min.js"></script>
</head>

<body>
	<%@ include file="includes/header.jsp"%>
	<div id="container">
		<section id="section1">
			<div class="mainSlideWrap">
				<ul class="mainSlide">
					<li><img src="image/slide1.jpg" alt="main slide1"></li>
					<li><img src="image/slide2.jpg" alt="main slide2"></li>
					<li><img src="image/slide3.jpg" alt="main slide3"></li>
					<li><img src="image/slide4.jpg" alt="main slide4"></li>
				</ul>
				<span class="prev">&lt;</span> <span class="next">&gt;</span>
			</div>
		</section>

		<section id="section2">
			<div class="recommendWrap">
				<div class="recommendTitle">
					<ul>
						<li class="bestTitle">인기도서</li>
						<li class="newTitle">신착도서</li>
					</ul>
				</div>
				<ul class="recommend">
					<li class="bestWrap"><c:forEach var="book"
							items="${ bookPList }">
							<div>
								<c:choose>
									<c:when test="${empty book.bookimgurl }">
										<a
											href="BookServlet?command=book_detail_view&isbn=${book.isbn}">
											<img src="image/noimage.gif" alt="#">
										</a>
									</c:when>
									<c:otherwise>
										<a
											href="BookServlet?command=book_detail_view&isbn=${book.isbn}">
											<img src="image/${book.bookimgurl }" alt="#">
										</a>
									</c:otherwise>
								</c:choose>
								<p>${book.title }</p>
							</div>
						</c:forEach></li>
					<li class="newWrap"><c:forEach var="book"
							items="${ bookDList }">
							<div>
								<c:choose>
									<c:when test="${empty book.bookimgurl }">
										<a
											href="BookServlet?command=book_detail_view&isbn=${book.isbn}">
											<img src="image/noimage.gif" alt="#">
										</a>
									</c:when>
									<c:otherwise>
										<a
											href="BookServlet?command=book_detail_view&isbn=${book.isbn}">
											<img src="image/${book.bookimgurl }" alt="#">
										</a>
									</c:otherwise>
								</c:choose>
								<p>${book.title }</p>
							</div>
						</c:forEach></li>
				</ul>
			</div>
		</section>
	</div>

	<script type="text/javascript">
		$(document).ready(function() {
			function prev() {
				$('.mainSlide li:last').prependTo('.mainSlide');
				$('.mainSlide').css('margin-left', -1200);
				$('.mainSlide').stop().animate({
					marginLeft : 0
				}, 1200);
			}

			function next() {
				$('.mainSlide').stop().animate({
					marginLeft : -1200
				}, function() {
					$('.mainSlide li:first').appendTo('.mainSlide');
					$('.mainSlide').css({
						marginLeft : 0
					});
				});
			}

			function slide() {
				$('.mainSlide').stop().animate({
					marginLeft : -1200
				}, function() {
					$('.mainSlide li:first').appendTo('.mainSlide');
					$('.mainSlide').css({
						marginLeft : 0
					});
				});
			}

			setInterval(slide, 5000);

			$('.prev').click(function() {
				prev();
			});

			$('.next').click(function() {
				next();
			});
		});

		/*recommend*/
		$(document).ready(function() {
			// 초기로드시
			$('.bestTitle').addClass('underline');
			$('.bestWrap').show();
			$('.newWrap').hide();

			// 'bestTitle'을 클릭하면 '인기도서' 표시 및 '신착도서' 숨김
			$('.bestTitle').click(function() {
				$('.bestTitle').addClass('underline');
				$('.newTitle').removeClass('underline');
				$('.bestWrap').show(); // 인기도서 보이기
				$('.newWrap').hide(); // 신착도서 숨기기
				$('.newWrap').css('opacity', '0');
			});

			// 'newTitle'을 클릭하면 '신착도서' 표시 및 '인기도서' 숨김
			$('.newTitle').click(function() {
				$('.newTitle').addClass('underline');
				$('.bestTitle').removeClass('underline');
				$('.newWrap').show(); // 신착도서 보이기
				$('.bestWrap').hide(); // 인기도서 숨기기
				$('.newWrap').css('opacity', '1');
			});
		});
	</script>
	
	
	<%@ include file="includes/footer.jsp"%>
</body>

</html>