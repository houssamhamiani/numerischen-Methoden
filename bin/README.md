# Mathematisches Programmieren Projekt

## Beschreibung

In diesem Java-Projekt werden verschiedene numerische Methoden zur Verfügung gestellt. Die GesamtSchritt.java-Klasse steht für die numerische Lösung linearer Gleichungssysteme. Die Gradi.java-Klasse steht für die numerische Lösung von nicht linearen Gleichungssystemen, wobei diese Klasse sich ausschließlich auf 2 Gleichungen mit 2 Variablen beschränkt. Die Horne.java-Klasse ist in der Lage, gegebene Polynonfunktionen in gesuchte Polynomfunktionen mithilfe des Hornerschemas umzuwandeln. Das Projekt stellt eine nützliche Quelle für Studierende, Wissenschaftler und alle dar, die ein Interesse an der praktischen Umsetzung numerischer Methoden haben.

## Struktur des Repositorys

classpath und .project: Konfigurationsdateien für Eclipse.

.settings: Enthält Eclipse-spezifische Einstellungen.

bin/: Enthält kompilierte Java-Klassen.

java/com/simplilearn/mavenproject/: Enthält Java-Testklassen.

src/: Enthält den Java-Quellcode und die Maven-Konfigurationsdatei (pom.xml).



README.md: Die Hauptdokumentation des Projekts.

GesamtSchritt.java: Implementiert das Gesamtschrittverfahren zur numerischen Lösung von linearen Gleichungssystemen. Nutzt die Jama-Bibliothek für Matrixoperationen und stellt Methoden zur Generierung von Matrizen, Vektoren und zur Iteration bereit.

Gradi.java: Eine Klasse, die sich auf das Gradientenverfahren zur Lösung von Gleichungssystemen konzentriert. Sie bietet Funktionen zur Generierung von Gleichungen, Überprüfung der Lösbarkeit und Durchführung des Gradientenverfahrens.

Horne.java: Implementiert das Horner-Schema zur effizienten Auswertung von Polynomen. Ermöglicht die schnelle Berechnung von Polynomwerten an gegebenen Stellen.

Verfahren.java: Diese zentrale Klasse stellt eine Schnittstelle bereit, über die die anderen Klassen und ihre spezifischen Funktionen aufgerufen werden können. Durch die Koordination der verschiedenen numerischen Ansätze ermöglicht Verfahren.java eine flexible und effiziente Anwendung der bereitgestellten Methoden.
## Abhängigkeiten

- Java Development Kit (JDK)
- Jama-1.0.3 Bibliothek

## Installation und Ausführung

1. Klonen Sie das Repository.
   ```
   git clone https://github.com/houssamhamiani/numerischen-Methoden.git
   ```
2. Öffnen Sie das Projekt in Ihrer bevorzugten IDE.

3. Bauen und starten Sie das Projekt.

## GesamtSchritt.java

### Methoden


- `generiereMatrix(int m)`: Generiert eine quadratische Matrix der Größe m x m.
- `generiereVektor(int m)`: Generiert einen Vektor der Größe m.
- `generiereNullVektor(int m)`: Generiert einen Nullvektor der Größe m.
- `macheDiagonalDominantDurchZeilenTausch(Matrix matrix)`: Versucht, die Matrix diagonal dominant zu machen, indem Zeilen vertauscht werden.
- `istDiagonalDominant(Matrix matrix)`: Überprüft, ob die Matrix diagonal dominant ist.
- `istMatrixSingular(Matrix matrix)`: Überprüft, ob die Matrix singulär ist.
- `druckeMatrix(Matrix matrix)`: Druckt die Matrix.
- `druckeVektor(Matrix vektor)`: Druckt den Vektor.
- `holeDiagonalmatrix(Matrix matrix)`: Gibt die Diagonalmatrix zurück.
- `holeElementeRechtsDerDiagonalen(Matrix matrix)`: Gibt die Matrixelemente rechts der Diagonalen zurück.
- `holeElementeLinksDerDiagonalen(Matrix matrix)`: Gibt die Matrixelemente links der Diagonalen zurück.
- `berechneT(Matrix ad, Matrix al, Matrix ar)`: Berechnet die Matrix T.
- `iteriere(Matrix ad, Matrix b, Matrix T, Matrix x, int n)`: Führt die Iteration durch, um das lineare Gleichungssystem zu lösen.
- `druckeGleichungssystem(Matrix A, Matrix b)`: Druckt das Gleichungssystem.
- `main(String[] args)`:
Die Hauptmethode dient als Einstiegspunkt für das Programm und bietet eine interaktive Benutzeroberfläche für den Benutzer.

Matrix- und Vektoreingabe: Zunächst wird der Benutzer gefragt, ob er die Matrix und den Vektor manuell eingeben oder automatisch generieren lassen möchte.

Überprüfung der Matrix: Nachdem die Matrix und der Vektor eingegeben oder generiert wurden, überprüft das Programm, ob die Matrix diagonal dominant ist. Wenn sie nicht diagonal dominant ist, versucht das Programm, sie durch Zeilentausch diagonal dominant zu machen.

Lösung des Gleichungssystems: Anschließend wird das Gesamtschrittverfahren angewendet, um das lineare Gleichungssystem zu lösen. Das Programm führt Iterationen durch, bis eine Lösung gefunden wird oder die maximale Anzahl von Iterationen erreicht ist.

Ausgabe der Ergebnisse: Schließlich gibt das Programm das resultierende Gleichungssystem und die Lösung aus.

### Verwendung

Dieses Programm eignet sich, um sich ein Bild zu machen, nach wie vielen Iterationen des Gesamtschrittverfahrens die Lösung konvergiert. 

---

# Gradi Java Klasse


## Methoden

- `Gradi(boolean automatisch)`

Der Konstruktor der Klasse. Wenn `automatisch` auf `true` gesetzt ist, wird ein zufälliges Gleichungssystem generiert. Andernfalls wird der Benutzer zur manuellen Eingabe aufgefordert.

- `generiereZufaelligeGleichungen()`

Generiert zufällige Koeffizienten und Konstanten für das Gleichungssystem.

- `ueberpruefeUnendlichVieleLoesungen()`

Überprüft, ob das Gleichungssystem unendlich viele Lösungen hat.

- `ueberpruefeKeineLoesung()`

Überprüft, ob das Gleichungssystem keine Lösung hat.

- `manuelleEingabe()`

Ermöglicht die manuelle Eingabe der Koeffizienten, Konstanten und Exponenten für das Gleichungssystem.

- `zeigeGleichungssystem()`

Zeigt das aktuelle Gleichungssystem an.

- `gradientenVerfahren()`

Führt das Gradientenverfahren zur Lösung des Gleichungssystems durch.

## Verwendung

Die Hauptmethode `main` bietet eine Benutzeroberfläche, um entweder ein Gleichungssystem manuell einzugeben oder es automatisch generieren zu lassen. Anschließend wird das Gradientenverfahren angewendet, um das Gleichungssystem zu lösen.

# Horne Java Klasse


## Methoden

- `urspruenglichesPolynomAlsString(double[] koeffizienten)`: Diese Methode konvertiert ein gegebenes Array von Koeffizienten in einen String, der das zugehörige Polynom repräsentiert. Dies ermöglicht eine klare Darstellung des Polynoms in seiner Standardform.

- `zuEntwickelndesPolynomAlsString(double[] nullstellen)`: Diese Methode nimmt die Nullstellen des Polynoms als Eingabe und gibt einen String zurück, der das Polynom in einer Form darstellt, die die Nullstellen und die zugehörigen Alphas enthält. Dies ist nützlich, um zu visualisieren, wie das Polynom in Bezug auf seine Nullstellen strukturiert ist.

- `lesePositiveGanzzahl(Scanner scanner)`: Liest eine positive Ganzzahl von der Eingabeaufforderung.

- `leseGleitkommazahl(Scanner scanner)`: Liest eine Gleitkommazahl von der Eingabeaufforderung.

Hauptmethode:
- `main(String[] args)`: Die Hauptmethode dient als Benutzeroberfläche für die Anwendung des Horner-Schemas. Der Benutzer hat die Wahl, die Koeffizienten des Polynoms manuell einzugeben oder sie automatisch generieren zu lassen. Basierend auf dieser Auswahl wird das Polynom erstellt und das Horner-Schema angewendet. Die Methode zeigt dann die Horner-Tabelle an, die die schrittweise Auswertung des Polynoms anzeigt. Schließlich werden die berechneten Alphas und das entwickelte Polynom präsentiert.

### Anwendung des Horner-Schemas
Für jede Nullstelle des Polynoms wird das Schema wie folgt angewendet:
1. Der erste Eintrag der aktuellen Zeile ist immer der erste Eintrag der vorherigen Zeile.
2. Jeder nachfolgende Eintrag wird berechnet, indem der aktuelle Wert der vorherigen Zeile mit der
Nullstelle multipliziert und zum nächsten Wert der vorherigen Zeile addiert wird.
3. Dies wird fortgesetzt, bis alle Einträge der aktuellen Zeile berechnet sind.
4. Die nächste Zeile wird dann mit den berechneten Werten dieser Zeile initiiert.

# Verfahren Java Klasse


## Methoden

- `createButton(String text)`: Erstellt und gibt einen JButton mit dem angegebenen Text zurück. Der Button hat ein vordefiniertes Aussehen und Schriftart.

- `displayInfo(String verfahren)`: Zeigt dem Benutzer eine Informationsnachricht über das ausgewählte Verfahren. Es enthält eine kurze Beschreibung des Verfahrens und fragt den Benutzer, ob er fortfahren möchte.

- `handleSelection(String verfahren)`: Ruft das ausgewählte Verfahren basierend auf dem vom Benutzer gewählten Button auf.

Hauptmethode:
- `main(String[] args)`: Die Hauptmethode initialisiert ein JFrame-Fenster mit einer Benutzeroberfläche, die drei Buttons enthält: "Gradi Verfahren", "GesamtSchritt Verfahren" und "Horne Verfahren". Jeder Button repräsentiert ein spezifisches numerisches Verfahren. Wenn ein Button geklickt wird, wird dem Benutzer eine kurze Beschreibung des Verfahrens angezeigt und er wird gefragt, ob er fortfahren möchte. Bei Zustimmung wird das ausgewählte Verfahren aufgerufen.









