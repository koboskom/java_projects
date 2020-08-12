package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Zarzadzanie {

    private Liga liga;
    private Druzyna druzyna;
    private List<Zawodnik> dotreningu = new ArrayList<>();
    private List<Zawodnik> pozostali;

    private int dni = 0;
    private int kolejka = 1;
    private LocalDate data;
    private boolean trening = false;

    public Zarzadzanie(Liga liga, Druzyna druzyna, String data) {
        this.liga = liga;
        this.druzyna = druzyna;
        this.data = LocalDate.parse(data);
        pozostali();
    }

    public boolean isTrening() {
        return trening;
    }

    public List<Zawodnik> getDotreningu() {
        return dotreningu;
    }

    public List<Zawodnik> getPozostali() {
        return pozostali;
    }

    public Druzyna getDruzyna() {
        return druzyna;
    }

    public int getDni() {
        return dni;
    }

    public void nastepnydzien() {
        data = data.plusDays(1);
        dni++;
        rozegraj();
        trening = false;
        setData(data);
    }

    private void rozegraj() {
        if (dni == 7) {
            liga.kolejka(kolejka);
            dni = 0;
            kolejka++;
        }
    }

    public Liga getLiga() {
        return liga;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getData() {
        return data.toString();
    }


    public int getKolejka() {
        return kolejka;
    }

    public void dodajdotreningu(Zawodnik zawodnik) {
        if (dotreningu.size() < 5) {
            dotreningu.add(zawodnik);
        } else {
            System.out.println("Możesz trenować maksymalnie 5 zawodników naraz!");
        }
    }

    public void pozostali() {
        pozostali = new ArrayList<>(druzyna.getZawodnicy());
        for (Zawodnik zawodnik : dotreningu) {
            pozostali.remove(zawodnik);
        }
    }

    public void usunztreningu(Zawodnik zawodnik) {
        dotreningu.remove(zawodnik);
    }

    public void dodajdoskladu(Zawodnik zawodnik) {
        getDruzyna().getPierwszysklad().add(zawodnik);
    }

    public void usunzeskladu() {
        getDruzyna().getPierwszysklad().clear();
    }

    public void trening() {
        if (!trening && dotreningu.size() != 0) {
            for (Zawodnik zawodnik : dotreningu) {
                Random generator = new Random();
                if ((zawodnik.getSkill() + (druzyna.getTrener().getUmiejetnosci() / 50 * generator.nextDouble()) <= 100)) {
                    zawodnik.setSkill(zawodnik.getSkill() + (druzyna.getTrener().getUmiejetnosci() / 50 * generator.nextDouble()));
                } else {
                    zawodnik.setSkill(100);
                }
                zawodnik.silazawodnika();
            }
            dotreningu = new ArrayList<>();
            trening = true;
            druzyna.siladruzyny();
        } else if (trening) {
            System.out.println("Możesz wykonać tylko jeden trening w ciągu dnia!");
        } else {
            System.out.println("Wybierz zawodników, których chcesz trenować!");
        }
    }

    public void taktyka(int a) {
        switch (a) {
            case 1:
                druzyna.setTaktyka(1); //defensywna
                break;
            case 2:
                druzyna.setTaktyka(2);  //ofensywna
                break;
            case 0:
                druzyna.setTaktyka(0); //neutralna
        }
    }

    public void formacja(int a) {
        switch (a) {
            case 1:
                druzyna.setFormacja(1); // 4-3-3
                break;
            case 2:
                druzyna.setFormacja(2); // 4-4-2
                break;
            case 3:
                druzyna.setFormacja(3); // 5-3-2
        }
    }

}

