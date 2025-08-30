<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <form action="servletCandidature" method="post">
        <input type="hidden" name="id_offre" value="${id_offre}">
        <input type="hidden" name="id_candidat" value="${id_candidat}">
        
        <label for="motivation">Motivation:</label>
        <textarea name="motivation" rows="5" cols="40"></textarea>
        
        <input type="submit" value="Submit">
    </form>
</body>
</html>