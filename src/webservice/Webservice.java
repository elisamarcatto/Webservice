/* Classe Main do projeto Webservice
*/

package webservice;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class Webservice
{
     public static void main(String[] args) throws Exception {
         
        Gson gson = new Gson();

        String json = getJson("http://ec2-35-164-139-210.us-west-2.compute.amazonaws.com/hirers/111222/opportunities");

        System.out.println("1");
        System.out.println(json);   
        //json = "{\"created_at\":\"2016-07-01 13:06:12\",\"updated_at\":\"2016-11-21 15:21:07\",\"category\":{\"id\":1,\"name\":\"Empregada Dom\\u00e9stica\"},\"hirer\":{\"id\":111222,\"name\":\"Felipe Matos Dos Santos\",\"account_type\":\"pf\",\"cnpj\":null,\"company_contact_name\":null,\"phone\":\"(21) 99870-0327\",\"email\":\"felipe_med@yahoo.com.br\",\"mobile_phone\":\"(21) 93234-8378\",\"is_plan_active\":true},\"location\":{\"neighborhood\":\"Ipanema\",\"address\":\"Prudente de Morais\",\"address_type\":\"Rua\",\"latitude\":-22.9851707,\"longitude\":-43.2071601,\"city_id\":\"6861\",\"city\":\"Rio de Janeiro\",\"zipcode\":\"22420043\",\"state\":\"RJ\"},\"id\":98765,\"title\":\"Vaga para Empregada Dom\\u00e9stica\",\"description\":\"Casal sem filhos e sem animais dom\\u00e9sticos  procura empregada \\n            dom\\u00e9stica para cuidar de um apartamento duplex. Limpar, cozinhar, lavar e \\n            passar roupas. In\\u00edcio a partir de 20 de julho\",\"is_contact_available\":true,\"is_active\":true,\"frequency\":\"mensalista_2x\",\"is_automatic\":false,\"score\":3,\"salary_requirements\":1100,\"characteristics\":[],\"starts\":\"esse_mes\",\"amount_candidates\":19,\"amount_visualizations\":58,\"feedback\":\"\",\"salary_research\":\"\",\"relevancy\":\"\"}";
       
        Type listType = new TypeToken<List<Registration>>(){}.getType();
        List<Registration> registration = gson.fromJson(json, listType);
            
        //JSONObject obj = registration.getJSONObject(1);
        
        
        //JSONArray id = jsonobject.getJSONArray("id");
        
        //Registration registration = gson.fromJson(json, Registration.class);
        System.out.println(registration.get(0).category.id);
    }

    private static String getJson(String urlString) throws Exception {
        BufferedReader reader = null;
        try {
            URL url = new URL(urlString);
            reader = new BufferedReader(new InputStreamReader(url.openStream()));
            System.out.println(reader);
            String output;
            String jsonString = null;
            
            while ((output = reader.readLine()) != null) {
                
                jsonString = output;
		System.out.println(output);
            }
            //output = reader.readLine()
            //while ((read = reader.read(chars)) != -1)
            //    buffer.append(chars, 0, read); 

            return jsonString;
        } finally {
            if (reader != null)
                reader.close();
        }

    }
}

