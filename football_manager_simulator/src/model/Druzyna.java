package model;

import java.util.List;

public class Druzyna {
    private String nazwa;
    private String stadion;
    private double siladruzyny;
    private Trener trener;
    private List<Zawodnik> zawodnicy;
    private List<Zawodnik> pierwszysklad;
    private int punkty;
    private int rozegranemecze;
    private int bramkizdobyte;
    private int barmkistracone;
    private int formacja;
    private int taktyka; //domyślnie - neutralna, 1 - defensywna, 2 - ofensywna

    public Druzyna(String nazwa, String stadion, Trener trener, List<Zawodnik> zawodnicy, List<Zawodnik> pierwszysklad, int formacja, int taktyka) {
        this.nazwa = nazwa;
        this.stadion = stadion;
        this.trener = trener;
        this.zawodnicy = zawodnicy;
        this.pierwszysklad = pierwszysklad;
        this.formacja = formacja;
        this.taktyka = taktyka;
        siladruzyny();
    }

    @Override
    public String toString() {
        return nazwa;
    }

    public int getPunkty() {
        return punkty;
    }

    public List<Zawodnik> getPierwszysklad() {
        return pierwszysklad;
    }

    public int getFormacja() {
        return formacja;
    }

    public void setFormacja(int formacja) {
        this.formacja = formacja;
    }

    public int getTaktyka() {
        return taktyka;
    }

    public void setTaktyka(int taktyka) {
        this.taktyka = taktyka;
    }

    public void setPunkty(int punkty) {
        this.punkty = punkty;
    }

    public int getRozegranemecze() {
        return rozegranemecze;
    }

    public void setRozegranemecze(int rozegranemecze) {
        this.rozegranemecze = rozegranemecze;
    }

    public int getBramkizdobyte() {
        return bramkizdobyte;
    }

    public void setBramkizdobyte(int bramkizdobyte) {
        this.bramkizdobyte = bramkizdobyte;
    }

    public int getBarmkistracone() {
        return barmkistracone;
    }

    public void setBarmkistracone(int barmkistracone) {
        this.barmkistracone = barmkistracone;
    }

    public String getNazwa() {
        return nazwa;
    }

    public String getStadion() {
        return stadion;
    }

    public Trener getTrener() {
        return trener;
    }

    public void siladruzyny() {
        siladruzyny = 0;
        for (Zawodnik zawodnik : pierwszysklad) {
            siladruzyny = siladruzyny + zawodnik.getSilazawodnika();
        }
        siladruzyny = siladruzyny / pierwszysklad.size();
    }

    public double getSiladruzyny() {
        return siladruzyny;
    }

    public List<Zawodnik> getZawodnicy() {
        return zawodnicy;
    }
}

