<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="${pageContext.request.contextPath }/views/style.css">
<title>Gallery</title>
</head>
<body>
<div><jsp:include page="nav.jsp"/></div>
<div>
	<h1>Gallery</h1>
</div>

<div>

<c:forEach var="image" items="${images}">
        <img src="images/${image.getPath()}/${image.getNom()}" alt="${image.getNom()}" width="150" height="150"/>
</c:forEach>
</div>

</body>
</html>