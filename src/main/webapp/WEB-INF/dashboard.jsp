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
<title>Your Books</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
	<div class="container">
		<div class="head1">
			<h1>Welcome, <c:out value="${user.getName()}"></c:out></h1>
			<div class='logout'>
				<a href='/logout' class="btn btn-danger">logout</a>	
			</div>
		</div>
		
		<div class="subhead">
			<p>Books from everyone's shelves:</p>
			<div class='add'>
				<a href='/books/new'>+ Add a book to my shelf!</a>			
			</div>
		</div>
		
		<div class="content">
			<table class="table">
				<thead>
					<tr>
						<th>Id</th>
						<th>Title</th>
						<th>Author</th>
						<th>Posted By</th>
					</tr>
				</thead>
				
				<tbody>
					<c:forEach var="b" items="${book}">
						<tr>
							<td><c:out value="${b.id}"></c:out></td>
							<td><a href='/book/${b.id}'><c:out value="${b.title}"></c:out></a></td>
							<td><c:out value="${b.author}"></c:out></td>
							<td><c:out value="${b.user.name}"></c:out></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		
		</div>
	</div>
</body>
</html>