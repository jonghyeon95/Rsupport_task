<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>

<%@include file="../layout/header.jsp"%>


<div class="container">
	<form>
		<div class="form-group">
			<label for="id">ID</label> <input type="text" value ="${principal.username}" class="form-control" placeholder="Enter username" id="id" readonly>
		</div>

		<div class="form-group">
			<label for="password">Password</label> <input type="password" class="form-control" placeholder="Enter password" id="password">
		</div>

		<div class="form-group">
			<label for="name">Name</label> <input type="text" value="${principal.member.name}" class="form-control" placeholder="Enter name" id="name">
		</div>

		<div class="form-group">
			<label for="email">Email</label> <input type="email" value="${principal.member.email}" class="form-control" placeholder="Enter email" id="email">
		</div>
	</form>
	<button id="btn-update" class="btn btn-primary">회원수정</button>

</div>

<br></br>


<script src="/js/member.js"></script>
<%@include file="../layout/footer.jsp"%>

