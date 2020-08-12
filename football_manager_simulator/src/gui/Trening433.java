package gui;

import model.Zawodnik;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Trening433 extends JFrame {
    private JPanel trenowanko;
    private JComboBox o2;
    private JComboBox o3;
    private JComboBox o1;
    private JComboBox o4;
    private JComboBox a1;
    private JComboBox a3;
    private JComboBox s1;
    private JComboBox s2;
    private JComboBox s3;
    private JComboBox a2;
    private JComboBox b1;
    private JLabel bramkaz;
    private JButton zatwierdz;

    public Trening433(Glowny okno, NowyZarzadanie gui) {

        setContentPane(trenowanko);
        pack();
        setTitle("Menedżer piłkarski by Ryba & Kobosko");
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        for (Zawodnik zawodnik : okno.getZarzadzanie().getDruzyna().getZawodnicy()) {
            if (zawodnik.getPozycja().equals("Goalkeeper")) {
                b1.addItem(zawodnik);
            }
        }
        for (Zawodnik zawodnik : okno.getZarzadzanie().getDruzyna().getZawodnicy()) {
            if (zawodnik.getPozycja().equals("Defender")) {
                o1.addItem(zawodnik);
            }
        }
        for (Zawodnik zawodnik : okno.getZarzadzanie().getDruzyna().getZawodnicy()) {
            if (zawodnik.getPozycja().equals("Defender")) {
                o2.addItem(zawodnik);
            }
        }
        for (Zawodnik zawodnik : okno.getZarzadzanie().getDruzyna().getZawodnicy()) {
            if (zawodnik.getPozycja().equals("Defender")) {
                o3.addItem(zawodnik);
            }
        }
        for (Zawodnik zawodnik : okno.getZarzadzanie().getDruzyna().getZawodnicy()) {
            if (zawodnik.getPozycja().equals("Defender")) {
                o4.addItem(zawodnik);
            }
        }
        for (Zawodnik zawodnik : okno.getZarzadzanie().getDruzyna().getZawodnicy()) {
            if (zawodnik.getPozycja().equals("Midfielder")) {
                s1.addItem(zawodnik);
            }
        }
        for (Zawodnik zawodnik : okno.getZarzadzanie().getDruzyna().getZawodnicy()) {
            if (zawodnik.getPozycja().equals("Midfielder")) {
                s2.addItem(zawodnik);
            }
        }
        for (Zawodnik zawodnik : okno.getZarzadzanie().getDruzyna().getZawodnicy()) {
            if (zawodnik.getPozycja().equals("Midfielder")) {
                s3.addItem(zawodnik);
            }
        }
        for (Zawodnik zawodnik : okno.getZarzadzanie().getDruzyna().getZawodnicy()) {
            if (zawodnik.getPozycja().equals("Forward")) {
                a3.addItem(zawodnik);
            }
        }
        for (Zawodnik zawodnik : okno.getZarzadzanie().getDruzyna().getZawodnicy()) {
            if (zawodnik.getPozycja().equals("Forward")) {
                a1.addItem(zawodnik);
            }
        }
        for (Zawodnik zawodnik : okno.getZarzadzanie().getDruzyna().getZawodnicy()) {
            if (zawodnik.getPozycja().equals("Forward")) {
                a2.addItem(zawodnik);
            }
        }
        b1.setSelectedItem(null);
        o1.setSelectedItem(null);
        o2.setSelectedItem(null);
        o3.setSelectedItem(null);
        o4.setSelectedItem(null);
        s1.setSelectedItem(null);
        s2.setSelectedItem(null);
        s3.setSelectedItem(null);
        a3.setSelectedItem(null);
        a1.setSelectedItem(null);
        a2.setSelectedItem(null);
        zatwierdz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Zawodnik c1 = (Zawodnik) b1.getSelectedItem();
                Zawodnik c2 = (Zawodnik) o1.getSelectedItem();
                Zawodnik c3 = (Zawodnik) o2.getSelectedItem();
                Zawodnik c4 = (Zawodnik) o3.getSelectedItem();
                Zawodnik c5 = (Zawodnik) o4.getSelectedItem();
                Zawodnik c6 = (Zawodnik) s1.getSelectedItem();
                Zawodnik c7 = (Zawodnik) s2.getSelectedItem();
                Zawodnik c8 = (Zawodnik) s3.getSelectedItem();
                Zawodnik c9 = (Zawodnik) a1.getSelectedItem();
                Zawodnik c10 = (Zawodnik) a2.getSelectedItem();
                Zawodnik c11 = (Zawodnik) a3.getSelectedItem();
                okno.getZarzadzanie().usunzeskladu();
                if (okno.getZarzadzanie().getDruzyna().getPierwszysklad().size() > 11) {
                    okno.getZarzadzanie().usunzeskladu();
                } else if (c1 != null && c2 != null && c3 != null && c4 != null && c5 != null && c6 != null && c7 != null && c8 != null && c9 != null && c10 != null && c11 != null) {
                    okno.getZarzadzanie().dodajdoskladu((Zawodnik) b1.getSelectedItem());
                    if (!o1.getSelectedItem().equals(o2.getSelectedItem()) && !o1.getSelectedItem().equals(o3.getSelectedItem()) && !o1.getSelectedItem().equals(o4.getSelectedItem())) {
                        okno.getZarzadzanie().dodajdoskladu((Zawodnik) o1.getSelectedItem());

                    } else {
                        okno.getZarzadzanie().usunzeskladu();
                        JOptionPane.showMessageDialog(trenowanko,
                                "Wybierz innego zawodnika",
                                "Warning",
                                JOptionPane.WARNING_MESSAGE);
                    }
                    if (!o2.getSelectedItem().equals(o1.getSelectedItem()) && !o2.getSelectedItem().equals(o3.getSelectedItem()) && !o2.getSelectedItem().equals(o4.getSelectedItem())) {
                        okno.getZarzadzanie().dodajdoskladu((Zawodnik) o2.getSelectedItem());
                    } else {
                        okno.getZarzadzanie().usunzeskladu();
                        JOptionPane.showMessageDialog(trenowanko,
                                "Wybierz innego zawodnika",
                                "Warning",
                                JOptionPane.WARNING_MESSAGE);
                    }
                    if (!o3.getSelectedItem().equals(o1.getSelectedItem()) && !o3.getSelectedItem().equals(o2.getSelectedItem()) && !o3.getSelectedItem().equals(o4.getSelectedItem())) {
                        okno.getZarzadzanie().dodajdoskladu((Zawodnik) o3.getSelectedItem());
                    } else {

                        okno.getZarzadzanie().usunzeskladu();
                        JOptionPane.showMessageDialog(trenowanko,
                                "Wybierz innego zawodnika",
                                "Warning",
                                JOptionPane.WARNING_MESSAGE);
                    }
                    if (!o4.getSelectedItem().equals(o1.getSelectedItem()) && !o4.getSelectedItem().equals(o3.getSelectedItem()) && !o4.getSelectedItem().equals(o2.getSelectedItem())) {
                        okno.getZarzadzanie().dodajdoskladu((Zawodnik) o4.getSelectedItem());
                    } else {
                        okno.getZarzadzanie().usunzeskladu();
                        JOptionPane.showMessageDialog(trenowanko,
                                "Wybierz innego zawodnika",
                                "Warning",
                                JOptionPane.WARNING_MESSAGE);
                    }
                    if (!s1.getSelectedItem().equals(s2.getSelectedItem()) && !s1.getSelectedItem().equals(s3.getSelectedItem())) {
                        okno.getZarzadzanie().dodajdoskladu((Zawodnik) s1.getSelectedItem());

                    } else {
                        okno.getZarzadzanie().usunzeskladu();
                        JOptionPane.showMessageDialog(trenowanko,
                                "Wybierz innego zawodnika",
                                "Warning",
                                JOptionPane.WARNING_MESSAGE);
                    }
                    if (!s2.getSelectedItem().equals(s1.getSelectedItem()) && !s2.getSelectedItem().equals(s3.getSelectedItem())) {
                        okno.getZarzadzanie().dodajdoskladu((Zawodnik) s2.getSelectedItem());
                    } else {
                        okno.getZarzadzanie().usunzeskladu();
                        JOptionPane.showMessageDialog(trenowanko,
                                "Wybierz innego zawodnika",
                                "Warning",
                                JOptionPane.WARNING_MESSAGE);
                    }
                    if (!s3.getSelectedItem().equals(s1.getSelectedItem()) && !s3.getSelectedItem().equals(s2.getSelectedItem())) {
                        okno.getZarzadzanie().dodajdoskladu((Zawodnik) s3.getSelectedItem());
                    } else {

                        okno.getZarzadzanie().usunzeskladu();
                        JOptionPane.showMessageDialog(trenowanko,
                                "Wybierz innego zawodnika",
                                "Warning",
                                JOptionPane.WARNING_MESSAGE);
                    }
                    if (!a1.getSelectedItem().equals(a2.getSelectedItem()) && !a1.getSelectedItem().equals(a3.getSelectedItem())) {
                        okno.getZarzadzanie().dodajdoskladu((Zawodnik) a1.getSelectedItem());

                    } else {
                        okno.getZarzadzanie().usunzeskladu();
                        JOptionPane.showMessageDialog(trenowanko,
                                "Wybierz innego zawodnika",
                                "Warning",
                                JOptionPane.WARNING_MESSAGE);
                    }
                    if (!a2.getSelectedItem().equals(a1.getSelectedItem()) && !a2.getSelectedItem().equals(a3.getSelectedItem())) {
                        okno.getZarzadzanie().dodajdoskladu((Zawodnik) a2.getSelectedItem());
                    } else {
                        okno.getZarzadzanie().usunzeskladu();
                        JOptionPane.showMessageDialog(trenowanko,
                                "Wybierz innego zawodnika",
                                "Warning",
                                JOptionPane.WARNING_MESSAGE);
                    }
                    if (!a3.getSelectedItem().equals(a1.getSelectedItem()) && !a3.getSelectedItem().equals(a2.getSelectedItem())) {
                        okno.getZarzadzanie().dodajdoskladu((Zawodnik) a3.getSelectedItem());
                    } else {

                        okno.getZarzadzanie().usunzeskladu();
                        JOptionPane.showMessageDialog(trenowanko,
                                "Wybierz innego zawodnika",
                                "Warning",
                                JOptionPane.WARNING_MESSAGE);
                    }

                    okno.getZarzadzanie().getDruzyna().siladruzyny();
                    gui.odswiez();
                } else {
                    JOptionPane.showMessageDialog(trenowanko,
                            "Wybierz 11 zawodników!",
                            "Warning",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });
    }
}
