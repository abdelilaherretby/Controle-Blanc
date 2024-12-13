package org.example.controle_blanc.Dao;

import org.example.controle_blanc.Model.Incident;
import org.example.controle_blanc.Model.Membre;

import java.util.Set;

public interface MembreDao {
    void inserer(Membre m); // Ajouter un membre
    Set<Incident> chargerListeIncidents(); // Charger la liste des incidents
    Set<Membre> chargerListeMembre(String nomFichier);
}
