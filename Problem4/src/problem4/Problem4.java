/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problem4;

import javax.swing.*;

/**
 * Main class
 * 
 * @author Evan
 */
public class Problem4 {

    /**
     * Creates a JFrame GUI
     */
    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Ten Bouncing Balls"); //Create a JFrame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Make the program terminate when the JFrame is closed

        BouncingBallPanel panel = new BouncingBallPanel(); //Crate a panel and add it to the frame
        frame.add(panel);

        frame.setSize(800, 800); //Set the frame's size, make it visible, and make it non-resizable
        frame.setVisible(true);
        frame.setResizable(false);
    }
    
    /**
     * Main method
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
    
}
