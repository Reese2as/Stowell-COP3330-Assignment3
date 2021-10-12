/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Reese Stowell
 */
package org.example.ex44;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class App {
    public static void Printer(Object obj) {
        String user_product;
        Scanner user_input = new Scanner(System.in);
        System.out.println("What is the product name? ");
        user_product = user_input.nextLine();

        int exists = DoesProductExist(obj, user_product);

        if (exists ==  1){
            System.out.println("Sorry, that product was not found in our inventory.");
            Printer(obj);
        }
        else
            System.out.println(String.format("Name: %s\nPrice: %.2f\nQuantity: %d", obj.products[obj.I].name, obj.products[obj.I].price, obj.products[obj.I].quantity));
    }
    public static int DoesProductExist(Object obj, String user_product) {
        int exists = 1;

        for (int i = 0; i < obj.products.length; i++)
            if (obj.products[i].name.equals(user_product)) {
                exists = 2;
                obj.I = i;
                break;
            }
        return exists;
    }
    public static void main(String[] args) {
        Gson gson = new Gson();
        try
        {
            Reader reader = Files.newBufferedReader(Paths.get("src/main/java/org/example/ex44/exercise44_input.json"));
            Object obj = gson.fromJson(reader, Object.class);
            Printer(obj);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}

