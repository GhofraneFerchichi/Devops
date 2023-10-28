package tn.esprit.rh.achat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import tn.esprit.rh.achat.entities.Facture;
import tn.esprit.rh.achat.repositories.DetailFournisseurRepository;
import tn.esprit.rh.achat.repositories.FactureRepository;
import tn.esprit.rh.achat.repositories.ProduitRepository;
import tn.esprit.rh.achat.repositories.SecteurActiviteRepository;
import tn.esprit.rh.achat.services.FactureServiceImpl;
import tn.esprit.rh.achat.services.FournisseurServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FactureServiceImpltest {
    @InjectMocks
    private FactureServiceImpl factureService;
    @Mock
    private FactureRepository factureRepository;
    @Mock
    private FournisseurServiceImpl fournisseurService;
    @Mock
    private DetailFournisseurRepository detailFournisseurRepository;
    @Mock
    private ProduitRepository produitRepository;
    @Mock
    private SecteurActiviteRepository secteurActiviteRepository;

    public FactureServiceImpltest() {
    }

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testRetrieveAllFactures() {
        List<Facture> factures = this.createSampleFactures();
        Mockito.when(this.factureRepository.findAll()).thenReturn(factures);
        List<Facture> retrievedFactures = this.factureService.retrieveAllFactures();
        Assertions.assertEquals(factures, retrievedFactures);
    }

    @Test
    public void testAddFacture() {
        Facture sampleFacture = this.createSampleFacture();
        Mockito.when((Facture)this.factureRepository.save(sampleFacture)).thenReturn(sampleFacture);
        Facture addedFacture = this.factureService.addFacture(sampleFacture);
        Assertions.assertEquals(sampleFacture, addedFacture);
    }

    @Test
    public void testCancelFacture() {
        Long factureId = 1L;
        Mockito.when(this.factureRepository.findById(factureId)).thenReturn(Optional.of(this.createSampleFacture()));
        this.factureService.cancelFacture(factureId);
        Facture canceledFacture = this.createSampleFacture();
        canceledFacture.setArchivee(true);
        Assertions.assertEquals(canceledFacture, this.createSampleFacture());
    }

    @Test
    public void testRetrieveFacture() {
        Long factureId = 1L;
        Facture sampleFacture = this.createSampleFacture();
        Mockito.when(this.factureRepository.findById(factureId)).thenReturn(Optional.of(sampleFacture));
        Facture retrievedFacture = this.factureService.retrieveFacture(factureId);
        Assertions.assertEquals(sampleFacture, retrievedFacture);
    }

    private List<Facture> createSampleFactures() {
        List<Facture> sampleFactures = new ArrayList();
        Facture facture1 = new Facture();
        facture1.setIdFacture(1L);
        facture1.setMontantFacture(100.0F);
        facture1.setArchivee(false);
        Facture facture2 = new Facture();
        facture2.setIdFacture(2L);
        facture2.setMontantFacture(150.0F);
        facture2.setArchivee(false);
        sampleFactures.add(facture1);
        sampleFactures.add(facture2);
        return sampleFactures;
    }

    private Facture createSampleFacture() {
        Facture facture = new Facture();
        facture.setIdFacture(1L);
        facture.setMontantFacture(100.0F);
        facture.setMontantRemise(10.0F);
        return facture;
    }
}
