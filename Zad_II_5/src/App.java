
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class App {
    public static void main(String[] args) {
        Przepowiednia okno = new Przepowiednia("Przepowiednia");
        okno.init();
    }
}


class Przepowiednia extends JFrame implements ActionListener, KeyListener {
    JTextArea poleWyniku;
    JButton przyciskPrzepowiedz, przyciskZamknij;
    String[] przepowiednie = {"Zostaniesz programistą Javy, ale musisz się dużo uczyć",
            "Jeszcze długa droga przed tobą", "Każdy problem da się rozwiązać",
            "Wszędzie jest programowanie"};



    Color[] kolory = {Color.cyan, Color.green, Color.orange, new Color(144, 238, 144)};

    Random los = new Random();

    public Przepowiednia(String t) {
        super(t);
    }

    void init() {
        setSize(500, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        poleWyniku = new JTextArea(4, 40);
        poleWyniku.setEditable(false);
        poleWyniku.setLineWrap(true);
        poleWyniku.setWrapStyleWord(true);
        poleWyniku.setBackground(kolory[0]);
        poleWyniku.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        JScrollPane scrollPane = new JScrollPane(poleWyniku);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        add(scrollPane, BorderLayout.CENTER);

        przyciskPrzepowiedz = new JButton("Podaj przepowiednię");
        przyciskZamknij = new JButton("Zamknij");

        przyciskPrzepowiedz.addActionListener(this);
        przyciskZamknij.addActionListener(e -> System.exit(0));

        przyciskPrzepowiedz.addKeyListener(this);
        przyciskZamknij.addKeyListener(this);

        JPanel panelDolny = new JPanel();

        panelDolny.add(przyciskPrzepowiedz);
        panelDolny.add(przyciskZamknij);

        add(panelDolny, BorderLayout.SOUTH);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        pokazPrzepowiednie();
    }

    private void pokazPrzepowiednie() {
        int i = los.nextInt(przepowiednie.length);
        poleWyniku.setText(przepowiednie[i]);

        int k = los.nextInt(kolory.length);
        poleWyniku.setBackground(kolory[k]);

        poleWyniku.requestFocus();
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER)
            pokazPrzepowiednie();
    }

    @Override
    public void keyReleased(KeyEvent e) {}
}
