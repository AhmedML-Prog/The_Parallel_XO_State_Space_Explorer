/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.the_parallel_xo_state_space_explorer;

/**
 *
 * @author ahmed
 */
public class Result {
    int xWins = 0;
    int oWins = 0;
    int draws = 0;
    int total = 0;

    public void add(Result r) {
        xWins += r.xWins;
        oWins += r.oWins;
        draws += r.draws;
        total += r.total;
    }
}
