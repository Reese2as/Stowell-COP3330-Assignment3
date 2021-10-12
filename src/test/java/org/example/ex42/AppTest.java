package org.example.ex42;

import junit.framework.TestCase;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AppTest extends TestCase {

    public void testParser() {
        App undertest = new App();

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

        Records[] records  = undertest.Parser(Fullrecord);

        assertEquals("Ling", records[0].Last_Name);
        assertEquals("Mai", records[0].First_Name);
        assertEquals(55900, records[0].Salary);
        assertEquals("Johnson", records[1].Last_Name);
        assertEquals("Jim", records[1].First_Name);
        assertEquals(56500, records[1].Salary);
        assertEquals("Jones", records[2].Last_Name);
        assertEquals("Aaron", records[2].First_Name);
        assertEquals(46000, records[2].Salary);
    }

}