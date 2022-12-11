package org.gambite.soacc.Controller;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;



import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.gambite.soacc.DOA.EtudiantDOA;
import org.gambite.soacc.Model.Etudiant;

import java.io.IOException;

@WebServlet(name = "EtudiantServlet", value = "/EtudiantServlet")
public class EtudiantServlet extends HttpServlet {
    private static final long serialVersionUID = 102831973239L;

   private EtudiantDOA etudiantDOA;
    @Override
    public void init() throws ServletException {
        super.init();
        etudiantDOA = new EtudiantDOA();

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        try {
            switch (action) {

                default:
                    listEtudiants(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    private void listEtudiants(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Etudiant> listEtudiant;

        listEtudiant = etudiantDOA.selectAllEtudiant();
        request.setAttribute("listEtudiant", listEtudiant);
        RequestDispatcher dispatcher = request.getRequestDispatcher("etudiants-list.jsp");
        dispatcher.forward(request, response);
    }
}
