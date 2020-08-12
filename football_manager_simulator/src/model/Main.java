package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private Liga premier;
    private Zarzadzanie moja;

    public Liga getPremier() {
        return premier;
    }

    public Zarzadzanie getMoja() {
        return moja;
    }

    public void startgry(Liga liga, Druzyna druzyna, String data) {
        moja = new Zarzadzanie(liga, druzyna, data);
    }

    public void wczytaj() {

        List<Zawodnik> all = new ArrayList<Zawodnik>();
        String csvFile = "zawodnicy.csv";
        String line = "";
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] zawodnik = line.split(cvsSplitBy);

                Zawodnik a = new Zawodnik(zawodnik[0], zawodnik[1], zawodnik[2], Double.parseDouble(zawodnik[3]), Double.parseDouble(zawodnik[4]));
                all.add(a);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        List<Zawodnik> arsenal_zaw = new ArrayList<Zawodnik>();
        List<Zawodnik> chelsea_zaw = new ArrayList<Zawodnik>();
        List<Zawodnik> leicester_zaw = new ArrayList<Zawodnik>();
        List<Zawodnik> liverpool_zaw = new ArrayList<Zawodnik>();
        List<Zawodnik> mancity_zaw = new ArrayList<Zawodnik>();
        List<Zawodnik> manunited_zaw = new ArrayList<Zawodnik>();
        List<Zawodnik> newcastle_zaw = new ArrayList<Zawodnik>();
        List<Zawodnik> southhampton_zaw = new ArrayList<Zawodnik>();

        for (int i = 0; i < 32; i++) {
            arsenal_zaw.add(all.get(i));
        }
        for (int i = 32; i < 62; i++) {
            chelsea_zaw.add(all.get(i));
        }
        for (int i = 62; i < 87; i++) {
            leicester_zaw.add(all.get(i));
        }
        for (int i = 87; i < 133; i++) {
            liverpool_zaw.add(all.get(i));
        }
        for (int i = 133; i < 163; i++) {
            mancity_zaw.add(all.get(i));
        }
        for (int i = 163; i < 202; i++) {
            manunited_zaw.add(all.get(i));
        }
        for (int i = 202; i < 228; i++) {
            newcastle_zaw.add(all.get(i));
        }
        for (int i = 228; i < 256; i++) {
            southhampton_zaw.add(all.get(i));
        }

        List<Zawodnik> arsenal_zaw_domyslni = new ArrayList<Zawodnik>();
        List<Zawodnik> chelsea_zaw_domyslni = new ArrayList<Zawodnik>();
        List<Zawodnik> leicester_zaw_domyslni = new ArrayList<Zawodnik>();
        List<Zawodnik> liverpool_zaw_domyslni = new ArrayList<Zawodnik>();
        List<Zawodnik> mancity_zaw_domyslni = new ArrayList<Zawodnik>();
        List<Zawodnik> manunited_zaw_domyslni = new ArrayList<Zawodnik>();
        List<Zawodnik> newcastle_zaw_domyslni = new ArrayList<Zawodnik>();
        List<Zawodnik> southhampton_zaw_domyslni = new ArrayList<Zawodnik>();

        for (int i = 0; i < 11; i++) {
            arsenal_zaw_domyslni.add(arsenal_zaw.get(i));
        }
        for (int i = 0; i < 11; i++) {
            chelsea_zaw_domyslni.add(chelsea_zaw.get(i));
        }
        for (int i = 0; i < 11; i++) {
            leicester_zaw_domyslni.add(leicester_zaw.get(i));
        }
        for (int i = 0; i < 11; i++) {
            liverpool_zaw_domyslni.add(liverpool_zaw.get(i));
        }
        for (int i = 0; i < 11; i++) {
            mancity_zaw_domyslni.add(mancity_zaw.get(i));
        }
        for (int i = 0; i < 11; i++) {
            manunited_zaw_domyslni.add(manunited_zaw.get(i));
        }
        for (int i = 0; i < 11; i++) {
            newcastle_zaw_domyslni.add(newcastle_zaw.get(i));
        }
        for (int i = 0; i < 11; i++) {
            southhampton_zaw_domyslni.add(southhampton_zaw.get(i));
        }

        Trener trenerchelsea = new Trener("Frank", "Lampard", 40, 45);
        Trener trenerarsenal = new Trener("Fredrik", "Ljungberg", 42, 35);
        Trener trenermanuni = new Trener("Ole Gunnar", "Solskjaer", 46, 35);
        Trener trenermancity = new Trener("Josep", "Guardiola", 48, 40);
        Trener trenersouth = new Trener("Ralph", "Hasenhuttl", 52, 30);
        Trener trenerleicester = new Trener("Brendan", "Rodgers", 46, 40);
        Trener trenerliverpool = new Trener("Jurgen", "Klopp", 52, 45);
        Trener trenernewcastle = new Trener("Steve", "Bruce", 58, 30);

        List<Druzyna> lista_druzyn = new ArrayList<Druzyna>();

        Druzyna chelsea = new Druzyna("Chelsea     ", "Stamford Bridge", trenerchelsea, chelsea_zaw, chelsea_zaw_domyslni, 0, 2);
        Druzyna manu = new Druzyna("Man Utd     ", "Old Trafford", trenermanuni, manunited_zaw, manunited_zaw_domyslni, 0, 1);
        Druzyna mancity = new Druzyna("Man City    ", "Etihad Stadium", trenermancity, mancity_zaw, mancity_zaw_domyslni, 0, 2);
        Druzyna liverpool = new Druzyna("Liverpool   ", "Anfield", trenerliverpool, liverpool_zaw, liverpool_zaw_domyslni, 0, 2);
        Druzyna arsenal = new Druzyna("Arsenal     ", "Emirates Stadium", trenerarsenal, arsenal_zaw, arsenal_zaw_domyslni, 0, 0);
        Druzyna leicester = new Druzyna("Leicester   ", "King Power Stadium", trenerleicester, leicester_zaw, leicester_zaw_domyslni, 0, 0);
        Druzyna newcastle = new Druzyna("Newcastle   ", "St. James Park", trenernewcastle, newcastle_zaw, newcastle_zaw_domyslni, 0, 0);
        Druzyna southhampton = new Druzyna("Southampton ", "St. Mary Stadium", trenersouth, southhampton_zaw, southhampton_zaw_domyslni, 0, 1);

        lista_druzyn.add(chelsea);
        lista_druzyn.add(manu);
        lista_druzyn.add(mancity);
        lista_druzyn.add(liverpool);
        lista_druzyn.add(arsenal);
        lista_druzyn.add(leicester);
        lista_druzyn.add(newcastle);
        lista_druzyn.add(southhampton);

        Kombinacja pomocnicza = new Kombinacja();
        List<Mecz> lista_meczy = new ArrayList<>();
        List<Integer> dodane = new ArrayList<>();
        int n = 8; //liczba drużyn dla których tworzymy terminarz
        List<int[]> kombinacje = pomocnicza.generate(n, 2); // r - rozmiar kombinacji
        for (int i = 1; i <= (n - 1); i++) {
            List<Integer> wystapienia = new ArrayList<>();

            for (int[] kombinacja : kombinacje) {

                if (!dodane.contains(kombinacje.indexOf(kombinacja))) {
                    if (!wystapienia.contains(kombinacja[0]) && !wystapienia.contains(kombinacja[1])) {

                        dodane.add(kombinacje.indexOf(kombinacja));
                        wystapienia.add(kombinacja[0]);
                        wystapienia.add(kombinacja[1]);

                        List<Druzyna> lista_druzyn_1 = new ArrayList<>();
                        lista_druzyn_1.add(lista_druzyn.get(kombinacja[0]));
                        lista_druzyn_1.add(lista_druzyn.get(kombinacja[1]));
                        Mecz mecz = new Mecz(i, lista_druzyn_1);
                        lista_meczy.add(mecz);
                    }
                }
            }
        }

        List<Integer> dodane_reverse = new ArrayList<>();
        List<int[]> kombinacje_reverse = pomocnicza.generate_reverse(n, 2); // r - rozmiar kombinacji
        for (int i = 1; i <= (n - 1); i++) {

            List<Integer> wystapienia = new ArrayList<>();

            for (int[] kombinacja : kombinacje_reverse) {

                if (!dodane_reverse.contains(kombinacje_reverse.indexOf(kombinacja))) {
                    if (!wystapienia.contains(kombinacja[0]) && !wystapienia.contains(kombinacja[1])) {

                        dodane_reverse.add(kombinacje_reverse.indexOf(kombinacja));
                        wystapienia.add(kombinacja[0]);
                        wystapienia.add(kombinacja[1]);

                        List<Druzyna> lista_druzyn_1 = new ArrayList<>();
                        lista_druzyn_1.add(lista_druzyn.get(kombinacja[0]));
                        lista_druzyn_1.add(lista_druzyn.get(kombinacja[1]));
                        Mecz mecz = new Mecz(i + n - 1, lista_druzyn_1);
                        lista_meczy.add(mecz);
                    }
                }
            }
        }

        Terminarz terminarz = new Terminarz(lista_meczy);
        Tabela tabela = new Tabela(lista_druzyn);

        premier = new Liga("Premier League", "Anglia", lista_druzyn, terminarz, tabela);

    }


}



