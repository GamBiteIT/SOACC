package org.gambite.soacc.Controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.gambite.soacc.DOA.EtudiantDOA;
import org.gambite.soacc.Model.Etudiant;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "UpdateEtudiantServlet", value = "/UpdateEtudiantServlet")
public class UpdateEtudiantServlet extends HttpServlet {
    private int  mat;
    private EtudiantDOA etudiantDOA;
    @Override
    public void init() throws ServletException {
        super.init();
        etudiantDOA = new EtudiantDOA();

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        try {
            showEditForm(request,response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            updateEtudiant(request,response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int matricule = Integer.parseInt(request.getParameter("matricule"));
        mat = matricule;
        Etudiant existingEtudiant = etudiantDOA.selectEtudiant(matricule);
        RequestDispatcher dispatcher = request.getRequestDispatcher("etudiant-edit.jsp");
        request.setAttribute("etudiant", existingEtudiant);
        dispatcher.forward(request, response);
    }
    private void updateEtudiant(HttpServletRequest request,HttpServletResponse response)
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
        Etudiant etudiantupdated = new Etudiant(matricule,nom,prenom,sexe,date_naissance,prenom_pere,nom_mere,prenom_mere,annee_derniere_inscription,1);


        etudiantDOA.updateEtudiant(etudiantupdated);
        response.sendRedirect("Etudiants");
    }


}
