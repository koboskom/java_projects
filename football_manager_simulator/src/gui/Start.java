package gui;

import model.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Start extends JFrame {

    private JFrame frame;
    private JPanel panel1;
    private JTextArea powitanie;
    private JButton zacznij;
    private JLabel druzyna;
    private JLabel liga;
    private JComboBox ligacombo;
    private JComboBox druzynacombo;
    private Druzyna druzyna1;


    public Start() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setContentPane(panel1);
        pack();
        setTitle("Menedżer piłkarski by Ryba & Kobosko");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        model.Main main = new model.Main();
        main.wczytaj();
        ligacombo.addItem(main.getPremier());
        for (Druzyna druzyna : main.getPremier().getDruzyny()) {
            druzynacombo.addItem(druzyna);
        }
        setDruzyna1((Druzyna) druzynacombo.getSelectedItem());
        zacznij.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main.startgry((Liga) ligacombo.getSelectedItem(), (Druzyna) druzynacombo.getSelectedItem(), "2019-12-25");
                Glowny nd = new Glowny(main.getMoja());
                nd.setVisible(true);
                dispose();
            }
        });

    }

    public void setDruzyna1(Druzyna druzyna1) {
        this.druzyna1 = druzyna1;
    }

    public Druzyna getDruzyna1() {
        return druzyna1;
    }

    public static void main(String[] args) {

        new Start();

    }
}