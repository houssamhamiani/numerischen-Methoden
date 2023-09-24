
import java.util.Random;
import java.util.Scanner;

public class Gradi {
	
	public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    
    private double koeffizientA, koeffizientB, koeffizientC, koeffizientD, konstanteE, konstanteF;
    private int exponentN, exponentM, exponentS, exponentT;
    private double x;
    private double y;
    
    public double getX() {
        return x;
    }

    public double getY() {
        
       
return y;
    }
    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }
    
    public double getKoeffizientA() {
        return koeffizientA;
    }

    public double getKoeffizientB() {
        return koeffizientB;
    }

    public double getKoeffizientC() {
        return koeffizientC;
    }

    public double getKoeffizientD() {
        return koeffizientD;
    }

    public double getKonstanteE() {
        return konstanteE;
    }

    public double getKonstanteF() {
        return konstanteF;
    }

    public int getExponentN() {
        return exponentN;
    }

    public int getExponentM() {
        return exponentM;
    }

    public int getExponentS() {
        return exponentS;
    }
    public int getExponentT() {
        return exponentT;
    }
    
    public void setKoeffizientA(double koeffizientA) {
        this.koeffizientA = koeffizientA;
    }

    public void setKoeffizientB(double koeffizientB) {
        this.koeffizientB = koeffizientB;
    }

    public void setKoeffizientC(double koeffizientC) {
        this.koeffizientC = koeffizientC;
    }

    public void setKoeffizientD(double koeffizientD) {
        this.koeffizientD = koeffizientD;
    }

    public void setKonstanteE(double konstanteE) {
        this.konstanteE = konstanteE;
    }

    public void setKonstanteF(double konstanteF) {
        this.konstanteF = konstanteF;
    }

    public void setExponentN(int exponentN) {
        this.exponentN = exponentN;
    }

    public void setExponentM(int exponentM) {
        this.exponentM = exponentM;
    }

    public void setExponentS(int exponentS) {
        this.exponentS = exponentS;
    }

    public void setExponentT(int exponentT) {
        this.exponentT = exponentT;
    }

    public Gradi(boolean automatisch) {
        if (automatisch) {
            generiereZufaelligeGleichungen();
        } else {
            manuelleEingabe(new Scanner(System.in));
        }

        zeigeGleichungssystem();

        if (ueberpruefeUnendlichVieleLoesungen()) {
            System.out.println(ANSI_RED + "Das Gleichungssystem hat unendlich viele Lösungen." + ANSI_RESET);
        } else if (ueberpruefeKeineLoesung()) {
            System.out.println(ANSI_RED + "Das Gleichungssystem hat keine Lösung." + ANSI_RESET);
        }
    }

    public void generiereZufaelligeGleichungen() {
        Random zufall = new Random();
        do {
            koeffizientA = zufall.nextInt(2001) - 1000;
            koeffizientB = zufall.nextInt(2001) - 1000;
            koeffizientC = zufall.nextInt(2001) - 1000;
            koeffizientD = zufall.nextInt(2001) - 1000;
        } while (koeffizientA == koeffizientC || koeffizientB == koeffizientD ||
                 (koeffizientB != 0 && koeffizientC != 0 && koeffizientA / koeffizientB == koeffizientC / koeffizientD) ||
                 (koeffizientA != 0 && koeffizientC != 0 && koeffizientB / koeffizientD == koeffizientA / koeffizientC));
        
        exponentN = zufall.nextInt(2)+1;
        exponentM = zufall.nextInt(2)+1;
        exponentS = zufall.nextInt(2)+1;
        exponentT = zufall.nextInt(2)+1;
        konstanteE = zufall.nextInt(2001) - 1000;
        konstanteF = zufall.nextInt(2001) - 1000;
    }

    public boolean ueberpruefeUnendlichVieleLoesungen() {
        if (exponentN == 1 && exponentM == 1 && exponentS == 1 && exponentT == 1) {
            double verhaeltnisAB = (koeffizientB != 0) ? koeffizientA / koeffizientB : Double.MAX_VALUE;
            double verhaeltnisCD = (koeffizientD != 0) ? koeffizientC / koeffizientD : Double.MAX_VALUE;
            return verhaeltnisAB == verhaeltnisCD && konstanteE / koeffizientA == konstanteF / koeffizientC;
        }
        return false;
    }

    public boolean ueberpruefeKeineLoesung() {
        if (exponentN == 1 && exponentM == 1 && exponentS == 1 && exponentT == 1) {
            double verhaeltnisAB = (koeffizientB != 0) ? koeffizientA / koeffizientB : Double.MAX_VALUE;
            double verhaeltnisCD = (koeffizientD != 0) ? koeffizientC / koeffizientD : Double.MAX_VALUE;
            return verhaeltnisAB == verhaeltnisCD && konstanteE / koeffizientA != konstanteF / koeffizientC;
        }
        return false;
    }
    
    
    
    
    public void manuelleEingabe(Scanner scanner) {

        System.out.println(ANSI_RED+"Geben Sie koeffizientA ein:"+ANSI_RED);
        koeffizientA = scanner.nextDouble();
        System.out.println(ANSI_RED+"Geben Sie koeffizientB ein:"+ANSI_RED);
        koeffizientB = scanner.nextDouble();

        System.out.println(ANSI_RED+"Geben Sie koeffizientC ein:"+ANSI_RED);
        koeffizientC = scanner.nextDouble();

        System.out.println(ANSI_RED+"Geben Sie koeffizientD ein:"+ANSI_RED);
        koeffizientD = scanner.nextDouble();

        System.out.println(ANSI_GREEN+"Geben Sie konstanteE ein:"+ANSI_GREEN);
        konstanteE = scanner.nextDouble();

        System.out.println(ANSI_GREEN+"Geben Sie konstanteF ein:"+ANSI_GREEN);
        konstanteF = scanner.nextDouble();

        System.out.println(ANSI_PURPLE+"Geben Sie exponentN ein:"+ANSI_PURPLE);
        exponentN = scanner.nextInt();

        System.out.println(ANSI_PURPLE+"Geben Sie exponentM ein:"+ANSI_PURPLE);
        exponentM = scanner.nextInt();

        System.out.println(ANSI_PURPLE+"Geben Sie exponentS ein:"+ANSI_PURPLE);
        exponentS = scanner.nextInt();

        System.out.println(ANSI_PURPLE+"Geben Sie exponentT ein:"+ANSI_PURPLE);
        exponentT = scanner.nextInt();
        
    }
    
    public String zeigeGleichungssystem() {
        StringBuilder output = new StringBuilder();
        output.append(ANSI_BLUE).append("Verwendetes Gleichungssystem:").append(ANSI_BLUE).append("\n");
        output.append(koeffizientA).append(" * x^").append(exponentN).append(" + ").append(koeffizientB)
                .append(" * y^").append(exponentM).append(" = ").append(konstanteE).append("\n");
        output.append(koeffizientC).append(" * x^").append(exponentS).append(" + ").append(koeffizientD)
                .append(" * y^").append(exponentT).append(" = ").append(konstanteF).append("\n");
        return output.toString();
    }

    public void gradientenVerfahren() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(ANSI_YELLOW + "Möchten Sie den Startvektor automatisch generieren? (ja/nein)" + ANSI_YELLOW);
        String antwort = scanner.nextLine();
        System.out.println(ANSI_BLUE + "Wie viele Iterationen möchten Sie durchführen?" + ANSI_BLUE);
        int anzahlIterationen = scanner.nextInt();
        scanner.nextLine(); // Um den Zeilenumbruch zu entfernen

        if ("ja".equalsIgnoreCase(antwort)) {
            x = (koeffizientA != 0) ? Math.pow(Math.abs(konstanteE / koeffizientA), 1.0 / exponentN) : 0;
            y = (koeffizientB != 0) ? Math.pow(Math.abs(konstanteE / koeffizientB), 1.0 / exponentM) : 0;
        } else {
            System.out.println(ANSI_PURPLE + "Geben Sie den Startwert für x ein:" + ANSI_PURPLE);
            x = scanner.nextDouble();

            System.out.println(ANSI_PURPLE + "Geben Sie den Startwert für y ein:" + ANSI_PURPLE);
            y = scanner.nextDouble();
        }
        double vorherigesX = x, vorherigesY = y;

        System.out.println(ANSI_GREEN + "Durchschnittlicher Startpunkt (x,y): (" + ANSI_GREEN + x + ", " + y + ")");

        // Definieren Sie eine Schwelle für die Änderung der Parameter
        double parameterAenderungsSchwelle = 1e-6;

        for (int i = 0; i < anzahlIterationen; i++) {
            double fxy = koeffizientA * Math.pow(x, exponentN) + koeffizientB * Math.pow(y, exponentM) - konstanteE;
            System.out.println("f(x,y): " + fxy);
            double gxy = koeffizientC * Math.pow(x, exponentS) + koeffizientD * Math.pow(y, exponentT) - konstanteF;
            System.out.println("g(x,y): " + gxy);

            double Qxy = Math.pow(fxy, 2) + Math.pow(gxy, 2);
            System.out.println("Q(x,y): " + Qxy);

            double fx = (exponentN != 0) ? exponentN * koeffizientA * Math.pow(x, exponentN - 1) : 0;
            System.out.println(ANSI_RED + "Ableitung von f bezüglich x: " + ANSI_RED + fx);
            double gx = (exponentS != 0) ? exponentS * koeffizientC * Math.pow(x, exponentS - 1) : 0;
            System.out.println(ANSI_GREEN + "Ableitung von g bezüglich x: " + ANSI_GREEN + gx);
            double fy = (exponentM != 0) ? exponentM * koeffizientB * Math.pow(y, exponentM - 1) : 0;
            System.out.println(ANSI_RED + "Ableitung von f bezüglich y: " + ANSI_RED + fy);
            double gy = (exponentT != 0) ? exponentT * koeffizientD * Math.pow(y, exponentT - 1) : 0;
            System.out.println(ANSI_GREEN + "Ableitung von g bezüglich y: " + ANSI_GREEN + gy);

            double Qx = 2 * fxy * fx + 2 * gxy * gx;
            System.out.println(ANSI_BLUE + "Ableitung von Q bezüglich x: " + ANSI_BLUE + Qx);
            double Qy = 2 * fxy * fy + 2 * gxy * gy;
            System.out.println(ANSI_BLUE + "Ableitung von Q bezüglich y: " + ANSI_BLUE + Qy);

            if (Qx == 0 && Qy == 0) {
                System.out.println("Gradientenverfahren nicht anwendbar, da sonst durch 0 geteilt wird");
                break;
            }

            x = x - (Qxy / (Qx * Qx + Qy * Qy)) * Qx;
            y = y - (Qxy / (Qx * Qx + Qy * Qy)) * Qy;

            System.out.println(ANSI_PURPLE + "Nach Iteration " + ANSI_PURPLE + (i + 1) + ":");
            System.out.println("x: " + x + ", y: " + y);

            // Berechnen Sie die Änderung der Parameter
            double aenderungX = Math.abs(x - vorherigesX);
            double aenderungY = Math.abs(y - vorherigesY);

            // Überprüfen Sie, ob die Änderung der Parameter unter der Schwelle liegt
            if (aenderungX < parameterAenderungsSchwelle && aenderungY < parameterAenderungsSchwelle) {
                System.out.println("Die Lösung hat konvergiert nach " + (i + 1) + " Iterationen.");
                break;
            }

            vorherigesX = x;
            vorherigesY = y;
        }
    }
    
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(ANSI_BLUE+"Möchten Sie das Gleichungssystem automatisch generieren? Nur für (ja/nein)"+ANSI_BLUE);
        String antwort = scanner.nextLine();

        boolean automatisch = "ja".equalsIgnoreCase(antwort);
        Gradi gradiObj = new Gradi(automatisch);
        String gleichungssystem = gradiObj.zeigeGleichungssystem();
        System.out.println(gleichungssystem); // Gleichungssystem ausgeben
        gradiObj.gradientenVerfahren(); // Rufen Sie die Methode hier auf
    }

    }