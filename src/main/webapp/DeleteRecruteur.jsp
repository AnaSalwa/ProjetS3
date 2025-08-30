<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Supprimer un recruteur</title>
</head>
<body>
    <h1>Supprimer un recruteur :</h1>

    <!-- Formulaire de saisie du nom de l'utilisateur à supprimer -->
  
	<form action="servletRecruteur?action=delete" method="post">
	    <input type="hidden" name="action" value="delete">
	    <label for="nom">Nom du recruteur à supprimer :</label>
	    <input type="text" id="nom" name="nom" required>
	    <input type="submit" value="Supprimer l'utilisateur">
	</form>
	    

    <a href="Acceuil.jsp">Retour à l'accueil</a>
</body>
</html>
