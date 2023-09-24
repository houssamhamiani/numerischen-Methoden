
import org.junit.Before;
import org.junit.Test;


import Jama.Matrix;
import static org.junit.Assert.*;

import java.io.PrintStream;
import java.io.ByteArrayOutputStream;



public class GesamtSchrittTest {
	
	
	
    private static final String ANSI_BLUE = "\u001B[34m";
    
	private GesamtSchritt gesamtSchritt;

    @Before
    public void setUp() {
        gesamtSchritt = new GesamtSchritt();
    }
    
    @Test
    public void testGeneriereMatrix() {
        int matrixSize = 3; // Ändere die Matrixgröße nach Bedarf

        Matrix matrix = gesamtSchritt.generiereMatrix(matrixSize);

        assertNotNull(matrix);
        assertEquals(matrixSize, matrix.getRowDimension());
        assertEquals(matrixSize, matrix.getColumnDimension());

        // Überprüfung der Diagonalendominanz
        assertTrue(gesamtSchritt.istDiagonalDominant(matrix));

        // Überprüfung der Singulärität
        assertFalse(gesamtSchritt.istMatrixSingular(matrix));
    }
    
    @Test
    public void testGeneriereVektor() {
        Matrix vektor = gesamtSchritt.generiereVektor(3); // Passen Sie die Größe nach Bedarf an
        assertNotNull(vektor);
        assertEquals(3, vektor.getRowDimension()); // Überprüfen Sie, ob die Vektorgröße korrekt ist
    }

    @Test
    public void testGeneriereNullVektor() {
        Matrix nullVektor = gesamtSchritt.generiereNullVektor(3); // Passen Sie die Größe nach Bedarf an
        assertNotNull(nullVektor);
        assertEquals(3, nullVektor.getRowDimension()); // Überprüfen Sie, ob die Vektorgröße korrekt ist
        for (int i = 0; i < nullVektor.getRowDimension(); i++) {
            assertEquals(0, nullVektor.get(i, 0), 0.001); // Überprüfen Sie, ob alle Elemente 0 sind (mit einer kleinen Toleranz)
        }
    }

    @Test
    public void testMacheDiagonalDominantDurchZeilenTausch() {
        double[][] testData = {{4, -1, 1}, {-1, 3, 2}, {2, 1, 5}};
        Matrix matrix = new Matrix(testData);
        Matrix diagonalDominantMatrix = gesamtSchritt.macheDiagonalDominantDurchZeilenTausch(matrix);
        assertTrue(gesamtSchritt.istDiagonalDominant(diagonalDominantMatrix)); // Überprüfen Sie, ob die resultierende Matrix diagonal dominant ist
    }
    
    @Test
    public void testIstDiagonalDominant() {
        GesamtSchritt gesamtSchritt = new GesamtSchritt();

        // Erstellen Sie eine diagonal dominante Matrix
        double[][] diagonalDominanteDaten = {{4, -1, 0}, {-1, 4, -1}, {0, -1, 4}};
        Matrix diagonalDominanteMatrix = new Matrix(diagonalDominanteDaten);

        // Überprüfen Sie, ob die Methode istDiagonalDominant die Matrix als diagonal dominant erkennt
        assertTrue(gesamtSchritt.istDiagonalDominant(diagonalDominanteMatrix));

        // Erstellen Sie eine nicht diagonal dominante Matrix
        double[][] nichtDiagonalDominanteDaten = {{0, 1, 0}, {2, 4, 2}, {0, 3, 1}};
        Matrix nichtDiagonalDominanteMatrix = new Matrix(nichtDiagonalDominanteDaten);

        // Überprüfen Sie, ob die Methode istDiagonalDominant die Matrix als nicht diagonal dominant erkennt
        assertFalse(gesamtSchritt.istDiagonalDominant(nichtDiagonalDominanteMatrix));
    }

    @Test
    public void testIstMatrixSingular() {
        GesamtSchritt gesamtSchritt = new GesamtSchritt();

        // Erstellen Sie eine reguläre (nicht singuläre) Matrix
        double[][] nichtSingulaereDaten = {{1, 2}, {3, 4}};
        Matrix nichtSingulaereMatrix = new Matrix(nichtSingulaereDaten);

        // Überprüfen Sie, ob die Methode istMatrixSingular die Matrix als nicht singulär erkennt
        assertFalse(gesamtSchritt.istMatrixSingular(nichtSingulaereMatrix));

        // Erstellen Sie eine singuläre Matrix
        double[][] singulaereDaten = {{1, 2}, {2, 4}};
        Matrix singulaereMatrix = new Matrix(singulaereDaten);

        // Überprüfen Sie, ob die Methode istMatrixSingular die Matrix als singulär erkennt
        assertTrue(gesamtSchritt.istMatrixSingular(singulaereMatrix));
    }

    @Test
    public void testDruckeMatrix() {
        GesamtSchritt gesamtSchritt = new GesamtSchritt();
        // Erstellen Sie eine Testmatrix
        double[][] matrixDaten = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        Matrix testMatrix = new Matrix(matrixDaten);

        // Umleitung der Standardausgabe zum Erfassen der gedruckten Ausgabe
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(baos));

        // Rufen Sie die Methode druckeMatrix auf
        gesamtSchritt.druckeMatrix(testMatrix);

        // Stellen Sie die Standardausgabe wieder her
        System.setOut(originalOut);

        // Tatsächliche Ausgabe
        String actualOutput = baos.toString();
        System.out.println("Tatsächliche Ausgabe:");
        System.out.println(actualOutput);

        // Angepasste erwartete Ausgabe
        String expectedOutput = String.format("1.0 2.0 3.0 %n4.0 5.0 6.0 %n7.0 8.0 9.0 %n");
        
        // Direkter Vergleich der angepassten erwarteten und tatsächlichen Ausgabe
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testDruckeVektor() {
        GesamtSchritt gesamtSchritt = new GesamtSchritt();
        // Erstellen Sie einen Testvektor
        double[][] vektorDaten = {{1}, {2}, {3}};
        Matrix testVektor = new Matrix(vektorDaten);

        // Umleitung der Standardausgabe zum Erfassen der gedruckten Ausgabe
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(baos));

        // Rufen Sie die Methode druckeVektor auf
        gesamtSchritt.druckeVektor(testVektor);

        // Stellen Sie die Standardausgabe wieder her
        System.setOut(originalOut);

        // Erwartete Ausgabe mit System.lineSeparator()
        String expectedOutput = "1.0" + System.lineSeparator() +
                                "2.0" + System.lineSeparator() +
                                "3.0" + System.lineSeparator();
        assertEquals(expectedOutput, baos.toString());
    }
    
    
    @Test
    public void testHoleDiagonalmatrix() {
        GesamtSchritt gesamtSchritt = new GesamtSchritt();

        // Erstellen Sie eine Testmatrix
        double[][] matrixDaten = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        Matrix testMatrix = new Matrix(matrixDaten);

        // Rufen Sie die Methode holeDiagonalmatrix auf
        Matrix diagonaleMatrix = gesamtSchritt.holeDiagonalmatrix(testMatrix);

        // Überprüfen Sie, ob die zurückgegebene Matrix die erwartete Größe hat
        int expectedSize = Math.min(testMatrix.getRowDimension(), testMatrix.getColumnDimension());
        assertEquals(expectedSize, diagonaleMatrix.getRowDimension());
        assertEquals(expectedSize, diagonaleMatrix.getColumnDimension());

        // Überprüfen Sie, ob die zurückgegebene Matrix tatsächlich eine Diagonalmatrix ist
        for (int i = 0; i < expectedSize; i++) {
            for (int j = 0; j < expectedSize; j++) {
                if (i == j) {
                    // Diagonalelemente sollten gleich sein
                    assertEquals(testMatrix.get(i, i), diagonaleMatrix.get(i, i), 0.001);
                } else {
                    // Alle anderen Elemente sollten 0 sein
                    assertEquals(0.0, diagonaleMatrix.get(i, j), 0.001);
                }
            }
        }
    }
    
    @Test
    public void testHoleElementeRechtsDerDiagonalen() {
        GesamtSchritt gesamtSchritt = new GesamtSchritt();

        // Erstellen Sie eine Testmatrix
        double[][] matrixDaten = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        Matrix testMatrix = new Matrix(matrixDaten);

        // Rufen Sie die Methode holeElementeRechtsDerDiagonalen auf
        Matrix ergebnisMatrix = gesamtSchritt.holeElementeRechtsDerDiagonalen(testMatrix);

        // Überprüfen Sie, ob die zurückgegebene Matrix die erwartete Größe hat
        int expectedRows = testMatrix.getRowDimension();
        int expectedCols = testMatrix.getColumnDimension();
        assertEquals(expectedRows, ergebnisMatrix.getRowDimension());
        assertEquals(expectedCols, ergebnisMatrix.getColumnDimension());

        // Überprüfen Sie, ob die Werte rechts der Hauptdiagonalen korrekt extrahiert wurden
        for (int i = 0; i < expectedRows; i++) {
            for (int j = i + 1; j < expectedCols; j++) {
                double expectedValue = matrixDaten[i][j];
                assertEquals(expectedValue, ergebnisMatrix.get(i, j), 0.001);
            }
        }
    }
    
    @Test
    public void testHoleElementeLinksDerDiagonalen() {
        GesamtSchritt gesamtSchritt = new GesamtSchritt();

        // Erstellen Sie eine Testmatrix
        double[][] matrixDaten = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        Matrix testMatrix = new Matrix(matrixDaten);

        // Rufen Sie die Methode holeElementeLinksDerDiagonalen auf
        Matrix ergebnisMatrix = gesamtSchritt.holeElementeLinksDerDiagonalen(testMatrix);

        // Überprüfen Sie, ob die zurückgegebene Matrix die erwartete Größe hat
        int expectedRows = testMatrix.getRowDimension();
        int expectedCols = testMatrix.getColumnDimension();
        assertEquals(expectedRows, ergebnisMatrix.getRowDimension());
        assertEquals(expectedCols, ergebnisMatrix.getColumnDimension());

        // Überprüfen Sie, ob die Werte links der Hauptdiagonalen korrekt extrahiert wurden
        for (int i = 0; i < expectedRows; i++) {
            for (int j = 0; j < i; j++) {
                double expectedValue = matrixDaten[i][j];
                assertEquals(expectedValue, ergebnisMatrix.get(i, j), 0.001);
            }
        }
    }
    
    
    
    @Test
    public void testBerechneT() {
        GesamtSchritt gesamtSchritt = new GesamtSchritt();

        // Erstellen Sie Matrizen ad, al und ar
        double[][] adData = {{4, 0}, {0, 3}}; // Beispielmatrix, die invertierbar ist
        double[][] alData = {{0, 0}, {1, 0}};
        double[][] arData = {{0, 2}, {0, 0}};
        
        Matrix ad = new Matrix(adData);
        Matrix al = new Matrix(alData);
        Matrix ar = new Matrix(arData);

        // Rufen Sie die Methode berechneT auf
        Matrix t = gesamtSchritt.berechneT(ad, al, ar);

        // Überprüfen Sie, ob die zurückgegebene Matrix nicht null ist
        assertNotNull(t);

        // Überprüfen Sie, ob die Größe der T-Matrix korrekt ist
        assertEquals(ad.getRowDimension(), t.getRowDimension());
        assertEquals(ad.getColumnDimension(), t.getColumnDimension());

        // Überprüfen Sie, ob die berechnete T-Matrix korrekt ist (je nach Ihren Berechnungen)
        // Beachten Sie, dass die genauen Werte von t von Ihren Eingabematrizen abhängen
        // und dass Sie die erwarteten Ergebnisse entsprechend anpassen müssen.
        double[][] expectedData = {{0, -0.5}, {-0.3333333333333333, 0}}; // Beispielwert für t basierend auf den Eingabematrizen
        Matrix expectedMatrix = new Matrix(expectedData);

        for (int i = 0; i < t.getRowDimension(); i++) {
            for (int j = 0; j < t.getColumnDimension(); j++) {
                assertEquals(expectedMatrix.get(i, j), t.get(i, j), 0.001);
            }
        }
    }
    
    @Test
    public void testIteriere() {
        GesamtSchritt gesamtSchritt = new GesamtSchritt();

        // Erstellen Sie Matrizen ad, b, T und x
        double[][] adData = {{2, 0}, {0, 3}}; // Beispielmatrix, die invertierbar ist
        double[][] bData = {{1}, {2}};
        double[][] TData = {{-1, 0}, {0, -1}};
        double[][] xData = {{0}, {0}};
        
        Matrix ad = new Matrix(adData);
        Matrix b = new Matrix(bData);
        Matrix T = new Matrix(TData);
        Matrix x = new Matrix(xData);

        int n = 100; // Anzahl der Iterationen

        // Rufen Sie die Methode iteriere auf
        Matrix ergebnis = gesamtSchritt.iteriere(ad, b, T, x, n);

        // Überprüfen Sie, ob die zurückgegebene Matrix nicht null ist
        assertNotNull(ergebnis);

        // Überprüfen Sie, ob die Größe der Ergebnismatrix korrekt ist
        assertEquals(b.getRowDimension(), ergebnis.getRowDimension());
        assertEquals(b.getColumnDimension(), ergebnis.getColumnDimension());
    
    }
    
    
    @Test
    public void testDruckeGleichungssystem() {
        GesamtSchritt gesamtSchritt = new GesamtSchritt();

        // Erstellen Sie eine Testmatrix A und einen Testvektor b
        double[][] aData = {{2, 1}, {3, 2}};
        double[][] bData = {{3}, {4}};

        Matrix A = new Matrix(aData);
        Matrix b = new Matrix(bData);

        // Umleitung der Standardausgabe zum Erfassen der gedruckten Ausgabe
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(baos));

        // Rufen Sie die Methode druckeGleichungssystem auf
        gesamtSchritt.druckeGleichungssystem(A, b);

        // Stellen Sie die Standardausgabe wieder her
        System.setOut(originalOut);

        // Tatsächliche Ausgabe
        String actualOutput = baos.toString();
        System.out.println("Tatsächliche Ausgabe:");
        System.out.println(actualOutput);

        // Erwartete Ausgabe
        String expectedOutput = ANSI_BLUE + "Gleichungssystem (x und b sind Vektoren):" + ANSI_BLUE + System.lineSeparator() +
                                ANSI_BLUE + "A * x = b" + ANSI_BLUE + System.lineSeparator() +
                                System.lineSeparator() +
                                "2.0 * x1 + 1.0 * x2 = 3.0" + System.lineSeparator() +
                                "3.0 * x1 + 2.0 * x2 = 4.0" + System.lineSeparator();

        // Direkter Vergleich der erwarteten und tatsächlichen Ausgabe
        assertEquals(expectedOutput, actualOutput);
    }
    
    
    @Test
    public void testGesaKonvergenz() {
        GesamtSchritt gesamtSchritt = new GesamtSchritt();

        /*
    	 * KonvergenzTest auch für größere Matrizen    	   
    	 */
        // Erstellen der Matrix A und des Vektors b aus dem gegebenen LGS
        double[][] aData = {
            {342.0, 51.0, 36.0, 22.0, -92.0, -4.0, 12.0},
            {65.0, 738.0, 2.0, 48.0, -76.0, 61.0, -40.0},
            {-33.0, 49.0, -453.0, 50.0, 76.0, -100.0, -74.0},
            {-4.0, -43.0, -91.0, -628.0, -47.0, -14.0, 72.0},
            {36.0, 34.0, -51.0, 4.0, -346.0, -16.0, -70.0},
            {41.0, 57.0, -56.0, -51.0, -33.0, 767.0, -54.0},
            {45.0, -38.0, -6.0, -86.0, -92.0, 85.0, 543.0}
        };
        double[][] bData = {
            {37.0},
            {36.0},
            {83.0},
            {76.0},
            {90.0},
            {50.0},
            {7.0}
        };
        Matrix A = new Matrix(aData);
        Matrix b = new Matrix(bData);

        Matrix ad = gesamtSchritt.holeDiagonalmatrix(A);
        Matrix al = gesamtSchritt.holeElementeLinksDerDiagonalen(A);
        Matrix ar = gesamtSchritt.holeElementeRechtsDerDiagonalen(A);
        Matrix T = gesamtSchritt.berechneT(ad, al, ar);

        Matrix startVektor = gesamtSchritt.generiereNullVektor(ad.getRowDimension());
        Matrix loesung = gesamtSchritt.iteriere(ad, b, T, startVektor, 50);

        assertNotNull(loesung);  // Überprüfen, ob eine Lösung zurückgegeben wird
        assertEquals(A.getRowDimension(), loesung.getRowDimension());  // Überprüfen der Größe der Lösung

        // Genauere Überprüfung der Lösungswerte
        double[] expectedSolution = {
            0.08000071995671729,
            0.02148181834379031,
            -0.22847472134293553,
            -0.08019371554658694,
            -0.20863502972394699,
            0.02503615758995166,
            -0.04672877955027873
        };
        for (int i = 0; i < expectedSolution.length; i++) {
            assertEquals(expectedSolution[i], loesung.get(i, 0), 0.001);  // 0.001 ist die Toleranz
        }
    }
    
   
    
    
    
    
    
    }
    
    
    
   
    
    






