import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class Zad_III_1 {
    public static void main(String[] args) {
        FileBrowser f = new FileBrowser();
        f.init();
        f.setVisible(true);
    }
}


class FileBrowser extends JFrame implements ActionListener {
    JTextField nazwa;
    JTextArea zawartosc;
    JButton wczytaj, zapisz;

    public FileBrowser() {
        super("File Browser");
    }

    public void init() {
        setSize(500, 450);
        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // setResizable(false);

        nazwa = new JTextField(20);
        zawartosc = new JTextArea(20, 40);
        zapisz = new JButton("Zapisz");
        zapisz.addActionListener(this);
        wczytaj = new JButton("Wczytaj");
        wczytaj.addActionListener(this);

        add(nazwa);
        add(wczytaj);
        add(zapisz);
        add(new JScrollPane(zawartosc));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // do uzupełnienia
        Object zrodlo = e.getSource();

        if (zrodlo == wczytaj) {
            String nazwaPliku = nazwa.getText();

            try {
                BufferedReader in =
                        new BufferedReader(new InputStreamReader(new FileInputStream(nazwaPliku)));

                String linia;
                while ((linia = in.readLine()) != null) {
                    zawartosc.append(linia);
                }
                in.close();
            } catch (IOException ex) {
                System.out.println(ex);
            }

        }
    }

}
