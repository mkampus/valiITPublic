package ee.bcs.valiit.tasks;

import java.util.Scanner;

// TODO kasuta if/else. Ära kasuta Math librarit
public class Lesson1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Siia sisse võid sa kirjutada koodi, et testida kas su meetodid töötavad ilusti
        // Katseta IntelliJ shortcuti. Olles intelliJ kirjuta "sout" ja siis vajuta enter
        System.out.println("Millist meetodit soovid: 1-6? 1 = min, 2 = max, 3 = abs, 4 = even, 5 = min3, 6 = max3");
        int f = scanner.nextInt();
        String function = scanner.nextLine();
        {
            if (function.equalsIgnoreCase("min") || f <= 1) { //mida kasutaja pani, kas kirjutas
                System.out.println("Sisesta a");                         //:min: v6i kirjutas :1:
                int a = scanner.nextInt();
                System.out.println("Sisesta b");
                int b = scanner.nextInt();
                System.out.println(min(a, b));
            } else if (f == 2) {
                System.out.println("Sisesta a");
                int a = scanner.nextInt();
                System.out.println("Sisesta b");
                int b = scanner.nextInt();
                System.out.println(max(a, b));
            } else if (f == 3) {
                System.out.println("Sisesta number");
                int a = scanner.nextInt();
                System.out.println(abs(a));
            } else if (f == 4) {
                System.out.println("Sisesta number");
                int a = scanner.nextInt();
                System.out.println(isEven(a));
            } else if (f == 5) {
                System.out.println("Sisesta a");
                int a = scanner.nextInt();
                System.out.println("Sisesta b");
                int b = scanner.nextInt();
                System.out.println("Sisesta c");
                int c = scanner.nextInt();
                System.out.println(min3(a, b, c));
            } else if (f == 6) {
                System.out.println("Sisesta a");
                int a = scanner.nextInt();
                System.out.println("Sisesta b");
                int b = scanner.nextInt();
                System.out.println("Sisesta c");
                int c = scanner.nextInt();
                System.out.println(max3(a, b, c));
            }

        }

//        int a = scanner.nextInt (); //tagastab int
//        String aS = scanner.nextLine (); //tagastab string kuni enter
//        System.out.println("Sa sisestasid" + a);


    }

    // TODO tagasta a ja b väikseim väärtus
    public static int min(int a, int b) {
        if (a < b) {
            return a;
        } else {
            return b;
        }
    }

    // TODO tagasta a ja b suurim väärtus
    public static int max(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }


    // TODO tagasta a absoluut arv
    public static int abs(int a) {
        if (a < 0) {
            a = a * -1;
        }
        return a;
    }

    // TODO tagasta true, kui a on paaris arv
    // tagasta false kui a on paaritu arv
    public static boolean isEven(int a) {
        if (a % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    // TODO tagasta kolmest arvust kõige väiksem
    public static int min3(int a, int b, int c) {
        if (a <= b && a <= c) {
            return a;
        } else {
            if (b <= a && b <= c) {
                return b;
            } else {
                return c;
            }


        }
    }

    // TODO tagasta kolmest arvust kõige suurem
    public static int max3(int a, int b, int c) {
        if (a >= b && a >= c) {
            return a;
        } else if (b >= a && b >= c) {
            return b;
        } else {
            return c;
        }
    }
}
