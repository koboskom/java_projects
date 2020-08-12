import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SamochodGUI {

    private Samochod samochod;
    private JPanel panel1;
    private JButton zmniejszobroty;
    private JButton wiekszobroty;
    private JTextField maxbieg;
    private JTextField bieg;
    private JButton zmniejszbieg;
    private JButton zwiekszbieg;
    private JTextField model;
    private JTextField plate;
    private JTextField vmax;
    private JTextField maxobroty;
    private JTextField obroty;
    private JTextField pozycjaX;
    private JTextField pozycjaY;
    private JTextField predkosc;
    private JTextField jedzdox;
    private JTextField jedzdoy;
    private JButton STOPbutton;
    private JPanel mapa;
    private JLabel location;
    private JButton Dodaj;
    public JComboBox comboBox1;
    private JButton STARTButton;
    private JTextField wagatext;
    private JButton usun;


    public JComboBox getComboBox1() {
        return comboBox1;
    }

    public SamochodGUI(Samochod a) {
        samochod = a;
        odswiez();
        timer.setInitialDelay(500);
        timer.start();
        /*
        ImageIcon i = new ImageIcon("C:\\Users\\marek\\OneDrive\\Dokumenty\\java\\kobosko\\foto\\pobrane.png");
        location.setIcon(i);
*/
        wiekszobroty.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                samochod.silnik.zwiekszObroty();
            }
        });
        zmniejszobroty.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                samochod.silnik.zmniejszObroty();
            }
        });
        zwiekszbieg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                samochod.skrzynia.zwiekszbieg();
            }
        });
        zmniejszbieg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                samochod.skrzynia.zmniejszbieg();
            }
        });


        STOPbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                samochod.setDest(Double.parseDouble(jedzdox.getText()),Double.parseDouble(jedzdoy.getText()));
            }
        });

        mapa.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                samochod.setDest(e.getX(),e.getY());
                super.mousePressed(e);
            }
        });
        STOPbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                  samochod.wylacz();
                  odswiez();

            }
        });
        STARTButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                samochod.wlacz();
                odswiez();
            }
        });
        Dodaj.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                NowySamochodGUI sg = new NowySamochodGUI(SamochodGUI.this);
                sg.setVisible(true);
            }
        });
        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                samochod = (Samochod) comboBox1.getSelectedItem();
            }
        });

        usun.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                comboBox1.removeItem(samochod);
            }
        });

    }

    Timer timer = new Timer(100, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            odswiez();
        }
    });


    public void odswiez(){

        model.setText(samochod.getModel());
        plate.setText(samochod.getPlate());
        vmax.setText(Integer.toString(samochod.getMaxspeed()));
        maxobroty.setText(Double.toString(samochod.silnik.getMaxObroty()));
        obroty.setText(Double.toString(samochod.silnik.getObroty()));
        maxbieg.setText(Double.toString(samochod.skrzynia.getIloscbiegow()));
        bieg.setText(Double.toString(samochod.skrzynia.getAktualnybieg()));
        pozycjaX.setText(Double.toString(samochod.pozycja.getX()));
        pozycjaY.setText(Double.toString(samochod.pozycja.getY()));
        jedzdox.setText(Double.toString(samochod.pozycja.getDx()));
        jedzdoy.setText(Double.toString(samochod.pozycja.getDy()));
        predkosc.setText(Double.toString(samochod.predkosc()));
        wagatext.setText(Double.toString(samochod.getWaga()));

        location.setLocation((int)samochod.gdzie()[0],(int)samochod.gdzie()[1]);


    }

    public static void main(String[] args){

        Skrzynia SKF = new Skrzynia("SKF",100,4000);
        Silnik V8 = new Silnik("V8",200,200, 5000, 0);
        Sprzeglo a = new Sprzeglo("a", 20, 1000);
        Samochod civic = new Samochod(" ",  0, " ",V8,SKF,a);
        civic.skrzynia.setIloscbiegow(5);
        SamochodGUI c = new SamochodGUI(civic);


        JFrame frame = new JFrame("SamochodGUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setContentPane(c.panel1);
        frame.pack();

    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        location = new JLabel((new ImageIcon("autko.png")));
    }
}
