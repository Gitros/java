import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class KalkulatorVAT extends JFrame implements ActionListener {

    private JTextField poleNetto, poleBrutto, polePodatek;
    private JButton przyciskZNetto, przyciskZBrutto;
    private JRadioButton vat0, vat5, vat8, vat23;
    private ButtonGroup grupaVat;

    public KalkulatorVAT() {
        setTitle("Kalkulator biznesowy");
        setSize(450, 220);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panelStawki = new JPanel();
        panelStawki.setBorder(BorderFactory.createTitledBorder("stawki VAT:"));
        vat0 = new JRadioButton("0%");
        vat5 = new JRadioButton("5%");
        vat8 = new JRadioButton("8%");
        vat23 = new JRadioButton("23%", true);

        grupaVat = new ButtonGroup();
        grupaVat.add(vat0);
        grupaVat.add(vat5);
        grupaVat.add(vat8);
        grupaVat.add(vat23);

        panelStawki.add(vat0);
        panelStawki.add(vat5);
        panelStawki.add(vat8);
        panelStawki.add(vat23);

        JPanel panelSrodek = new JPanel(new GridLayout(3, 1, 5, 5));

        JPanel wiersz1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        wiersz1.add(new JLabel("Wartość netto:"));
        poleNetto = new JTextField(10);
        wiersz1.add(poleNetto);
        wiersz1.add(new JLabel("zł"));
        przyciskZNetto = new JButton("OBLICZ");
        przyciskZNetto.setForeground(Color.RED);
        przyciskZNetto.addActionListener(this);
        wiersz1.add(przyciskZNetto);

        JPanel wiersz2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        wiersz2.add(new JLabel("Wartość podatku:"));
        polePodatek = new JTextField(10);
        polePodatek.setEditable(false);
        wiersz2.add(polePodatek);
        wiersz2.add(new JLabel("zł"));

        JPanel wiersz3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        wiersz3.add(new JLabel("Wartość brutto:"));
        poleBrutto = new JTextField(10);
        wiersz3.add(poleBrutto);
        wiersz3.add(new JLabel("zł"));
        przyciskZBrutto = new JButton("OBLICZ");
        przyciskZBrutto.setForeground(Color.BLUE);
        przyciskZBrutto.addActionListener(this);
        wiersz3.add(przyciskZBrutto);

        panelSrodek.add(wiersz1);
        panelSrodek.add(wiersz2);
        panelSrodek.add(wiersz3);

        add(panelStawki, BorderLayout.NORTH);
        add(panelSrodek, BorderLayout.CENTER);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private double pobierzStawkeVAT() {
        if (vat0.isSelected())
            return 0.0;
        if (vat5.isSelected())
            return 0.05;
        if (vat8.isSelected())
            return 0.08;
        return 0.23;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            double vat = pobierzStawkeVAT();

            if (e.getSource() == przyciskZNetto) {
                double netto = Double.parseDouble(poleNetto.getText());
                double podatek = netto * vat;
                double brutto = netto + podatek;

                polePodatek.setText(String.format("%.2f", podatek));
                poleBrutto.setText(String.format("%.2f", brutto));
            } else if (e.getSource() == przyciskZBrutto) {
                double brutto = Double.parseDouble(poleBrutto.getText());
                double netto = brutto / (1 + vat);
                double podatek = brutto - netto;

                polePodatek.setText(String.format("%.2f", podatek));
                poleNetto.setText(String.format("%.2f", netto));
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Wprowadź poprawną wartość liczbową!",
                    "Błąd danych", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new KalkulatorVAT();
    }
}
