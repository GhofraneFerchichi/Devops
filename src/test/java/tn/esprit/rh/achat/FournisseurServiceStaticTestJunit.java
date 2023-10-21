package tn.esprit.rh.achat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.rh.achat.entities.Fournisseur;
import tn.esprit.rh.achat.repositories.DetailFournisseurRepository;
import tn.esprit.rh.achat.repositories.FournisseurRepository;
import tn.esprit.rh.achat.services.FournisseurServiceImpl;
import tn.esprit.rh.achat.services.IFournisseurService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class FournisseurServiceStaticTestJunit {

    @Mock
    private FournisseurRepository fournisseurRepository;

    @Mock
    private DetailFournisseurRepository detailFournisseurRepository;

    private IFournisseurService fournisseurService;

    @BeforeEach
    public void setUp() {
        // Create an instance of FournisseurServiceImpl and inject the mock repositories
        fournisseurService = new FournisseurServiceImpl(fournisseurRepository, detailFournisseurRepository);
    }

    @Test
    public void testRetrieveAllFournisseurs() {
        // Define the behavior of the mock repository when findAll is called
        List<Fournisseur> fournisseurs = new ArrayList<>();
        Mockito.when(fournisseurRepository.findAll()).thenReturn(fournisseurs);

        // Now you can call the method you want to test
        List<Fournisseur> result = fournisseurService.retrieveAllFournisseurs();

        // Add assertions to verify the results
        assertEquals(fournisseurs.size(), result.size());
    }

    @Test
    public void testAddFournisseur() {
        Fournisseur fournisseur = new Fournisseur(/* provide constructor arguments */);

        // Simulate the behavior of the FournisseurRepository when saving
        Mockito.when(fournisseurRepository.save(fournisseur)).thenReturn(fournisseur);

        // Call the method you want to test
        Fournisseur addedFournisseur = fournisseurService.addFournisseur(fournisseur);

        // Verify that the Fournisseur was saved and returned correctly
        assertEquals(fournisseur, addedFournisseur);
    }

    @Test
    public void testUpdateFournisseur() {
        Fournisseur fournisseur = new Fournisseur(/* provide constructor arguments */);

        // Simulate the behavior of the FournisseurRepository when saving
        Mockito.when(fournisseurRepository.save(fournisseur)).thenReturn(fournisseur);

        // Call the method you want to test
        Fournisseur updatedFournisseur = fournisseurService.updateFournisseur(fournisseur);

        // Verify that the Fournisseur was updated and returned correctly
        assertEquals(fournisseur, updatedFournisseur);
    }

    @Test
    public void testDeleteFournisseur() {
        Long fournisseurId = 1L;

        // Call the method you want to test
        fournisseurService.deleteFournisseur(fournisseurId);

        // Verify that the Fournisseur with the specified ID was deleted
        Mockito.verify(fournisseurRepository).deleteById(fournisseurId);
    }

    @Test
    public void testRetrieveFournisseur() {
        Long fournisseurId = 1L;
        Fournisseur expectedFournisseur = new Fournisseur(/* provide constructor arguments */);

        // Simulate the behavior of the FournisseurRepository when finding by ID
        Mockito.when(fournisseurRepository.findById(fournisseurId)).thenReturn(Optional.of(expectedFournisseur));

        // Call the method you want to test
        Fournisseur retrievedFournisseur = fournisseurService.retrieveFournisseur(fournisseurId);

        // Verify that the correct Fournisseur was retrieved
        assertEquals(expectedFournisseur, retrievedFournisseur);
    }
}
