package gui;

import javax.swing.*;

import model.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


public class NowyTrening extends JFrame {
    private JPanel pruum;
    private JComboBox<Zawodnik> zawodnicycombo;
    private JButton dodajButton;
    private JButton trenujButton;
    private JTextArea zawodnicyText;
    private JButton usunButton;
    private JComboBox<Zawodnik> usunzaw;
    private List<Zawodnik> dopodsumowanie;

    public List<Zawodnik> getDopodsumowanie() {
        return dopodsumowanie;
    }

    public NowyTrening(Glowny okno, NowyZarzadanie sila) {

        dopodsumowanie = new ArrayList<>();
        setContentPane(pruum);
        pack();
        setTitle("Menedżer piłkarski by Ryba & Kobosko");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);

        for (Zawodnik zawodnik : okno.getZarzadzanie().getDruzyna().getZawodnicy()) {
            zawodnicycombo.addItem(zawodnik);
        }
        zawodnicycombo.setSelectedItem(null);

        trenujButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (!okno.getZarzadzanie().isTrening() && okno.getZarzadzanie().getDotreningu().size() != 0) {
                    dopodsumowanie = new ArrayList<>(okno.getZarzadzanie().getDotreningu());
                    okno.getZarzadzanie().trening();
                    zawodnicyText.setText("Zawodnicy do treningu (możesz wybrać  maksymalnie 5):");
                    zawodnicycombo.removeAllItems();
                    for (Zawodnik zawodnik : okno.getZarzadzanie().getDruzyna().getZawodnicy()) {
                        zawodnicycombo.addItem(zawodnik);
                    }
                    sila.odswiez();
                    usunzaw.removeAllItems();
                    new Podsumowanie(NowyTrening.this);
                } else if (okno.getZarzadzanie().isTrening()) {
                    JOptionPane.showMessageDialog(pruum,
                            "Możesz wykonać tylko jeden trening w ciągu dnia!",
                            "Warning",
                            JOptionPane.WARNING_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(pruum,
                            "Wybierz zawodników, których chcesz trenować!",
                            "Warning",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });


        dodajButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (zawodnicycombo.getSelectedItem() != null) {
                    if (okno.getZarzadzanie().getDotreningu().size() < 5) {

                        okno.getZarzadzanie().dodajdotreningu((Zawodnik) zawodnicycombo.getSelectedItem());
                        usunzaw.addItem((Zawodnik) zawodnicycombo.getSelectedItem());
                        zawodnicyText.append("\n" + zawodnicycombo.getSelectedItem());
                        okno.getZarzadzanie().pozostali();
                        zawodnicycombo.removeAllItems();
                        for (Zawodnik zawodnik : okno.getZarzadzanie().getPozostali()) {
                            zawodnicycombo.addItem(zawodnik);
                        }
                    } else {
                        JOptionPane.showMessageDialog(pruum,
                                "Możesz trenować maksymalnie 5 zawodników naraz!",
                                "Warning",
                                JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        });


        usunButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                okno.getZarzadzanie().usunztreningu((Zawodnik) usunzaw.getSelectedItem());
                usunzaw.removeItem(usunzaw.getSelectedItem());
                zawodnicyText.setText("Zawodnicy do treningu (możesz wybrać  maksymalnie 5):");
                for (Zawodnik zawodnik : okno.getZarzadzanie().getDotreningu()) {
                    zawodnicyText.append("\n" + zawodnik);
                }
            }
        });


    }

}
