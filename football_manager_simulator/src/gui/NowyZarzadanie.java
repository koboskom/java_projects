package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class NowyZarzadanie extends JFrame {

    private JPanel pr;
    private JTextField ZARZADZANIETextField;
    private JComboBox<String> combotaktyka;
    private JComboBox<String> comboformacja;
    private JButton trenujButton;
    private JButton skladButton;
    private JLabel taktykaLabel;
    private JLabel formacjaLabel;
    private JTextField silaText;
    private JLabel silaLabel;
    private JButton raportButton;
    private Glowny okno;

    public NowyZarzadanie(Glowny okno) {
        this.okno = okno;
        setContentPane(pr);
        pack();
        setVisible(true);
        setTitle("Menedżer piłkarski by Ryba & Kobosko");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        comboformacja.addItem("4-3-3");
        comboformacja.addItem("4-4-2");
        comboformacja.addItem("5-3-2");

        combotaktyka.addItem("defensywna");
        combotaktyka.addItem("ofensywna");
        combotaktyka.addItem("neutralna");
        odswiez();

        comboformacja.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (comboformacja.getSelectedIndex() == 0) {
                    okno.getZarzadzanie().formacja(1);
                } else if (comboformacja.getSelectedIndex() == 1) {
                    okno.getZarzadzanie().formacja(2);
                } else if (comboformacja.getSelectedIndex() == 2) {
                    okno.getZarzadzanie().formacja(3);
                }
            }
        });


        trenujButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                NowyTrening nt = new NowyTrening(okno, NowyZarzadanie.this);
            }
        });
        skladButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (comboformacja.getSelectedIndex() == 0) {
                    Trening433 dr = new Trening433(okno, NowyZarzadanie.this);
                    dr.setVisible(true);
                }
                if (comboformacja.getSelectedIndex() == 1) {
                    Trening442 dz = new Trening442(okno, NowyZarzadanie.this);
                    dz.setVisible(true);
                }
                if (comboformacja.getSelectedIndex() == 2) {
                    Trening532 dt = new Trening532(okno, NowyZarzadanie.this);
                    dt.setVisible(true);
                }
            }
        });
        combotaktyka.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (combotaktyka.getSelectedIndex() == 0) {
                    okno.getZarzadzanie().taktyka(1);
                } else if (combotaktyka.getSelectedIndex() == 1) {
                    okno.getZarzadzanie().taktyka(2);
                } else if (combotaktyka.getSelectedIndex() == 2) {
                    okno.getZarzadzanie().taktyka(0);
                }
            }
        });
        raportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Raport r = new Raport(okno);
            }
        });
    }


    public void odswiez() {

        double sila = okno.getZarzadzanie().getDruzyna().getSiladruzyny();
        double sila_text = BigDecimal.valueOf(sila).setScale(2, RoundingMode.HALF_UP).doubleValue();
        silaText.setText(Double.toString(sila_text));
    }


}




