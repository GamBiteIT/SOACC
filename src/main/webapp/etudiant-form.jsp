<%--
  Created by IntelliJ IDEA.
  User: abderahmanemahdigharzouli
  Date: 11/12/2022
  Time: 11:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form method="post" action="CreateEtudiantServlet">
    <label>Matricule</label>
    <input name="matricule" type="number" id="matricule">
    <label>Nom</label>
    <input name="nom" type="text" id="nom">
    <label>Prenom</label>
    <input name="prenom" type="text" id="prenom">
    <label>Sexe</label>
    <input name="sexe" type="text" id="sexe">
    <label>Date de Naissance</label>
    <input name="date_naissance" type="text" id="date_naissance">
    <label>Prenom Pere</label>
    <input name="prenom_pere" type="text" id="prenom_pere">
    <label>Nom Mere</label>
    <input name="nom_mere" type="text" id="nom_mere">
    <label>prenom_mere</label>
    <input name="prenom_mere" type="text" id="prenom_mere">
    <label>annee_derniere_inscription</label>
    <input name="annee_derniere_inscription" type="number" id="annee_derniere_inscription">
    <input type="submit" name="Create" id="Create">

</form>

</body>
</html>
