/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problem3;

import javax.swing.*;

/**
 * Main class
 * 
 * @author Evan
 */
public class Problem3 {

    /**
     * Calculates the binary coefficient given r and n
     * 
     * @param r the number of objects being chosen from the set
     * @param n the total number of objects in the set
     * @return n! after being divided by r! and (n-r)!
     */
    public static long getCoefficient(int r, int n)
    {
        long nFact = 0, rFact = 0, nMinusRFact = 0; //Declare variables
        
        nFact = factorial(n); //Get the needed factorials (n, r, n-r)
        rFact = factorial(r);
        nMinusRFact = factorial(n-r);
        
        nFact /= rFact; //Perform the needed equation (n!/r!(n-r)!) while keeping the highest number ever reached to a minimum
        nFact /= nMinusRFact;
        return nFact; 
    }
    
    /**
     * Calculates the factorial of a number
     * 
     * @param l The number for which the factorial is being calculated
     * @return The factorial of the number
     */
    private static long factorial(long l)
    {
        long factorial = 1;
        for (int i = 1; i <= l; i++) //Multiplies every number from 1 to l together
        {
            factorial *= i;
        }
        return factorial;
    }
    
    /**
     * Creates a JFrame GUI
     */
    private static void createAndShowGUI()
    {
        Problem3Window window = new Problem3Window(); //Create window and make it visible and not resizable
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
