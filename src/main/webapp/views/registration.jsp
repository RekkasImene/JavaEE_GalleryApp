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
			<input type="text" size="20" id="login" name="login" value='<c:out value="${requestProcessor.getLogin()}"/>'>
		</div>
		<br>
		<div>
			<label for="email">Adresse email :</label>
			<input type="email" size="20" id="email" name="email" value='<c:out value="${requestProcessor.getEmail()}"/>'>
		</div>
		<br>
		<div>
			<label for="password">Mot de passe :</label>
			<input type="password" size="20" id="password" name="password" value='<c:out value="${requestProcessor.getPassword()}"/>'>
		</div>
		<br>
		<div>
			<label for="confPass">Confirmation du mot de pass :</label>
			<input type="password" size="20" id="confPass" name="confPass" value='<c:out value="${requestProcessor.getConfPass()}"/>'>
		</div>
		<br>
		<div>
		<label for="cat">Choix de categorie :</label>
			   <select id="cat" name="cat">
			   
				    <option value="">--Choisissez une catégorie d'images--</option>
				    <c:forEach var="category" items="${listCategory}" >
				    
				    	<c:choose>
						    <c:when test="${category == requestProcessor.getCat()}">
						       <option value="${category}" selected>${category}</option>
						    </c:when>    
						    <c:otherwise>
						        <option value="${category}">${category}</option>
						    </c:otherwise>
						</c:choose>	
				    
					  
					</c:forEach>
				</select>
		</div>
		<br>
		<div class="button">
        	<button type="submit">Inscription</button>
   		 </div>
   		 <br>
	</form>

<c:choose>
    <c:when test="${message=='Succes'}">
        <div id="succes">
     		<c:out value="${message}" escapeXml="false"/>
 		</div>
    </c:when>    
    <c:otherwise>
        <div id="error">
		     <c:out value="${message}" escapeXml="false"/>
		 </div>
    </c:otherwise>
</c:choose>	

</body>
</html>