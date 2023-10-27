package tn.esprit.rh.achat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.rh.achat.entities.Stock;
import tn.esprit.rh.achat.repositories.StockRepository;
import tn.esprit.rh.achat.services.StockServiceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;


@SpringBootTest(classes = StockServiceImplTest.class)
@ExtendWith(MockitoExtension.class)
public class StockServiceImplTest {

    @InjectMocks
    private StockServiceImpl stockService;

    @Mock
    private StockRepository stockRepository;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testRetrieveAllStocks() {

        when(stockRepository.findAll()).thenReturn(Arrays.asList(new Stock(), new Stock()));

        List<Stock> stocks = stockService.retrieveAllStocks();

        assertEquals(2, stocks.size());
    }
    @Test
    public void testAddStock() {
        Stock stock = new Stock();
        when(stockRepository.save(stock)).thenReturn(stock);

        Stock result = stockService.addStock(stock);

        // Verify that the stock is saved
        verify(stockRepository, times(1)).save(stock);
        // Assert the result
        assertEquals(stock, result);
    }

    @Test
    public void testDeleteStock() {
        Long stockId = 1L;

        stockService.deleteStock(stockId);

        // Verify that the stock is deleted by the provided stockId
        verify(stockRepository, times(1)).deleteById(stockId);
    }

    @Test
    public void testUpdateStock() {
        Stock stock = new Stock();
        when(stockRepository.save(stock)).thenReturn(stock);

        Stock result = stockService.updateStock(stock);

        // Verify that the stock is saved
        verify(stockRepository, times(1)).save(stock);
        // Assert the result
        assertEquals(stock, result);
    }

    @Test
    public void testRetrieveStock() {
        Long stockId = 1L;
        Stock stock = new Stock();
        when(stockRepository.findById(stockId)).thenReturn(Optional.of(stock));

        Stock result = stockService.retrieveStock(stockId);

        // Verify that the stock is retrieved by the provided stockId
        verify(stockRepository, times(1)).findById(stockId);
        // Assert the result
        assertEquals(stock, result);
    }

    @Test
    public void testRetrieveStatusStock() {
        // Create a mocked list of stocksEnRouge
        List<Stock> stocksEnRouge = new ArrayList<>();
        Stock stock1 = new Stock();
        stock1.setLibelleStock("Stock 1");
        stock1.setQte(5);
        stock1.setQteMin(10);
        stocksEnRouge.add(stock1);
        when(stockRepository.retrieveStatusStock()).thenReturn(stocksEnRouge);

        String result = stockService.retrieveStatusStock();

        // Verify that the stockRepository's retrieveStatusStock method is called
        verify(stockRepository, times(1)).retrieveStatusStock();
        // Assert the result
        assertNotNull(result);
        // Add additional assertions for the expected message format and content
    }
}
