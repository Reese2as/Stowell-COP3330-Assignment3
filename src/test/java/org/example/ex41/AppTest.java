package org.example.ex41;

import junit.framework.TestCase;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AppTest extends TestCase {

    public void testNameSort()
    {
        App undertest = new App();
        ArrayList<String> Names = new ArrayList<>();
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
        List<String> result;
        result = undertest.NameSort(Names);

        assertEquals("Johnson, Jim", result.get(0));
        assertEquals("Jones, Aaron", result.get(1));
        assertEquals("Jones, Chris", result.get(2));
        assertEquals("Ling, Mai", result.get(3));
        assertEquals("Swift, Geoffrey", result.get(4));
        assertEquals("Xiong, Fong", result.get(5));
        assertEquals("Zarnecki, Sabrina", result.get(6));
    }
}