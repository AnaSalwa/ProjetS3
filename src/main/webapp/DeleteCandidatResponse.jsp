<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Confirmation de suppression</title>
</head>
<body>
    <h1>Suppression d'utilisateur :</h1>
    
    <%-- Affichez un message de succès ou d'erreur ici --%>
    <c:if test="${not empty message}">
        <p class="success">${message}</p>
    </c:if>
    <c:if test="${not empty error}">
        <p class="error">${error}</p>
    </c:if>

    <a href="Acceuil.jsp">Retour à l'accueil</a>
</body>
</html>