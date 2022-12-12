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
    private static final String SELECT_ETUDIANT_BY_MATRICULE = "select matricule, nom, prenom,sexe,date_naissance,prenom_pere,nom_mere,prenom_mere,annee_derniere_inscription,niveau_id from etudiants where matricule = ?";
    private static final String UPDATE_ETUDIANTS_SQL = "update etudiants set nom = ?,prenom = ?, sexe = ?, date_naissance = ?,prenom_pere = ?, nom_mere = ? , prenom_mere = ? , annee_derniere_inscription= ?  where matricule = ?;";
    private static final String INSERT_ETUDIANTS_SQL = "INSERT INTO etudiants" + "  (matricule, nom, prenom,sexe,date_naissance,prenom_pere,nom_mere,prenom_mere,annee_derniere_inscription,niveau_id) VALUES "
            + " (?, ?, ?,?,?,?,?,?,?,?);";
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
    public void insertUser(Etudiant etudiant) throws SQLException {
        System.out.println(INSERT_ETUDIANTS_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ETUDIANTS_SQL)) {
            preparedStatement.setInt(1, etudiant.getMatricule());
            preparedStatement.setString(2, etudiant.getNom());
            preparedStatement.setString(3, etudiant.getPrenom());
            preparedStatement.setString(4, etudiant.getSexe());
            preparedStatement.setString(5, etudiant.getDateNaissance());
            preparedStatement.setString(6,etudiant.getPrenomPere());
            preparedStatement.setString(7,etudiant.getNomMere());
            preparedStatement.setString(8,etudiant.getPrenomMere());
            preparedStatement.setInt(9,etudiant.getAnneeDerniereInscription());
            preparedStatement.setInt(10,1);


            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
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
                String date_naissance = rs.getString("date_naissance");
                String prenom_pere = rs.getString("prenom_pere");
                String nom_mere = rs.getString("nom_mere");
                String prenom_mere = rs.getString("prenom_mere");
                int annee_derniere_inscription = rs.getInt("annee_derniere_inscription");


                etudiants.add(new Etudiant(matricule, nom , prenom , sexe, date_naissance, prenom_pere, nom_mere, prenom_mere,  annee_derniere_inscription,1));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return etudiants;
    }

    public Etudiant selectEtudiant(int matricule) {
        Etudiant etudiant = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ETUDIANT_BY_MATRICULE);) {
            preparedStatement.setInt(1, matricule);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {

                String nom = rs.getString("nom");
                String prenom = rs.getString("prenom");
                String sexe = rs.getString("sexe");
                String date_naissance = rs.getString("date_naissance");
                String prenom_pere = rs.getString("prenom_pere");
                String nom_mere = rs.getString("nom_mere");
                String prenom_mere = rs.getString("prenom_mere");
                int annee_derniere_inscription = rs.getInt("annee_derniere_inscription");
                int niveau_id = rs.getInt("niveau_id");


                etudiant = new Etudiant(matricule, nom , prenom , sexe, date_naissance, prenom_pere, nom_mere, prenom_mere,  annee_derniere_inscription,niveau_id);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return etudiant;
    }
    public boolean updateEtudiant(Etudiant etudiant) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_ETUDIANTS_SQL);) {

            statement.setString(1, etudiant.getNom());
            statement.setString(2, etudiant.getPrenom());
            statement.setString(3, etudiant.getSexe());
            statement.setString(4, etudiant.getDateNaissance());
            statement.setString(5, etudiant.getPrenomPere());
            statement.setString(6, etudiant.getNomMere());
            statement.setString(7, etudiant.getPrenomMere());
            statement.setInt(8, etudiant.getAnneeDerniereInscription());
            statement.setInt(9,etudiant.getMatricule());


            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
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
