package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class AdventureTime {

    static ArrayList<Scene> scenes;

    static void main(String[] args)
    {
        scenes = loadAdventure();
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
        for (int i = 0; i < scenes.size(); i++) {
            Scene scene = scenes.get(i);
            if (scene.getId() == id) {
                System.out.println();
                System.out.println("Story text: " + scene.getStoryText());
                System.out.println("1) " + scene.getOption1Text());
                System.out.println("2) " + scene.getOption2Text());
                System.out.print("Choose: ");
            }
        }
    }
    public static ArrayList <Scene> loadAdventure()
    {
        // Create the "container"
        ArrayList<Scene> scenes = new ArrayList<>(); // Array lists can change index quantity as needed
        try
        {
            FileReader fileReader = new FileReader("adventure1.csv"); // Create FileReader class to reach file
            BufferedReader bufferedReader = new BufferedReader(fileReader); // Formats the FileReader to read efficiently

            String header = bufferedReader.readLine(); // BufferedReader reads first line of .csv, the header (we don't want to print this!)
            String line = bufferedReader.readLine();   // BufferedReader is now reading the first line we want to print (line 2) we declare String line as our variable.

            while(line != null) // As long as 'line' has a value inside it, it will print below.
            {
                System.out.println(line);  // Variable 'line' holds the text of 'bufferedReader' and we display it by printing using System.out.println();

                String[]columns = line.split("\\|");
                int sceneId = Integer.parseInt(columns[0]);
                String storyText = columns[1];
                String option1Text = columns [2];
                int option1NextId = Integer.parseInt(columns [3]);
                String option2Text = columns [4];
                int option2NextId = Integer.parseInt(columns[5]);

                // create a Step from the data in the current line
                Scene scene = new Scene(sceneId, storyText, option1Text, option1NextId, option2Text, option2NextId );

                scenes.add(scene); // Put 'stepClass' into an array list
            }
            bufferedReader.close();
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        return scenes;
    }
}

