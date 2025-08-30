<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Ajouter un utilisateur</title>
</head>
<body>
    <h1>Ajouter un utilisateur :</h1>

    <!-- Formulaire de saisie des informations de l'utilisateur à ajouter -->
    <form action="servletRecruteur?action=insert" method="post">
        <input type="hidden" name="action" value="insert">
        <label for="nom">Nom :</label>
        <input type="text" id="nom" name="nom" required><br>
        <label for="prenom">Prénom :</label>
        <input type="text" id="prenom" name="prenom" required><br>
        <label for="email">Email :</label>
        <input type="email" id="email" name="email" required><br>
         <label for="password">Mot de passe :</label>
        <input type="password" id="password" name="password" required><br>
        <label for="entreprise">Entreprise :</label>
        <input type="text" id="entreprise" name="entreprise" required><br>
        <input type="submit" value="Ajouter l'utilisateur">
        
    </form>

    <a href="Acceuil.jsp">Retour à l'accueil</a>
</body>
</html>
