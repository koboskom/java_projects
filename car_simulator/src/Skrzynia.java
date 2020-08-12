public class Skrzynia extends Komponent {
    private double iloscbiegow ;
    private double aktualnybieg;
    private double aktualneprzelozenie;
    private Sprzeglo sprzeglo = new Sprzeglo("B", 400, 101);

    public Skrzynia(String nazwa, int waga, float cena) {
        super(nazwa, waga, cena);
        this.iloscbiegow = iloscbiegow;
        this.aktualnybieg = aktualnybieg;
        this.aktualneprzelozenie = aktualneprzelozenie;

    }

    public double getIloscbiegow(){
        return iloscbiegow;
    }

    public void setIloscbiegow(double iloscbiegow) {
        this.iloscbiegow = iloscbiegow;
    }

    public void setAktualnybieg(double aktualnybieg) {
        this.aktualnybieg = aktualnybieg;
    }

    public double getAktualnybieg(){
        System.out.println(aktualnybieg);
        return aktualnybieg;
    }

    public double getAktualneprzelozenie(){

        if (aktualnybieg == 1){
            aktualneprzelozenie = (double) 1.1;
        }
        if (aktualnybieg == 2){
            aktualneprzelozenie = (double)1.5;
        }
        if (aktualnybieg == 3){
            aktualneprzelozenie = (double)1.8;
        }
        if (aktualnybieg == 4){
            aktualneprzelozenie = (double)2.1;
        }
        if (aktualnybieg == 5){
            aktualneprzelozenie = (double)2.5;
        }
        if (aktualnybieg == 6){
            aktualneprzelozenie = (double)2.8;
        }
        return aktualneprzelozenie;
    }

    public void zwiekszbieg(){
        if (aktualnybieg<5) {
            sprzeglo.wcisnij();
            aktualnybieg += 1;
            sprzeglo.zwolnij();
        }
        System.out.println(aktualnybieg);
    }
    public void zmniejszbieg(){
        if(aktualnybieg>1){
            sprzeglo.wcisnij();
            aktualnybieg -= 1;
            sprzeglo.zwolnij();
        }
        System.out.println(aktualnybieg);
    }
    public int getWaga(){
        return super.getWaga() + sprzeglo.getWaga();
    }
}