import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class App {
    public static void main(String[] args) {
        // utworzenie obiektu okna
        Kalkulator okno = new Kalkulator("Moj pierwszy kalkulator");

        // wywołanie init
        okno.init();


        // prezentacja okna na ekranie
        okno.setVisible(true);

    }
}


class Kalkulator extends JFrame {

    JTextField p1, p2;
    JLabel wynikLabel;

    Kalkulator(String t) {
        super(t);
    }

    public void init() {
        // ustawienia okna
        setSize(600, 140);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(2, 3, 5, 5));

        // Panel: Operand 1
        JPanel panel1 = new JPanel(new BorderLayout());
        JLabel l1 = new JLabel("Operand 1:");
        p1 = new JTextField();
        panel1.add(l1, BorderLayout.NORTH);
        panel1.add(p1, BorderLayout.CENTER);

        // Panel: Operand 2
        JPanel panel2 = new JPanel(new BorderLayout());
        JLabel l2 = new JLabel("Operand 2:");
        p2 = new JTextField();
        panel2.add(l2, BorderLayout.NORTH);
        panel2.add(p2, BorderLayout.CENTER);

        // Panel: Wynik
        JPanel panel3 = new JPanel(new BorderLayout());
        JLabel l3 = new JLabel("Wynik operacji:");
        wynikLabel = new JLabel(" ");
        wynikLabel.setForeground(Color.RED);
        wynikLabel.setFont(new Font("Arial", Font.BOLD, 14));
        panel3.add(l3, BorderLayout.NORTH);
        panel3.add(wynikLabel, BorderLayout.CENTER);

        // Przyciski
        JButton dodajButton = new JButton("+");
        JButton odejmijButton = new JButton("-");
        JButton mnozButton = new JButton("*");

        // obsługa przycisków
        dodajButton.addActionListener(e -> wykonajOperacje('+'));
        odejmijButton.addActionListener(e -> wykonajOperacje('-'));
        mnozButton.addActionListener(e -> wykonajOperacje('*'));

        // dodanie do okna
        add(panel1);
        add(panel2);
        add(panel3);
        add(dodajButton);
        add(odejmijButton);
        add(mnozButton);
    }

    private void wykonajOperacje(char operacja) {
        try {
            double a = Double.parseDouble(p1.getText().trim());
            double b = Double.parseDouble(p2.getText().trim());
            double wynik = switch (operacja) {
                case '+' -> a + b;
                case '-' -> a - b;
                case '*' -> a * b;
                default -> 0;
            };
            wynikLabel.setText("Wynik operacji: " + wynik);
        } catch (NumberFormatException e) {
            wynikLabel.setText("Wprowadź poprawne liczby!");
        }
    }
}
