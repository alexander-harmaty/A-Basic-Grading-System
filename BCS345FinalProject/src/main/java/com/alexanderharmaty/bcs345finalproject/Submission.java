/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alexanderharmaty.bcs345finalproject;

import java.io.FileReader;
import java.io.PrintStream;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * This class generates a submission record. 
 * 
 * @author Alexander Harmaty
 * @version 1.0
 * @since 10/20/2021
 */
public class Submission
{
    private SubDate date;
    private String assignment;
    private double score;
    
    /**
     * Default constructor. Sets the values of each member variable to a 
     * default value. 
     */
    public Submission()
    {
        date = new SubDate();
        assignment = "NO_ASSIGNMENT";
        score = 0.0;
    }
    /**
     * Constructor. Sets the values of each member variable to the corresponding
     * parameter values. 
     * 
     * @param d Date
     * @param a Assignment
     * @param s Score
     */
    public Submission(SubDate d, String a, double s)
    {
        date = d;
        assignment = a;
        score = s;
    }
    
    /**
     * This method returns the date as a Subdate datatype .
     * @return date
     */
    public SubDate getDate() {return date;}
    /**
     * This method sets a new value for date.
     * @param d Subdate datatype for new date.
     */
    public void setDate(SubDate d) {date = d;}
    
    /**
     * This method returns the assignment as a String.
     * @return assignment
     */
    public String getAssignment() {return assignment;}
    /**
     * This method sets a new value for assignment.
     * @param a String for new assignment.
     */
    public void setAssignment(String a) {assignment = a;}
    
    /**
     * This method returns the score as a double.
     * @return score
     */
    public double getScore() {return score;}
    /**
     * This method sets a new value for score.
     * @param s Double for new score.
     */
    public void setScore(double s) {score = s;}
    
    /**
     * This method reads the contents of all member variables from the given 
     * instance of FileReader as JSON. Assumes the FileReader is open.
     * 
     * @param fr
     */
    public void readJSON(FileReader fr)
    {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        
        Submission s2 = gson.fromJson(fr, Submission.class);
        
        date = s2.getDate();
        assignment = s2.getAssignment();
        score = s2.getScore();
    }
    
    /**
     * This method writes the member variables in JSON format to the given 
     * PrintStream. 
     * 
     * @param ps 
     */
    public void writeJSON(PrintStream ps)
    {
        Submission s = new Submission();
        s.setDate(date);
        s.setAssignment(assignment);
        s.setScore(score);
        
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        
        String jsonString = gson.toJson(s);
        ps.println(jsonString);
    }
    
    /**
     * This method returns a string with descriptive text.
     * All member variables are represented in the string.
     * @return class variables together as a string
     */
    @Override
    public String toString()
    {
        String s = date + "\t" + assignment + "\t\t" + score;
        return s;
    }
}

