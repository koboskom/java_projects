package model;

import java.util.List;

public class Mecz {
    private int kolejka;
    private List<Druzyna> mecz;

    public Mecz(int kolejka, List<Druzyna> mecz) {
        this.kolejka = kolejka;
        this.mecz = mecz;
    }

    public int getKolejka() {
        return kolejka;
    }

    public List<Druzyna> getDruzyny() {
        return mecz;
    }


}
