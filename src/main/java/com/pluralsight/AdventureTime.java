package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class AdventureTime {

    static ArrayList<StepClass> steps;

    static void main(String[] args)
    {
        steps = loadAdventure();
        homeScreen();
    }
    public static void homeScreen()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Welcome to Adventure Time!");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Press (P) to play: ");
        System.out.println("Press (Q) to quit: " );
        String selection = scanner.nextLine().toUpperCase().trim();

        if (selection.equals("P"))
        {
            gameScreen(1);
        }
        else if (selection.equals("Q"))
        {
            System.out.println("Oh...ok... till next time traveler. (is depressed)");
            System.exit(0);
        }
        else
        {
            System.out.println("You're lucky I'm a patient person. Let's try that again.");
            homeScreen();
        }
    }
    public static void gameScreen(int id)
    {
        for (int i = 0; i < steps.size(); i++) {
            StepClass stepClass = steps.get(i);
            if (stepClass.getId() == id) {
                System.out.println();
                System.out.println("Story text: " + stepClass.getStoryText());
                System.out.println("1) " + stepClass.getOption1Text());
                System.out.println("2) " + stepClass.getOption2Text());
                System.out.print("Choose: ");
            }
        }
    }
    public static ArrayList <StepClass> loadAdventure()
    {
        // Create the "container"
        ArrayList<StepClass> steps = new ArrayList<>(); // Array lists can change index quantity as needed
        try
        {
            FileReader fileReader = new FileReader("adventure1.csv"); // Creat FileReader class to reach file
            BufferedReader bufferedReader = new BufferedReader(fileReader); // Formats the FileReader to read efficiently

            String line = bufferedReader.readLine(); // Skips the first line in the file from being read (header)


            while((line = bufferedReader.readLine()) != null) // Loops to each line of the file until next line's value is null
            {
                System.out.println(line); // Prints variable 'line' which we assigned to hold and read the text of 'bufferedReader' on line 20

                String[]columns = line.split("\\|");
                int id = Integer.parseInt(columns[0]);
                String storyText = columns[1];
                String option1Text = columns [2];
                int option1NextId = Integer.parseInt(columns [3]);
                String option2Text = columns [4];
                int option2NextId = Integer.parseInt(columns[5]);

                // create a Step from the data in the current line
                StepClass stepClass = new StepClass(id, storyText, option1Text, option1NextId, option2Text, option2NextId );

                steps.add(stepClass); // Put 'stepClass' into an array list
            }
            bufferedReader.close();
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        return steps;
    }
}

