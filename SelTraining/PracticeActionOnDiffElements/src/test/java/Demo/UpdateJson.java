package Demo;

import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class UpdateJson {
	@SuppressWarnings("unchecked")
	@Test
	public void writejSON() {
		
        JSONObject json = new JSONObject();
        json.put("title", "Harry Potter and Half Blood Prince");
        json.put("author", "J. K. Rolling");
        json.put("price", 20);
        json.put("edition", "1");

        JSONArray jsonArray = new JSONArray();
        jsonArray.add("Harry");
        jsonArray.add("Ron");
        jsonArray.add("Hermoinee");
        jsonArray.add("Meghu");
        
        json.put("characters", jsonArray);
        
        Map m = new LinkedHashMap(4);
        m.put("streetAddress", "21 2nd Street");
        m.put("city", "New York");
        m.put("state", "NY");
        m.put("postalCode", 10021);
        
        //putting address to JSONObject
        json.put("address", m);
        
        try {
            System.out.println("Writting JSON into file ...");
            System.out.println(json);
            String file = "D:\\KalpanaD\\JSON\\book.json";
			FileWriter jsonFileWriter = new FileWriter(file);
            jsonFileWriter.write(json.toJSONString());
            jsonFileWriter.flush();
            jsonFileWriter.close();
            System.out.println("Done");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}


