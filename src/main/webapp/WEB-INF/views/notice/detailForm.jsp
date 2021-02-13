<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>

<%@include file="../layout/header.jsp"%>


<div class="container">
	<form>
		<button class="btn btn-secondary" onClick="history.back(); return false ;">돌아가기</button>
		<c:if test="${notice.member.member_id eq principal.username}">
			<a href="/notice/${notice.notice_num}/updateForm" class="btn btn-warning">수정</a>
			<button id="btn-delete" class="btn btn-danger">삭제</button>
		</c:if>
		<br /> <br />
		<div>
			글번호 : <span id="id"><i>${notice.notice_num} </i></span> 작성자 : <span><i>${notice.member.member_name} </i></span>
		</div>
		<br />
		<div>
			<label for="username">Title</label>
			<h3>${notice.notice_title}</h3>
		</div>


		<div>
			<label for="content">Content:</label>
			<div>${notice.notice_content}</div>
		</div>

	</form>

</div>

<br></br>

<script src="/js/notice.js"></script>
<%@include file="../layout/footer.jsp"%>

