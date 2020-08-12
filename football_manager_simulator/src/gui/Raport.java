package gui;

import model.Zawodnik;

import javax.swing.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Raport extends JFrame {
    private JTextArea skladText;
    private JTextField formacjaText;
    private JTextField taktykaText;
    private JPanel p;

    public Raport(Glowny okno) {
        setContentPane(p);
        pack();
        setVisible(true);
        setTitle("Menedżer piłkarski by Ryba & Kobosko");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        skladText.setText("Zawodnik\t\t" + "Pozycja\t" +"Umiejętności\t" + "Dyspozycja\t\n");
        for (Zawodnik zawodnik : okno.getZarzadzanie().getDruzyna().getPierwszysklad()) {
            skladText.append(String.format("%-20s", zawodnik.getImie()) + "\t" + zawodnik.getPozycja() + "\t" + Math.floor(zawodnik.getSkill())
                    + "\t" + BigDecimal.valueOf(zawodnik.getDyspozycja()).setScale(2, RoundingMode.HALF_UP) + "\n");
        }

        if (okno.getZarzadzanie().getDruzyna().getFormacja() == 1) {
            formacjaText.setText("4-3-3");
        } else if (okno.getZarzadzanie().getDruzyna().getFormacja() == 2) {
            formacjaText.setText("4-4-2");
        } else {
            formacjaText.setText("5-3-2");
        }
        if (okno.getZarzadzanie().getDruzyna().getTaktyka() == 1) {
            taktykaText.setText("Defensywna");
        } else if (okno.getZarzadzanie().getDruzyna().getTaktyka() == 2) {
            taktykaText.setText("Ofensywna");
        } else {
            taktykaText.setText("Neutralna");
        }
    }
}

