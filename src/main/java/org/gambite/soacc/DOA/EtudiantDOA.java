package org.gambite.soacc.DOA;
import org.gambite.soacc.Model.Etudiant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EtudiantDOA {

    private String jdbcURL = "jdbc:postgresql://localhost:5432/soacc_university";
    private String jdbcUsername = "postgres";
    private String jdbcPassword = "";
    private  final String SELECT_ALL_ETUDIANTS = "SELECT * FROM etudiants";
    private static final String INSERT_ETUDIANTS_SQL = "INSERT INTO etudiants" + "  (matricule, nom, prenom,sexe,) VALUES "
            + " (?, ?, ?);";
    public EtudiantDOA(){}
    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }
    public  List<Etudiant> selectAllEtudiant(){
        List<Etudiant> etudiants = new ArrayList<>();
        try (Connection connection = getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ETUDIANTS);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int matricule = rs.getInt("matricule");
                String nom = rs.getString("nom");
                String prenom = rs.getString("prenom");
                String sexe = rs.getString("sexe");
                Date date_naissance = rs.getDate("date_naissance");
                String prenom_pere = rs.getString("prenom_pere");
                String nom_mere = rs.getString("nom_mere");
                String prenom_mere = rs.getString("prenom_mere");
                int annee_derniere_inscription = rs.getInt("annee_derniere_inscription");


                etudiants.add(new Etudiant(matricule, nom , prenom , sexe, date_naissance, prenom_pere, nom_mere, prenom_mere,  annee_derniere_inscription));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return etudiants;
    }
    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

}
