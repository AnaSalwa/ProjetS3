<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Rechercher un candidat</title>
</head>
<body>
    <h1>Rechercher un candidat :</h1>

    <!-- Formulaire de saisie du nom de l'utilisateur à supprimer -->
  
	<form action="servletRecruteur?action=find" method="post">
	    <input type="hidden" name="action" value="find">
	    <label for="nom">Nom du candidat à rechercher :</label>
	    <input type="text" id="nom" name="nom" required>
	    <input type="submit" value="Rechercher">
	</form>
    

    <a href="Acceuil.jsp">Retour à l'accueil</a>
</body>
</html>
