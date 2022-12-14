<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<div class="container m-5">
	<form action="/action_page.php">
		<div class="form-group">
			<label for="username">Username : </label> <input type="text" class="form-control" placeholder="Enter username" id="username">
		</div>
		<div class="form-group">
			<label for="pwd">Password:</label> <input type="password" class="form-control" placeholder="Enter password" id="password">
		</div>
		<button type="button" id="btn--login" class="btn btn-primary">signin</button>
	</form>
</div>
<%@ include file="../layout/footer.jsp"%>