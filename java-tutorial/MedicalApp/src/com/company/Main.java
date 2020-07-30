package com.company;

public class Main {
    public static void main(String[] args) {
	// write your code here
        Patient patient = new Patient("Brad", 28,
                new Eye("Left Eye", "Short sighted", "Blue", true),
                new Eye("Right Eye", "Normal", "Blue", true),
                new Heart("Heart", "Normal", 65),
                new Stomach("Stomach", "PUD", false),
                new Skin("Skin", "Burned", "White", 40));
        System.out.println("Name: " + patient.getName());
        System.out.println("Age: " + patient.getAge());


    }
}
