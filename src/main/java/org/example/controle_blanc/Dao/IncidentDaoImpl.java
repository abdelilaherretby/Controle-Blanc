package org.example.controle_blanc.Dao;

import org.example.controle_blanc.Model.Incident;
import org.example.controle_blanc.Utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Set;

public class IncidentDaoImpl  implements  IncidentDao{
    @Override
    public void inserer(Incident i) {
        // Connexion à la base de données
        Connection con = DBConnection.getConnection();
        if (con == null) {
            return; // Si la connexion échoue, sortir de la méthode
        }

        // Requête SQL pour insérer un incident
        String query = "INSERT INTO incident (reference, time, status, id_membre) VALUES (?, ?, ?, ?);";

        // Exécution de la requête avec les données de l'incident
        try (PreparedStatement pst = con.prepareStatement(query)) {

            // Définir les paramètres de la requête
            pst.setString(1, i.getReference()); // Référence de l'incident
            pst.setDate(2, new java.sql.Date(i.getTime().getTime())); // Convertir Date en java.sql.Date pour SQL
            pst.setString(3, i.getStatus()); // Statut de l'incident
            pst.setInt(4, i.getId_membre()); // Identifiant du membre

            // Exécuter la mise à jour dans la base de données
            pst.executeUpdate();

        } catch (SQLException se) {
            se.printStackTrace(); // Gérer les erreurs SQL
        } finally {
            try {
                con.close(); // Fermer la connexion à la base de données
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
    @Override
    public void inserer(Set<Incident> incidents) {
        // Connexion à la base de données
        Connection con = DBConnection.getConnection();
        if (con == null) {
            return; // Si la connexion échoue, sortir de la méthode
        }

        // Requête SQL pour insérer un incident
        String query = "INSERT INTO incident (reference, time, status, id_membre) VALUES (?, ?, ?, ?);";

        try (PreparedStatement pst = con.prepareStatement(query)) {

            // Itérer sur l'ensemble des incidents et les insérer un par un
            for (Incident i : incidents) {
                // Définir les paramètres de la requête pour chaque incident
                pst.setString(1, i.getReference());
                pst.setDate(2, new java.sql.Date(i.getTime().getTime())); // Convertir Date en java.sql.Date pour SQL
                pst.setString(3, i.getStatus());
                pst.setInt(4, i.getId_membre());

                // Exécuter la requête d'insertion pour chaque incident individuellement
                pst.executeUpdate();
            }

        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }


}
