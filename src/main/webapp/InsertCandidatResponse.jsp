<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Résultat de l'insertion d'utilisateur</title>
</head>
<body>
    <h1>Résultat de l'insertion d'utilisateur :</h1>
    <c:if test="${not empty message}">
        <p>${message}</p> <!-- Affiche un message de succès -->
    </c:if>
    <c:if test="${not empty error}">
        <p>${error}</p> <!-- Affiche un message d'erreur -->
    </c:if>
  
  
    <a href="Acceuil.jsp">Retour à l'accueil</a>
  
</body>
</html>
