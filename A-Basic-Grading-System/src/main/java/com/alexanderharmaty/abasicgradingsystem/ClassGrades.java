/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alexanderharmaty.abasicgradingsystem;

import java.io.FileReader;
import java.io.PrintStream;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * This class generates a record of class grades. 
 * 
 * @author Alexander Harmaty
 * @version 1.0
 * @since 11/4/2021
 */
public class ClassGrades {
    protected Student student;
    protected Submission[] submissions;
    
    /**
     * Default constructor. Sets the values of each member variable to a 
     * default value. 
     * The default constructor should call new on the student and the 
     * submissions member variables. All elements of the array should have 
     * new called on them in this method.
     */
    public ClassGrades(){
        student = new Student();
        submissions = new Submission[3];
        for (int i =0; i< submissions.length; i++)
        {
            submissions[i] = new Submission();
        }
    }
    
    /**
     * This method sets a new value for student
     * @param w value for new student
     */
    public void setStudent(Student w) {student = w;}
    
    /**
     * This method returns student as a datatype of Student.
     * @return  student
     */
    public Student getStudent() {return student;}
    
    /**
     * This method sets a new value for submission
     * @param s value for new submission
     */
    public void setSubmission(Submission[] s) {submissions = s;}
    
    /**
     * This method returns submissions as a datatype of Submission[].
     * @return  submissions
     */
    public Submission[] getSubmission() {return submissions;}
    
    /**
     * This method searches the array for the Submission with the highest
     * score. 
     * @return highest score
     */
    public Submission getHighestScoreSubmission()
    {
        Submission highest = new Submission();
        
        for (int i=0; i < submissions.length; i++) 
        {
            if (submissions[i].getScore() > highest.getScore())
            {
                highest.setDate(submissions[i].getDate());
                highest.setAssignment(submissions[i].getAssignment());
                highest.setScore(submissions[i].getScore());
            }
        }
        
        return highest;
    }
    
    /**
     * This method returns the Submission at the given index. 
     * @param index
     * @return submission
     */
    public Submission getAt(int index) throws ArrayIndexOutOfBoundsException
    {
        if (index >= submissions.length || index < 0)
        {
            ArrayIndexOutOfBoundsException e;
            e = new ArrayIndexOutOfBoundsException();
            throw e;
        }
        else
        {
            return submissions[index];
        }
    }
    
    /**
     * This method writes a report to the given PrintStream
     * @param ps 
     */
    public void report(PrintStream ps) 
    {
        ps.println("Student Grades");
        ps.println("--------------\n");
        ps.println("First: " + student.getFirst());
        ps.println("Last : " + student.getLast());
        ps.println("Major: " + student.getMajor());
        
        ps.println("\n\tMonth\tDay\tYear\tAssignment\tNumeric Grade\tLetter");
        ps.println("\t-----\t---\t----\t----------\t-------------\t------");
        
        double score;
        double sum = 0;
        double average;
        
        for (int i=0; i < submissions.length; i++)
        {
            score = submissions[i].getScore();
            ps.printf("\t%2d\t%d\t%d\t%10s\t%13.2f\t%2s\n", 
                    submissions[i].date.getMonth(),
                    submissions[i].date.getDay(),
                    submissions[i].date.getYear(),
                    submissions[i].getAssignment(), 
                    submissions[i].getScore(), 
                    this.getLetter(score)
            );
        }
        
        for (int i=0; i < submissions.length; i++)
            sum = sum + submissions[i].getScore();
        
        average = sum / submissions.length;
        
        ps.printf("\nNumberic Average: %2.2f", average);
        ps.printf("\nOverall Letter  : %2s\n", this.getLetter(average));
    }
    
    /**
     * This method helps the report method calculate letter grades from 
     * submissions[i].getScore()
     * @param score
     * @return letter
     */
    public String getLetter(double score){
        String letter;
        
        if(score >= 93){
            letter = "A ";
        }else if (score >= 90){
            letter = "A-";
        }else if (score >= 87){
            letter = "B+";
        }else if (score >= 83){
            letter = "B ";
        }else if (score >= 80){
            letter = "B-";
        }else if (score >= 77){
            letter = "C+";
        }else if (score >= 73){
            letter = "C ";
        }else if (score >= 70){
            letter = "C-";
        }else if (score >= 67){
            letter = "D+";
        }else if (score >= 60){
            letter = "D ";
        }else{
            letter = "F ";
        }
        
        return letter;
    }
    
    /**
     * This method reads the contents of all member variables from the given
     * instance of FileReader as JSON
     * @param fr 
     */
    public void readJSON(FileReader fr) 
    {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        
        ClassGrades s2 = gson.fromJson(fr, ClassGrades.class);
        
        student = s2.getStudent();
        submissions = s2.getSubmission();
    }
    
    /**
     * This method writes the member variables in JSON format to the given
     * PrintStream. 
     * @param ps 
     */
    public void writeJSON(PrintStream ps) 
    {
        ClassGrades s = new ClassGrades();
        s.setStudent(student);
        s.setSubmission(submissions);
        
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
        String name = student.toString();
        String entries = "";
        for (int i = 0; i < submissions.length; i++)
        {
            entries = entries + "\n\tSubmission Date = " + submissions[i].date.getMonth();
            entries = entries + "/" + submissions[i].date.getDay();
            entries = entries + "/" + submissions[i].date.getYear();
            entries = entries + "\n\tAssignment = " + submissions[i].getAssignment();
            entries = entries + "\n\tScore = " + submissions[i].getScore();
        }
        return name + entries;
    }
}
