package gui;

import javax.swing.*;

public class Podsumowanie extends JFrame {
    private JTextField pierwszyText;
    private JTextField drugiText;
    private JTextField trzeciText;
    private JTextField czwartyText;
    private JTextField piatyText;
    private JProgressBar progressBar1;
    private JProgressBar progressBar2;
    private JProgressBar progressBar3;
    private JProgressBar progressBar4;
    private JProgressBar progressBar5;
    private JPanel p;
    private JTextField rezultatyTreninguTextField;
    private JLabel min1;
    private JLabel max1;
    private JLabel min2;
    private JLabel max2;
    private JLabel min3;
    private JLabel max3;
    private JLabel min4;
    private JLabel max4;
    private JLabel min5;
    private JLabel max5;

    public Podsumowanie(NowyTrening gui) {
        setContentPane(p);
        pack();
        setVisible(true);
        setTitle("Menedżer piłkarski by Ryba & Kobosko");
        setSize(800, 600);
        setLocationRelativeTo(null);
        int a = gui.getDopodsumowanie().size();
        switch (a) {
            case 1:
                pierwszyText.setText(gui.getDopodsumowanie().get(0).getImie());
                progressBar1.setMaximum((int) ((Math.floor(gui.getDopodsumowanie().get(0).getSkill())) * 100) + 100);
                progressBar1.setMinimum((int) (Math.floor(gui.getDopodsumowanie().get(0).getSkill())) * 100);
                progressBar1.setValue((int) ((gui.getDopodsumowanie().get(0).getSkill()) * 100));
                progressBar1.setBorderPainted(true);
                min1.setText(String.valueOf(Math.floor(gui.getDopodsumowanie().get(0).getSkill())));
                max1.setText(String.valueOf(Math.floor(gui.getDopodsumowanie().get(0).getSkill()) + 1));
                min2.setVisible(false);
                max2.setVisible(false);
                min3.setVisible(false);
                max3.setVisible(false);
                min4.setVisible(false);
                max4.setVisible(false);
                min5.setVisible(false);
                max5.setVisible(false);
                break;
            case 2:
                pierwszyText.setText(gui.getDopodsumowanie().get(0).getImie());
                progressBar1.setMaximum((int) ((Math.floor(gui.getDopodsumowanie().get(0).getSkill())) * 100) + 100);
                progressBar1.setMinimum((int) (Math.floor(gui.getDopodsumowanie().get(0).getSkill())) * 100);
                progressBar1.setValue((int) ((gui.getDopodsumowanie().get(0).getSkill()) * 100));
                progressBar1.setBorderPainted(true);
                min1.setText(String.valueOf(Math.floor(gui.getDopodsumowanie().get(0).getSkill())));
                max1.setText(String.valueOf(Math.floor(gui.getDopodsumowanie().get(0).getSkill()) + 1));
                drugiText.setText(gui.getDopodsumowanie().get(1).getImie());
                progressBar2.setMaximum((int) ((Math.floor(gui.getDopodsumowanie().get(1).getSkill())) * 100) + 100);
                progressBar2.setMinimum((int) (Math.floor(gui.getDopodsumowanie().get(1).getSkill())) * 100);
                progressBar2.setValue((int) ((gui.getDopodsumowanie().get(1).getSkill()) * 100));
                progressBar2.setBorderPainted(true);
                min2.setText(String.valueOf(Math.floor(gui.getDopodsumowanie().get(1).getSkill())));
                max2.setText(String.valueOf(Math.floor(gui.getDopodsumowanie().get(1).getSkill()) + 1));
                min3.setVisible(false);
                max3.setVisible(false);
                min4.setVisible(false);
                max4.setVisible(false);
                min5.setVisible(false);
                max5.setVisible(false);
                break;
            case 3:
                pierwszyText.setText(gui.getDopodsumowanie().get(0).getImie());
                progressBar1.setMaximum((int) ((Math.floor(gui.getDopodsumowanie().get(0).getSkill())) * 100) + 100);
                progressBar1.setMinimum((int) (Math.floor(gui.getDopodsumowanie().get(0).getSkill())) * 100);
                progressBar1.setValue((int) ((gui.getDopodsumowanie().get(0).getSkill()) * 100));
                progressBar1.setBorderPainted(true);
                min1.setText(String.valueOf(Math.floor(gui.getDopodsumowanie().get(0).getSkill())));
                max1.setText(String.valueOf(Math.floor(gui.getDopodsumowanie().get(0).getSkill()) + 1));
                drugiText.setText(gui.getDopodsumowanie().get(1).getImie());
                progressBar2.setMaximum((int) ((Math.floor(gui.getDopodsumowanie().get(1).getSkill())) * 100) + 100);
                progressBar2.setMinimum((int) (Math.floor(gui.getDopodsumowanie().get(1).getSkill())) * 100);
                progressBar2.setValue((int) ((gui.getDopodsumowanie().get(1).getSkill()) * 100));
                progressBar2.setBorderPainted(true);
                min2.setText(String.valueOf(Math.floor(gui.getDopodsumowanie().get(1).getSkill())));
                max2.setText(String.valueOf(Math.floor(gui.getDopodsumowanie().get(1).getSkill()) + 1));
                trzeciText.setText(gui.getDopodsumowanie().get(2).getImie());
                progressBar3.setMaximum((int) ((Math.floor(gui.getDopodsumowanie().get(2).getSkill())) * 100) + 100);
                progressBar3.setMinimum((int) (Math.floor(gui.getDopodsumowanie().get(2).getSkill())) * 100);
                progressBar3.setValue((int) ((gui.getDopodsumowanie().get(2).getSkill()) * 100));
                progressBar3.setBorderPainted(true);
                min3.setText(String.valueOf(Math.floor(gui.getDopodsumowanie().get(2).getSkill())));
                max3.setText(String.valueOf(Math.floor(gui.getDopodsumowanie().get(2).getSkill()) + 1));
                min4.setVisible(false);
                max4.setVisible(false);
                min5.setVisible(false);
                max5.setVisible(false);
                break;
            case 4:
                pierwszyText.setText(gui.getDopodsumowanie().get(0).getImie());
                progressBar1.setMaximum((int) ((Math.floor(gui.getDopodsumowanie().get(0).getSkill())) * 100) + 100);
                progressBar1.setMinimum((int) (Math.floor(gui.getDopodsumowanie().get(0).getSkill())) * 100);
                progressBar1.setValue((int) ((gui.getDopodsumowanie().get(0).getSkill()) * 100));
                progressBar1.setBorderPainted(true);
                min1.setText(String.valueOf(Math.floor(gui.getDopodsumowanie().get(0).getSkill())));
                max1.setText(String.valueOf(Math.floor(gui.getDopodsumowanie().get(0).getSkill()) + 1));
                drugiText.setText(gui.getDopodsumowanie().get(1).getImie());
                progressBar2.setMaximum((int) ((Math.floor(gui.getDopodsumowanie().get(1).getSkill())) * 100) + 100);
                progressBar2.setMinimum((int) (Math.floor(gui.getDopodsumowanie().get(1).getSkill())) * 100);
                progressBar2.setValue((int) ((gui.getDopodsumowanie().get(1).getSkill()) * 100));
                progressBar2.setBorderPainted(true);
                min2.setText(String.valueOf(Math.floor(gui.getDopodsumowanie().get(1).getSkill())));
                max2.setText(String.valueOf(Math.floor(gui.getDopodsumowanie().get(1).getSkill()) + 1));
                trzeciText.setText(gui.getDopodsumowanie().get(2).getImie());
                progressBar3.setMaximum((int) ((Math.floor(gui.getDopodsumowanie().get(2).getSkill())) * 100) + 100);
                progressBar3.setMinimum((int) (Math.floor(gui.getDopodsumowanie().get(2).getSkill())) * 100);
                progressBar3.setValue((int) ((gui.getDopodsumowanie().get(2).getSkill()) * 100));
                progressBar3.setBorderPainted(true);
                min3.setText(String.valueOf(Math.floor(gui.getDopodsumowanie().get(2).getSkill())));
                max3.setText(String.valueOf(Math.floor(gui.getDopodsumowanie().get(2).getSkill()) + 1));
                czwartyText.setText(gui.getDopodsumowanie().get(3).getImie());
                progressBar4.setMaximum((int) ((Math.floor(gui.getDopodsumowanie().get(3).getSkill())) * 100) + 100);
                progressBar4.setMinimum((int) (Math.floor(gui.getDopodsumowanie().get(3).getSkill())) * 100);
                progressBar4.setValue((int) ((gui.getDopodsumowanie().get(3).getSkill()) * 100));
                progressBar4.setBorderPainted(true);
                min4.setText(String.valueOf(Math.floor(gui.getDopodsumowanie().get(3).getSkill())));
                max4.setText(String.valueOf(Math.floor(gui.getDopodsumowanie().get(3).getSkill()) + 1));
                min5.setVisible(false);
                max5.setVisible(false);
                break;
            case 5:
                pierwszyText.setText(gui.getDopodsumowanie().get(0).getImie());
                progressBar1.setMaximum((int) ((Math.floor(gui.getDopodsumowanie().get(0).getSkill())) * 100) + 100);
                progressBar1.setMinimum((int) (Math.floor(gui.getDopodsumowanie().get(0).getSkill())) * 100);
                progressBar1.setValue((int) ((gui.getDopodsumowanie().get(0).getSkill()) * 100));
                progressBar1.setBorderPainted(true);
                min1.setText(String.valueOf(Math.floor(gui.getDopodsumowanie().get(0).getSkill())));
                max1.setText(String.valueOf(Math.floor(gui.getDopodsumowanie().get(0).getSkill()) + 1));
                drugiText.setText(gui.getDopodsumowanie().get(1).getImie());
                progressBar2.setMaximum((int) ((Math.floor(gui.getDopodsumowanie().get(1).getSkill())) * 100) + 100);
                progressBar2.setMinimum((int) (Math.floor(gui.getDopodsumowanie().get(1).getSkill())) * 100);
                progressBar2.setValue((int) ((gui.getDopodsumowanie().get(1).getSkill()) * 100));
                progressBar2.setBorderPainted(true);
                min2.setText(String.valueOf(Math.floor(gui.getDopodsumowanie().get(1).getSkill())));
                max2.setText(String.valueOf(Math.floor(gui.getDopodsumowanie().get(1).getSkill()) + 1));
                trzeciText.setText(gui.getDopodsumowanie().get(2).getImie());
                progressBar3.setMaximum((int) ((Math.floor(gui.getDopodsumowanie().get(2).getSkill())) * 100) + 100);
                progressBar3.setMinimum((int) (Math.floor(gui.getDopodsumowanie().get(2).getSkill())) * 100);
                progressBar3.setValue((int) ((gui.getDopodsumowanie().get(2).getSkill()) * 100));
                progressBar3.setBorderPainted(true);
                min3.setText(String.valueOf(Math.floor(gui.getDopodsumowanie().get(2).getSkill())));
                max3.setText(String.valueOf(Math.floor(gui.getDopodsumowanie().get(2).getSkill()) + 1));
                czwartyText.setText(gui.getDopodsumowanie().get(3).getImie());
                progressBar4.setMaximum((int) ((Math.floor(gui.getDopodsumowanie().get(3).getSkill())) * 100) + 100);
                progressBar4.setMinimum((int) (Math.floor(gui.getDopodsumowanie().get(3).getSkill())) * 100);
                progressBar4.setValue((int) ((gui.getDopodsumowanie().get(3).getSkill()) * 100));
                progressBar4.setBorderPainted(true);
                min4.setText(String.valueOf(Math.floor(gui.getDopodsumowanie().get(3).getSkill())));
                max4.setText(String.valueOf(Math.floor(gui.getDopodsumowanie().get(3).getSkill()) + 1));
                piatyText.setText(gui.getDopodsumowanie().get(4).getImie());
                progressBar5.setMaximum((int) ((Math.floor(gui.getDopodsumowanie().get(4).getSkill())) * 100) + 100);
                progressBar5.setMinimum((int) (Math.floor(gui.getDopodsumowanie().get(4).getSkill())) * 100);
                progressBar5.setValue((int) ((gui.getDopodsumowanie().get(4).getSkill()) * 100));
                progressBar5.setBorderPainted(true);
                min5.setText(String.valueOf(Math.floor(gui.getDopodsumowanie().get(4).getSkill())));
                max5.setText(String.valueOf(Math.floor(gui.getDopodsumowanie().get(4).getSkill()) + 1));
        }


    }
}
