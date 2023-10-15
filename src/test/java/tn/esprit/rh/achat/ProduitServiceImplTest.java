package tn.esprit.rh.achat;

import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import tn.esprit.rh.achat.repositories.ProduitRepository;
import tn.esprit.rh.achat.repositories.StockRepository;
import tn.esprit.rh.achat.services.ProduitServiceImpl;
import tn.esprit.rh.achat.services.StockServiceImpl;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class ProduitServiceImplTest {
    @Autowired
    ProduitServiceImpl produitService ;
    @Autowired
    StockServiceImpl stockService;
    @MockBean
    StockRepository SR ;
    @MockBean
    ProduitRepository PR;


}
