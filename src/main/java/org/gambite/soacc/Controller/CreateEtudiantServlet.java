package org.gambite.soacc.Controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.gambite.soacc.DOA.EtudiantDOA;
import org.gambite.soacc.Model.Etudiant;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

@WebServlet(name = "CreateEtudiantServlet", value = "/CreateEtudiantServlet")
public class CreateEtudiantServlet extends HttpServlet {
    private EtudiantDOA etudiantDOA;
    @Override
    public void init() throws ServletException {
        super.init();
        etudiantDOA = new EtudiantDOA();

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     showNewForm(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            insertEtudiant(request,response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("etudiant-form.jsp");
        dispatcher.forward(request, response);
    }
    private void insertEtudiant(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int matricule = Integer.parseInt(request.getParameter("matricule"));
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String sexe = request.getParameter("sexe");
        String date_naissance = request.getParameter("date_naissance");
        String prenom_pere = request.getParameter("prenom_pere");
        String nom_mere = request.getParameter("nom_mere");
        String prenom_mere = request.getParameter("prenom_mere");
        int annee_derniere_inscription = Integer.parseInt(request.getParameter("annee_derniere_inscription"));
        Etudiant newEtudiant = new Etudiant(matricule,nom,prenom,sexe,date_naissance,prenom_pere,nom_mere,prenom_mere,annee_derniere_inscription,1);
        etudiantDOA.insertUser(newEtudiant);
        response.sendRedirect("/");
    }
}
