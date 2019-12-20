/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problem1;

import javax.swing.*;
/**
 * Main class
 * 
 * @author Evan
 */
public class Problem1 {

    /**
     * Converts a decimal number into binary
     * 
     * @param input The decimal number as a string
     * @return The binary equivalent of the decimal number
     */
    public static String decimalToBinary(String input)
    {
        int inputNum = Integer.parseInt(input); //Declare input and output numbers
        String output = "";
        for (int i = 7; i >= 0; i--)
        {
            if (inputNum >= Math.pow(2, i)) //If the corresponding power of 2 is there, add a 1 to the output and subtract the power from the input
            {
                output += "1";
                inputNum -= Math.pow(2, i);
            }
            else //If the corresponding power of 2 is not there, add a 0 to the output
            {
                output += "0";
            }
        }
        return output;
    }
    
    /**
     * Converts a binary number into decimal
     * 
     * @param input The binary number as a string
     * @return The decimal equivalent of the binary number
     */    
    public static String binaryToDecimal(String input)
    {
        int output = 0; //Declare decimal number
        for (int i = 7; i >= 0; i--)
        {
            if (input.charAt(7-i) == '1') //If a character in the binary number is 1, add the corresponding power of 2
            {
                output += Math.pow(2, i);
            }
        }
        return Integer.toString(output);
    }
    
    /**
     * Creates a JFrame GUI
     */
    private static void createAndShowGUI()
    {
        converterWindow window = new converterWindow(); //Create window and make it visible and not resizable
        window.setVisible(true);
        window.setResizable(false);
    }

    /**
     * Main method
     * 
     * @param args The command line arguments
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
