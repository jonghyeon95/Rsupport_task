<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>

<%@include file="../layout/header.jsp"%>


<div class="container">
	<form>
		<div class="form-group">
			<label for="title">Title</label> 
			<input value="${notice.title}" type="text" class="form-control" placeholder="Enter title" id="title">
		</div>

		<div class="form-group">
			<label for="content">Content:</label>
			<textarea class="form-control summernote" rows="5" id="content">${notice.content}</textarea>
		</div>
		
		<input type="hidden" id="id" value="${notice.num}">
	</form>
	<button id="btn-update" class="btn btn-primary">수정 완료</button>
</div>

<br></br>

<script>
      $('.summernote').summernote({
        tabsize: 2,
        height: 300
      });
</script>
<script src="/js/notice.js"></script>
<%@include file="../layout/footer.jsp"%>

