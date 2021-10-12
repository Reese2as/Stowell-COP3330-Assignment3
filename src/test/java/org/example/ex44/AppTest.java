package org.example.ex44;

import com.google.gson.Gson;
import junit.framework.TestCase;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class AppTest extends TestCase {

    public void testDoesProductExist() {
        App undertest = new App();
        Gson gson = new Gson();
        String user_product = "Widget";
        String user_product2 = "FAKE";
        try
        {

            Reader reader = Files.newBufferedReader(Paths.get("src/main/java/org/example/ex44/exercise44_input.json"));
            Object obj = gson.fromJson(reader, Object.class);
            int result = undertest.DoesProductExist(obj, user_product);
            int result2 = undertest.DoesProductExist(obj, user_product2);
            assertEquals(2, result);
            assertEquals(1, result2);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }
}