package com.alexanderharmaty.bcs345finalproject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

public class PrimaryController 
{
    @FXML
    private TextField textFieldFirst;
    @FXML
    private TextField textFieldLast;
    @FXML
    private TextField textFieldMajor;
    
    @FXML
    private ListView<Submission> listViewSubmissions;
    
    public ClassGrades cg = new ClassGrades();
    
    @FXML
    private void handleOpenMenuItem(){
        System.out.println("\nOpen Menu Item Pressed!");

        FileChooser fc;
        fc = new FileChooser();
        File selectedFile;
        selectedFile = fc.showOpenDialog(null);
        
        System.out.println("\nFile Selected!");
        System.out.println(selectedFile);

        //textFieldMessage.setText(selectedFile.toString());  
        
        FileReader fr = null;
        
        try
        {
            fr = new FileReader(selectedFile);
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File Not Found!");
            //break;
        }
        
        cg.readJSON(fr);
        System.out.println("\nFile Read!\n");
        
        String first;
        first = cg.student.getFirst();
        this.textFieldFirst.clear();
        System.out.println("First Name Cleared!");
        this.textFieldFirst.setText(first);
        System.out.println("First Name Updated!");
        
        String last;
        last = cg.student.getLast();
        this.textFieldLast.clear();
        System.out.println("Last Name Cleared!");
        this.textFieldLast.setText(last);
        System.out.println("Last Name Updated!");
        
        String major;
        major = cg.student.getMajor();
        this.textFieldMajor.clear();
        System.out.println("Major Cleared!");
        this.textFieldMajor.setText(major);
        System.out.println("Major Updated!");
        
        ObservableList<Submission> observableList 
                = (ObservableList<Submission>) listViewSubmissions.getItems();
        observableList.clear();
        System.out.println("Submissions Cleared!");
        
        for (int i = 0; i < cg.submissions.length; i++)
            observableList.add(cg.submissions[i]);
        System.out.println("Submissions Updated!");
    }
    
    @FXML
    private void handleSaveMenuItem()
    {
        System.out.println("\nSave Menu Item Pressed!");

        FileChooser fc;
        fc = new FileChooser();
        File selectedFile;
        selectedFile = fc.showSaveDialog(null);
        
        System.out.println("\nName & Path Selected!");
        System.out.println(selectedFile);
        
        PrintStream ps = null;
        
        try
        {
            ps = new PrintStream(selectedFile);
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File Not Found!");
            //break;
        }

        cg.report(ps);
        System.out.println("\nReport Written!\n");
        
        this.textFieldFirst.clear();
        System.out.println("First Name Cleared!");
        this.textFieldLast.clear();
        System.out.println("Last Name Cleared!");
        this.textFieldMajor.clear();
        System.out.println("Major Cleared!");
        
        ObservableList<Submission> observableList 
                = (ObservableList<Submission>) listViewSubmissions.getItems();
        observableList.clear();
        System.out.println("Submissions Cleared!");        
    }
    
    @FXML
    private void handleCloseMenuItem()
    {
        System.out.println("\nClose Menu Item Pressed!\nProgram Closing!");
        System.exit(0);
    }
    
    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
}
