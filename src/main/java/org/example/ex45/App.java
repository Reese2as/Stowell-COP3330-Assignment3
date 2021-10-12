/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Reese Stowell
 */
package org.example.ex45;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;

public class App {
    public static void generateFile(String File) throws IOException
    {
        File file = new File(File);

        if (file.createNewFile())
        {
            System.out.println("Created " + file);
        }
    }
    public static String replacer(String Text)
    {
        String ReplacedText = Text.replace("utilize", "use");
        return ReplacedText;
    }
    public static void main(String[] args) throws IOException {
        ArrayList<String> Text = new ArrayList<>();
        Scanner scan = null;
        String Filename, Root, ReplacedText, TextString;

        System.out.print("What would you like the output file name to be? ");
        Scanner user_input = new Scanner(System.in);
        Filename = user_input.nextLine();

        try
        {
            scan = new Scanner(new File("src/main/java/org/example/ex45/exercise45_input.txt"));
        }
        catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        while(scan.hasNextLine())
        {
            Text.add(scan.nextLine());
        }

        Root = "src/main/java/org/example/ex45/"+ Filename+ ".txt";
        generateFile(Root);

        TextString = String.join("\n",Text);
        ReplacedText = replacer(TextString);

        try
        {
            FileWriter myWriter = new FileWriter(Root);
            myWriter.write(ReplacedText);
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
