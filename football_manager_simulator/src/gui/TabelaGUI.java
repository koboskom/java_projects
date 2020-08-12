package gui;

import model.Zarzadzanie;

import javax.swing.*;

public class TabelaGUI extends JFrame {
    private JTextArea textArea1;
    private JPanel panel1;
    Zarzadzanie zarzadzanie;

    public TabelaGUI(Zarzadzanie zarzadzanie) {
        this.zarzadzanie = zarzadzanie;
        setContentPane(panel1);
        pack();
        setTitle("Menedżer piłkarski by Ryba & Kobosko");

        setSize(1050, 500);
        setLocationRelativeTo(null);
        setVisible(true);
        textArea1.setText(zarzadzanie.getLiga().getTabela().pokaztabele());
    }
}
