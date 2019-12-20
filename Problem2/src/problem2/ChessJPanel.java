/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problem2;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
        
/**
 * Custom JPanel to create a chessboard
 * 
 * @author Evan
 */
public class ChessJPanel extends JPanel
{
    /**
     * Paints the chess board
     * 
     * @param g Graphics object
     */
    @Override
    public void paintComponent(Graphics g)
    {
        for (int i = 0; i < 4; i++) //Loop through 4 pairs of columns
        {
            for (int j = 0; j < 8; j++) //Loop through 8 rows
            {
                if (j%2 == 0) //If it is the 1st, 3rd, 5th, or 7th row, start with a red square
                {
                    g.setColor(Color.red); //Paint a red square in the first colum of the ith pair of columns, in the jth row
                    g.fillRect(i*200, j*100, 100, 100);
                    g.setColor(Color.black); //Paint a black square in the first colum of the ith pair of columns, in the jth row
                    g.fillRect(i*200+100, j*100, 100, 100);
                }
                else //Otherwise, start with a black square
                {
                    g.setColor(Color.black); //Paint a black square in the first colum of the ith pair of columns, in the jth row
                    g.fillRect(i*200, j*100, 100, 100);
                    g.setColor(Color.red); //Paint a red square in the second colum of the ith pair of columns, in the jth row
                    g.fillRect(i*200+100, j*100, 100, 100);
                }
            }
        }
    }
}
