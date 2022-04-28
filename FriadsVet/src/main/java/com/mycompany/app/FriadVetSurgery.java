package com.mycompany.app;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * 
 * @author friad
 */

public class FriadVetSurgery extends Application
{

    private PatientList patientList;
    
    
    // WIDTH and HEIGHT of GUI stored as constants 
    private final int WIDTH = 1500;
    private final int HEIGHT = 800;
    // visual components
    private final Label headingLabel = new Label("Verterinary Surgery Booking");
    private final Label animalLabel = new Label("Animal Testing");
    private final Label breedLabel = new Label("Animal Breed");
    private final TextField breedField =  new TextField();
    private final Label animalNameLabel = new Label("Animal Name");
    private final TextField animalNameField =  new TextField();
    private final Label animalColourLabel = new Label("Gender");
    private final TextField animalColourField = new TextField();
    private final TextField animalGenderField = new TextField();
    private final Label animalGenderLabel = new Label("Colour");
    private final Label ageLabel = new Label("age");
    private final TextField ageField =  new TextField();
    private final Label weightLabel = new Label("weight");
    private final TextField weightField = new TextField();
    private final Label animalIssueLabel = new Label("issue");
    private final TextField animalIssueField = new TextField();
    
    private final Separator sectSeparator = new Separator();
    private final Separator sectSeparator2 = new Separator();
    private final Separator sectSeparator3 = new Separator();
    private final Separator sectSeparator4 = new Separator();
    
    private final Label ownerLabel = new Label("Owner Details");
    private final Label nameLabel = new Label("Given Name");
    private final TextField nameField =  new TextField();
    private final Label surnameLabel = new Label("Surname");
    private final TextField surnameField =  new TextField();
    private final Label addressLabel = new Label("Address");
    private final TextField addressField =  new TextField();
    private final TextArea displayPatient  = new TextArea();
    private final Button addButton = new Button("Book Your Animal ");
    private final Button storeButton = new Button("Store Your Animal ");
    private final Button clearButton = new Button("Clear Your Animal ");
    
    /**
     *
     * @param stage
     */
    @Override
    public void start(Stage stage)
    {
        //this is the class to contain the patients(animals). The parameter represents the maximum number of patient(animals)
        if(!displayPetList()) {
            patientList = new PatientList(30);
        }
       HBox patientDetails = new HBox (10);
       HBox ownerDetails = new HBox (10);
 
       // add components to HBoxes
       patientDetails.getChildren().addAll(breedLabel, breedField, animalNameLabel, animalNameField, animalColourLabel, animalColourField, animalGenderLabel, animalGenderField, ageLabel, ageField, weightLabel, weightField, animalIssueLabel, animalIssueField);
       
       ownerDetails.getChildren().addAll(nameLabel, nameField, surnameLabel, surnameField, addressLabel, addressField);
       
       // create VBox
       VBox root = new VBox(10);
       // add all components to VBox
       root.getChildren().addAll(headingLabel,sectSeparator, animalLabel,  patientDetails, sectSeparator2 
               ,ownerLabel, ownerDetails, sectSeparator3, displayPatient, sectSeparator4, addButton, storeButton, clearButton);
       // create the scene
       Scene scene = new Scene(root, Color.web("#00fffb"));
        
	// set font of heading
       Font font = new Font("Vedana", 40);
       headingLabel.setFont(font);
       font = new Font("Vedana", 20);
       animalLabel.setFont(font);
       ownerLabel.setFont(font);
       
       
 	// set alignment of HBoxes
       patientDetails.setAlignment(Pos.CENTER);
       ownerDetails.setAlignment(Pos.CENTER);
       addButton.setAlignment(Pos.CENTER);
       storeButton.setAlignment(Pos.CENTER);
       clearButton.setAlignment(Pos.CENTER);

       // set alignment and Colour of  VBox 
       root.setAlignment(Pos.CENTER);
       root.setBackground(Background.EMPTY); 
       // set minimum and maximum width of components 

        
       displayPatient.setMaxSize(400, 700);
       displayPatient.appendText(patientList.displayPatient());
       stage.setWidth(WIDTH);
       stage.setHeight(HEIGHT);    

       // call private methods for button event handlers
       addButton.setOnAction(e -> addHandler());
       
       stage.setScene(scene);
       stage.setTitle("Animal Centre");
       stage.show(); 
       
       storeButton.setOnAction(e -> storePetsList());
       
       stage.setScene(scene);
       stage.setTitle("Animal Centre");
       stage.show(); 
       
       clearButton.setOnAction(e -> clearAnimal());
       
       stage.setScene(scene);
       stage.setTitle("Animal Centre");
       stage.show(); 
    
    }
 
    /**
     * method to add a animal you should be able to create more methods to
     * remove and search for animals and set a animal as serviced
     *
     */
    private void addHandler()
    {
       
        String animalBreed =  breedField.getText();
        String animalName = animalNameField.getText();
        String animalColour = animalColourField.getText();
        String animalGender = animalGenderField.getText();
        String age =  ageField.getText();
        String weight =  weightField.getText();
        String animalIssue = animalIssueField.getText();
        String givenName =  nameField.getText();
        String surname =  surnameField.getText();
        String animalAddress = addressField.getText();

        String storeMessage;
        

        // check for errors
        if(animalBreed.length()== 0 ||age.length()== 0 || weight.length()== 0) 
        {
            displayPatient.setText ("You must enter the Animal Breed, age and weight of the Verterinary Surgery");
        } 
        else if(givenName.length()== 0|| surname.length()== 0)
        {
            displayPatient.setText ("You must enter both your given name and surname");
        } 
        else  // ok to add a Tenant
        {
            Pet patientToAdd =  new Pet(animalBreed, animalName, animalColour, animalGender, age, weight, animalIssue, givenName, surname, animalAddress);
            storeMessage = patientList.addPatient(patientToAdd);
            //clear the fields
            breedField.setText("");
            animalNameField.setText("");
            animalColourField.setText("");
            animalGenderField.setText("");
            ageField.setText("");
            weightField.setText("");
            animalIssueField.setText("");
            nameField.setText("");
            surnameField.setText("");
            addressField.setText("");
            displayPatient.setText("");
            displayPatient.appendText(animalName + " successfully added");
            displayPatient.appendText(storeMessage);
            displayPatient.appendText("\n\nThe Patients currently awaiting for Surgery are: ");
            displayPatient.appendText(patientList.displayPatient());
        }
      
    } 
    private void storePetsList() {
        try {
            FileOutputStream fileOut = new FileOutputStream("./petlist.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(patientList);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in ./petlist.ser file");
        } catch (IOException myException) {
            myException.printStackTrace();
        }
}
    private boolean displayPetList() {
        Object obj;
        try {
            FileInputStream fileIn = new FileInputStream("./petlist.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            obj = in.readObject();
            patientList = (PatientList) obj;
            in.close();
            fileIn.close();
            patientList.displayPatient();
            return true;
        } catch (IOException i) {
            i.printStackTrace();
            return false;
        } catch (ClassNotFoundException c) {
            System.out.println("PatientList class not found");
            c.printStackTrace();
            return false;
        }
        
}
    /**
     *
     * @param args
     */
    public static void main(String[] args)
    {
        launch(args);
    }
   
    private void clearAnimal() {
        breedField.setText("");
        animalNameField.setText("");
        animalColourField.setText("");
        animalGenderField.setText("");
        ageField.setText("");
        weightField.setText("");
        animalIssueField.setText("");
        nameField.setText("");
        surnameField.setText("");
        addressField.setText("");
        displayPatient.setText("");
    }
    
}

