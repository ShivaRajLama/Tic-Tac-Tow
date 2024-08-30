import java.util.Random;
import java.util.Scanner;

public class Game {
    public static String player1 = "X";
    public static String player2 = "O";

    public static void main(String[] args) {
        runGame();

    }


    public static void runGame(){
        Random random = new Random();
        int player = random.nextInt(2);
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        String[][] board = getBoard();
        System.out.printf("Player %s goes 1st ",player==0?player1:player2);
        System.out.println();
        printBoard(board);
        int position;

        while(running){
            System.out.printf("Player %s enter the position",player==0?player1:player2);
            position = scanner.nextInt();
            boolean isValid = addMove(board,position,player==0?player1:player2);
            running = check(board).equals("continue");
            if(isValid) {
                player = (player + 1) % 2;
            }else{
                System.out.println("Invalid move");
            }
            printBoard(board);
        }

        switch(check(board)){
            case "X"-> System.out.println("The winner is Player X");
            case "O"-> System.out.println("The winner is Player O");
            case "draw" -> System.out.println("Its a draw");
            default -> System.out.println("Invalid Game");
        }

    }


    static String[][] getBoard(){
        String[][] board = new String[3][3];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                board[i][j] = "#";
            }
        }

        return board;
    }

    static String check(String[][] board){
        //Row check
        for(int i=0;i<3;i++){
            if(board[i][0].equals(board[i][1]) && board[i][1].equals(board[i][2])){
                if(board[i][0].equals(player1)) return player1;
                if(board[i][0].equals(player2)) return player2;
            };
        }

        //Column Check
        for(int i=0;i<3;i++){
            if(board[0][i].equals(board[1][i]) && board[1][i].equals(board[2][i])){
                if(board[0][i].equals(player1)) return player1;
                if(board[0][i].equals(player2)) return player2;
            };
        }

        if(board[0][0].equals(board[1][1]) && board[1][1].equals(board[2][2])){
            if(board[0][0].equals(player1)) return player1;
            if(board[0][0].equals(player2)) return player2;
        };

        if(board[0][2].equals(board[1][1]) && board[1][1].equals(board[2][0])){
            if(board[0][2].equals(player1)) return player1;
            if(board[0][2].equals(player2)) return player2;
        };

        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[i].length;j++){
                if(board[i][j].equals("#")){
                    return "continue";
                }
            }
        }

        return "draw";
    }

    static boolean addMove(String[][] board,int position,String player){
        switch (position){
            case 1 -> {
                if(board[0][0].equals("#")) {
                    board[0][0] = player;
                    return true;
                }
            }
            case 2 -> {
                if(board[0][1].equals("#")){
                    board[0][1]= player;
                    return true;}
            }
            case 3-> {
                if(board[0][2].equals("#")){
                    board[0][2]= player;
                    return true;}
            }
            case 4-> {
                if(board[1][0].equals("#")){
                    board[1][0]= player;
                    return true;}
            }
            case 5-> {
                if(board[1][1].equals("#")){
                    board[1][1]= player;return true;}
            }
            case 6-> {
                if(board[1][2].equals("#")){
                    board[1][2]= player;return true;}
            }
            case 7-> {
                if(board[2][0].equals("#")) {
                    board[2][0] = player;
                    return true;
                }
            }
            case 8-> {
                if(board[2][1].equals("#")){
                    board[2][1]= player;
                    return true;
                }
            }
            case 9-> {
                if(board[2][2].equals("#")) {board[2][2]= player;
                    return true;}
            }
            default -> {
                return false;
            }
        }
        return false;
    }

    static void printBoard(String[][] board){
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[i].length;j++){
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
}
