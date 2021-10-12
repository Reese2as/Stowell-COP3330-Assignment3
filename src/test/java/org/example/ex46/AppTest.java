package org.example.ex46;

import junit.framework.TestCase;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AppTest extends TestCase {

    public void testWordCounter() {
        App undertest = new App();
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

        String TextString = String.join(" ",Words);
        String[] WordsArray = TextString.split(" ");
        List<Words> Allwords = undertest.WordCounter(WordsArray);

        assertEquals(7, Allwords.get(0).Frequency);
        assertEquals(2, Allwords.get(1).Frequency);
        assertEquals(1, Allwords.get(2).Frequency);
        assertEquals("badger", Allwords.get(0).Word);
        assertEquals("mushroom", Allwords.get(1).Word);
        assertEquals("snake", Allwords.get(2).Word);
    }
}