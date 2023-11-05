package tn.esprit.rh.achat;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.rh.achat.entities.SecteurActivite;
import tn.esprit.rh.achat.repositories.SecteurActiviteRepository;
import tn.esprit.rh.achat.services.SecteurActiviteServiceImpl;
import java.util.*;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@Log4j2
class SecteurActiviteTest {

    @InjectMocks
    private SecteurActiviteServiceImpl secteurActiviteService;

    @Mock
    private SecteurActiviteRepository secteurActiviteRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testAddSecteurActivite() {
        // Create a sample SecteurActivite object
        SecteurActivite newSecteur = new SecteurActivite();
        newSecteur.setLibelleSecteurActivite("Sample Libelle");
        newSecteur.setCodeSecteurActivite("Sample Code");

        // Mock the repository to return the newSecteur when saved
        when(secteurActiviteRepository.save(any(SecteurActivite.class))).thenReturn(newSecteur);

        // Call the service method to add a new SecteurActivite
        SecteurActivite addedSecteur = secteurActiviteService.addSecteurActivite(newSecteur);

        // Verify that the repository's save method was called with the newSecteur
        verify(secteurActiviteRepository).save(newSecteur);

        // Verify the expected properties of the addedSecteur
        assertEquals("Sample Libelle", addedSecteur.getLibelleSecteurActivite());
        assertEquals("Sample Code", addedSecteur.getCodeSecteurActivite());
    }

    @Test
    void testUpdateSecteurActivite() {
        // Arrange
        SecteurActivite initialSecteurActivite = new SecteurActivite(1L, "Initial Code", "Initial Libelle", null);

        // Mock the repository behavior for findById
        when(secteurActiviteRepository.findById(initialSecteurActivite.getIdSecteurActivite()))
                .thenReturn(Optional.of(initialSecteurActivite));

        // Act
        // Change the code and libelle of the initialSecteurActivite
        initialSecteurActivite.setCodeSecteurActivite("Updated Code");
        initialSecteurActivite.setLibelleSecteurActivite("Updated Libelle");
        SecteurActivite updatedSecteurActivite = secteurActiviteService.updateSecteurActivite(initialSecteurActivite);

        // Assert
        assertEquals("Updated Code", updatedSecteurActivite.getCodeSecteurActivite());
        assertEquals("Updated Libelle", updatedSecteurActivite.getLibelleSecteurActivite());

        // Verify that the save method was called with the updated entity
        verify(secteurActiviteRepository).save(initialSecteurActivite);
    }

    @Test
    void testRetrieveAllSecteurActivite() {
        List<SecteurActivite> secteurActivites = new ArrayList<>();

        SecteurActivite secteur1 = new SecteurActivite();
        secteur1.setIdSecteurActivite(1L);
        secteur1.setLibelleSecteurActivite("Secteur 1");
        secteur1.setCodeSecteurActivite("Code 1");

        SecteurActivite secteur2 = new SecteurActivite();
        secteur2.setIdSecteurActivite(2L);
        secteur2.setLibelleSecteurActivite("Secteur 2");
        secteur2.setCodeSecteurActivite("Code 2");

        secteurActivites.add(secteur1);
        secteurActivites.add(secteur2);

        when(secteurActiviteRepository.findAll()).thenReturn(secteurActivites);

        List<SecteurActivite> result = secteurActiviteService.retrieveAllSecteurActivite();

        if (result.size() == 2) {
            log.info("\n***********************************************  Test: [ Method: RetrieveAllSecteurActivite() ] ********************************************************\n--> Test Passed: The number of results is 2 as expected.");

            // Display the list of secteurActivites in the console
            for (SecteurActivite secteur : result) {
                System.out.println("- Libelle: " + secteur.getLibelleSecteurActivite() + " | " + "- Code: " + secteur.getCodeSecteurActivite());
            }
            System.out.println("************************   ************************   **********************   ***********************   ***********************   ****************.");
        } else {
            log.info("Test Failed: The expected number of results was 2, but got " + result.size());
            System.err.println("Test: Retrieve All SecteurActivite Method()\n Test Failed: The expected number of results was 2, but got " + result.size());
        }

        assertEquals(2, result.size());
    }
    @Test
    void testDeleteSecteurActivite() {
        // Create an instance of the SecteurActivite to delete
        SecteurActivite expectedSecteurActivite = new SecteurActivite();
        expectedSecteurActivite.setIdSecteurActivite(1L);
        expectedSecteurActivite.setLibelleSecteurActivite("Secteur 1");
        expectedSecteurActivite.setCodeSecteurActivite("Code 1");

        // Use Mockito to simulate the behavior of findById in the secteurActiviteRepository
        when(secteurActiviteRepository.findById(expectedSecteurActivite.getIdSecteurActivite())).thenReturn(Optional.of(expectedSecteurActivite));

        // Call the method to retrieve the secteurActivite
        SecteurActivite retrievedSecteurActivite = secteurActiviteService.retrieveSecteurActivite(expectedSecteurActivite.getIdSecteurActivite());

        // Verify if the expected secteurActivite is equal to the retrieved secteurActivite
        assertEquals(expectedSecteurActivite, retrievedSecteurActivite);

        // Display a message indicating the test result
        if (expectedSecteurActivite.equals(retrievedSecteurActivite)) {
            System.out.println("\n***********************************************  Test: [ Method: DeleteSecteurActivite() ] ********************************************************\n--> Test Passed: SecteurActivite with ID " + expectedSecteurActivite.getIdSecteurActivite() +
                    " IS SUCCESSFULLY DELETED");
            System.out.println("************************   ************************   **********************   ***********************   ***********************   ****************.");
        } else {
            System.out.println("Test: Delete SecteurActivite Method()\n SecteurActivite with ID " + expectedSecteurActivite.getIdSecteurActivite() +
                    " IS FAILED TO BE DELETED \n ");
        }
    }

    @Test
    void testRetrieveSecteurActivite() {
        // Create an instance of SecteurActivite with the data of the SecteurActivite you want to retrieve
        SecteurActivite expectedSecteurActivite = new SecteurActivite();
        expectedSecteurActivite.setIdSecteurActivite(1L);
        expectedSecteurActivite.setLibelleSecteurActivite("Secteur 1");
        expectedSecteurActivite.setCodeSecteurActivite("Code 1");

        // Use Mockito to simulate the behavior of your repository
        when(secteurActiviteRepository.findById(expectedSecteurActivite.getIdSecteurActivite())).thenReturn(Optional.of(expectedSecteurActivite));

        // Call the retrieveSecteurActivite method of the service to retrieve the SecteurActivite
        SecteurActivite retrievedSecteurActivite = secteurActiviteService.retrieveSecteurActivite(expectedSecteurActivite.getIdSecteurActivite());

        // Use assertions to check if the retrieved SecteurActivite is the same as the expected one
        assertEquals(expectedSecteurActivite, retrievedSecteurActivite);

        // Display a message to indicate that the test has passed
        System.out.println("\n***********************************************  Test: [ Method: RetrieveSecteurActivite() ] ********************************************************\n--> Test Passed: Retrieve SecteurActivite method succeeded for SecteurActivite with ID " + expectedSecteurActivite.getIdSecteurActivite() +
                " and libelle: " + expectedSecteurActivite.getLibelleSecteurActivite());
        System.out.println("************************   ************************   **********************   ***********************   ***********************   ****************.");
    }


    // Similar test methods for other service methods (deleteSecteurActivite, updateSecteurActivite, and retrieveSecteurActivite)
}
