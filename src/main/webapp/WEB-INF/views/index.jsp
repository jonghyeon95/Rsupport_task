<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>

<%@include file="layout/header.jsp"%>

<div class="container">
	<div>
		<h2>공지사항</h2>
		<c:choose>
			<c:when test="${!empty principal}">
				<button class="btn btn-primary" onClick="location.href='/notice/saveForm'">글쓰기</button>
			</c:when>
		</c:choose>

	</div>

	<table class="table table-hover">
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
			</tr>
		</thead>

		<tbody>
			<c:forEach var="notice" items="${notices.content}">
				<tr onClick="location.href='/notice/${notice.notice_num}'">
					<td>${notice.notice_num}</td>
					<td>${notice.notice_title}</td>
					<td>${notice.member.member_name}</td>
					<td>${notice.notice_createDate}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<ul class="pagination justify-content-center">
		<c:choose>
			<c:when test="${notices.first}">
				<li class="page-item disabled"><a class="page-link" href="?page=${notices.number-1}">Previous</a></li>
			</c:when>
			<c:otherwise>
				<li class="page-item"><a class="page-link" href="?page=${notices.number-1}">Previous</a></li>
			</c:otherwise>
		</c:choose>

		<c:choose>
			<c:when test="${notices.last}">
				<li class="page-item disabled"><a class="page-link" href="?page=${notices.number+1}">Next</a></li>
			</c:when>
			<c:otherwise>
				<li class="page-item"><a class="page-link" href="?page=${notices.number+1}">Next</a></li>
			</c:otherwise>
		</c:choose>
	</ul>

</div>
<br></br>

<link rel="stylesheet" type="text/css" href="css/index.css">
<%@include file="layout/footer.jsp"%>

