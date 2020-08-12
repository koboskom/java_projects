import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NowySamochodGUI extends JFrame {

    private JPanel pr;
    private JTextField modeltext;
    private JTextField nrrejtext;
    private JTextField vmaxtext;
    private JTextField wagatext;
    private JButton cancelButton;
    private JButton utworz;

    public NowySamochodGUI(SamochodGUI nowy) {
        setContentPane(pr);
        pack();


        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                dispose();
            }
        });

        utworz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String model  = modeltext.getText();
                String rej = nrrejtext.getText();
                int vmax = Integer.parseInt(vmaxtext.getText());
                int waga = Integer.parseInt(wagatext.getText());

                Skrzynia SKF = new Skrzynia("SKF",100,4000);
                Silnik V8 = new Silnik("V8",200,200, 5000, 6000);
                Sprzeglo a = new Sprzeglo("a", 20, 1000);
                Samochod x = new Samochod(model,vmax,rej,V8,SKF,a);

                x.setWaga(waga);
                x.skrzynia.setIloscbiegow(6);
                x.setPozycja(0,0);
                nowy.comboBox1.addItem(x); //!!




            }
        });
    }
}
