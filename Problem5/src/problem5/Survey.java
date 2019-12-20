/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problem5;

import java.io.*;
import javax.swing.*;

/**
 * Survey object, used to store the results of surveys
 * 
 * @author Evan
 */
public class Survey
{
    int numSurveys; //Number of surveys taken so far
    int[] q1Numbers; //Number of times each option in question 1 was checked
    final String[] q1Names = {"Shooters", "Fighters", "Platformers", "Strategy", "RPG", "Puzzle", "Arcade", "Sports", "Other"}; //Names of each option in question 1
    int[] q2Numbers; //Number of times each option in question 2 was chosen
    final String[] q2Names = {"<5 hours", "<10 hours", "<15 hours", "15+ hours"}; //Names of each option in question 2
    String[] q3Answers; //List of answers from question 3
    
    /**
     * Constructs a new survey
     * 
     * @param numSurveys The number of surveys completes
     * @param q1Numbers The tallies for question 1
     * @param q2Numbers The tallies for question 2
     * @param q3Answers The answers for question 3
     */
    public Survey(int numSurveys, int[] q1Numbers, int[] q2Numbers, String[] q3Answers)
    {
        this.numSurveys = numSurveys;
        this.q1Numbers = q1Numbers;
        this.q2Numbers = q2Numbers;
        this.q3Answers = q3Answers;
    }
    
    /**
     * Reads the file to get previous survey results
     * 
     * @return a Survey object with the results of previous surveys
     */
    public static Survey readFile()
    {
        BufferedReader br = null; //Declare a BufferedReader
        try 
        {
            File file = new File("SurveyResults.txt"); //If the file does not exist, create the file and return blanks for all question because this means no surveys have been taken yet
            if (!file.exists())
            {
                try
                {
                    file.createNewFile();
                    int[] q1b = {0, 0, 0, 0, 0, 0, 0, 0, 0};
                    int[] q2b = {0, 0, 0, 0};
                    String[] q3b = {};
                    return new Survey(0, q1b, q2b, q3b);
                }
                catch (IOException ex)
                {
                    ex.printStackTrace(System.out);
                }
            }
            br = new BufferedReader(new FileReader(file));  //Initializes the BufferedReader       
        }
        catch (FileNotFoundException ex)
        {
            ex.printStackTrace(System.out);
        }        
        try
        {
            //Variable declarations
            int[] q1 = new int[9], q2 = new int[4]; //Integer arrays for the tallis of the first 2 questions
            String[] q1Names = {"Shooters", "Fighters", "Platformers", "Strategy", "RPG", "Puzzle", "Arcade", "Sports", "Other"}; //The names of the options for the first 2 questions
            String[] q2Names = {"<5 hours", "<10 hours", "<15 hours", "15+ hours"};
            String[] q3 = {}; //The list of answers to question 3
            String currentLine; //The line that is currently being read
            
            currentLine = br.readLine(); //Number of surveys
            int numSurveys = Integer.parseInt(currentLine.substring(29)); //This line contains the number of surveys so far, starting at character 29
            
            br.readLine(); //Question 1
            br.readLine();
            for (int i = 0; i < 9; i++)
            {
                currentLine = br.readLine();
                q1[i] = Integer.parseInt(currentLine.substring(q1Names[i].length() + 3)); //Each line contains the name of the option, " - ", and the tally, so the substing removes the first two
            }
            
            br.readLine(); //Question 2
            br.readLine();
            for (int i = 0; i < 4; i++)
            {
                currentLine = br.readLine();
                q2[i] = Integer.parseInt(currentLine.substring(q2Names[i].length() + 3)); //See question 1
            }
            br.readLine(); //Question 3
            br.readLine();
            currentLine = br.readLine(); //For this question, the while loop checks the line after it is read but before being added to prevent a null string from getting into the array
            while (currentLine != null) 
            {
                q3 = Survey.addString(q3, currentLine.substring(2)); //Adds each line to the array of answers (after removing the "- " at the beginning
                currentLine = br.readLine();
            }
            return new Survey(numSurveys, q1, q2, q3); //Return a survey object with all of the past results
            
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace(System.out);
        }
        finally //Closes the BufferedReader
        {
            try
            {
                if (br != null)
                {
                   br.close();
                }
            }
            catch (IOException ex)
            {
                ex.printStackTrace(System.out);
            }
        }
        return null;    
    }

    /**
     * Writes the results back to the file after updating them with the current survey
     */
    public void writeFile()
    {
        PrintWriter pw = null; //Declare the printWriter
        try
        {
            pw = new PrintWriter(new BufferedWriter(new FileWriter("SurveyResults.txt", false))); //Initializes the PrintWriter
            pw.println("Number of surveys completed: " + this.numSurveys); //Prints the number of surveys completed
            
            pw.println();
            pw.println("Question 1:");
            for (int i = 0; i < 9; i++)
            {
                pw.println(this.q1Names[i] + " - " + this.q1Numbers[i]); //Prints each option's name and tally
            }
            
            pw.println();            
            pw.println("Question 2:");
            for (int i = 0; i < 4; i++)
            {
                pw.println(this.q2Names[i] + " - " + this.q2Numbers[i]); //See question 1
            }
            
            pw.println();
            pw.print("Question 3:");
            for (int i = 0; i < this.q3Answers.length; i++) //Prints each answer on its own line
            {
                pw.println();
                pw.print("- " + this.q3Answers[i]);
            }
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace(System.out);
        }
        finally //Closes the PrintWriter
        {
            if (pw != null)
            {
                pw.close();
            }
        }
    }
    
    /**
     * Helper method to add a string to an array
     * 
     * @param oldArray the array before adding the string
     * @param s the string you want to add
     * @return the array after adding the string
     */
    public static String[] addString(String[] oldArray, String s)
    {
        if (s == null || s.equals("")) //If the string to be added is empty or null, change it to a string indicating that there was no answer
        {
            s = "NO ANSWER";
        }
        String[] newArray = new String[oldArray.length+1]; //Creates new array with length 1 higher than the old one
        for (int i = 0; i < oldArray.length; i++) //Puts the values from the old array into the same spot on the new array
        {
            newArray[i] = oldArray[i];
        }
        newArray[newArray.length-1] = s; //Puts the new string in the final index of the new array and returns it
        return newArray;
    }
        
}
