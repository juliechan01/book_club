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
<title>Editing <c:out value="${book.title}"></c:out></title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
	<div class="container">
		<div class="head1">
			<h1>Editing <c:out value="${book.title}"></c:out></h1>
			<a href='/dashboard'>back to the shelves</a>
		</div>
		
		<div class="content1">
			<form:form action='/book/${book.id}/update' method='PUT' modelAttribute='book'>
				<form:label path='title'>Title</form:label>
				<form:errors path='title'></form:errors>
				<form:input path='title' type='text' class='form-control' placeholder='${book.title}'></form:input>
				
				<form:label path='author'>Author</form:label>
				<form:errors path='author'></form:errors>
				<form:input path='author' type='text' class='form-control' placeholder='${book.author}'></form:input>
				
				<form:label path='thoughts'>My Thoughts</form:label>
				<form:errors path='thoughts'></form:errors>
				<form:textarea path='thoughts' class='form-control' placeholder='${book.thoughts}'></form:textarea>
				
				<button type='submit' class='btn btn-success'>Submit changes</button>
			</form:form>
		</div>
	</div>
</body>
</html>