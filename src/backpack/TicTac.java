package backpack;

import java.awt.*;
import java.util.Scanner;

public class TicTac {

    private char[][] board = new char[3][3];

    private String name1;
    private String name2;

    private void get_names(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Set name for Player1");
        name1 = scanner.nextLine();
        if(name1.isEmpty())
            name1 = "Player1";
        System.out.println("Set name for Player2");
        name2 = scanner.nextLine();
        if(name2.isEmpty())
            name2 = "Player2";
    }
    private boolean init_board(char[][] board){
        for(int i = 0 ; i < 3 ; i++){
            for(int j =0; j < 3; j++){
                board[i][j]='0';
            }
        }
        return true;
    }
    private void print_board(char[][] board)
    {
        char row = 'a';

        System.out.println("\n\t1\t\t2\t\t3\n");
        for(int i = 0 ; i < 3 ; i++){

            System.out.print(row+"\t");
            for(int j =0; j < 3; j++){
                if(board[i][j] != '0')
                System.out.print(board[i][j]);
                if(j<2)
                    System.out.print("\t|\t");
            }
            row++;
            if(i<2)
            System.out.print("\n\t__________________\n");
        }
        System.out.print("\n");
    }
    private void pick_move(char[][] board, int player){
        Scanner scanner = new Scanner(System.in);

        boolean invalid_pick = true;
        while(invalid_pick){
            if(player%2+1 == 1) {
                System.out.print(name1 + " is making move. Pick field: ");
            }else{
                System.out.print(name2 + " is making move. Pick field: ");
            }
            String pick = scanner.nextLine();
            switch (pick){
                case "a1":
                    if(board[0][0] != '0') {
                        System.out.println("This field is already taken. You can't take it.");
                        break;
                    }
                    if(player%2 == 0) {
                        board[0][0] = 'O';
                        invalid_pick = false;
                    }else {
                        board[0][0] = 'X';
                        invalid_pick = false;
                    }
                    break;
                case "a2":
                    if(board[0][1] != '0') {
                        System.out.println("This field is already taken. You can't take it.");
                        break;
                    }
                    if(player%2 == 0) {
                        board[0][1] = 'O';
                        invalid_pick = false;
                    }else {
                        board[0][1] = 'X';
                        invalid_pick = false;
                    }
                    break;
                case "a3":
                    if(board[0][2] != '0') {
                        System.out.println("This field is already taken. You can't take it.");
                        break;
                    }
                    if(player%2 == 0) {
                        board[0][2] = 'O';
                        invalid_pick = false;
                    }else {
                        board[0][2] = 'X';
                        invalid_pick = false;
                    }
                    break;
                case "b1":
                    if(board[1][0] != '0') {
                        System.out.println("This field is already taken. You can't take it.");
                        break;
                    }
                    if(player%2 == 0) {
                        board[1][0] = 'O';
                        invalid_pick = false;
                    }else {
                        board[1][0] = 'X';
                        invalid_pick = false;
                    }
                    break;
                case "b2":
                    if(board[1][1] != '0') {
                        System.out.println("This field is already taken. You can't take it.");
                        break;
                    }
                    if(player%2 == 0) {
                        board[1][1] = 'O';
                        invalid_pick = false;
                    }else {
                        board[1][1] = 'X';
                        invalid_pick = false;
                    }
                    break;
                case "b3":
                    if(board[1][2] != '0') {
                        System.out.println("This field is already taken. You can't take it.");
                        break;
                    }
                    if(player%2 == 0) {
                        board[1][2] = 'O';
                        invalid_pick = false;
                    }else {
                        board[1][2] = 'X';
                        invalid_pick = false;
                    }
                    break;
                case "c1":
                    if(board[2][0] != '0') {
                        System.out.println("This field is already taken. You can't take it.");
                        break;
                    }
                    if(player%2 == 0) {
                        board[2][0] = 'O';
                        invalid_pick = false;
                    }else {
                        board[2][0] = 'X';
                        invalid_pick = false;
                    }
                    break;
                case "c2":
                    if(board[2][1] != '0') {
                        System.out.println("This field is already taken. You can't take it.");
                        break;
                    }
                    if(player%2 == 0) {
                        board[2][1] = 'O';
                        invalid_pick = false;
                    }else {
                        board[2][1] = 'X';
                        invalid_pick = false;
                    }
                    break;
                case "c3":
                    if(board[2][2] != '0') {
                        System.out.println("This field is already taken. You can't take it.");
                        break;
                    }
                    if(player%2 == 0) {
                        board[2][2] = 'O';
                        invalid_pick = false;
                    }else {
                        board[2][2] = 'X';
                        invalid_pick = false;
                    }
                    break;
                default:
                    System.out.println("Insert proper field");
                    break;

            }
        }
    }
    public int game(){
        if(init_board(board))
        {
            get_names();
            print_board(board);
            for(int i = 0; i < 9; i++) {
                pick_move(board, i);
                print_board(board);
                if(win(board)) {
                    if (i % 2 == 0) {
                        System.out.print(name1 + " wins! Congratulations!");
                        return 0;
                    }else{
                        System.out.print(name2 + " wins! Congratulations!");
                        return 0;
                    }
                }
            }
            System.out.print("Draw!");
            return 0;
        }else{
            return -1;
        }


    }

    private boolean win(char[][] board) {
        for(int i = 0; i < 3; i ++){
            if(board[i][0] == board[i][1] && board[i][0] == board[i][2] && board[i][0] != '0')
                return true;
            if(board[0][i] == board[1][i] && board[0][i] == board[2][i] && board[0][i] != '0')
                return true;
        }
        if(board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[0][0] != '0')
            return true;
        if(board[0][2] == board[1][1] && board[0][2] == board[2][0] && board[0][2] != '0')
            return true;
        return false;
    }
}
