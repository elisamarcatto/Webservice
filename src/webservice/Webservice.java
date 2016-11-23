/* Classe Main do projeto Webservice
*/

package webservice;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;

public class Webservice
{
     public static void main(String[] args) throws Exception {
        
        /* Leitura do teclado para receber ID do usuario */ 
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Insira o numero de ID: ");
        String id = keyboard.nextLine();
        String URL = "http://ec2-35-164-139-210.us-west-2.compute.amazonaws.com"+"/hirers/"+id+"/opportunities"; 
        
        /* Obtendo JSON a partir da URL */
        String json = getJson(URL);  
        
        Gson gson = new Gson();   
        
        JsonParser parser = new JsonParser();
        JsonArray jArray = parser.parse(json).getAsJsonArray();        
        
        System.out.println("Contador de vagas do usuario '"+id+"': "+jArray.size());
    }

    private static String getJson(String urlString) throws Exception {
        BufferedReader reader = null;
        try {
            URL url = new URL(urlString);
            reader = new BufferedReader(new InputStreamReader(url.openStream()));           
            String output;
            String jsonString = null;
            
            while ((output = reader.readLine()) != null) {                
                jsonString = output;		
            } 
            return jsonString;
        } finally {
            if (reader != null)
                reader.close();
        }
    }
}

