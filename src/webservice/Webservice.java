/* Classe Main do projeto Webservice
*/

package webservice;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Webservice
{
     public static void main(String[] args) throws Exception {
        
        /* Leitura do teclado para receber ID do usuario */ 
        //Scanner keyboard = new Scanner(System.in);
        //System.out.println("Insira o numero de ID: ");
        //String id = keyboard.nextLine();
        //String URL = "http://ec2-35-164-223-211.us-west-2.compute.amazonaws.com"+"/hirers/"+id+"/opportunities"; 
         
        
        System.out.println("** ADICIONAR OPORTUNIDADE **");
         
        Scanner keyboardTitle = new Scanner(System.in);
        System.out.println("Insira o título da vaga: ");
        String title = keyboardTitle.nextLine();
                 
        Scanner keyboardDescrip = new Scanner(System.in); 
        System.out.println("Insira a descrição da vaga: ");
        String descrip = keyboardDescrip.nextLine();
        
        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date now = new Date();
        String date = sdfDate.format(now);
        
        Scanner keyboardContact = new Scanner(System.in);
        System.out.println("O contato está disponível?(sim/nao): ");
        String contact = keyboardContact.nextLine();
        if(contact.equals("sim")){
            contact = "true";
        } else contact = "false";
        
        Scanner keyboardActive = new Scanner(System.in); 
        System.out.println("Está ativo?(sim/nao): ");
        String active = keyboardActive.nextLine();
        if(active.equals("sim")){
            active = "true";
        } else active = "false";
        
        Scanner keyboardIdH = new Scanner(System.in); 
        System.out.println("Insira o ID do contratante: ");
        String id = keyboardIdH.nextLine();
        
        Scanner keyboardNameH = new Scanner(System.in); 
        System.out.println("Insira o nome do contratante: ");
        String nameHirer = keyboardNameH.nextLine();
        
        Scanner keyboardAccType = new Scanner(System.in); 
        System.out.println("O contratante é uma pessoa física(pf) ou jurídica (pj)? ");
        String accType = keyboardAccType.nextLine();
        String company;
        String cnpj;
        if(accType.equals("pj")){
            Scanner keyboardCompany = new Scanner(System.in); 
            System.out.println("Insira o nome da empresa: ");
            company = keyboardCompany.nextLine();
            
            Scanner keyboardCnpj = new Scanner(System.in); 
            System.out.println("Insira o CNPJ da empresa: ");
            cnpj = keyboardCnpj.nextLine();
        } else{
            company = null;
            cnpj = null;
        } 
        
        Scanner keyboardPhone = new Scanner(System.in); 
        System.out.println("Insira o telefone do contratante: ");
        String phone = keyboardPhone.nextLine();
        
        Scanner keyboardEmail = new Scanner(System.in); 
        System.out.println("Insira o email do contratante: ");
        String email = keyboardEmail.nextLine();
        
        Scanner keyboardMobile = new Scanner(System.in); 
        System.out.println("Insira o celular do contratante: ");
        String mobile = keyboardMobile.nextLine();
        
        Scanner keyboardPlan = new Scanner(System.in); 
        System.out.println("O plano do contratante está ativo?(sim/nao): ");
        String plan = keyboardPlan.nextLine();
        if(plan.equals("sim")){
            plan = "true";
        } else plan = "false";
        
        Scanner keyboardNeigh = new Scanner(System.in); 
        System.out.println("Insira o bairro do contratante: ");
        String neigh = keyboardNeigh.nextLine();
        
        Scanner keyboardAddr = new Scanner(System.in); 
        System.out.println("Insira o endereço do contratante: ");
        String addr = keyboardAddr.nextLine();
        
        Scanner keyboardAddrType = new Scanner(System.in); 
        System.out.println("Insira o tipo de endereço: ");
        String addrType = keyboardAddrType.nextLine();
        
        String latitude = "-22.9851707";
        String longitude = "-43.2071601";
        String idCity = "6861";
        
        Scanner keyboardCity = new Scanner(System.in); 
        System.out.println("Insira o tipo de endereço: ");
        String city = keyboardCity.nextLine();
        
        Scanner keyboardZip = new Scanner(System.in); 
        System.out.println("Insira o tipo de endereço: ");
        String zip = keyboardZip.nextLine();
        
        Scanner keyboardState = new Scanner(System.in); 
        System.out.println("Insira o tipo de endereço: ");
        String state = keyboardState.nextLine();
        
        Scanner keyboardFreq = new Scanner(System.in); 
        System.out.println("Insira a frequência do serviço: ");
        String freq = keyboardFreq.nextLine();
        
        String is_automatic = "false";
        String score = "3";
        String categoryId = "1";
        String categoryName = "Empregada Dom\\u00e9stica";
        
        Scanner keyboardSalary = new Scanner(System.in); 
        System.out.println("Insira os requisitos de salário: ");
        String salary = keyboardSalary.nextLine();
        
        Scanner keyboardStarts = new Scanner(System.in); 
        System.out.println("Insira o início da prestação dos serviços desejado: ");
        String starts = keyboardStarts.nextLine();
        
        String amount_candidates = "19";
        String amount_visualizations = "58";
        String feedback = "";
        String  salary_research = "";
        String relevancy = "";
        
        System.out.println(phone);
        
        /* Obtendo JSON a partir da URL */
        //String json = getJson(URL);         
        //Gson gson = new Gson();   
        
        //countOpp(json, gson, id);   // fornece o numero de vagas do contratante 'id'     
        
    }
    
    private static void countOpp(String json, Gson gson, String id){
         
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

