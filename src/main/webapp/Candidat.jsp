<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Tests JDBC</title>
        <link type="text/css" rel="stylesheet" href="<c:url value="/inc/form.css"/>" />
    </head>
    <body>
        <h1>Tests JDBC</h1>
           <c:forEach items="${personnes}" var="personne">
            <li>Nom : ${personne.nom}</li>
            <li>Prénom : ${personne.prenom}</li>
             --------------------------------------
        </c:forEach>
    </body>
</html>