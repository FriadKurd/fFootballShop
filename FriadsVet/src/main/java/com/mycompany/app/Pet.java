package com.mycompany.app;
import java.io.Serializable;


public class Pet implements Serializable{
    String animalBreed;
    String animalName;
    String animalColour;
    String animalGender;
    String age;
    String animalWeight;
    String animalIssue;
    String givName;
    String familyName;
    String animalAddress;

    public Pet(String animalBreed, String animalName, String animalColour , String animalGender ,String age, String animalWeight, String animalIssue, String givName, String familyName, String animalAddress) {
        this.animalBreed = animalBreed;
        this.animalName = animalName;
        this.animalColour = animalColour;
        this.animalGender = animalGender;
        this.age = age;
        this.animalWeight = animalWeight;
        this.animalIssue = animalIssue;
        this.givName = givName;
        this.familyName = familyName;
        this.animalAddress = animalAddress;
    }

    public String getBreed() {
        return animalBreed;
    }

    public void setBreed(String animalBreed) {
        this.animalBreed = animalBreed;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGivName() {
        return givName;
    }

    public void setGivName(String givName) {
        this.givName = givName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }    

    public String getAnimalBreed() {
        return animalBreed;
    }

    public String getAnimalName() {
        return animalName;
    }

    public String getAnimalColour() {
        return animalColour;
    }

    public String getAnimalGender() {
        return animalGender;
    }

    public String getAnimalWeight() {
        return animalWeight;
    }

    public String getAnimalIssue() {
        return animalIssue;
    }

    public void setAnimalBreed(String animalBreed) {
        this.animalBreed = animalBreed;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public void setAnimalColour(String animalColour) {
        this.animalColour = animalColour;
    }

    public void setAnimalGender(String animalGender) {
        this.animalGender = animalGender;
    }

    public void setAnimalWeight(String animalWeight) {
        this.animalWeight = animalWeight;
    }

    public void setAnimalIssue(String animalIssue) {
        this.animalIssue = animalIssue;
    }

    public String getAnimalAddress() {
        return animalAddress;
    }

    public void setAnimalAddress(String animalAddress) {
        this.animalAddress = animalAddress;
    } 
}
