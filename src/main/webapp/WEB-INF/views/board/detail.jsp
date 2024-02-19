<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" ></script>
<title>모델2</title>
</head>
<body>
	
<c:set var="menu" value="게시판" />
<%@ include file="../common/navbar.jsp" %> 
	<div class="container">
		<div class="row mb-3">
			<div class="col-12">
				<h1>게시글 상세정보</h1>
				
				<table class="table">
					<colgroup>
						<col width="15%">					
						<col width="35%">					
						<col width="15%">					
						<col width="35%">					
					</colgroup>
					<tbody>
						<tr>
							<th>번호</th>
							<td>${board.no}</td>
							<th>작성자</th>
							<td>${board.user.name }</td>
						</tr>
						<tr>
							<th>제목</th>
							<td>${board.title }</td>
							<th>조회수</th>
							<td>${board.readCount }</td>
						</tr>
						<tr>
							<th>등록일</th>
							<td><fmt:formatDate value="${board.createdDate }"/></td>
							<th>수정일</th>
							<td><fmt:formatDate value="${board.updatedDate }"/></td>
						</tr>
						<tr>
							<th>내용</th>
							<th colspan="3">${board.content }</th>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>