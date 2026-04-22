package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;

public class AdventureTime
{
    public static void main(String[] args)
    {
        loadAdventure();
    }
    public static void loadAdventure()
    {
        try
        {
            FileReader fileReader = new FileReader("adventure1.csv"); // import FileReader to reach file
            BufferedReader bufferedReader = new BufferedReader(fileReader); // Formats the FileReader to read efficiently

            String line = bufferedReader.readLine(); // Skips header

            while(line != null) // Loops to each line of the file until next line is null
            {
                System.out.println(line); // Prints line
                line = bufferedReader.readLine(); // Goes to next line in file to print
            }

        }
        catch (Exception c)
        {

        }
    }
}

