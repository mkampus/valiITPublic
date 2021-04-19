package ee.bcs.valiit.codewarsandbackups;

public class CodeWars {

    public static void main(String[] args) {
        System.out.println(redKnight(0,4));

    }


    public static PawnDistance redKnight(int knight, long pawn) {

        long PawnDistance = pawn;
        int knightSquareVertical = knight;
        int knightSquareHorizontal = 0;
        for (PawnDistance = pawn+1; knightSquareHorizontal != (PawnDistance-2); PawnDistance++){
            knightSquareHorizontal = knightSquareHorizontal + 2;
            if (knightSquareVertical == 0){
                knightSquareVertical++;
            } else {
                knightSquareVertical--;
            }
        } if (knightSquareVertical==1){
            String colorSquare = "White";
            return new PawnDistance();
        } else {
            String colorSquare = "Black";
            return new PawnDistance();
        }

    }
}

class PawnDistance {

    int knightVertical = 0;

}