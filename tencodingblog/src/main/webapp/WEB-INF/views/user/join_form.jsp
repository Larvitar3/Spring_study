<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<div class="container m-5">
	<form action="">
		<div class="form-group">
			<label for="username">UserName :</label> <input type="text" class="form-control" placeholder="Enter username" id="username">
		</div>
		<div class="form-group">
			<label for="password">Password:</label> <input type="password" class="form-control" placeholder="Enter password" id="password">
		</div>
		<div class="form-group">
			<label for="email">Email :</label> <input type="email" class="form-control" placeholder="Enter email" id="email">
		</div>
	</form>
		<button type="submit" class="btn btn-primary" id="btn--save">signUp</button>
</div>

<%@ include file="../layout/footer.jsp"%>