package Demo;


import org.testng.annotations.Test;



import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ReadJson {
	@Test
	public void fetchUpdatejSON() throws IOException {

		JSONParser parser = new JSONParser();
        try
        {
            Object object = parser
                    .parse(new FileReader("D:\\KalpanaD\\JSON\\Sample.JSON"));
            
            //convert Object to JSONObject
            JSONObject jsonObject = (JSONObject)object;
            
            //Reading the String
            String name = (String) jsonObject.get("Name");
            
            Long age = (Long) jsonObject.get("Age");
            
            //Reading the array
            JSONArray countries = (JSONArray)jsonObject.get("Countries");
            
            //Printing all the values
            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
            System.out.println("Countries:");
            for(Object country : countries)
            {
                System.out.println("\t"+country.toString());
            }
        }
        catch(FileNotFoundException fe)
        {
            fe.printStackTrace();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}