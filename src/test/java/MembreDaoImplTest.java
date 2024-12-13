import org.example.controle_blanc.Dao.MembreDaoImpl;
import org.example.controle_blanc.Model.Incident;
import org.example.controle_blanc.Model.Membre;
import org.junit.jupiter.api.Test;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.*;


public class MembreDaoImplTest {

    private final MembreDaoImpl membreDao = new MembreDaoImpl();

    @Test
    public void testChargerListeIncidents() {
        // Tester la méthode chargerListeIncidents
        Set<Incident> incidents = membreDao.chargerListeIncidents();

        // Vérifier que les incidents sont correctement chargés
        assertNotNull(incidents, "La liste des incidents ne doit pas être nulle.");
        assertTrue(incidents.size() > 0, "La liste des incidents doit contenir au moins un élément.");

        // Afficher les incidents pour validation
        incidents.forEach(incident -> {
            System.out.println("Incident:");
            System.out.println("ID Membre: " + incident.getId_membre());
            System.out.println("Référence: " + incident.getReference());
            System.out.println("Statut: " + incident.getStatus());
            System.out.println("Time: " + incident.getTime());
        });
    }

    @Test
    public void testChargerListeMembre() {
        // Tester la méthode chargerListeMembre
        String cheminFichier = "src/main/java/org/example/controle_blanc/Utils/membres.csv"; // Chemin relatif vers le fichier CSV
        Set<Membre> membres = membreDao.chargerListeMembre(cheminFichier);

        // Vérifier que les membres sont correctement chargés
        assertNotNull(membres, "La liste des membres ne doit pas être nulle.");
        assertTrue(membres.size() > 0, "La liste des membres doit contenir au moins un élément.");

        // Afficher les membres pour validation
        membres.forEach(membre -> {
            System.out.println("Membre:");
            System.out.println("Nom: " + membre.getNom());
            System.out.println("Prénom: " + membre.getPrenom());
            System.out.println("Email: " + membre.getEmail());
            System.out.println("Phone: " + membre.getPhone());
        });
    }
}
