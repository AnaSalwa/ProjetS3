<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Résultats de la recherche</title>
</head>
<body>
    <h1>Résultats de la recherche :</h1>

    <c:if test="${not empty personnes}">
        <ul>
            <c:forEach items="${personnes}" var="personne">
                <li>Nom : ${personne.nom}</li>
                <li>Prénom : ${personne.prenom}</li>
                <li> Entreprise : ${personne.entreprise}</li>
            </c:forEach>
        </ul>
    </c:if>

    <c:if test="${empty personnes}">
        <p>Aucun résultat trouvé pour le nom saisi.</p>
    </c:if>

    <a href="Acceuil.jsp">Retour à l'accueil</a>
</body>
</html>
