<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<br/>
<div class="container">
	<div class="form-group">
		<form action="">
			<label for="title">title</label> <input type="text" name="title"
				id="title" class="form-control">
		</form>
	</div>
	<div class="form-group">
		<form action="">
			<label for="content">contetnt</label>
			<textarea rows="5" name="content" id="content"
				class="form-control content"> 
			</textarea>
		</form>
		<button type="button" class="btn btn-primary" id="btn--save"
			style="margin-top: 20px">글 쓰기 완료</button>
	</div>
	<script>
		$('.content').summernote(
				{
					placeholder : '내용을 입력해주세요.',
					tabsize : 2,
					height : 400,
					toolbar : [ [ 'style', [ 'style' ] ],
							[ 'color', [ 'color' ] ],
							[ 'para', [ 'ul', 'ol', 'paragraph' ] ],
							[ 'table', [ 'table' ] ],
							[ 'insert', [ 'link', 'picture', 'video' ] ],
							[ 'view', [ 'fullscreen', 'codeview', 'help' ] ] ]
				});
	</script>
	<script type="text/javascript" src="../js/board.js"></script>
</div>
<%@ include file="../layout/footer.jsp"%>