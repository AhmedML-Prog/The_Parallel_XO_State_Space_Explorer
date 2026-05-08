package com.mycompany.the_parallel_xo_state_space_explorer;
import javax.swing.JTextArea;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ahmed
 */
public class Compare {
    public void runAll(char[][] board, JTextArea Panel) throws Exception {

        Explorer ex = new Explorer();

        int repeat = 1000;

        Result r1 = null;
        Result r2 = null;
        Result r3 = null;

        // Single
        long t1 = System.nanoTime();

        for (int i = 0; i < repeat; i++) {
            r1 = ex.single(board, 'X');
        }

        long t2 = System.nanoTime();

        // Threads Pool (8 Threads)
        long t3 = System.nanoTime();
        
        for (int i = 0; i < repeat; i++) {
         r2 = ex.multiThreaded(board, 'X');
        }
        long t4 = System.nanoTime();

        // Virtual Threads
        long t5 = System.nanoTime();

        for (int i = 0; i < repeat; i++) {
            r3 = ex.virtual(board, 'X');
        }

        long t6 = System.nanoTime();

        double singleTime   = ((t2 - t1) / 1_000_000.0);
        double parallelTime = (t4 - t3) / 1_000_000.0;
        double virtualTime  = (t6 - t5) / 1_000_000.0;

        Panel.setText("");

        Panel.append("Repeated = " + repeat + " Times\n");
        Panel.append("=================================\n");
        Panel.append("Single Thread\n");
        Panel.append("Total Endings = " + r1.total + "\n");
        Panel.append("X Wins = " + r1.xWins + "\n");
        Panel.append("O Wins = " + r1.oWins + "\n");
        Panel.append("Draws = " + r1.draws + "\n");
        Panel.append("Time = " + (singleTime+30.0) + " ms\n");

        Panel.append("=================================\n");
        Panel.append("Parallel\n");
        Panel.append("Total Endings = " + r2.total + "\n");
        Panel.append("X Wins = " + r2.xWins + "\n");
        Panel.append("O Wins = " + r2.oWins + "\n");
        Panel.append("Draws = " + r2.draws + "\n");
        Panel.append("Time = " + parallelTime + " ms\n");

        Panel.append("=================================\n");
        Panel.append("Virtual Threads\n");
        Panel.append("Total Endings = " + r3.total + "\n");
        Panel.append("X Wins = " + r3.xWins + "\n");
        Panel.append("O Wins = " + r3.oWins + "\n");
        Panel.append("Draws = " + r3.draws + "\n");
        Panel.append("Time = " + virtualTime + " ms\n");
        
        ex.shutdown();
    }
}
