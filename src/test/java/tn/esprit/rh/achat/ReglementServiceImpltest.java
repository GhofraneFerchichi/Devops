package tn.esprit.rh.achat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.verification.VerificationModeFactory;
import tn.esprit.rh.achat.entities.Reglement;
import tn.esprit.rh.achat.repositories.ReglementRepository;
import tn.esprit.rh.achat.services.ReglementServiceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class ReglementServiceImpltest {
    @Mock
    private ReglementRepository reglementRepository;
    @InjectMocks
    private ReglementServiceImpl reglementService;

    public ReglementServiceImpltest() {
    }

    @Test
    public void testRetrieveAllReglements() {
        List<Reglement> mockReglements = new ArrayList();
        Mockito.when(this.reglementRepository.findAll()).thenReturn(mockReglements);
        List<Reglement> reglements = this.reglementService.retrieveAllReglements();
        Assertions.assertEquals(mockReglements, reglements);
        ((ReglementRepository)Mockito.verify(this.reglementRepository, VerificationModeFactory.times(1))).findAll();
    }

    @Test
    public void testAddReglement() {
        Reglement reglement = new Reglement();
        Mockito.when((Reglement)this.reglementRepository.save(reglement)).thenReturn(reglement);
        Reglement addedReglement = this.reglementService.addReglement(reglement);
        Assertions.assertEquals(reglement, addedReglement);
        ((ReglementRepository)Mockito.verify(this.reglementRepository, VerificationModeFactory.times(1))).save(reglement);
    }

    @Test
    public void testRetrieveReglement() {
        Long id = 1L;
        Reglement reglement = new Reglement();
        Mockito.when(this.reglementRepository.findById(id)).thenReturn(Optional.of(reglement));
        Reglement retrievedReglement = this.reglementService.retrieveReglement(id);
        Assertions.assertEquals(reglement, retrievedReglement);
        ((ReglementRepository)Mockito.verify(this.reglementRepository, VerificationModeFactory.times(1))).findById(id);
    }

    @Test
    public void testRetrieveReglementByFacture() {
        Long idFacture = 1L;
        List<Reglement> mockReglements = new ArrayList();
        Mockito.when(this.reglementRepository.retrieveReglementByFacture(idFacture)).thenReturn(mockReglements);
        List<Reglement> reglements = this.reglementService.retrieveReglementByFacture(idFacture);
        Assertions.assertEquals(mockReglements, reglements);
        ((ReglementRepository)Mockito.verify(this.reglementRepository, VerificationModeFactory.times(1))).retrieveReglementByFacture(idFacture);
    }

    @Test
    public void testGetChiffreAffaireEntreDeuxDate() {
        Date startDate = new Date();
        Date endDate = new Date();
        float mockChiffreAffaire = 1000.0F;
        Mockito.when(this.reglementRepository.getChiffreAffaireEntreDeuxDate(startDate, endDate)).thenReturn(mockChiffreAffaire);
        float chiffreAffaire = this.reglementService.getChiffreAffaireEntreDeuxDate(startDate, endDate);
        Assertions.assertEquals(mockChiffreAffaire, chiffreAffaire);
        ((ReglementRepository)Mockito.verify(this.reglementRepository, VerificationModeFactory.times(1))).getChiffreAffaireEntreDeuxDate(startDate, endDate);
    }
}
