/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.the_parallel_xo_state_space_explorer;
/**
 *
 * @author ahmed
 */
public class main {

    public static void main(String[] args) throws Exception {

       try {
            com.formdev.flatlaf.themes.FlatMacDarkLaf.setup();
        } catch (Exception e) {
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }
}


