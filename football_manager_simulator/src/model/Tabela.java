package model;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Tabela {
    public List<Druzyna> mecz;

    public Tabela(List<Druzyna> mecz) {
        this.mecz = mecz;
    }

    public void sortowanie() {
        Comparator<Druzyna> comparator = Comparator.comparing(druzyna -> druzyna.getPunkty(), Comparator.reverseOrder());
        comparator = comparator.thenComparing((druzyna -> (druzyna.getBramkizdobyte() - druzyna.getBarmkistracone())), Comparator.reverseOrder());
        Collections.sort(mecz, comparator);
    }

    public String pokaztabele() {
        sortowanie();
        String t = ("Klub\t\t" + "RM\t" + "BZ\t" + "BS\t" + "RB\t" + "P\t\n");
        for (int i = 0; i < mecz.size(); i++) {
            int rb = mecz.get(i).getBramkizdobyte() - mecz.get(i).getBarmkistracone();
            String nazwa = mecz.get(i).getNazwa();
            int rozegrane = mecz.get(i).getRozegranemecze();
            int zdobyte = mecz.get(i).getBramkizdobyte();
            int stracone = mecz.get(i).getBarmkistracone();
            int punkty = mecz.get(i).getPunkty();

            t = t + (nazwa + "\t\t" + rozegrane + "\t" + zdobyte + "\t" + stracone + "\t" + rb + "\t" + punkty + "\n");
        }
        return t;
    }
}
