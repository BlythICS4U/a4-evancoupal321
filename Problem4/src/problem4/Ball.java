/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problem4;
import java.util.Random;
/**
 * Bouncing Ball object, used to store each ball's speed, size, and location
 * 
 * @author Evan
 */
public class Ball
{
    Random rand = new Random();
    int radius = 15; //Sets size to 15
    int x = rand.nextInt(800-radius*2)+radius; //Sets starting location to a random spot from 0-800 while ensuring that the entire ball is inside the frame
    int y = rand.nextInt(800-radius*2)+radius; //Repeats for the y coordinate
    
    int dx = rand.nextInt(11)-5; //Sets starting speed to a random value from -5 to 5
    int dy = rand.nextInt(11)-5; //Repeats for the y coordinate
}
