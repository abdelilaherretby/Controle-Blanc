package org.example.controle_blanc.Model;

import java.util.Objects;
import java.util.Set;

public class Membre {
    private String identifiant;
    private String nom;
    private String prenom;
    private String email;
    private String phone;
    private Set<Incident> incidents; // Association avec les incidents

    public Membre(String nom, String prenom,String email, String phone) {
        this.email = email;
        this.nom = nom;
        this.phone = phone;
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public Set<Incident> getIncidents() {
        return incidents;
    }

    public void setIncidents(Set<Incident> incidents) {
        this.incidents = incidents;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    // Redéfinition des méthodes equals et hashCode
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Membre membre = (Membre) obj;

        return Objects.equals(identifiant, membre.identifiant) &&
                Objects.equals(nom, membre.nom) &&
                Objects.equals(prenom, membre.prenom) &&
                Objects.equals(email, membre.email) &&
                Objects.equals(phone, membre.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identifiant, nom, prenom, email, phone);
    }

}
