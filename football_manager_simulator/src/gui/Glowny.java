package gui;

import model.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Glowny extends JFrame {

    private Zarzadzanie zarzadzanie;
    private JPanel NowyDzien;
    private JTextField dataText;
    private JTextField ligaText;
    private JTextField klubText;
    private JTextArea wynikiText;
    private JTextField nastepnyText;
    private JButton tabelaButton;
    private JButton zarzadzajButton;
    private JButton dzienButton;
    private JLabel dataLabel;
    private JLabel ligaLabel;
    private JLabel klubLabel;
    private JLabel nastepnyLabel;
    private JTextField kolejkaText;
    private JLabel kolejkaLabel;
    private JTextField trenerText;
    private JLabel trenerLabel;


    public Glowny(Zarzadzanie zarzadzanie) {

        setContentPane(NowyDzien);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setTitle("Menedżer piłkarski by Ryba & Kobosko");
        this.zarzadzanie = zarzadzanie;
        odswiez();

        dzienButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                zarzadzanie.nastepnydzien();
                wynikiText.setText(zarzadzanie.getLiga().getWynikikolejki());
                odswiez();
            }
        });
        tabelaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TabelaGUI tabela = new TabelaGUI(zarzadzanie);
            }
        });
        zarzadzajButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                NowyZarzadanie du = new NowyZarzadanie(Glowny.this);
                du.setVisible(true);
            }
        });
    }

    public Zarzadzanie getZarzadzanie() {
        return zarzadzanie;
    }

    public void odswiez() {

        dataText.setText(zarzadzanie.getData());
        kolejkaText.setText(Integer.toString(zarzadzanie.getKolejka()));
        ligaText.setText(zarzadzanie.getLiga().getNazwa());
        klubText.setText(zarzadzanie.getDruzyna().getNazwa());
        nastepnyText.setText("z " + nastepnymecz() + " za " + (7-zarzadzanie.getDni()) + " dni");
        trenerText.setText(zarzadzanie.getDruzyna().getTrener().getImie() + " " + zarzadzanie.getDruzyna().getTrener().getNazwisko());
    }
    public String nastepnymecz() {
        String t = "";
        for (Mecz mecz : zarzadzanie.getLiga().getTerminarz().getLista_meczy()) {

            if (mecz.getKolejka() == zarzadzanie.getKolejka() && mecz.getDruzyny().get(0) == zarzadzanie.getDruzyna()) {
                t = mecz.getDruzyny().get(1).getNazwa().trim();
                return t;
            } else if (mecz.getKolejka() == zarzadzanie.getKolejka() && mecz.getDruzyny().get(1) == zarzadzanie.getDruzyna()) {
                t = mecz.getDruzyny().get(0).getNazwa().trim();
                return t;
            }
        }
        return t;
    }
}