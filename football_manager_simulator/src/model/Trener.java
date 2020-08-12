package model;

public class Trener {
    private String imie;
    private String nazwisko;
    private int wiek;
    private double umiejetnosci; //0-50

    public Trener(String imie, String nazwisko, int wiek, double umiejetnosci) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.wiek = wiek;
        this.umiejetnosci = umiejetnosci;
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public int getWiek() {
        return wiek;
    }

    public double getUmiejetnosci() {
        return umiejetnosci;
    }

}

