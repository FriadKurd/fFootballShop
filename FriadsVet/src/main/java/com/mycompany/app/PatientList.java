package com.mycompany.app;

import java.io.Serializable;
import java.util.ArrayList;

/** Collection class to hold a list of animals
 *  based on hostel applications in Java in Two Semesters
 *  @author Friad
 *  @version 1.0
 */

public class PatientList implements Serializable
{
    private final ArrayList<Pet> patientsToTreat;
    public final int MAX;
        
    /** Constructor initialises the empty animal list and sets the maximum list size 
     *  @param   maxIn The maximum number of animals in the list
     */
    public PatientList(int maxIn)
    {
        patientsToTreat = new ArrayList<>();
        MAX = maxIn;
    }
	
    /** Adds a new animal to the list
     *  @param  thePatient The animals to add
     *  @return Returns true if the animal was added successfully and false otherwise
     */
    
    public String addPatient(Pet thePatient)
    {
        if(!isFull())
        {
            patientsToTreat.add(thePatient);
            return thePatient.animalName;
        }
        else
        {
            return "Animal not added";
        }
    }
        


   /** Reports on whether or not the list is empty
     *  @return Returns true if the list is empty and false otherwise
     */
    public boolean isEmpty()
    {
        return patientsToTreat.isEmpty();
    }
	
    /** Reports on whether or not the list is full
     *  @return Returns true if the list is full and false otherwise
     */	
    public boolean isFull()
    {
        boolean fullChecker;
        if(patientsToTreat.size() <= MAX){
            fullChecker = false;
        }
        
        else{
            fullChecker = true;
        }
        return fullChecker;
        
    }
        
    /** Gets the total number of animals 
     *  @return Returns the total number of animals currently in the list 
     */
//    public int getTotal()
//    {       
//        return patientsToTreat.size();
//    }
      
     /** Reads the animal at the given position in the list
     *  @param      positionIn The position of the animal in the list
     *  @return     Returns the animal at the  position in the list
     *              or null if no animal at that logical position
     */
//    public Pet getPatient(int positionIn)
//    {
//        if (positionIn < 0 || positionIn >= getTotal()) // check for valid position
//        {
//            return null; // no object found at given position
//        }
//        else
//        {
//            // remove one frm logical poition to get ArrayList position
//            return patientsToTreat.get(positionIn);
//        }
//    }
    
     /** Outputs all the animals in the list
     *  @return     Returns all the animals and owners in the list in an easy to read format
     */
    
    public String displayPatient()
    {
      String output = "\n";  
      for (int counter = 0; counter < patientsToTreat.size(); counter++) {
          output += "\n" + "Owenr's Details: ";
          output += "\n" + "Owenr Name: " + patientsToTreat.get(counter).givName;
          output += "\n" + "Owner Surname: " + patientsToTreat.get(counter).familyName;
          output += "\n";
          
          output += "\n" + "animals Details: ";
          output += "\n" + "animal Breed: " + patientsToTreat.get(counter).animalBreed;
          output += "\n" + "animal Name: " + patientsToTreat.get(counter).animalName;
          output += "\n" + "animal Colour: " + patientsToTreat.get(counter).animalColour;
          output += "\n" + "animal Gneder: " + patientsToTreat.get(counter).animalGender;
          output += "\n" + "animal age: " + patientsToTreat.get(counter).age;
          output += "\n" + "animal Weight: " + patientsToTreat.get(counter).animalWeight;
          output += "\n" + "animal Issue: " + patientsToTreat.get(counter).animalIssue;
          output += "\n" + "animal Address: " + patientsToTreat.get(counter).animalAddress;
          output += "\n";

      } 
        return output;
    }
}

