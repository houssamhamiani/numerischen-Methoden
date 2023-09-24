import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HorneTest {

    @Test
    public void testUrspruenglichesPolynomAlsString() {
        // Vorbereitung
        double[] koeffizienten1 = {1, -3, 2};
        double[] koeffizienten2 = {2};
        double[] koeffizienten3 = {1, 0, -2, 1};

        // Ausführung
        String result1 = Horne.urspruenglichesPolynomAlsString(koeffizienten1);
        String result2 = Horne.urspruenglichesPolynomAlsString(koeffizienten2);
        String result3 = Horne.urspruenglichesPolynomAlsString(koeffizienten3);

        // Überprüfung
        assertEquals("P(z) = 1.0z^2 + -3.0z^1 + 2.0", result1);
        assertEquals("P(z) = 2.0", result2);
        assertEquals("P(z) = 1.0z^3 + 0.0z^2 + -2.0z^1 + 1.0", result3);
    }
    
    @Test
    public void testZuEntwickelndesPolynomAlsString() {
        // Vorbereitung
        double[] nullstellen1 = {1, 2};
        double[] nullstellen2 = {};
        double[] nullstellen3 = {1, -1, 2};

        // Ausführung
        String result1 = Horne.zuEntwickelndesPolynomAlsString(nullstellen1);
        String result2 = Horne.zuEntwickelndesPolynomAlsString(nullstellen2);
        String result3 = Horne.zuEntwickelndesPolynomAlsString(nullstellen3);

        // Überprüfung
        assertEquals("P(z) = alpha0 + alpha1*(z - 1.0) + alpha2*(z - 1.0)*(z - 2.0)", result1);
        assertEquals("P(z) = alpha0", result2);
        assertEquals("P(z) = alpha0 + alpha1*(z - 1.0) + alpha2*(z - 1.0)*(z - -1.0) + alpha3*(z - 1.0)*(z - -1.0)*(z - 2.0)", result3);
    }
    
    
    
    
    
    
    
}
	
	
	
	
	
	
	
	
	
	
	
	
	
