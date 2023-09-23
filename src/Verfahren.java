
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class Verfahren {

	private static final Map<String, String> INFO_MAP = new HashMap<String, String>() {{
	    put("Gradi", "Das Gradienten-Verfahren ist geeignet für die numerische Berechnung\nvon nicht linearen Gleichungssystemen. Dabei beschränken wir uns in diesem\nProgramm auf 2 Gleichungen mit 2 Variabeln .");
	    put("GesamtSchritt", "Das GesamtSchritt-Verfahren ist ein numerisches Verfahren für die\nBerechnung von linearen Gleichungssystemen. Dabei entscheidet man selbst,\nwie oft iteriert werden soll. Das Programm eignet sich zusätzlich für die\nBeobachtung der Konvergenz.");
	    put("Horne", "Das Horner-Schema ist ein numerisches Schema, um gegebene Polynome\nin gesuchte Polynome umzuwandeln.");
	}};

    private static final Map<String, Consumer<String[]>> ACTION_MAP = new HashMap<String, Consumer<String[]>>() {{
        put("Gradi", args -> Gradi.main(args));
        put("GesamtSchritt", args -> GesamtSchritt.main(args));
        put("Horne", args -> Horne.main(args));
    }};

    public static void main(String[] args) {
        JFrame frame = new JFrame("Verfahren Auswahl");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 250);
        frame.getContentPane().setBackground(new Color(52, 73, 94));

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1, 10, 10));
        panel.setBackground(new Color(52, 73, 94));

        JButton btnGradi = createButton("Gradi Verfahren");
        JButton btnGesamtSchritt = createButton("GesamtSchritt Verfahren");
        JButton btnHorne = createButton("Horne Verfahren");

        panel.add(btnGradi);
        panel.add(btnGesamtSchritt);
        panel.add(btnHorne);

        frame.add(panel);

        btnGradi.addActionListener(e -> displayInfo("Gradi"));
        btnGesamtSchritt.addActionListener(e -> displayInfo("GesamtSchritt"));
        btnHorne.addActionListener(e -> displayInfo("Horne"));

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 16));
        button.setBackground(new Color(46, 204, 113));
        button.setForeground(Color.WHITE);
        return button;
    }

    private static void displayInfo(String verfahren) {
        String infoMessage = INFO_MAP.getOrDefault(verfahren, "Keine Informationen verfügbar.");
        int result = JOptionPane.showConfirmDialog(null, infoMessage + "\nMöchten Sie fortfahren?", verfahren + " Info", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            handleSelection(verfahren);
        }
    }

    private static void handleSelection(String verfahren) {
        ACTION_MAP.getOrDefault(verfahren, args -> {}).accept(new String[]{});
    }
}