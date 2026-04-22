package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class AdventureTime {

    static ArrayList<StepClass> adventureSteps;

    static void main() {
        adventureSteps = loadAdventureTime();
        homeScreen();
    }
    public static void homeScreen() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Welcome to Adventure Time!");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Press (P) to play: ");
        System.out.println("Press (Q) to quit: " );
        String choice = scanner.nextLine().toUpperCase();
        System.out.println();
        if (choice.equals("P")) {
            gameScreen(1);
        }
    }
    public static void gameScreen(int id) {
        for (int i = 0; i < adventureSteps.size(); i++) {
            adventureSteps adventuresteps = adventureSteps.get(i);
            if(adventureSteps.getId() == id){
                System.out.println("");
                System.out.println("");
                System.out.println("");
                System.out.println("");
                System.out.println("");
            }
    }
        ArrayList<StepClass> adventureSteps = new ArrayList<>(); // Array lists can change index amount as needed

        try
        {
            FileReader fileReader = new FileReader("adventure1.csv"); // Creat FileReader class to reach file
            BufferedReader bufferedReader = new BufferedReader(fileReader); // Formats the FileReader to read efficiently

            String line = bufferedReader.readLine(); // Skips the first line in the file from being read (header)

            line = bufferedReader.readLine();

            while(line != null) // Loops to each line of the file until next line's value is null
            {
                System.out.println(line); // Prints variable 'line' which we assigned to hold and read the text of 'bufferedReader' on line 20
                line = bufferedReader.readLine(); // Goes to next line in file to print

                String[]columns = line.split("\\|");
                int id = Integer.parseInt(columns[0]);
                String storyText = columns[1];
                String option1Text = columns [2];
                int option1NextId = Integer.parseInt(columns [3]);
                String option2Text = columns [4];
                int option2NextId = Integer.parseInt(columns[5]);

                // create a Step from the data in the current line
                StepClass stepClass = new StepClass(id, storyText, option1Text, option1NextId, option2Text, option2NextId );

                adventureSteps.add(stepClass); // Put 'stepClass' into an array list
            }
            bufferedReader.close();
        }
        catch (Exception e)
        {

        }
    }
}

