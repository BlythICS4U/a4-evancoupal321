/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problem5;

import javax.swing.*;
/**
 * Main class
 * 
 * @author Evan
 */
public class Problem5 {

    /**
     * Creates a JFrame window
     */
    private static void createAndShowGUI()
    {
        SurveyForm window = new SurveyForm(); //Creates a JFrame window, makes it visible and non-resizable
        window.setVisible(true);
        window.setResizable(false);
    }

    /**
     * Main method
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }
    
}
