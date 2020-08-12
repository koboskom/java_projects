public class Silnik extends Komponent{



    public Silnik(String nazwa, int moc, int waga, float cena, float maxObroty) {
        super(nazwa,waga, cena);
        this.maxObroty = maxObroty;
        this.moc = moc;
    }

    public double getMoc() {
        return moc;
    }

    public double getMaxObroty(){
        return maxObroty;
    }

    public void setObroty(double obroty) {
        this.obroty = obroty;
        System.out.println("obroty = " + obroty);
    }

    public void uruchom() {
        System.out.println("silnikuruchomiony.");
        System.out.println("obroty= " + obroty);
    }
    public void zatrzymaj() {obroty= 0; //stop
        System.out.println("silnikzatrzymany.");
        System.out.println("obroty = " + obroty);
    }
    public void zwiekszObroty() {
        obroty= obroty+ 500 ;
        if (obroty> maxObroty) obroty= maxObroty;
        System.out.println("obroty = " + obroty);
    }
    public void zmniejszObroty() {
        obroty= obroty- 500 ;
        if (obroty< 800) obroty= 800;
        System.out.println("obroty = " + obroty);
    }
    public double getObroty(){
        return obroty;
    }
    private double maxObroty;
    private double moc;
    private double obroty;

}

