<%@ page import="org.gambite.soacc.Model.Etudiant" %><%--
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
<% Etudiant etd = (Etudiant) request.getAttribute("etudiant"); %>

<form method="post" action="UpdateEtudiantServlet">
  <label>Matricule</label>
  <input name="matricule" type="number" id="matricule" value="<%=etd.getMatricule()%>">
  <label>Nom</label>
  <input name="nom" type="text" id="nom" value="<%=etd.getNom()%>">
  <label>Prenom</label>
  <input name="prenom" type="text" id="prenom" value="<%=etd.getPrenom()%>">
  <label>Sexe</label>
  <input name="sexe" type="text" id="sexe" value="<%=etd.getSexe()%>">
  <LABEL>Date de naissance</LABEL>
  <input name="date_naissance" type="text" id="date_naissance" value="<%=etd.getDateNaissance()%>">

  <label>Prenom Pere </label>
  <input name="prenom_pere" type="text" id="prenom_pere" value="<%=etd.getPrenomPere()%>" >
  <label>Nom Mere</label>
  <input name="nom_mere" type="text" id="nom_mere" value="<%=etd.getNomMere()%>">
  <label>prenom_mere</label>
  <input name="prenom_mere" type="text" id="prenom_mere" value="<%=etd.getPrenomMere()%>">
  <label>annee_derniere_inscription</label>
  <input name="annee_derniere_inscription" type="number" id="annee_derniere_inscription" value="<%=etd.getAnneeDerniereInscription()%>">




  <input type="submit" name="Update" id="Update" value="Update">


</form>

</body>
</html>
