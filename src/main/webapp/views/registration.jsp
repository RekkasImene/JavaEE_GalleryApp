<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath }/style.css">
<meta charset="ISO-8859-1">
<title>Subscription</title>
</head>
<body>
<div><jsp:include page="nav.jsp"/></div>
<h1>Inscription</h1>
<form accept-charset="utf-8" method="post" action="${pageContext.request.contextPath }/gallery">
		<br>
		<div>
			<label for="login">Login :</label>
			<input type="text" size="20" id="login" name="login" value='<c:out value="${requestProcessor.login}"/>'>
		</div>
		<br>
		<div>
			<label for="email">Adresse email :</label>
			<input type="email" size="20" id="email" name="email" value='<c:out value="${requestProcessor.email}"/>'>
		</div>
		<br>
		<div>
			<label for="password">Mot de passe :</label>
			<input type="password" size="20" id="password" name="password" value='<c:out value="${requestProcessor.password}"/>'>
		</div>
		<br>
		<div>
			<label for="confPass">Confirmation du mot de pass :</label>
			<input type="password" size="20" id="confPass" name="confPass" value='<c:out value="${requestProcessor.confPass}"/>'>
		</div>
		<br>
		<div>
		<label for="cat">Choix de categorie :</label>
			   <select id="cat" name="cat" value='<c:out value="${requestProcessor.favoriteCategory}"/>'>
				    <option value="">--Choisissez une catégorie d'images--</option>
				    <option value="dog">Dog</option>
				    <option value="cat">Cat</option>
				    <option value="hamster">Hamster</option>
				    <option value="parrot">Parrot</option>
				    <option value="spider">Spider</option>
				    <option value="goldfish">Goldfish</option>
				</select>
		</div>
		<br>
		<div class="button">
        	<button type="submit">Inscription</button>
   		 </div>
   		 <br>
	</form>
	
<div id="error">
     <c:out value="${message}" escapeXml="false"/>
 </div>
</body>
</html>