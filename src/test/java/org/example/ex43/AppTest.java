package org.example.ex43;

import junit.framework.TestCase;

import java.io.File;

import java.io.IOException;


public class AppTest extends TestCase {

    public void testHTMLFileCreator() throws IOException {
        App undertest = new App();
        String Site_Name, Author;
        boolean exists;
        Site_Name = "awesomeco";
        Author = "Max Power";

        undertest.HTMLFileCreator(Site_Name,Author);

        File tempFile = new File("src/main/java/org/example/ex43/website/awesomeco/index.html");

        exists = tempFile.exists();
        assertEquals(true, exists);
    }

    public void testGenerateFile() {
        App undertest = new App();
        String Site_Name = "awesomeco";
        String Root = "src/main/java/org/example/ex43/website/" + Site_Name;
        boolean exists;
        undertest.generateFile(Root);

        File tempFile = new File("src/main/java/org/example/ex43/website/awesomeco");

        exists = tempFile.exists();
        assertEquals(true, exists);
    }
}