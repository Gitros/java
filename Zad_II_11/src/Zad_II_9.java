
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Zad_II_9 {
    public static void main(String[] args) {
        Komunikator okno = new Komunikator("Pierwszy komunikator");

        okno.init();
    }
}


class Komunikator extends JFrame implements ActionListener, KeyListener {

    JTextArea obszarChata;
    JTextField komunikat;
    JButton wyslij;

    public Komunikator(String t) {
        super(t);
    }

    void init() {
        setSize(750, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        obszarChata = new JTextArea(25, 60);
        obszarChata.setEditable(false);
        obszarChata.setFocusable(false);
        JScrollPane panelChata = new JScrollPane(obszarChata);
        komunikat = new JTextField(50);
        wyslij = new JButton("Wyślij");

        JPanel panelCentralny = new JPanel();
        JPanel panelDolny = new JPanel();

        panelCentralny.add(panelChata);
        panelDolny.add(komunikat);
        panelDolny.add(wyslij);

        add(panelCentralny, BorderLayout.CENTER);
        add(panelDolny, BorderLayout.SOUTH);

        wyslij.addActionListener(this);
        // komunikat.addKeyListener(this);

        for (var c : panelDolny.getComponents())
            c.addKeyListener(this);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        wyslij();
    }

    private void wyslij() {
        String wiadomosc = komunikat.getText();
        if (!wiadomosc.isBlank())
            obszarChata.append(wiadomosc + "\n");
        komunikat.setText("");
        komunikat.requestFocus();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER)
            wyslij();

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
