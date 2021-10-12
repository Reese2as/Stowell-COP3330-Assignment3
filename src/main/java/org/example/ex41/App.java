/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Reese Stowell
 */
package org.example.ex41;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.*;
import java.io.FileWriter;


public class App {
    public static List NameSort(List Names)
    {
        Collections.sort(Names);
        return Names;
    }
    public static void main(String[] args)
    {
        ArrayList<String> Names = new ArrayList<>();
        List<String> SortedNames;
        int Numnames;

        Scanner scan = null;
        try
        {
            scan = new Scanner(new File("src/main/java/org/example/ex41/exercise41_input.txt"));
        }
        catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }

        while(scan.hasNextLine())
        {
            Names.add(scan.nextLine());
        }

        SortedNames = NameSort(Names);
        Numnames = SortedNames.size();

        try
        {
            FileWriter myWriter = new FileWriter("src/main/java/org/example/ex41/exercise41_output.txt");

            myWriter.write(String.format("Total of %d names\n----------------- \n", Numnames));

            for(int i=0; i < SortedNames.size(); i++)
            {
                myWriter.write((SortedNames.get(i) + "\n"));
            }

            myWriter.close();

            System.out.println("Successfully wrote to the file.");
        }
        catch (Exception ex)
        {
            System.out.println("An error occurred.");
            ex.printStackTrace();
        }
    }
}
