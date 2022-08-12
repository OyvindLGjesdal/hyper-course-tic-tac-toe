package tictactoe;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static final char X = 'X';
    static final char O = 'O';
    static final char EMPTY = '_';
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println("---------");
        System.out.println("| " + input.charAt(0) + " " + input.charAt(1) + " " + input.charAt(2)+ " |");
        System.out.println("| " + input.charAt(3) + " " + input.charAt(4) + " " + input.charAt(5)+ " |");
        System.out.println("| " + input.charAt(6) + " " + input.charAt(7) + " " + input.charAt(8)+ " |");
        System.out.println("---------");

        char[] vertical_1 = {input.charAt(0), input.charAt(1),input.charAt(2)};
        char[] vertical_2 = {input.charAt(3), input.charAt(4),input.charAt(5)};
        char[] vertical_3 = {input.charAt(6), input.charAt(7),input.charAt(8)};
        char[] horizontal_1 = {input.charAt(0), input.charAt(3),input.charAt(6)};
        char[] horizontal_2 = {input.charAt(1), input.charAt(4),input.charAt(7)};
        char[] horizontal_3 = {input.charAt(2), input.charAt(5),input.charAt(8)};
        char[] diagonal_1 = {input.charAt(0), input.charAt(4),input.charAt(8)};
        char[] diagonal_2 = {input.charAt(2), input.charAt(4),input.charAt(6)};

        char[][] states = {vertical_1, vertical_2, vertical_3, horizontal_1, horizontal_2, horizontal_3, diagonal_1, diagonal_2};

        System.out.println(row(states));
    }

    public static String row (char[][] states) {
        int x = 0;
        int o = 0;
        int empty = 0;
        int o_wins = 0;
        int x_wins = 0;

        for (int i = 0; i < states.length ; i++ ) {
            char[] state = states[i];
            for (char c : state) {
                if (i < 3) {
                    if (c == O) {
                        o++;
                    } else if (c == X) {
                        x++;
                    } else {
                        empty++;
                    }
                }
            }
            if (state[0] == X && state[1] == X && state[2] == X) {
                x_wins++;
            } else if (state[0] == O && state[1] == O && state[2] == O) {
                o_wins++;
            }
        }
        if (x_wins == 1 && o_wins == 0) {
            return "X wins";
        } else if (o_wins == 1 && x_wins == 0){
            return  "O wins";
        } else if (o_wins + x_wins > 1 || Math.max(x,o) - Math.min(x,o) > 1) {
            return "Impossible";
        } else  if(empty == 0) {
            System.out.println(x_wins + o_wins);
            return "Draw";
        } else {
            return "Game not finished";
        }

        }

}
