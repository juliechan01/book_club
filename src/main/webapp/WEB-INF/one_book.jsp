<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix= "form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit <c:out value="${book.title}"></c:out></title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
	<div class="container">
		<div class="head1">
			<h1><c:out value="${book.title}"></c:out></h1>
			<a href='/dashboard'>back to the shelves</a>
		</div>
		
		<div class="content1">
			<h3><c:out value="${book.user.name}"></c:out> read <c:out value="${book.title}"></c:out>.</h3>
			<p>Here are <c:out value="${book.user.name}"></c:out>'s thoughts:</p>
			<p><c:out value='${book.thoughts}'></c:out></p>
			<div class ='actions'>
				<a href='/book/${book.id}/edit' class="btn btn-outline-primary">Edit</a>
				<form action="/book/${book.id}" method='POST'>
					<input type='hidden' name='_method' value='delete'>
					<button type='submit' value="Delete" class="btn btn-danger">Delete</button>
				</form>			
			</div>
		</div>
	</div>
</body>
</html>