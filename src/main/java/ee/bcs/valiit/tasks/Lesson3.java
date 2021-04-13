package ee.bcs.valiit.tasks;

import java.util.*;

public class Lesson3 {
    public static void main(String[] args) {


    }
    //if (arrayNimi[i] < minElement) { // arraynimi kohal 1 arraynimi[1 ]on < minElement
//        minElement = arrayNimi[i];
//            reformed.add(counter,); ///reversed[i] = inputArray[(inputArray.length - 1) - i];


    // TODO siia saab kirjutada koodi testimiseks


    // TODO tagasta x faktoriaal.
    // Näiteks
    // x = 5
    // return 5*4*3*2*1 = 120
    public static int factorial(int x) {

        int sum = 1;
        for (int i = 1; i <= x; i++) {
            sum = sum * i; //// 1*2*3*4*5=120
        }
        return sum;
    }

    // TODO tagasta string tagurpidi
    public static String reverseString(String a) {


        int sLength = a.length(); // Kui pikk on string ? (Tere puhul 4)
        char[] test = a.toCharArray();
        List<Character> list2 = new LinkedList<>();//   String reversed2 = "";  // paneb characterid a stringis character arreysse
        for (int i = sLength - 1; i >= 0; i--) { // i võrdub stringi pikkus -1 ehk ( 4 - 1)
            // vaatab kas i on suuremvõrdne 0 ( 3 ei ole)
            // läheb loopi
            char b = a.charAt(i);
            list2.add(b);
            //loob uue characteri nimega b, paneb selleks misiganes char on i positsioonil
            //   siis prindib b ja tühiku ning hüppab tagasi loopi otsa kus i--
        }
        String test2 = "";
        for (int x = 0; x != a.length(); x++) {
            char letter = list2.get(x);
            test2 = test2 + "" + letter;
        }
        return test2;
    }

    // TODO tagasta kas sisestatud arv on primaar arv (jagub ainult 1 ja iseendaga)
    public static boolean isPrime(int x) {

        int m = x / 2;
        if (x == 0 || x == 1) {
            return false;
        } else {
            for (int i = 2; i < x; i++) {
                if (x % i == 0) {
                    return false;
                }
            }
        }
        return true;
    }


    // TODO sorteeri massiiv suuruse järgi.
    // TODO kasuta tsükleid, ära kasuta ühtegi olemasolevat sort funktsiooni // kÕige väiksem element läheb viimaseks
    public static int[] sort(int[] a) {

        int[] newArray = new int[a.length];
        int minElement = 0;
        int counter3 = 0;
        int counter = 0;

        while (counter3 != a.length) {
            minElement++;
            for (counter = 0; counter < a.length; counter++) {
                if (a[counter] == minElement) {
                    minElement = a[counter];
                    newArray[counter3] = minElement;
                    counter3++;
                }
            }
        }
        return newArray;
    }


    public static int evenFibonacci(int x) {

        int numbersFromSequence = 0;
        int numbersAdded = 0;

        for (int i = 0; i < x; i++) {   // peab tagastama fibonacci jada {counter} element.
            numbersFromSequence = Lesson2.fibonacci(i);
            if (Lesson1.isEven(numbersFromSequence) && numbersFromSequence < x) {
                numbersAdded = numbersAdded + numbersFromSequence;
            }
        }
        /// leiann esimesest kuni x fibonaccy, siis checking kas on paaris,
        // kui on paaris siis liidan kokku, kui ei siis ei tee midagi
        // TODO liida kokku kõik paaris fibonacci arvud kuni numbrini x
        // kõik fibonacci/paaris arvud mille väärtus on väiksem kui ntx 30

        return numbersAdded;
    }

    public static String morseCode(String text) {

// saan teksti, pean selle morse koodi tõlkima.
        // esimene mõte, annan igale characterile väärtuse.


        int stringLength = text.length();
        String TranslatedMessage = "";
        Map<Character, String> Alphabet = new HashMap<>();
        Alphabet.put('a', ".-");
        Alphabet.put('b', "-...");
        Alphabet.put('c', "-.--.");
        Alphabet.put('d', "-..");
        Alphabet.put('e', ".");
        Alphabet.put('f', "..-.");
        Alphabet.put('g', "--.");
        Alphabet.put('h', "....");
        Alphabet.put('i', "..");
        Alphabet.put('j', ".---");
        Alphabet.put('k', "-.-");
        Alphabet.put('l', ".-..");
        Alphabet.put('m', "--");
        Alphabet.put('n', "-.");
        Alphabet.put('o', "---");
        Alphabet.put('p', ".--.");
        Alphabet.put('q', "--.-");
        Alphabet.put('r', ".-.");
        Alphabet.put('s', "...");
        Alphabet.put('t', "-");
        Alphabet.put('u', "..-");
        Alphabet.put('v', "...-");
        Alphabet.put('w', ".--");
        Alphabet.put('y', ".--");
        Alphabet.put('z', "--..");
        for (int i = 0; i < stringLength; i++) {
            Character Letter = text.charAt(i);
            TranslatedMessage = TranslatedMessage + Alphabet.get(Letter);
            TranslatedMessage = TranslatedMessage + " ";
            // TODO kirjuta programm, mis tagastab sisestatud teksti morse koodis (https://en.wikipedia.org/wiki/Morse_code)
            // Kasuta sümboleid . ja - ning eralda kõik tähed tühikuga
        }
        return TranslatedMessage.trim();
    }
}
