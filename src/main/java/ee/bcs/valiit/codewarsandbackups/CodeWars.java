package ee.bcs.valiit.codewarsandbackups;

public class CodeWars {

    public static void main(String[] args) {
        System.out.println(redKnight(0,4));

    }


    public static PawnDistance redKnight(int knight, long pawn) {

        long pawnPosition = pawn;
        int knightSquareVertical = knight;
        int knightSquareHorizontal = 0;
        for (pawnPosition = pawn+1; knightSquareHorizontal != (pawnPosition-2); pawnPosition++){
            knightSquareHorizontal = knightSquareHorizontal + 2;
            if (knightSquareVertical == 0){
                knightSquareVertical++;
            } else {
                knightSquareVertical--;
            }
        } if (knightSquareVertical==1){
            String colorSquare = "White";
        } else {
            String colorSquare = "Black";
        }
            return new PawnDistance();
    }
}

class PawnDistance {

    int knightVertical = 0;

}