/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Reese Stowell
 */
package org.example.ex46;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static List<Words> WordCounter (String[] WordsArray)
    {
        List<Words> AllWords = new ArrayList<Words>();
        int Wordexists;

        for(int i = 0; i < WordsArray.length; i++)
        {
            Wordexists = 1;

            for(int j = 0; j < AllWords.size(); j++)
            {
                if(WordsArray[i].equals(AllWords.get(j).getWord()))
                {
                    AllWords.get(j).Frequency++;
                    Wordexists = 2;
                }
            }
            if(Wordexists == 1)
            {
                Words x = new Words();
                x.Frequency = 1;
                x.Word = (WordsArray[i]);
                AllWords.add(x);
            }
        }
        return AllWords;
    }
    public static void main(String[] args)
    {
        ArrayList<String> Words = new ArrayList<>();
        Scanner scan = null;
        try
        {
            scan = new Scanner(new File("src/main/java/org/example/ex46/exercise46_input.txt"));
        }
        catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }

        while(scan.hasNextLine())
        {
            Words.add(scan.nextLine());
        }

        String WordsString = String.join(" ",Words);
        String[] WordsArray = WordsString.split(" ");
        List<Words> Allwords = WordCounter(WordsArray);

        for (int i = 0; i < Allwords.size(); i++)
        {
            System.out.print(String.format("%s: ", Allwords.get(i).Word));
            for (int j = 0; j < Allwords.get(i).Frequency; j++)
            {
                System.out.print("*");
            }
            System.out.print("\n");
        }

    }
}
