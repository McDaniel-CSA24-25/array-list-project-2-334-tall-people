//imports
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;


public class listOrganizer {
    ArrayList<String> contacts;
    public listOrganizer(){
        contacts = new ArrayList<>();
    }
    //method to add contact
    public void addCont(String name,String number){
        String contact = (name + " " + number);
        if(!contacts.contains(contact)){ //checks if the contact is already there
            contacts.add(contact);
            System.out.println("Contact successfully added");
        }
        else{
            System.out.println("Contact already exists");
        }
    }
    //used to search contact list
    public void lookUp(String name){
        boolean foundCont = false;
        for(int i = 0; i < contacts.size(); i++){ //basic search
            if(contacts.get(i).startsWith(name + " ")){
                System.out.println("Found contact at index "+ i);
                System.out.println("the contact is: " + contacts.get(i));
                foundCont = true;
                return;
            }
        }
        if(!foundCont){ //if contact isnt there
            System.out.println("contact was not found");
        }
    }
    public void sortCont() {
        Collections.sort(contacts);
        System.out.println(contacts);
    }
    public static void main(String[]args){
        listOrganizer organ = new listOrganizer(); //constructor used to initialize my methods
        Scanner input = new Scanner(System.in); //scanner
        int userChoice = 0;

        while(true) {
            System.out.println("\nChoices");
            System.out.println("1. Add Contact");
            System.out.println("2. Search for Contact");
            System.out.println("3. Show Contacts");
            System.out.println("Please choose an option");

            try{
                userChoice = input.nextInt();
                input.nextLine();
            }catch(java.util.InputMismatchException e){ //checks if user input is an int without crashing code
                input.nextLine();
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            //just if and if else statements to do whatever you press


            if (userChoice == 1) {
                System.out.println("Contact Name?");
                String name = input.nextLine();
                System.out.println("Contact Number?");
                String contNumber = input.nextLine();
                organ.addCont(name, contNumber);
            } else if (userChoice == 2) {
                System.out.println("Contact Name to Search?");
                String nameToSearch = input.nextLine();
                organ.lookUp(nameToSearch);
            } else if (userChoice == 3) {
                organ.sortCont();
            }else{
                System.out.println("Invalid choice");
            }
        }
    }
}

