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
 * This class generates a date datatype to be used for the submission class.
 * 
 * @author Alexander Harmaty
 * @version 1.0
 * @since 10/20/2021
 */
public class SubDate
{
    private int month;
    private int day;
    private int year;
    
    /**
     * Default constructor. Sets the values of each member variable to a default
     * value. 
     */
    public void SubDate()
    {
        month = 0;
        day = 0;
        year = 0000;
    }
    /**
     * Constructor. Sets the values of each member variable to the 
     * corresponding parameter values. 
     * 
     * @param m Month
     * @param d Day
     * @param y Year
     */
    public void SubDate(int m, int d, int y)
    {
        month = m;
        day = d;
        year = y;
    }
    
    /**
     * This method returns the month as an int.
     * @return month
     */
    public int getMonth() {return month;}
    /**
     * This method sets a new value for month.
     * @param m Int value of the new month.
     */
    public void setMonth(int m) {month = m;}
    
    /**
     * This method returns the day as an int.
     * @return day
     */
    public int getDay() {return day;}
    /**
     * This method sets a new value for day.
     * @param d Int value of the new day.
     */
    public void setDay(int d) {day = d;}
    
    /**
     * This method returns the year as an int.
     * @return year
     */
    public int getYear() {return year;}
    /**
     * This method sets a new value for year.
     * @param y Int value of the new year.
     */
    public void setYear(int y) {year = y;}
    
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
        
        SubDate s2 = gson.fromJson(fr, SubDate.class);
        
        month = s2.getMonth();
        day = s2.getDay();
        year = s2.getYear();
    }
    
    /**
     * This method writes the member variables in JSON format to the given 
     * PrintStream. 
     * 
     * @param ps 
     */
    public void writeJSON(PrintStream ps)
    {
        SubDate s = new SubDate();
        s.setMonth(month);
        s.setDay(day);
        s.setYear(year);
        
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        
        String jsonString = gson.toJson(s);
        ps.println(jsonString);
    }
    
    /**
     * This method returns a String instance that contains a formatted date. 
     * Here is an example of a string that gets returned from the method:
     * "9/1/2021"
     * 
     * @return 
     */
    @Override
    public String toString()
    {
        String s = month + "/" + day + "/" + year;
        return s;
    }
}
