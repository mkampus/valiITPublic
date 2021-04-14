package ee.bcs.valiit.tasks;

import java.util.Random;
import java.util.Scanner;

public class Lesson3Hard {

    final static Random random = new Random();
    final static int i = random.nextInt(100);
    int testCounter = 0;
    int counter = 0;


    // TODO kirjuta mäng mis leiab suvalise numbri 0-99, mille kasutaja peab ära arvama
    // iga kord pärast kasutaja sisestatud täis arvu peab programm ütlema kas number oli suurem või väiksem
    // ja kasutaja peab saama uuesti arvata
    // numbri ära aramise korral peab programm välja trükkima mitu katset läks numbri ära arvamiseks


    public static String game(int a) {
        System.out.println(random);
        System.out.println(i);
//        Scanner scanner = new Scanner(System.in);
        int guess = a;


        if (guess == i) {
            String correct = "Tubli! Õige number oli " + i;
        }
        if (guess > i) {
            String Kylm = "Proovi vähem! Uus number?";

            return Kylm;
//                guess = scanner.nextInt();
        } else if (guess>i) {
            String Soe = "Proovi rohkem! Uus number?";
            return Soe;
//                guess = scanner.nextInt();
        }
        String Tulemus = ("Õige number oli " + i);
        String Proovisid = ("Proovisid " + " korda");

        return Tulemus + Proovisid;

    }
}

