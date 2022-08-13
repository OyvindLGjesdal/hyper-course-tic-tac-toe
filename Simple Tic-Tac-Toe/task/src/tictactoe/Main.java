package tictactoe;

import java.util.Scanner;

public class Main {
    static final char X = 'X';
    static final char O = 'O';
    static final char EMPTY =  '_';

    static boolean draw(char[][] board) {

        for (char[] row: board){
            for (char field: row){ if (field == EMPTY) { return false;}
            }

        }
        return true;
    }
    static boolean winner(char[][] board) {
        for (char[] row : board) {
            if ((row[0] == X || row[0] == O) && row[0] == row[1] && row[0] == row[2])
                return true;
                }
        for (int i = 0; i < 3; i++) {
            if ((board[0][i] == X || board[0][i] == O) && board[0][i] == board[1][i] && board[0][i] == board[2][i]) {
                return true;
            }
            char[] d1 = {board[0][0], board[1][1], board[2][2]};
            char[] d2 = {board[0][2], board[1][1], board[2][0]};
            if ((d1[0] == O || d1[0] == X) && d1[0] == d1[1] && d1[0] == d1[2]) {
                return true;
            }
            if ((d2[0] == O || d2[0] == X) && d2[0] == d2[1] && d2[0] == d2[2]) {
                   return  true;}
            }
        return false;
    }

    static char [][] add( char[][] board, Scanner scanner, char symbol) {
        String[] coords = scanner.nextLine().split(" ");
        int c1, c2;
        try {
            c1 = Integer.parseInt(coords[0]) -1;
            c2 = Integer.parseInt(coords[1]) -1;
        }
        catch (Exception e){
            System.out.println("You should enter numbers!");
            return add(board, scanner,symbol);
        }
        if (c1 > 2 || c1 < 0 || c2 > 2 || c2 < 0) {
            System.out.println("Coordinates should be from 1 to 3!");
            return add(board,scanner,symbol);
        }
        char cell = board[c1][c2];
        if (cell == O || cell == X) {
            System.out.println("This cell is occupied! Choose another one!");
            return add(board, scanner, symbol);
        }
        board[c1][c2] = symbol;
        return board;
    }

    static char[][] add (char[][] board, int coord1, int coord2) {
        char pos = board[coord1-1][coord2-1];
        String msg;
       if (pos == X || pos == O) {
           msg = "This cell is occupied! Choose another one!";
       }
        return board;

    };

    public static void printBoard (char[][] board) {
        System.out.println("---------");
        System.out.println("| " + board[0][0] + " " + board[0][1] + " " + board[0][2] + " |");
        System.out.println("| " + board[1][0] + " " + board[1][1] + " " + board[1][2] + " |");
        System.out.println("| " + board[2][0] + " " + board[2][1] + " " + board[2][2] + " |");
        System.out.println("---------");
    }

    public static void main(String[] args) {
        char[][] ticTacToeBoard = {
                {'_', '_', '_'},
                {'_', '_', '_'},
                {'_', '_', '_'}
        };
        Scanner scanner = new Scanner(System.in);
        printBoard(ticTacToeBoard);
        char symbol = X;
        int i = 0;
        while (!winner(ticTacToeBoard) && !draw(ticTacToeBoard)) {
            symbol = i % 2 == 0 ? X : O;
            i = i+1;
            add(ticTacToeBoard, scanner, symbol);
            printBoard(ticTacToeBoard);

        }
        if (winner(ticTacToeBoard)) {
            System.out.printf("%s wins", symbol);
            System.exit(0);
        }
        if (draw(ticTacToeBoard)){
            System.out.print("Draw");
        }
    }
}
