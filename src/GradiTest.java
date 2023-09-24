import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Scanner;
import java.io.ByteArrayInputStream;

import java.io.PrintStream;
import java.io.ByteArrayOutputStream;



public class GradiTest {

    private Gradi gradi;

    @BeforeEach
    public void setUp() {
        gradi = new Gradi(true); // Wir verwenden den automatischen Modus, um die Benutzereingabe zu vermeiden
        
    }
    
    
    
    

    @Test
    public void testGeneriereZufaelligeGleichungen() {
        gradi.generiereZufaelligeGleichungen();
        // Überprüfen, ob die Koeffizienten innerhalb des erwarteten Bereichs liegen
        assertTrue(gradi.getKoeffizientA() >= -1000 && gradi.getKoeffizientA() <= 1000);
        assertTrue(gradi.getKoeffizientB() >= -1000 && gradi.getKoeffizientB() <= 1000);
        assertTrue(gradi.getKoeffizientC() >= -1000 && gradi.getKoeffizientC() <= 1000);
        assertTrue(gradi.getKoeffizientD() >= -1000 && gradi.getKoeffizientD() <= 1000);

        // Überprüfen von Grenzfällen und speziellen Bedingungen
        assertNotEquals(gradi.getKoeffizientA(), gradi.getKoeffizientC());
        assertNotEquals(gradi.getKoeffizientB(), gradi.getKoeffizientD());
        
        // Bedingung 1: A/B sollte nicht gleich C/D sein, wenn B und C nicht null sind
        if (gradi.getKoeffizientB() != 0 && gradi.getKoeffizientC() != 0) {
            assertNotEquals(gradi.getKoeffizientA() / gradi.getKoeffizientB(), 
                            gradi.getKoeffizientC() / gradi.getKoeffizientD());
        }
        
        // Bedingung 2: B/D sollte nicht gleich A/C sein, wenn A und C nicht null sind
        if (gradi.getKoeffizientA() != 0 && gradi.getKoeffizientC() != 0) {
            assertNotEquals(gradi.getKoeffizientB() / gradi.getKoeffizientD(), 
                            gradi.getKoeffizientA() / gradi.getKoeffizientC());
        }
    }
    @Test
    public void testManuelleEingabe() {
        // Simulierte Eingaben für die manuelleEingabe() Methode
        String simulatedInput = "100\n200\n300\n400\n500\n600\n2\n3\n4\n5\n6\n7\n";
        Scanner mockScanner = new Scanner(new ByteArrayInputStream(simulatedInput.getBytes()));

        gradi.manuelleEingabe(mockScanner);

        // Überprüfen Sie die Werte nach der manuellen Eingabe
        assertEquals(100, gradi.getKoeffizientA());
        assertEquals(200, gradi.getKoeffizientB());
        assertEquals(300, gradi.getKoeffizientC());
        assertEquals(400, gradi.getKoeffizientD());
        assertEquals(500, gradi.getKonstanteE());
        assertEquals(600, gradi.getKonstanteF());
        assertEquals(2, gradi.getExponentN());
        assertEquals(3, gradi.getExponentM());
        assertEquals(4, gradi.getExponentS());
        assertEquals(5, gradi.getExponentT());
    }
 // Test der Methode ueberpruefeUnendlichVieleLoesungen
    @Test
    public void testUeberpruefeUnendlichVieleLoesungen() {
        Gradi gradi = new Gradi(true); // Automatische Generierung aktivieren

        // Setzen Sie die Werte für das Gleichungssystem direkt
        gradi.setKoeffizientA(2.0);
        gradi.setKoeffizientB(-1.0);
        gradi.setKoeffizientC(-4.0);
        gradi.setKoeffizientD(2.0);
        gradi.setKonstanteE(-2.0);
        gradi.setKonstanteF(4.0);
        gradi.setExponentN(1);
        gradi.setExponentM(1);
        gradi.setExponentS(1);
        gradi.setExponentT(1);

        // Überprüfen Sie, ob die Methode ueberpruefeUnendlichVieleLoesungen true zurückgibt
        assertTrue(gradi.ueberpruefeUnendlichVieleLoesungen());
    }
    @Test
    public void testUeberpruefeKeineLoesung() {
        // Create a Gradi instance and set the specific values
        Gradi gradi = new Gradi(false); // Here, false activates manual input
        gradi.setKoeffizientA(2.0);
        gradi.setKoeffizientB(-1.0);
        gradi.setKoeffizientC(-4.0);
        gradi.setKoeffizientD(2.0);
        gradi.setKonstanteE(-2.0);
        gradi.setKonstanteF(6.0);
        gradi.setExponentN(1);
        gradi.setExponentM(1);
        gradi.setExponentS(1);
        gradi.setExponentT(1);

        // Check if the method ueberpruefeKeineLoesung() returns false
        assertTrue(gradi.ueberpruefeKeineLoesung());
    }
    
    @Test
    public void testZeigeGleichungssystem() {
        Gradi gradi = new Gradi(false); // Hier, false aktiviert die manuelle Eingabe
        gradi.setKoeffizientA(2.0);
        gradi.setKoeffizientB(-1.0);
        gradi.setKoeffizientC(-4.0);
        gradi.setKoeffizientD(2.0);
        gradi.setKonstanteE(-2.0);
        gradi.setKonstanteF(6.0);
        gradi.setExponentN(1);
        gradi.setExponentM(1);
        gradi.setExponentS(1);
        gradi.setExponentT(1);

        String expectedOutput = "\u001B[34mVerwendetes Gleichungssystem:\u001B[34m\n" +
                "2.0 * x^1 + -1.0 * y^1 = -2.0\n" +
                "-4.0 * x^1 + 2.0 * y^1 = 6.0\n"; // \u001B[34m fügt ANSI-Farbcodes hinzu

        assertEquals(expectedOutput, gradi.zeigeGleichungssystem());
    }
    
    @Test
    public void testGradientenVerfahrenKonvergenz() {
        // Setzen der erforderlichen Parameter und Startwerte
        gradi.setKoeffizientA(25.0);
        gradi.setKoeffizientB(2.0);
        gradi.setKoeffizientC(10.0);
        gradi.setKoeffizientD(-5.0);
        gradi.setKonstanteE(2022.0);
        gradi.setKonstanteF(0.0);
        gradi.setExponentN(2);
        gradi.setExponentM(2);
        gradi.setExponentS(2);
        gradi.setExponentT(1);
        gradi.setX(4.0); // Startwert für x
        gradi.setY(29.0); // Startwert für y

        // Aufrufen der gradientenVerfahren-Methode
        gradi.gradientenVerfahren();

        // Erwartete Werte
        double erwartetesX = 3.7963397623304638;
        double erwartetesY = 28.824427499332312;
        double toleranz = 1e-5; // Ein geeigneter Toleranzwert

        // Überprüfen, ob das Verfahren korrekt konvergiert ist
        assertTrue(Math.abs(gradi.getX() - erwartetesX) < toleranz, "x hat nicht wie erwartet konvergiert.");
        assertTrue(Math.abs(gradi.getY() - erwartetesY) < toleranz, "y hat nicht wie erwartet konvergiert.");
    }


    
    
    
    // ... Die restlichen Testmethoden ...
}