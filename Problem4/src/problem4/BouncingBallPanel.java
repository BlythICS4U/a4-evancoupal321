/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problem4;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.*;
/**
 * Custom JPanel for bouncing balls
 * 
 * @author Evan
 */
public class BouncingBallPanel extends JPanel implements ActionListener
{
    Ball[] balls = new Ball[10]; //List of 10 balls
    int delay = 10; //Delay between movements of the balls in milliseconds
    Timer timer; //Timer used to move the balls
    
    /**
     * Constructor for the JPanel
     */
    public BouncingBallPanel()
    {
        for (int i = 0; i < balls.length; i++) //Initializes all of the balls
        {
            balls[i] = new Ball();
        }
        timer = new Timer(delay, this); //Initializes and starts the times
        timer.start();
    }
    
    /**
     * Runs every time the timer hits the delay value
     * 
     * @param e Event
     */
    @Override
    public void actionPerformed(ActionEvent e)
    {
        repaint(); //Runs paintComponent
    }
    
    /**
     * Redraws the balls every "frame"
     * 
     * @param g Graphics object
     */
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setColor(Color.red); //Sets ball color to red
        balls = BallOnBallCollision(balls); //Checks if balls collide with each other and reacts accordingly
        for (int i = 0; i < balls.length; i++) //Checks if each ball is outside of the frame (in other words, if it is colliding with the wall)
        {
            if (balls[i].x < balls[i].radius) //Left Wall
            {
                balls[i].dx = Math.abs(balls[i].dx);
            }
            if (balls[i].x > getWidth() - balls[i].radius) //Right Wall
            {
                balls[i].dx = -Math.abs(balls[i].dx);
            }
            if (balls[i].y < balls[i].radius) //Top Wall
            {
                balls[i].dy = Math.abs(balls[i].dy);
            }
            if (balls[i].y > getHeight() - balls[i].radius) //Bottom Wall
            {
                balls[i].dy = -Math.abs(balls[i].dy);
            }

            balls[i].x += balls[i].dx; //Updates the ball's x location based on speed
            balls[i].y += balls[i].dy; //Updates the ball's y location based on speed
            g.fillOval(balls[i].x - balls[i].radius, balls[i].y - balls[i].radius, balls[i].radius * 2, balls[i].radius * 2); //Draws the ball based on location
        }
    }
    
    /**
     * Checks if any balls collide with each other and changes their speed accordingly
     * 
     * @param balls The array of balls
     * @return The array of balls (after updating based on collision)
     */
    public Ball[] BallOnBallCollision(Ball[] balls)
    {
        double distance, xDist, yDist; //Declares variables for the overall, x, and y distances apart between two balls
        Ball[] collidingBalls = new Ball[2]; //An array of two balls that have collided
        for (int i = 0; i < 9; i++) //For each ball (except the last one)...
        {
            for (int j = i+1; j < 10; j++) //...and every ball after the one at index i
            {
                xDist = Math.abs(balls[i].x - balls[j].x); //Calculates the horizontal distance between the two balls
                yDist = Math.abs(balls[i].y - balls[j].y); //Calculates the vertical distance between the two balls
                distance = Math.sqrt(Math.pow(xDist, 2) + Math.pow(yDist, 2)); //Calculates the overall distance between the two balls
                if (distance < balls[i].radius + balls[j].radius) //If the distance is less then the sum of the radiuses of the balls, they have collided
                {
                    collidingBalls = onCollide(balls[i], balls[j]); //Updates the balls' speed based on their collision
                    balls[i] = collidingBalls[0];
                    balls[j] = collidingBalls[1];
                }
            }
        }
        return balls;
    }
    
    /**
     * Updates the balls' speed based on their collision
     * 
     * @param a First ball
     * @param b Second ball
     * @return An array with both balls after the updates
     */
    public Ball[] onCollide(Ball a, Ball b) //Note: The algorithms used are not perfect
    {
        if (a.x > b.x) //Adds to the speeds of the balls based on their distance apart
        {
            a.dx += (a.x - b.x)/10;
            b.dx -= (a.x - b.x)/10;
        }
        else
        {
            b.dx += (b.x - a.x)/10;
            a.dx -= (b.x - a.x)/10;
        }
        if (a.y > b.y)
        {
            a.dy += (a.y - b.y)/10;
            b.dy -= (a.y - b.y)/10;
        }
        else
        {
            b.dy += (b.y - a.y)/10;
            a.dy -= (b.y - a.y)/10;
        }
        
        if (a.dx > 5) //Caps the balls' speeds at 5 in either direction to prevent the balls from spazzing out
        {
            a.dx = 5;
        }
        if (a.dy > 5)
        {
            a.dy = 5;
        }
        if (b.dx > 5)
        {
            b.dx = 5;
        }
        if (b.dy > 5)
        {
            b.dy = 5;
        }
        if (a.dx < -5)
        {
            a.dx = -5;
        }
        if (a.dy < -5)
        {
            a.dy = -5;
        }
        if (b.dx < -5)
        {
            b.dx = -5;
        }
        if (b.dy < -5)
        {
            b.dy = -5;
        }
        Ball[] collidingBalls = {a, b}; //Returns the balls after updating
        return collidingBalls;
    }

}
