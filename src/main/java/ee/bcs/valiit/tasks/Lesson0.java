package ee.bcs.valiit.tasks;

public class Lesson0 {
    public static void main(String[] args) {

    }

    // TODO
    // defineeri 3 muutujat a = 1, b = 1, c = 3
    // Prindi välja a==b
    // Prindi välja a==c
    // Lisa rida a = c
    // Prindi välja a==b
    // Prindi välja a==c, mis muutus???
    public static void excersie1(){
        System.out.println("ESIMENE ÜLESANNE");

        int a = 1;
        int b = 1;
        int c = 3;

        System.out.println(a==b);
        System.out.println(a==c);
        a = c;
        System.out.println(a==b);
        System.out.println(a==c);


    }
    // TODO
    // Loo muutujad x1 = 10 ja x2 = 20, vali sobiv andmetüüp
    // Tekita muutuja y1 = ++x1, trüki välja nii x1 kui y1
    // Tekita muutuja y2 = x2++, trüki välja nii x2 ja y2
    // Analüüsi tulemusi

    public static void excersie2(){
        System.out.println("TEINE ÜLESANNE");

        double x1 = 10;
        double x2 = 20;

        double y1 = ++x1; //lisab v incrementib prefix ie before the variable and expression

        double y2 = x2++;//increment postfix ie after after
        System.out.println(y1);
        System.out.println(y2);

    }

    // TODO
    // Loo arvulised muutujad
    // a = 18 % 3
    // b = 19 % 3
    // c = 20 % 3
    // d = 21 % 3
    // Prindi välja kõigi muutujate väärtused
    public static void excersie3(){
        System.out.println("KOLMAS ÜLESANNE");
        long a = 18 % 3;
        System.out.println(a);
        long b = 19 % 3;
        System.out.println(b);
        long c = 20 % 3;
        System.out.println(c);
        long d = 21 % 3;
        System.out.println(d);

    }

    // TODO
    // Defineeri String tüüpi muutuja mille sisu oleks "\"\\""
    // Trüki muutuja sisu välja
    public static void excersie4(){
        String a = "\"\\\"\\\\\"\"";
        System.out.println(a);
        //String test = "\"\\\"\\\\\\"\";
       // System.out.println(test);



    }
}
