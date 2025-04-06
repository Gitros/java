import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Zad_2_6 {
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

    // konstruktor
    Kalkulator(String t) {
        super(t);
    }

    // przygotownaie okna do wyświetlenia
    public void init() {

        // ustawienia ogólne okna
        setSize(1000, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // utworzenie i dodanie komponentów
        JLabel l1 = new JLabel("Operand 1: ");
        JLabel l2 = new JLabel("Operand 2: ");
        JLabel l3 = new JLabel("Przyciski operacji: ");
        JLabel l4 = new JLabel("Wynik operacji: ???");

        JTextField p1 = new JTextField(15);
        JTextField p2 = new JTextField(15);

        JButton dodajButton = new JButton(" + ");
        JButton odejmijButton = new JButton(" - ");
        JButton mnozButton = new JButton(" * ");

        // dodanie komponentów do okna
        add(l1);
        add(p1);
        add(l2);
        add(p2);
        add(l3);
        add(dodajButton);
        add(odejmijButton);
        add(mnozButton);
        add(l4);

    }


}
