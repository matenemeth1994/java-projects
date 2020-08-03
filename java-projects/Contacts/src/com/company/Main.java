package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static ArrayList<Contact> contacts;
    private static Scanner scanner;

    public static void main(String[] args) {

        contacts = new ArrayList<>();
        System.out.println("Welcome to my humble world of programming");
        showInitialOptions();
    }
    private static void showInitialOptions() {
        System.out.println("Please select one: " +
                "\n\t1. Manage contacts" +
                "\n\t2. Messages" +
                "\n\t3. Quit");

        scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch(choice) {
            case 1:
                manageContacts();
                break;
            case 2:
                manageDetails();
                break;
            default:
                break;

        }
    }

    private static void manageContacts() {
        System.out.println("Please select one: " +
                "\n\t1. Show all contacts" +
                "\n\t2. Add a new contact" +
                "\n\t3. Search for a contact" +
                "\n\t4. Delete a contact" +
                "\n\t5. Go back");

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                showAllContacts();
                break;
            case 2:
                addNewContact();
                break;
            case 3:
                searchForContact();
                break;
            case 4:
                deleteContact();
                break;
            default:
                showInitialOptions();
                break; 
        }
    }

    private static void deleteContact() {
        System.out.println("Please enter the contact's name");
        String name = scanner.next();
        if (name.equals("")) {
            System.out.println("Please enter the name");
            deleteContact();
        } else {
            boolean doesExist = false;
            for (Contact c: contacts) {
                if (c.getName().equals("")) {
                    doesExist = true;
                    contacts.remove(c);
                }
            }

            if (!doesExist) {
                System.out.println("There is no such contact");
            }
        }
        showInitialOptions();
    }

    private static void searchForContact() {
        System.out.println("Please enter the contact name:");
        String name = scanner.next();
        if (name.equals("")) {
            System.out.println("Please enter the name");
            searchForContact();
        } else {
            boolean doesExist = false;
            for (Contact c: contacts) {
                if (c.getName().equals((name))) {
                    doesExist = true;
                    c.getDetails();
                }
            }
            if (!doesExist) {
                System.out.println("There is no such contact in your phone");
            }
        }
        showInitialOptions();
    }

    private static void addNewContact() {
        System.out.println("Adding a new contact..." +
                "\nPlease enter the contact's name:");
        String name = scanner.next();
        System.out.println("Please enter contact's number:");
        String number = scanner.next();
        System.out.println("Please enter contact's email:");
        String email = scanner.next();

        if (name.equals("") || number.equals("") || email.equals("")) {
            System.out.println("Please enter all of the information");
            addNewContact();
        } else {
            Contact contact = new Contact(name, number, email);
            contacts.add(contact);
        }
        showInitialOptions();
    }

    private static void showAllContacts() {
        for (Contact c: contacts) {
            c.getDetails();
        }

        showInitialOptions();
    }

}
