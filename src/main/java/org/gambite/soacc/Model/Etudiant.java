package org.gambite.soacc.Model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Etudiant {
    protected int matricule;
    protected String nom;
    protected String prenom;
    protected String sexe;
    protected Date date_naissance;
    protected String prenom_pere;
    protected String nom_mere ;
    protected String prenom_mere;
    protected  int annee_derniere_inscription;
    protected int niveau_id = 1;
    public Etudiant(){}
    public Etudiant(int matricule, String nom , String prenom , String sexe, Date date_naissance, String prenom_pere,String nom_mere, String prenom_mere, int annee_derniere_inscription){
        super();
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.date_naissance = date_naissance;
        this.prenom_pere = prenom_pere;
        this.nom_mere = nom_mere;
        this.prenom_mere = prenom_mere;
        this.annee_derniere_inscription = annee_derniere_inscription;
        this.niveau_id = 1;

    }

    public int getMatricule() {
        return matricule;
    }

    public void setMatricule(int matricule) {
        this.matricule = matricule;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getPrenomPere() {
        return prenom_pere;
    }

    public void setPrenomPere(String prenom_pere) {
        this.prenom_pere = prenom_pere;
    }

    public String getNomMere() {
        return nom_mere;
    }

    public void setNomMere(String nom_mere) {
        this.nom_mere = nom_mere;
    }

    public String getPrenomMere() {
        return prenom_mere;
    }

    public void setPrenomMere(String prenom_mere) {
        this.prenom_mere = prenom_mere;
    }

    public int getAnneeDerniereInscription() {
        return annee_derniere_inscription;
    }

    public void setAnneeDerniereInscription(int annee_derniere_inscription) {
        this.annee_derniere_inscription = annee_derniere_inscription;
    }

    public Date getDateNaissance() {
       // return (new SimpleDateFormat("yyyy-MM-dd")).format(this.date_naissance);
        return date_naissance;
    }

    public void setDateNaissance(String date_naissance) {
        try {
            this.date_naissance = DateFormat.getDateInstance().parse(date_naissance);
        } catch (ParseException e) {
            // ...
        }
    }


}
