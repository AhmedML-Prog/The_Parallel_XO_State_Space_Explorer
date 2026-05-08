package com.mycompany.the_parallel_xo_state_space_explorer;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ahmed
 */


public class Board {

    public static char[][] copy(char[][] board) {

        char[][] newBoard = new char[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                newBoard[i][j] = board[i][j];
            }
        }

        return newBoard;
    }
    public static boolean didPlayerXPlay(char[][] board) {

    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {

            if (board[i][j] == 'X') {
                return true;
            }
        }
    }

    return false;
    }
    
    public static List<int[]> getMoves(char[][] board) {

        List<int[]> moves = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                if (board[i][j] == '-') {
                    moves.add(new int[]{i, j});
                }
            }
        }

        return moves;
    }

    public static boolean isWinner(char[][] b, char p) {

        for (int i = 0; i < 3; i++) {
            if (b[i][0] == p && b[i][1] == p && b[i][2] == p)
                return true;
        }

        for (int i = 0; i < 3; i++) {
            if (b[0][i] == p && b[1][i] == p && b[2][i] == p)
                return true;
        }

        if (b[0][0] == p && b[1][1] == p && b[2][2] == p)
            return true;

        if (b[0][2] == p && b[1][1] == p && b[2][0] == p)
            return true;

        return false;
    }

    public static boolean isFull(char[][] board) {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-')
                    return false;
            }
        }

        return true;
    }
}
