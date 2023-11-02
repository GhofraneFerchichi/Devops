package tn.esprit.rh.achat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.rh.achat.entities.Operateur;
import tn.esprit.rh.achat.repositories.OperateurRepository;
import tn.esprit.rh.achat.services.OperateurServiceImpl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
@SpringBootTest(classes = OperateurServiceImplTest.class)
@ExtendWith(MockitoExtension.class)
public class OperateurServiceImplTest {

    @InjectMocks
    private OperateurServiceImpl operateurService;

    @Mock
    private OperateurRepository operateurRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testRetrieveAllOperateurs() {
        // Arrange
        List<Operateur> operateurList = Arrays.asList(new Operateur(), new Operateur());
        when(operateurRepository.findAll()).thenReturn(operateurList);

        // Act
        List<Operateur> result = operateurService.retrieveAllOperateurs();

        // Assert
        assertEquals(2, result.size());
    }

    @Test
    public void testAddOperateur() {
        // Arrange
        Operateur operateur = new Operateur();

        // Act
        Operateur result = operateurService.addOperateur(operateur);

        // Assert
        assertEquals(operateur, result);
        verify(operateurRepository).save(operateur);
    }

    @Test
    public void testDeleteOperateur() {
        // Arrange
        Long id = 1L;

        // Act
        operateurService.deleteOperateur(id);

        // Assert
        verify(operateurRepository).deleteById(id);
    }

    @Test
    public void testUpdateOperateur() {
        // Arrange
        Operateur operateur = new Operateur();

        // Act
        Operateur result = operateurService.updateOperateur(operateur);

        // Assert
        assertEquals(operateur, result);
        verify(operateurRepository).save(operateur);
    }

    @Test
    public void testRetrieveOperateur() {
        // Arrange
        Long id = 1L;
        Operateur operateur = new Operateur();
        when(operateurRepository.findById(id)).thenReturn(Optional.of(operateur));

        // Act
        Operateur result = operateurService.retrieveOperateur(id);

        // Assert
        assertEquals(operateur, result);
    }

    @Test
    public void testRetrieveOperateur_NotFound() {
        // Arrange
        Long id = 1L;
        when(operateurRepository.findById(id)).thenReturn(Optional.empty());

        // Act
        Operateur result = operateurService.retrieveOperateur(id);

        // Assert
        assertNull(result);
    }
}
