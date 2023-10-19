package tn.esprit.rh.achat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.rh.achat.entities.Produit;
import tn.esprit.rh.achat.entities.Stock;
import tn.esprit.rh.achat.repositories.ProduitRepository;
import tn.esprit.rh.achat.repositories.StockRepository;
import tn.esprit.rh.achat.services.ProduitServiceImpl;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = ProduitServiceImplTest.class)
@ExtendWith(MockitoExtension.class)
public class ProduitServiceImplTest {
    @InjectMocks

    private ProduitServiceImpl produitService;

    @Mock
    private ProduitRepository produitRepository;
    @Mock
    private StockRepository stockRepository ;
    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void testretrieveAllProduits(){
        when(produitRepository.findAll()).thenReturn(Arrays.asList(new Produit(), new Produit()));
        List<Produit> produits = produitService.retrieveAllProduits();
        assertEquals(2, produits.size());
    }

    @Test
    public void testAddProduit() {
        Produit produit = new Produit();

        when(produitRepository.save(any(Produit.class))).thenReturn(produit);

        Produit result = produitService.addProduit(produit);

        assertEquals(produit, result);
    }
    @Test
    public void testDeleteProduit() {
        Long produitId = 1L;

        produitService.deleteProduit(produitId);

        verify(produitRepository).deleteById(produitId);
    }

    @Test
    public void testUpdateProduit() {
        Produit produit = new Produit();

        when(produitRepository.save(any(Produit.class))).thenReturn(produit);

        Produit result = produitService.updateProduit(produit);

        assertEquals(produit, result);
    }

    @Test
    public void testRetrieveProduit() {
        Long produitId = 1L;
        Produit produit = new Produit();

        when(produitRepository.findById(produitId)).thenReturn(Optional.of(produit));

        Produit result = produitService.retrieveProduit(produitId);

        assertEquals(produit, result);
    }

    @Test
    public void testAssignProduitToStock() {
        Long idProduit = 1L;
        Long idStock = 2L;
        Produit produit = new Produit();
        Stock stock = new Stock();

        when(produitRepository.findById(idProduit)).thenReturn(Optional.of(produit));
        when(stockRepository.findById(idStock)).thenReturn(Optional.of(stock));

        produitService.assignProduitToStock(idProduit, idStock);

        assertEquals(stock, produit.getStock());
        verify(produitRepository).save(produit);
    }


}
