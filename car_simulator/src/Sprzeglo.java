public class Sprzeglo extends Komponent{
    private boolean stan;

    public Sprzeglo(String nazwa, int waga, float cena) {
        super(nazwa, waga, cena);
    }

    public void wcisnij(){
        stan = true;
    }
    public void zwolnij(){
        stan = false;
    }
}
