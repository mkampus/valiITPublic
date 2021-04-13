package ee.bcs.valiit.tests;

import java.util.Scanner;

public class Test1 {

    public static int[] newArray(int[] array) {


        array[0] = 0;
        return array;
    }


    public static boolean main(String[] args) {
        boolean test = true;
        Scanner scanner = new Scanner(System.in);
        int testNumber = scanner.nextInt();

        if (!(testNumber % 3 == 0) && (testNumber % 7 == 0)) { //kui testnumber ei jagu kolmega ja jagub seitsmega
            test = true;
        } else if ((testNumber % 3 == 0) && !(testNumber % 7 == 0)) { //kui testnumber ei jagu seitsmega ja jagub kolmega
            test = true;
        } else { // kui ei jagu ei kolme ega seitsega.
            test = false;
        }
        return test;

    }

//    ÜL 1
//    Tee funktsioon, mis tagastab boolean väärtuse ja võtab sisse ühe parameetri
//    funktsioon peab tagastama
//		true: kui sisend parameeter jagub 3 või 7 (aga ei jagu mõlema numbriga)
//            false: kui sisend parameeter ei jagu 3 ega 7 või jagub mõlema numbriga


    // ÜL2
    // lisa x igale array elemendile
    // Näiteks
    // sisend [1,2,3], 5
    // vastus [6,7,8]
    public static int[] addToArray(int[] array, int x) {
        int[] newArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i] + x;
        }
        return newArray;
    }

}


