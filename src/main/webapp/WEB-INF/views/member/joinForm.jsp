<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>

<%@include file="../layout/header.jsp"%>


<div class="container">
	<form>
		<div class="form-group">
			<label for="id">ID</label> 
			<input type="text" class="form-control" placeholder="Enter ID" id="id">
		</div>

		<div class="form-group">
			<label for="password">Password</label> 
			<input type="password" class="form-control" placeholder="Enter password" id="password">
		</div>

		<div class="form-group">
			<label for="name">name</label> 
			<input type="text" class="form-control" placeholder="Enter name" id="name">
		</div>

		<div class="form-group">
			<label for="email">Email</label> 
			<input type="email" class="form-control" placeholder="Enter email" id="email">
		</div>
	</form>
	<button id="btn-save" class="btn btn-primary">회원가입</button>

</div>

<br></br>


<script src="/js/member.js"></script>
<%@include file="../layout/footer.jsp"%>

