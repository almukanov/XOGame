import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {



    public static final char HUMAN = 'X';
    public static final char PC = 'O';
    public static final char EMPTY_CELL = '_';

    public static final Scanner SCANNER = new Scanner(System.in);
    public static final Random RANDOM = new Random();


    public static char[][] GameField;
    public static int MaxWidth;
    public static int MaxHeight;

    public static void initGameField(){
        MaxHeight = 3;
        MaxWidth = 3;
        GameField = new char[MaxWidth][MaxHeight];
        for (int i = 0; i < MaxWidth; i++) {
            for (int j = 0; j < MaxHeight; j++) {
                GameField[j][i] = EMPTY_CELL;
            }

        }
    }
    public static void DrawField(){

        for (int i = 0; i < MaxWidth; i++){
            for (int j = 0; j < MaxHeight; j++) {
                System.out.print("|"+GameField[j][i]+"|");
            }
            System.out.println();
        }

    }
    public static boolean  ValidCell(int x, int y){
        return (x>=0 && x<MaxHeight && x<MaxHeight && y >=0 && y <MaxWidth);
    }
    public static boolean EmptyCell(int x, int y){

        return GameField[x][y] == EMPTY_CELL;
    }

    public static void HumanTurn(){
        int x;
        int y;
        do {
            System.out.println("Your turn");
            x = SCANNER.nextInt() - 1;
            y = SCANNER.nextInt() - 1;
        } while(!ValidCell(y, x) || !EmptyCell(y,x));
        GameField[y][x] = HUMAN;

    }

    public static void PCTurn(){
        int x;
        int y;
        do {
            System.out.println("PC turn");
            x = RANDOM.nextInt(MaxHeight);
            y = RANDOM.nextInt(MaxWidth);
        } while(!EmptyCell(y,x));
        GameField[y][x] = PC;

    }

    public static boolean IsFull(){
        for (int i = 0; i < MaxWidth; i++) {
            for (int j = 0; j < MaxHeight; j++) {
                if (GameField[i][j] == EMPTY_CELL){
                    return false;
                }

            }
        }return true;
    }

   public static boolean isWin(char inboxChar) {
       int res = 0;
        for (int i = 0; i < MaxWidth; i++) {
            for (int j = 0; j < MaxHeight; j++) {

            // horisontal
           if (GameField[i][j]==inboxChar){
               res++;
           } if(res==MaxHeight)return true;
       }
        }return false;
    }

/*          if (GameField[0][0] == inboxChar && GameField[0][1] == inboxChar && GameField[0][2] == inboxChar) return true;
            if (GameField[1][0] == inboxChar && GameField[1][1] == inboxChar && GameField[1][2] == inboxChar) return true;
            if (GameField[2][0] == inboxChar && GameField[2][1] == inboxChar && GameField[2][2] == inboxChar) return true;

            if (GameField[0][0] == inboxChar && GameField[1][0] == inboxChar && GameField[2][0] == inboxChar) return true;
            if (GameField[0][1] == inboxChar && GameField[1][1] == inboxChar && GameField[2][1] == inboxChar) return true;
            if (GameField[0][2] == inboxChar && GameField[1][2] == inboxChar && GameField[2][2] == inboxChar) return true;

            if (GameField[0][0] == inboxChar && GameField[1][1] == inboxChar && GameField[2][2] == inboxChar) return true;
            if (GameField[0][2] == inboxChar && GameField[1][1] == inboxChar && GameField[2][0] == inboxChar) return true;*/




public static void  main(String[] args){
    initGameField();
    DrawField();
   while(true) {
       HumanTurn();
       DrawField();
       if (IsFull()){
           break;
       }
       if (isWin(HUMAN)){
           System.out.println("You are winner!");
           break;
       }
       PCTurn();
       DrawField();
       if (IsFull()){
           break;
       }
       if (isWin(PC)){
           System.out.println("PC is winner");
           break;
       }
   }
}
}
