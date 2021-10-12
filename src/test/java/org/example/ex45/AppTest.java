package org.example.ex45;

import junit.framework.TestCase;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class AppTest extends TestCase {

    public void testGenerateFile() throws IOException {
        App undertest = new App();
        String Root, Filename;
        boolean exists;
        Filename = "output";
        Root = "src/main/java/org/example/ex45/"+ Filename+ ".txt";

        undertest.generateFile(Root);

        File tempFile = new File("src/main/java/org/example/ex45/output.txt");

        exists = tempFile.exists();
        assertEquals(true, exists);
    }

    public void testReplacer() {
        App undertest = new App();
        ArrayList<String> Text = new ArrayList<>();
        String ReplacedText, TextString;
        Scanner scan = null;

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

        TextString = String.join("\n",Text);
        ReplacedText =  undertest.replacer(TextString);

        assertEquals("One should never use the word \"use\" in writing. Use \"use\" instead.\n" +
                "For example, \"She uses an IDE to write her Java programs\" instead of \"She\n" +
                "uses an IDE to write her Java programs\".", ReplacedText);
    }
}