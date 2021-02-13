<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>

<%@include file="../layout/header.jsp"%>


<div class="container">
	<form>
		<button class="btn btn-secondary" onClick="history.back(); return false ;">���ư���</button>
		<c:if test="${notice.member.id eq principal.username}">
			<a href="/notice/${notice.num}/updateForm" class="btn btn-warning">����</a>
			<button id="btn-delete" class="btn btn-danger">����</button>
		</c:if>
		<br /> <br />
		<div class="inform">
			�ۼ��� : <span><i>${notice.member.name} </i></span> 
			�ۼ��� : <span><fmt:formatDate value="${notice.createDate}" pattern="yyyy.MM.dd"/></span>
			���������� : <span><fmt:formatDate value="${notice.updateDate}" pattern="yyyy.MM.dd"/></span>
		</div>
		<br />
		<div>
			<label for="username">Title</label>
			<h3>${notice.title}</h3>
		</div>


		<div>
			<label for="content">Content:</label>
			<div>${notice.content}</div>
		</div>

	</form>

</div>

<br></br>

<script src="/js/notice.js"></script>
<link rel="stylesheet" type="text/css" href="../css/detailForm.css">
<%@include file="../layout/footer.jsp"%>

