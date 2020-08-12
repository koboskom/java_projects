package model;

import java.util.List;

public class Terminarz {

    private List<Mecz> lista_meczy;

    public Terminarz(List<Mecz> lista_meczy) {
        this.lista_meczy = lista_meczy;
    }

    public List<Mecz> getLista_meczy() {
        return lista_meczy;
    }


}



