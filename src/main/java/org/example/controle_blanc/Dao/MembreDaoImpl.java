package org.example.controle_blanc.Dao;

import org.example.controle_blanc.Model.Incident;
import org.example.controle_blanc.Model.Membre;
import org.example.controle_blanc.Utils.DBConnection;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class MembreDaoImpl implements MembreDao {

    @Override
    public void inserer(Membre m) {

        Connection con = DBConnection.getConnection();
        if(con == null) {
            return;
        }

        String query = "INSERT INTO membre  (nom, prenom, email, phone) VALUES (?, ?, ?, ?);";
        try (PreparedStatement pst = con.prepareStatement(query)) {

            pst.setString(1, m.getNom());
            pst.setString(2, m.getPrenom());
            pst.setString(3, m.getEmail());
            pst.setString(4, m.getPhone());

            pst.executeUpdate();

        } catch(SQLException se) {
            se.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    @Override
    public Set<Incident> chargerListeIncidents() {
        Connection con = DBConnection.getConnection();
        if(con == null) {
            return null;
        }

        Set<Incident> incidents = new HashSet<>();

        String query = "SELECT * FROM incident";

        try (PreparedStatement pst = con.prepareStatement(query)) {

            ResultSet rs=pst.executeQuery();

            while(rs.next()) {
                Incident incident = new Incident(rs.getInt("id_membre")
                                                 ,rs.getString("reference")
                                                 ,rs.getString("status")
                                                 ,rs.getTime("time"));




                incidents.add(incident);
            }

        } catch(SQLException se) {
            se.printStackTrace();
        } finally {
            try {
                con.close();
            } catch(SQLException se) {
                se.printStackTrace();
            }
        }

        return  incidents ;
    }


    // Méthode pour charger la liste des membres depuis un fichier CSV
    @Override
    public Set<Membre> chargerListeMembre(String nomFichier) {
        Set<Membre> membres = new HashSet<>(); // Utilisation d'un Set pour filtrer les doublons

        // Lecture du fichier CSV
        try (BufferedReader br = new BufferedReader(new FileReader(nomFichier))) {
            String ligne;

            // Lire chaque ligne du fichier
            while ((ligne = br.readLine()) != null) {
                // Diviser la ligne par la virgule pour obtenir les différentes informations du membre
                String[] data = ligne.split(",");

                // Vérifier que la ligne a bien 4 éléments : Nom, Prénom, Email, Phone
                if (data.length == 4) {
                    String nom = data[0].trim();
                    String prenom = data[1].trim();
                    String email = data[2].trim();
                    String phone = data[3].trim();

                    // Créer un objet Membre avec les informations extraites
                    Membre membre = new Membre(nom, prenom, email, phone);

                    // Ajouter le membre au Set (les doublons seront automatiquement filtrés)
                    membres.add(membre);
                }
            }

        } catch (IOException e) {
            e.printStackTrace(); // Gérer les erreurs de lecture du fichier
        }

        return membres;
    }

}
