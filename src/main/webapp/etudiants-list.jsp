<%@ page contentType="text/html; UTF-8" pageEncoding="UTF-8" import="java.lang.String" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="org.gambite.soacc.Model.Etudiant" %>
<html>


<head>
    <title>Etudiant Management Application</title>

</head>
<body>

<header>

</header>
<br>
<h1><a href="CreateEtudiantServlet">Create</a></h1>

<div class="row">
    <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

    <div class="container">
        <h3 class="text-center">List of Etudiants</h3>
        <hr>

        <br>
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>Matricule</th>
                <th>nom</th>
                <th>prenom</th>
                <th>sexe</th>
                <th>date_naissance</th>

                <th>prenom_pere</th>
                <th>nom_mere</th>
                <th>prenom_mere</th>
                <th>annee_derniere_inscription</th>
                <th>${listEtudiant[0].nom}</th>

                <% ArrayList<Etudiant> list = (ArrayList<Etudiant>) request.getAttribute("listEtudiant");

                    for (Etudiant l:list){%>
                <tr>
                <td id="matricule" value = `<%l.getMatricule();%>`> <%=l.getMatricule()%> </td>
                <td> <%=l.getNom()%> </td>
                <td> <%=l.getPrenom()%> </td>
                <td> <%=l.getSexe()%> </td>
                <td> <%=l.getDateNaissance()%> </td>
                <td> <%=l.getPrenomPere()%> </td>
                <td><a href="UpdateEtudiantServlet?matricule=<%= l.getMatricule()%>">Edit</a></td>





                </tr>
            <%}%>
            </thead>
            <tbody>




            </tbody>

        </table>
    </div>
</div>
</body>
</html>
