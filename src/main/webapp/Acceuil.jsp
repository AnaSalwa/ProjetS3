<!DOCTYPE html>
<html>
<head>
    <title>Gestion des utilisateurs</title>
    
</head>
<body>
    <div class="container">
        <h1>Gestion des candidats et des recruteurs:</h1>
        
			        
		<table>
			  <tr>
			    <th>Candidats</th>
			    <th>Recruteurs</th>
			  </tr>
			  <tr>
			    <td><li><a href="servletCandidat?action=all">Afficher tous les candidats</a></li></td>
			    <td><li><a href="servletRecruteur?action=all">Afficher tous les recruteurs</a></li></td>
			  </tr>
			  <tr>
			    <td> <li><a href="DeleteCandidat.jsp">Supprimer un candidat</a></li></td>
			    <td>  <li><a href="DeleteRecruteur.jsp">Supprimer un recruteur</a></li></td>
			  </tr>
			  <tr>
			    <td><li><a href="InsertCandidat.jsp">Ajouter un candidat</a></li></td>
			    <td> <li><a href="InsertRecruteur.jsp">Ajouter un recruteur</a></li></td>
			  </tr>
			  <tr>
			    <td><li><a href="FindCandidat.jsp">Rechercher un candidat</a></li></td>
			    <td><li><a href="FindRecruteur.jsp">Rechercher un recruteur</li></td>
			  </tr>
		</table>
       
    </div>
</body>
</html>
