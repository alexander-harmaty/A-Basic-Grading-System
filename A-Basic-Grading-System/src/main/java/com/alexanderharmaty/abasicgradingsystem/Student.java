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
 * This class generates a student datatype. 
 * 
 * @author Alexander Harmaty
 * @version 1.0
 * @since 10/20/2021
 */
public class Student 
{
    protected String first;
    protected String last;
    protected String major;
    
    /**
     * Default constructor. Sets the values of each member variable 
     * to a default value. 
     */
    public Student() 
    {
        first = "NO_NAME";
        last = "NO_NAME";
        major = "NO_MAJOR";
    }
    /**
     * Constructor. Sets the values of each member variable to the corresponding
     * parameter values. 
     * 
     * @param f First Name
     * @param l Last Name
     * @param m Major
     */
    public Student(String f ,String l, String m)
    {
        first = f;
        last = l;
        major = m;
    }
    
    /**
     * This method returns the first name as a string.
     * @return first
     */
    public String getFirst() {return first;}
    /**
     * This method sets a new value for first name.
     * @param f String for new first name.
     */
    public void setFirst(String f) {first = f;}
    
    /**
     * This method returns the last name as a string.
     * @return last
     */
    public String getLast() {return last;}
    /**
     * This method sets a new value for last name.
     * @param l String for new last name.
     */
    public void setLast(String l) {last = l;}
    
    /**
     * This method returns the name of the major as a string.
     * @return major
     */
    public String getMajor() {return major;}
    /**
     * This method sets a new major.
     * @param m String for new major.
     */
    public void setMajor(String m) {major = m;}
    
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
        
        Student s2 = gson.fromJson(fr, Student.class);
        
        first = s2.getFirst();
        last = s2.getLast();
        major = s2.getMajor();
    }
    
    /**
     * This method writes the member variables in JSON format to the given 
     * PrintStream. 
     * 
     * @param ps 
     */
    public void writeJSON(PrintStream ps)
    {
        Student s = new Student();
        s.setFirst(first);
        s.setLast(last);
        s.setMajor(major);
        
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
        String s = "First = " + first + ", Last =  " + last + ", Major = " + major;
        return s;
    }
}

