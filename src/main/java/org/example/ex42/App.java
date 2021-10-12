
/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Reese Stowell
 */
package org.example.ex42;
import java.io.*;
import java.util.*;
import java.util.Scanner;

public class App {
    public static Records[] Parser (List Fullrecord)
    {
        Records[] records = new Records[Fullrecord.size()];
        String OngoingLine;

        for (int i = 0; i < records.length; i++)
        {
            records[i] = new Records();

            OngoingLine = (String) Fullrecord.get(i);

            records[i].Last_Name = OngoingLine.substring(0, OngoingLine.indexOf(","));

            OngoingLine = OngoingLine.substring(OngoingLine.indexOf(",") + 1);

            records[i].First_Name = OngoingLine.substring(0, OngoingLine.indexOf(","));

            OngoingLine = OngoingLine.substring(OngoingLine.indexOf(",") + 1);
            
            records[i].Salary = Integer.parseInt(OngoingLine);
        }
        return records;
    }
    public static void main(String[] args)
    {

        ArrayList<String> Fullrecord = new ArrayList<>();

        Scanner scanner = null;
        try
        {
            scanner = new Scanner(new File("src/main/java/org/example/ex42/exercise42_input.txt"));
        }
        catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }

        while(scanner.hasNextLine())
        {
            Fullrecord.add(scanner.nextLine());
        }

        Records[] records = Parser(Fullrecord);

        System.out.println(String.format("%s %10s %10s\n--------------------------", "Last", "First", "Salary"));

        for (int i = 0; i < records.length; i++)
        {
            System.out.println(String.format("%-9s %-9s %-9s", records[i].Last_Name, records[i].First_Name, records[i].Salary));
        }
    }
}
