/*
import java.util.Scanner;

public class Main{

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        System.out.println("podaj obroty");
        double obroty = scan.nextInt();
        System.out.println("podaj bieg");
        double bieg = scan.nextInt();



        Skrzynia SKF = new Skrzynia("SKF",100,4000);
        Silnik V8 = new Silnik("V8",200,200, 5000, 6000);
        Sprzeglo a = new Sprzeglo("a", 20, 1000);
        Samochod civic = new Samochod("Civic", 160, "SCI1211",V8,SKF,a);
        civic.wlacz();
        civic.skrzynia.setAktualnybieg(3);
        civic.silnik.setObroty(3000);
        System.out.println(civic.skrzynia.getAktualneprzelozenie());


        //civic.xdd(200,140);

        int s = scan.nextInt();
        if (s == 1) {
            civic.wylacz();
            System.out.println("Samochód dojechał");
        }
        try {
            civic.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        civic.skrzynia.setAktualnybieg(3);
        civic.skrzynia.getAktualnybieg();
        civic.skrzynia.zwiekszbieg();
        System.out.println(civic.getWaga());
        civic.silnik.setObroty(3000);
        civic.silnik.zwiekszObroty();
        System.out.println(civic.predkosc());


        }
}


*/