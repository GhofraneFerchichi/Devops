package tn.esprit.rh.achat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.rh.achat.entities.CategorieFournisseur;
import tn.esprit.rh.achat.entities.Fournisseur;
import tn.esprit.rh.achat.repositories.FournisseurRepository;
import tn.esprit.rh.achat.services.FournisseurServiceImpl;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
@Transactional
public class FournisseurServiceStaticTestJunit {

    @Autowired
    private FournisseurServiceImpl fournisseurService;

    @Autowired
    private FournisseurRepository fournisseurRepository;

    @Test
    public void testRetrieveAllFournisseurs() {
        List<Fournisseur> fournisseurs = fournisseurService.retrieveAllFournisseurs();

        // Add assertions to verify the results
        assertNotNull(fournisseurs);
        assertEquals(2, fournisseurs.size());
    }

    @Test
    public void testAddFournisseur() {
        Fournisseur fournisseur = new Fournisseur();
        fournisseur.setCode("F3");
        fournisseur.setLibelle("Supplier 3");
        fournisseur.setCategorieFournisseur(CategorieFournisseur.ORDINAIRE);

        // Call the method you want to test
        Fournisseur addedFournisseur = fournisseurService.addFournisseur(fournisseur);

        // Verify that the Fournisseur was saved and returned correctly
        assertNotNull(addedFournisseur.getIdFournisseur());
    }

    @Test
    public void testUpdateFournisseur() {
        Fournisseur fournisseur = fournisseurRepository.findByCode("F1"); // Assuming a method to find by code exists

        // Modify the Fournisseur object
        fournisseur.setLibelle("Updated Supplier 1");

        // Call the method you want to test
        Fournisseur updatedFournisseur = fournisseurService.updateFournisseur(fournisseur);

        // Verify that the Fournisseur was updated correctly
        assertEquals("Updated Supplier 1", updatedFournisseur.getLibelle());
    }

    @Test
    public void testDeleteFournisseur() {
        Fournisseur fournisseur = fournisseurRepository.findByCode("F2"); // Assuming a method to find by code exists

        // Call the method you want to test
        fournisseurService.deleteFournisseur(fournisseur.getIdFournisseur());

        // Verify that the Fournisseur with the specified ID was deleted
        Fournisseur deletedFournisseur = fournisseurService.retrieveFournisseur(fournisseur.getIdFournisseur());
        assertNull(deletedFournisseur);
    }

    @Test
    public void testRetrieveFournisseur() {
        Fournisseur fournisseur = fournisseurRepository.findByCode("F1"); // Assuming a method to find by code exists

        // Call the method you want to test
        Fournisseur retrievedFournisseur = fournisseurService.retrieveFournisseur(fournisseur.getIdFournisseur());

        // Verify that the correct Fournisseur was retrieved
        assertNotNull(retrievedFournisseur);
        assertEquals("F1", retrievedFournisseur.getCode());
    }
}
