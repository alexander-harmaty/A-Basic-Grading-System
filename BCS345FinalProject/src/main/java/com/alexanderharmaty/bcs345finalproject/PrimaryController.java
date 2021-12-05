package com.alexanderharmaty.bcs345finalproject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
        
        ClassGrades cg = new ClassGrades();
        
        cg.readJSON(fr);
        System.out.println("\nFile Read!");
        
        String first;
        first = cg.student.getFirst();
        this.textFieldFirst.clear();
        this.textFieldFirst.setText(first);
        
        String last;
        last = cg.student.getLast();
        this.textFieldLast.clear();
        this.textFieldLast.setText(last);
        
        String major;
        major = cg.student.getMajor();
        this.textFieldMajor.clear();
        this.textFieldMajor.setText(major);
        
        //there needs to be some sort of listView clear here
        ObservableList<Submission> observableList 
                = (ObservableList<Submission>) listViewSubmissions.getItems();
        
        for (int i = 0; i < cg.submissions.length; i++)
            observableList.add(cg.submissions[i]);
        //Submission class toString needs some editing
    }
    
    @FXML
    private void handleCloseMenuItem()
    {
        System.out.println("Close menu item pressed");
        System.exit(0);
    }
    
    /**
    @FXML
    private TextField textFieldMessage;
    
    @FXML
    private void handleMessage(){
        String message;
        message = textFieldMessage.getText();
        System.out.println(message);
        
        //System.out.println("I love JAVA");
    }
    **/
    
    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
}
