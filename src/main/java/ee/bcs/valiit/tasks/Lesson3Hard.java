package ee.bcs.valiit.tasks;

import java.util.Random;
import java.util.Scanner;

public class Lesson3Hard {


    // TODO kirjuta mäng mis leiab suvalise numbri 0-99, mille kasutaja peab ära arvama
    // iga kord pärast kasutaja sisestatud täis arvu peab programm ütlema kas number oli suurem või väiksem
    // ja kasutaja peab saama uuesti arvata
    // numbri ära aramise korral peab programm välja trükkima mitu katset läks numbri ära arvamiseks
    public static void main(){
        Random random = new Random();
        int i = random.nextInt(100);
        Scanner scanner = new Scanner(System.in);
        int guess = scanner.nextInt();
        int counter = 0;
        while (guess != i){

            if (guess > i){
                System.out.println("Proovi vähem!");
                counter++;
                System.out.println("Uus number?");
                guess = scanner.nextInt();
            } else {
                System.out.println("Proovi rohkem!");
                counter++;
                System.out.println("Uus number?");
                guess = scanner.nextInt();
            }
        }
        System.out.println("Õige number oli " + i);
        System.out.println("Proovisid " + counter + " korda");
    }
}
