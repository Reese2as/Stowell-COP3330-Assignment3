/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Reese Stowell
 */
package org.example.ex43;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.*;

public class App
{
    public static void HTMLFileCreator(String Site_Name, String Author) throws IOException
    {
        File f = new File("src/main/java/org/example/ex43/website/"+Site_Name+"/index.html");
        BufferedWriter bw = new BufferedWriter(new FileWriter(f));
        bw.write("<html><head><title>"+ Site_Name+ "</title><meta name = \"" + Author + "\"></head>");
        bw.close();
        System.out.println("Created src/main/java/org/example/ex43/website/" + Site_Name + "/index.html");
    }
    public static void generateFile(String File)
    {
        new File(File).mkdirs();
        System.out.println("Created " + File);
    }
    public static void main(String[] args) throws Exception
    {
        Scanner user_input = new Scanner(System.in);

        String Site_Name, Author, JS, CSS, Root;

        System.out.print("Site name: ");
        Site_Name = user_input.nextLine();
        System.out.print("Author: ");
        Author = user_input.nextLine();
        System.out.print("Do you want a folder for JavaScript? ");
        JS = user_input.nextLine();
        System.out.print("Do you want a folder for CSS? ");
        CSS = user_input.nextLine();

        Root = "src/main/java/org/example/ex43/website/" + Site_Name;
        generateFile(Root);

        HTMLFileCreator(Site_Name,Author);

        if (JS.equals("y") || JS.equals("Y"))
        {
            Root = "src/main/java/org/example/ex43/website/" + Site_Name+ "/js/";
            generateFile(Root);
        }
        if (CSS.equals("y") || CSS.equals("Y"))
        {
            Root = "src/main/java/org/example/ex43/website/" + Site_Name+ "/css/";
            generateFile(Root);
        }
    }
}
