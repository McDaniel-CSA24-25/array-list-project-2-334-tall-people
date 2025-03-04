import java.util.List;
import java.util.Scanner;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
            ArrayList<Double>  grades  = new ArrayList<Double>();
            Scanner input = new Scanner(System.in);
            double average = 0;
            double high =0;
            double low = 0;
            System.out.println("Please input the grades you'd like to input one at a time.");
            double num = input.nextDouble();
             average +=num;
            grades.add(num);
            //lets them input as many 
        while(num>-1){
            System.out.println("Please input the grades you'd like to input one at a time. When you are done input -1.");
            num = input.nextDouble();
            if(num>-1) {
                grades.add(num);
                average += num;
            }
        }
        //asks user if they'd like to start removing grades
        System.out.println("This is your list of grades:");
        for (double j : grades) {
            System.out.print(j + ", ");
        }
        //the ugly code here is just to round the average
        System.out.println("This is the average grade: "+ ((int) 1000*(average/grades.size()))/1000);
        System.out.println("If you would like to start removing grades from the list type 1 other wise type 0.");
        num = input.nextDouble();
        if(num == 1){
            while(num>-1) {
                System.out.println("Please type the index of the grade you would like to remove, when you're done type -1. The index starts at 0.");
                num = input.nextDouble();
                //makes it so that they can type -1 without freaking out the remove function
                if (num > grades.size() || num < -1) {
                    System.out.println("The number you imputed is either out of bounds or not -1");
                } else if (num != -1) {

                    average -= grades.get((int) num);
                    grades.remove((int) num);

                    for (double j : grades) {
                        System.out.print(j + ", ");
                    }
                }
            }
        }
        //checks for the highest grade and the lowest grade
        for(int i = 1; i<grades.size();i++){
             low = grades.getFirst();
             high = grades.getFirst();
            if(low >grades.get(i)){
                low = grades.get(i);
            }
            if(high <grades.get(i)){
                high = grades.get(i);
            }
        }
        //says what number grades are which letter grades
        System.out.println("These are the grades that have an F:");

        for (double j : grades) {
            if(j<60) {
                System.out.print(j + ", ");
            }
        }
        System.out.println("\nThese are the grades that have a D:");

        for (double j : grades) {
            if(70>j&& j>=60) {
                System.out.print(j + ", ");
            }
        }

        System.out.println("\nThese are the grades that have a C:");

        for (double j : grades) {
            if(j>=70&&j<80) {
                System.out.print(j + ", ");
            }
        }
        System.out.println("\nThese are the grades that have a B:");

        for (double j : grades) {
            if(j>=80&&j<90) {
                System.out.print(j + ", ");
            }
        }
        System.out.println("\nThese are the grades that have an A:");

        for (double j : grades) {
            if(j>=90) {
                System.out.print(j + ", ");
            }
        }
        System.out.println("This is the average grade: "+ ((int) 1000*(average/grades.size()))/1000);
        System.out.println("This is the highest grade: "+ high);
        System.out.println("This is the lowest grade: "+ low);


    }
}