package org.example.controle_blanc.Dao;

import org.example.controle_blanc.Model.Incident;

import java.util.Set;

public interface IncidentDao {
    void inserer(Incident i); // Ajouter un incident
    void inserer(Set<Incident> incidents); // Ajouter un ensemble d'incidents
}
