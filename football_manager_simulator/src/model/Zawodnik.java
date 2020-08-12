package model;


public class Zawodnik {

    private String imie;
    private String narodowosc;
    private double dyspozycja;  ///0-1
    private String pozycja;
    private double skill; //0-100
    private double silazawodnika;

    public Zawodnik(String imie, String narodowosc, String pozycja, double dyspozycja, double skill) {
        this.imie = imie;
        this.narodowosc = narodowosc;
        this.dyspozycja = dyspozycja;
        this.pozycja = pozycja;
        this.skill = skill;
        silazawodnika();
    }

    @Override
    public String toString() {
        return imie + "    umiejętności: " + Math.floor(skill) + "  dyspozycja: " + dyspozycja;
    }

    public void silazawodnika() {
        silazawodnika = Math.floor(skill) * 0.5 * dyspozycja; //*0,5 żeby dyspozycja nie wpływała za bardzo, bo dla dyspozycji 0,1 zawodnik byłby 10 razy słabszy, a tak tylko 5
    }

    public void setSkill(double skill) {
        this.skill = skill;
    }

    public void setDyspozycja(double dyspozycja) {
        this.dyspozycja = dyspozycja;
        silazawodnika();
    }

    public double getSilazawodnika() {
        return silazawodnika;
    }

    public String getImie() {
        return imie;
    }

    public String getNarodowosc() {
        return narodowosc;
    }

    public double getDyspozycja() {
        return dyspozycja;
    }

    public String getPozycja() {
        return pozycja;
    }

    public double getSkill() {
        return skill;
    }

}