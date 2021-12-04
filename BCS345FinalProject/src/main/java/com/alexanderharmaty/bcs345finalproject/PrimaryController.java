package com.alexanderharmaty.bcs345finalproject;

import java.io.File;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

public class PrimaryController 
{
    @FXML
    private void handleOpenMenuItem(){
        FileChooser fc;
        fc = new FileChooser();
        File selectedFile;
        selectedFile = fc.showOpenDialog(null);
        
        //textFieldMessage.setText(selectedFile.toString());
        
        System.out.println(selectedFile);
        System.out.println("Open menu item pressed");
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
