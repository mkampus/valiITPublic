package ee.bcs.valiit.codewarsandbackups;

import org.springframework.boot.builder.SpringApplicationBuilder;

public class SeitsmesRaskusJaden {

    public static void main(String[] args) {

        System.out.print(SeitsmesRaskusJaden.toJadenCase("test test test"));
    }

    public static String toJadenCase(String phrase) {

        if ((phrase == null) || (phrase == "")){
            return null;
        }

        String returnPhrase= "";
        int test = 0;
        for (int i=0; i<phrase.length(); i++){
            char ch = phrase.charAt(i);

            char firstChar = phrase.charAt(0);
            if (ch==' '){
               Character Upper = Character.toUpperCase(phrase.charAt(i+1));
                returnPhrase = returnPhrase + " " + Upper;
                i++;
            } else if ((Character.isLowerCase(firstChar)) && (test == 0)) {
                firstChar = Character.toUpperCase(firstChar);
                returnPhrase = firstChar + "";
                test++;
            } else {
                returnPhrase = returnPhrase + phrase.charAt(i);
                returnPhrase = returnPhrase + "";
            }

        }
        return returnPhrase;
    }
}
