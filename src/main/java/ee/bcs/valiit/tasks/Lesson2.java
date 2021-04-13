package ee.bcs.valiit.tasks;

public class Lesson2 {

    public static void main(String[] args) {


        //System.out.println(Lesson2.nextElement(1));
      // Lesson3.reverseString("Tere");
//        Lesson2.sequence3n(10, 20);
//        Lesson2.sequence3n(100, 200);
//        Lesson2.sequence3n(201, 210);
//        Lesson2.sequence3n(900, 1000);

        // TODO siia saab kirjutada koodi testimiseks
    }

    // TODO loe funktsiooni sisendiks on täisarvude massiiv
    // TODO tagasta massiiv mille elemendid on vastupidises järiekorras
    public static int[] reverseArray(int[] inputArray) {
        int[] reversed = new int[inputArray.length];
        for (int i = 0; i < inputArray.length; i++) {
            reversed[i] = inputArray[(inputArray.length - 1) - i];
        }
        return reversed; //
    }

    // TODO tagasta massiiv mis sisaldab n esimest paaris arvu
    // Näide:
    // Sisend 5
    // Väljund 2 4 6 8 10
    public static int[] evenNumbers(int n) {
        int[] returnArray = new int[n];
        int index = 0;
        int number = 2;
        while (index < n) {
            returnArray[index] = number;
            index++;
            number = number + 2;

//        int index = 0;
//        for (int i = 2; i < 2*n; i++) {
//            if (Lesson1.isEven(i)) {
//                returnArray[index] = i;
//                index++;

        }
        return returnArray;
    }

    // TODO, leia massiivi kõige väiksem element
    public static int min(int[] arrayNimi) { // 4,2,6,9
        int minElement = arrayNimi[0]; // minElement = 4
        for (int i = 1; i < arrayNimi.length; i++) { // i = 0-4
            if (arrayNimi[i] < minElement) { // arraynimi kohal 1 arraynimi[1 ]on < minElement
                minElement = arrayNimi[i];
            }
        }
        return minElement;


    }

    // TODO, leia massiivi kõige suurem element
    public static int max(int[] arrayNimi) { //4,2,6,9
        int maxElement = arrayNimi[0]; // maxElement = 9
        for (int i = 0; i < arrayNimi.length; i++) { // i = 0-4
            if (arrayNimi[i] > maxElement) { // arrayNimi kohal 1 arraynimi[1 ]on > maxElement
                maxElement = arrayNimi[i];
            }
        }
        return maxElement;
    }

    // TODO, leia massiivi kõigi elementide summa
    public static int sum(int[] x) {
        int sum = 0;
        for (int i = 0; i < x.length; i++) {
            sum += x[i];
        }
        return sum;
    }

    // TODO trüki välja korrutustabel mis on x ühikut lai ja y ühikut kõrge
    // TODO näiteks x = 3 y = 3
    // TODO väljund
    // 1 2 3
    // 2 4 6
    // 3 6 9
    // TODO 1 trüki korrutustabeli esimene rida (numbrid 1 - x)
    // TODO 2 lisa + " " print funktsiooni ja kasuta print mitte println
    // TODO 3 trüki seda sama rida y korda
    // TODO 4 Kuskile võiks kirjutada System.out.println(),
    //  et saada taebli kuju
    // TODO 5 võrdle ridu. Kas on mingi seaduspärasus ridade vahel,
    // mis on ja mis võiks olla. Äkki tuleb mõni idee
    public static void multiplyTable(int x, int y) {


        //int targetX = 0;
        // int targetY = 0;


        for (int i = 1; i <= x; i++) {
            System.out.print("\n");
            for (int j = 1; j <= y; j++) { //j 1
                System.out.print((i * j) + " ");
            }
        }
    }

    //        int x1 = 1 * 1;
//        int x2 = 2 * 2;
//        int x3 = 3 * 3;
//        int x4 = 4 * 4;
//
//        int y1 = 1 * 1;
//        int y2 = 2 * 2;
//        int y3 = 3 * 3;
//        int y4 = 4 * 4;

    //if (x == 1 && y == 1) {
    //  System.out.print(x1);
    //} else if (x == 1 && y >)   // ((x == 1 && y == 2) || (x == 2 && y == 1) || (x == 2 && y == 2)) {
    // System.out.print((x2-1) + " " + (x2) + " " + (x3-2) + (x3-2) + "\n" + "  " + (y2) + " " + (y5)); //(x + " " + (x2) + " " + (x3) + " " + (x4) + "\n" + y + " " + (y2) + " " + (y3) + " " + (y4) )

    // } else if (x == 3 && y == 3) {
    // System.out.print((x - 1) + " " + x + "\n" + y + " " + (y + 1));

//        if (x == 1 && y == 1) {
//            System.out.print(x);
//        }
//        else if (x == 1 && y == 2) {
//            System.out.print(x + " " + (x + 1) + "\n" + y);
//        }
//        else if (x == 2 && y == 1) {
//            System.out.print(x + " " + (x + 1) + "\n" + y);
//        }
//        else if (x == 2 && y == 2) {
//            System.out.print((x - 1) + " " + x + "\n" + y + " " + (y + 1));
//
//        }
//        else if (x == 3 && y == 3) {
//            System.out.print((x - 1) + " " + x + "\n" + y + " " + (y + 1));


    // TODO
    // Fibonacci jada on fib(n) = fib(n-1) + fib(n-2);
    // 0, 1, 1, 2, 3, 5, 8, 13, 21
    // Tagasta fibonacci jada n element. Võid eeldada, et n >= 0
    public static int fibonacci(int n) {

        int num1 = 0; //num 0
        int num2 = 1; // num 1
        int counter = 0; /// counter 0
        while (counter < n) { //senikaua kuni counter on väikesem, kui antud n, lähme loopi
            System.out.println(num1 + " "); // prindi num 1 ehk 0 hetkel
            int num3 = (num2) + (num1); // num3 saab väärtuse num 2+num1 milleks hetkel 1
            num1 = num2;// num 1 mis oli 0 saab 1ks
            num2 = num3;// num 2 mis oli 1 saab olema (num2+1) ehk 2+1 sest num1 (eelnevalt 0) muutus üheks
            counter = counter + 1; //counter mis oli 0 saab väärtuse counter + 1, ehk 1 praegu(järgmisel loopil 2)
        }
        return num1;

        // 0 1 | 0 + 1 = 1
        // 1 1 | 1 + 1 = 2
        // 1 2 | 1 + 2 = 3
        // 2 3 | 2 + 3 = 5
        // 3 5 | 3 + 5 = 8

    }

    // TODO
    // Kujutame ette numbrite jada, kus juhul kui number on paaris arv siis me jagame selle 2-ga
    // Kui number on paaritu arv siis me korrutame selle 3-ga ja liidame 1. (3n+1)
    // Seda tegevust teeme me niikaua kuni me saame vastuseks 1
    // Näiteks kui sisend arv on 22, siis kogu jada oleks:
    // 22 -> 11 -> 34 -> 17 -> 52 -> 26 -> 13 -> 40 -> 20 -> 10 -> 5 -> 16 -> 8 -> 4 -> 2 -> 1
    // Sellise jada pikkus on 16
    //
    // Kirjutada programm, mis peab leidma kõige pikema jada pikkuse mis jääb kahe täis arvu vahele
    // Näiteks
    // Sisend 10 20
    // Siis tuleb vaadata, kui pikk jada tuleb kui esimene numbr on 10. Järgmisen tuleb arvutada number 11 jada pikkus.
    // jne. kuni numbrini 20
    // Tagastada tuleb kõige pikem number
    // Näiteks sisendi 10 ja 20 puhul on vastus 20

    public static int sequence3n(int x, int y) {

        int temp = 0;
        for (int i = 1; x <= y; x++) {


        }

//        for (int countfrom = x; countfrom != y; countfrom++) {
//
//
//            if (whatXCurrently == x) {
//
//                for (int i = countfrom; whatXCurrently != 1; counter++) {
//
//
//                    if (Lesson1.isEven(whatXCurrently)) {
//                        whatXCurrently = whatXCurrently / 2;
//
//                    } else if (Lesson1.isEven(whatXCurrently) == false) {
//                        whatXCurrently = (whatXCurrently * 3) + 1;
//                    }
//                }
//
//            } else {
//                whatXCurrently = countfrom;
//                for (int i = countfrom; whatXCurrently != 1; counter++) {
//
//                    if (Lesson1.isEven(whatXCurrently)) {
//                        whatXCurrently = whatXCurrently / 2;
//                    } else if (Lesson1.isEven(whatXCurrently) == false) {
//                        whatXCurrently = (whatXCurrently * 3) + 1;
//                    }
//                }
//            }
//            if (maxSequence <= counter) {
//                maxSequence = counter + 1;
//            }
//            counter = 0;


        return 0;

    }


    public static int nextElement(int x) {

        if (x % 2 == 0) {
            x = x / 2;
        } else  {
            x = (x * 3) + 1;
        }
        return x;  }


        //TODO Tagaasta sequence järgmine element
        // x = 1 -> 4 etc



// järgmisena

    public static int getSeqLength(int x) {

        int counter = 0;

        if (nextElement(x) !=1){

        }
        for (counter = 0; x != 1; x++) {
            if (Lesson1.isEven(x)) {
                x = x / 2;
            } else if (Lesson1.isEven(x) == false) {
                x = (x * 3) + 1;
            }
            counter++;

        }
        return counter;
    }


}


// String a = "Hello";
//System.out.println(a.charAt(3)); / tagastab neljanda // 0 on ka number

// if (a.equals(b)) {
// a == b kasutame ainult primitiivide juhul, objektide puhul lati equals (ylemine) meetod
//


