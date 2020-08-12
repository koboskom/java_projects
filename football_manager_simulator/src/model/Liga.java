package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Liga {
    private String nazwa;
    private String kraj;
    private List<Druzyna> druzyny;
    private Terminarz terminarz;
    private Tabela tabela;
    private String wynikikolejki = "";

    public Liga(String nazwa, String kraj, List<Druzyna> druzyny, Terminarz terminarz, Tabela tabela) {
        this.nazwa = nazwa;
        this.kraj = kraj;
        this.druzyny = druzyny;
        this.terminarz = terminarz;
        this.tabela = tabela;
    }

    @Override
    public String toString() {
        return nazwa;
    }

    public String getWynikikolejki() {
        return wynikikolejki;
    }

    public String getNazwa() {
        return nazwa;
    }

    public String getKraj() {
        return kraj;
    }

    public List<Druzyna> getDruzyny() {
        return druzyny;
    }

    public Terminarz getTerminarz() {
        return terminarz;
    }

    public Tabela getTabela() {
        return tabela;
    }

    public void zmiendysp(double p, Zawodnik zawodnik) {
        Random generator = new Random();
        int dysp = generator.nextInt(4);
        double zmiana = generator.nextDouble();
        if (zmiana < p) {
            if (zawodnik.getDyspozycja() - 0.05*dysp > 0) {
                zawodnik.setDyspozycja(zawodnik.getDyspozycja() - 0.05 * dysp);
            }
        } else {
            if (zawodnik.getDyspozycja() + 0.05*dysp < 1) {
                zawodnik.setDyspozycja(zawodnik.getDyspozycja() + 0.05 * dysp);
            }
        }
    }

    public void kolejka(int kolejka) {

        wynikikolejki = wynikikolejki + ("Kolejka " + kolejka + ":" + "\n");
        List<List<Long>> wyniki = new ArrayList<>();

        for (int i = 0; i < getTerminarz().getLista_meczy().size(); i++) {
            List<Long> bramki = new ArrayList<>();
            if (getTerminarz().getLista_meczy().get(i).getKolejka() == kolejka) {
                Druzyna pierwsza = getTerminarz().getLista_meczy().get(i).getDruzyny().get(0);
                Druzyna druga = getTerminarz().getLista_meczy().get(i).getDruzyny().get(1);
                String gospodarze = pierwsza.getNazwa();
                String goscie = druga.getNazwa();
                String stadion = pierwsza.getStadion();
                String trenergosp = pierwsza.getTrener().getImie() + pierwsza.getTrener().getNazwisko();
                String trenergoscie = druga.getTrener().getImie() + druga.getTrener().getNazwisko();
                Random generator = new Random();
                double p_gosp = generator.nextDouble();
                double p_gosc = generator.nextDouble();
                int wsp_gosp = 0;
                int wsp_gosc = 0;
                double sila_pierwszej = pierwsza.getSiladruzyny();
                double sila_drugiej = druga.getSiladruzyny();

//--------------------------------------------------------------------------------
//na podstawie wylosowanego p ustalamy wspołczynnik przez który mnożę liczbe goli (z odpowiednim prawdopodobięństwem)

                if (p_gosp < 0.1) {
                    wsp_gosp = 0;
                } else if (p_gosp < 0.6) {
                    wsp_gosp = 1;
                } else if (p_gosp < 0.85) {
                    wsp_gosp = 2;
                } else if (p_gosp < 0.95) {
                    wsp_gosp = 3;
                } else {
                    wsp_gosp = 4;
                }

                if (p_gosc < 0.1) {
                    wsp_gosc = 0;
                } else if (p_gosc < 0.6) {
                    wsp_gosc = 1;
                } else if (p_gosc < 0.85) {
                    wsp_gosc = 2;
                } else if (p_gosc < 0.95) {
                    wsp_gosc = 3;
                } else {
                    wsp_gosc = 4;
                }
//----------------------------------------------------------------------------------
                pierwsza.setRozegranemecze(pierwsza.getRozegranemecze() + 1);
                druga.setRozegranemecze(druga.getRozegranemecze() + 1);
                double bramki_slabszej = (sila_drugiej / sila_pierwszej) * (sila_drugiej / sila_pierwszej) * wsp_gosc;
                double bramki_silniejszej = 1.41 * Math.sqrt(sila_pierwszej / sila_drugiej) * wsp_gosp;

                if (pierwsza.getSiladruzyny() >= druga.getSiladruzyny()) { // uwzglednianie taktyk druzyn
                    if (pierwsza.getTaktyka() == 0 && druga.getTaktyka() == 0) {
                        bramki.add(0, Math.round(bramki_silniejszej));
                        bramki.add(1, Math.round(bramki_slabszej));
                        wyniki.add(bramki);
                    } else if (pierwsza.getTaktyka() == 1 && druga.getTaktyka() == 1) {
                        bramki.add(0, Math.abs(Math.round(bramki_silniejszej - 1)));
                        bramki.add(1, Math.abs(Math.round(bramki_slabszej - 1)));
                        wyniki.add(bramki);
                    } else if (pierwsza.getTaktyka() == 2 && druga.getTaktyka() == 2) {
                        bramki.add(0, Math.round(bramki_silniejszej + 1));
                        bramki.add(1, Math.round(bramki_slabszej + 1));
                        wyniki.add(bramki);
                    } else if (pierwsza.getTaktyka() == 2 && druga.getTaktyka() == 0) {
                        bramki.add(0, Math.round(bramki_silniejszej + 0.5));
                        bramki.add(1, Math.round(bramki_slabszej + 0.3));
                        wyniki.add(bramki);
                    } else if (pierwsza.getTaktyka() == 2 && druga.getTaktyka() == 1) {
                        bramki.add(0, Math.round(bramki_silniejszej));
                        bramki.add(1, Math.round(bramki_slabszej));
                        wyniki.add(bramki);
                    } else if (pierwsza.getTaktyka() == 1 && druga.getTaktyka() == 0) {
                        bramki.add(0, Math.round(bramki_silniejszej - 0.5));
                        bramki.add(1, Math.round(bramki_slabszej - 0.3));
                        wyniki.add(bramki);
                    } else if (pierwsza.getTaktyka() == 1 && druga.getTaktyka() == 2) {
                        bramki.add(0, Math.round(bramki_silniejszej));
                        bramki.add(1, Math.round(bramki_slabszej));
                        wyniki.add(bramki);
                    } else if (pierwsza.getTaktyka() == 0 && druga.getTaktyka() == 1) {
                        bramki.add(0, Math.round(bramki_silniejszej - 0.3));
                        bramki.add(1, Math.round(bramki_slabszej - 0.5));
                        wyniki.add(bramki);
                    } else if (pierwsza.getTaktyka() == 0 && druga.getTaktyka() == 2) {
                        bramki.add(0, Math.round(bramki_silniejszej + 0.3));
                        bramki.add(1, Math.round(bramki_slabszej + 0.5));
                        wyniki.add(bramki);
                    }
                } else if (pierwsza.getSiladruzyny() < druga.getSiladruzyny()) { // uwzglednianie taktyk druzyn
                    if (pierwsza.getTaktyka() == 0 && druga.getTaktyka() == 0) {
                        bramki.add(0, Math.round(bramki_slabszej));
                        bramki.add(1, Math.round(bramki_silniejszej));
                        wyniki.add(bramki);
                    } else if (pierwsza.getTaktyka() == 1 && druga.getTaktyka() == 1) {
                        bramki.add(0, Math.abs(Math.round(bramki_slabszej - 1)));
                        bramki.add(1, Math.abs(Math.round(bramki_silniejszej - 1)));
                        wyniki.add(bramki);
                    } else if (pierwsza.getTaktyka() == 2 && druga.getTaktyka() == 2) {
                        bramki.add(0, Math.round(bramki_slabszej + 1));
                        bramki.add(1, Math.round(bramki_silniejszej + 1));
                        wyniki.add(bramki);
                    } else if (pierwsza.getTaktyka() == 2 && druga.getTaktyka() == 0) {
                        bramki.add(0, Math.round(bramki_slabszej + 0.5));
                        bramki.add(1, Math.round(bramki_silniejszej + 0.3));
                        wyniki.add(bramki);
                    } else if (pierwsza.getTaktyka() == 2 && druga.getTaktyka() == 1) {
                        bramki.add(0, Math.round(bramki_slabszej));
                        bramki.add(1, Math.round(bramki_silniejszej));
                        wyniki.add(bramki);
                    } else if (pierwsza.getTaktyka() == 1 && druga.getTaktyka() == 0) {
                        bramki.add(0, Math.round(bramki_slabszej - 0.5));
                        bramki.add(1, Math.round(bramki_silniejszej - 0.3));
                        wyniki.add(bramki);
                    } else if (pierwsza.getTaktyka() == 1 && druga.getTaktyka() == 2) {
                        bramki.add(0, Math.round(bramki_slabszej));
                        bramki.add(1, Math.round(bramki_silniejszej));
                        wyniki.add(bramki);
                    } else if (pierwsza.getTaktyka() == 0 && druga.getTaktyka() == 1) {
                        bramki.add(0, Math.round(bramki_slabszej - 0.3));
                        bramki.add(1, Math.round(bramki_silniejszej - 0.5));
                        wyniki.add(bramki);
                    } else if (pierwsza.getTaktyka() == 0 && druga.getTaktyka() == 2) {
                        bramki.add(0, Math.round(bramki_slabszej + 0.3));
                        bramki.add(1, Math.round(bramki_silniejszej + 0.5));
                        wyniki.add(bramki);
                    }
                }
                if (wyniki.get(i).get(0) > wyniki.get(i).get(1)) {
                    pierwsza.setPunkty(pierwsza.getPunkty() + 3); //dodawanie punktów dla zwycięstwa gospodarzy
                    for (Zawodnik zawodnik : pierwsza.getZawodnicy()) {
                        zmiendysp(0.3, zawodnik);
                    }
                    for (Zawodnik zawodnik : druga.getZawodnicy()) {
                        zmiendysp(0.7, zawodnik);
                    }
                } else if (wyniki.get(i).get(0) == wyniki.get(i).get(1)) {
                    pierwsza.setPunkty(pierwsza.getPunkty() + 1);
                    druga.setPunkty(druga.getPunkty() + 1); //dodawanie punktów dla remisu
                    for (Zawodnik zawodnik : pierwsza.getZawodnicy()) {
                        zmiendysp(0.5, zawodnik);
                    }
                    for (Zawodnik zawodnik : druga.getZawodnicy()) {
                        zmiendysp(0.5, zawodnik);
                    }
                } else {
                    druga.setPunkty(druga.getPunkty() + 3); //dodawanie punktów dla zwycięstwa gości
                    for (Zawodnik zawodnik : pierwsza.getZawodnicy()) {
                        zmiendysp(0.7, zawodnik);
                    }
                    for (Zawodnik zawodnik : druga.getZawodnicy()) {
                        zmiendysp(0.3, zawodnik);
                    }
                }
                pierwsza.setBramkizdobyte((int) (pierwsza.getBramkizdobyte() + wyniki.get(i).get(0))); //bramki strzelone przez gosp
                druga.setBramkizdobyte((int) (druga.getBramkizdobyte() + wyniki.get(i).get(1))); //bramki strzelone przez gosc
                pierwsza.setBarmkistracone((int) (pierwsza.getBarmkistracone() + wyniki.get(i).get(1))); //bramki stracone przzez gosp
                druga.setBarmkistracone((int) (druga.getBarmkistracone() + wyniki.get(i).get(0))); //bramki stracone przzez gosc
                wynikikolejki = wynikikolejki + (gospodarze.trim() + " " + (wyniki.get(i).get(0)) + ":" + (wyniki.get(i).get(1)) + " " + goscie.trim() + "\tStadion: " + stadion + "\n");
                pierwsza.siladruzyny(); //po zmianie dyspozycji zawodników trzeba znowu policzyć siłe drużyny
                druga.siladruzyny();
            } else { //dodawanie do listy "pustych" elementów żeby nie wychodziło poza liste
                bramki.add((long) 0);
                bramki.add((long) 0);
                wyniki.add(bramki);
            }


        }
    }

}