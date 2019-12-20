/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problem2;
import javax.swing.*;
/**
 * Main class
 * 
 * @author Evan
 */
public class Problem2 {

    /**
     * Main method
     * 
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        final JFrame f = new JFrame("Chess"); //Create JFrame
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Make program exit when JFrame is closed
        f.setSize(806, 840); //Set the size of the JFrame, accounting for the size of the frame's outer GUI
        
        ChessJPanel panel = new ChessJPanel(); //Create a panel and add it to the frame
        f.add(panel);
        

        SwingUtilities.invokeLater(new Runnable() {
            /**
             * Overridden run method
             */
            @Override
            public void run() { //Runs the JFrame by setting it to be visible and not resizable
                f.setVisible(true);
                f.setResizable(false);
            }
        });
    }
    
}
