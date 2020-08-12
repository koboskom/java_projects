import java.lang.Math;

public class Samochod extends Thread {

    private boolean stan;
    private String model;
    private int maxspeed;
    private String plate;
    private int waga;
    public Silnik silnik;
    public Skrzynia skrzynia;
    public Sprzeglo sprzeglo;
    public Pozycja pozycja = new Pozycja();


    public Samochod(String model, int maxspeed, String plate, Silnik silnik, Skrzynia skrzynia, Sprzeglo sprzeglo) {
        this.model = model;
        this.maxspeed = maxspeed;
        this.plate = plate;
        this.silnik = silnik;
        this.sprzeglo = sprzeglo;
        this.skrzynia = skrzynia;
        start();
    }

    public boolean getStan() {
        return stan;
    }

    public String getModel() {
        return model;
    }

    public void setMaxspeed(int maxspeed) {
        this.maxspeed = maxspeed;
    }

    public void setWaga(int waga) {
        this.waga = waga;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getPlate() {
        return plate;
    }

    public int getMaxspeed() {
        return maxspeed;
    }

    @Override
    public String toString() {
        return  model;
    }

    public void wlacz() {
        silnik.uruchom();
        stan = true;
        skrzynia.setAktualnybieg(1);
        silnik.setObroty(800);
        System.out.println("samochod uruchomiony");

    }

    public void wylacz() {
        silnik.zatrzymaj();
        stan = false;
        System.out.println("samochod stop");
    }

    public Pozycja getPozycja() {
        return pozycja;
    }

    public void setPozycja(double x, double y) {
        pozycja.setX(x);
        pozycja.setY(y);
    }


    public int getWaga() {
        return (waga + silnik.getWaga() + skrzynia.getWaga() + sprzeglo.getWaga());
    }

    public double predkosc() {
        if (silnik.getObroty() * skrzynia.getAktualneprzelozenie() * 2/100 < maxspeed){
            return (silnik.getObroty() * skrzynia.getAktualneprzelozenie() * 2/100);
        }else
        return (maxspeed);
    }

    public void setDest(double a, double b) {
        pozycja.setDx(a);
        pozycja.setDy(b);
    }

    public double[] gdzie() {
        double[] tab = {pozycja.getX(), pozycja.getY()};
        return (tab);
    }




    public void run() {
        while (true) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            while(pozycja.getX() != pozycja.getDx() && pozycja.getY() != pozycja.getDy()) {
                if (pozycja.getX() == pozycja.getDx() && pozycja.getY() == pozycja.getDy()) {

                } else {

                    pozycja.jedzdo(predkosc(), 0.2);
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if(gdzie()[0]>pozycja.getDx() || gdzie()[1]>pozycja.getDy()){
                        gdzie()[0] = pozycja.getDx();
                        gdzie()[1] = pozycja.getDy();
                        break;
                    }else {

                    System.out.println(model + " x: " + gdzie()[0]);
                    System.out.println(model + " y: " + gdzie()[1]);
                    System.out.println(predkosc());
                }
            }

        }
    }
}}

