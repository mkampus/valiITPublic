package ee.bcs.valiit.tasks;

public class Lesson2b {
    public static void main(String[] args) {
        Lesson3.reverseString("Tere");



    }
    // TODO trüki välja n arvu
    // näiteks
    // sisend: 5
    // trüki välja: 1 2 3 4 5


    public static void exercise1(int n) {
        int i = 1;
        while (i < n) {
            i++;
            System.out.print(i + " ");
        }

    }

    // TODO tagasta massiiv milles oleks numbrid 1,2,3,4,5
    public static int[] sampleArray() {

        int[] numbers = {1, 2, 3, 4, 5};
        return numbers;
    }

    // TODO loo massiiv mis saab sisendiks n ja tagastab massiivi suurusega n
    // Kus esimene element on 1 ja iga järnev arv on 1 võrra suurem
    // näiteks:
    // sisend: 5
    // vastus: {1, 2, 3, 4, 5}
    public static int[] generateArray(int n) {

        int[] number = new int[n];
        for (int i = 0; i < number.length; i++) {
            number[i] = i + 1;
            System.out.println(i);
        }
        return number;
    }

    // TODO
    // Tagastada massiiv kus oleks numbrid n-ist 0 ini
    // Näiteks: sisend: 5
    // Väljund: 5, 4, 3, 2, 1, 0
    // Näide2: siend: -3
    // Väljund: -3, -2, -1, 0
    public static int[] decreasingArray(int n) {


        if (n >= 0) {
            int[] number = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                number[i] = n - i;
            }
            return number;
        } else {
            int[] number = new int[-n+1];
            for (int i = n; i <= 0; i++) {
                number[-n + i] = i;
            }
//            number[-n+i] = i; /// -(-5)+(-5)
//            number[1] = i; // -(-5)+(-4)
//            number[2] = i;
//            number[3] = i;
//            number[4] = i;
//            number[5] = i;

            return number;
        }
    }
    //
    //
    //
    //
//        }

    // TODO
    // tagasta massiiv pikkusega n, mille kõigi elementide väärtused on 3/// kui sisend on 5, siis tagasta k]igi elementide v''rtus on 3
    public static int[] yl3(int n) {
        int[] returnArray = new int[n];
        for (int i = 0; i < n; i++){
            returnArray[i] = 3;
        }



        return returnArray;



    }
}
