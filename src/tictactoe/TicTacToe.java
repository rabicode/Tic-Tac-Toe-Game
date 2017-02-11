/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.awt.Color;
import javax.swing.JFrame;

/**
 *
 * @author User
 */
public class TicTacToe {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        JFrame ttt = new TicTacToeFrame();
        ttt.setTitle("Tic Tac Toe Game !");
        ttt.setSize(600, 600);
        ttt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ttt.setLocationRelativeTo(null);
        ttt.setBackground(Color.DARK_GRAY);
        ttt.setVisible(true);
        
    }
    
}
