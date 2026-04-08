import org.junit.Test;
import static org.junit.Assert.*;

public class PricingServiceTest {

    PricingService service = new PricingService();

    
    @Test
    public void testPeakHourPricing() {
        double fare = service.calculateFare(100, 2.0, 12, 9);
        
        // Expected: 100 * (1 + 1.0 + 0.5 + 0.3) = 280
        assertEquals(280.0, fare, 0.1);
    }

    
    @Test
    public void testNonPeakPricing() {
        double fare = service.calculateFare(100, 1.0, 5, 14);
        
        // Expected: 100 * 1.0 = 100
        assertEquals(100.0, fare, 0.1);
    }

    
    @Test
    public void testHighDemandOnly() {
        double fare = service.calculateFare(100, 2.0, 5, 14);
        
        // Expected: 100 * (1 + 1.0) = 200
        assertEquals(200.0, fare, 0.1);
    }

    
    @Test
    public void testPeakTimeOnly() {
        double fare = service.calculateFare(100, 1.0, 5, 9);
        
   
        assertEquals(150.0, fare, 0.1);
    }

    
    @Test
    public void testLongDistanceOnly() {
        double fare = service.calculateFare(100, 1.0, 15, 14);
        
        
        assertEquals(130.0, fare, 0.1);
    }
}