/* Classe Main do projeto Webservice
*/

package webservice;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
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
         
        Registration registration = new Registration();
        Category category = new Category();
        Hirer hirer = new Hirer();
          
        Location location = new Location();
        
        System.out.println("** ADICIONAR OPORTUNIDADE **");
         
        Scanner keyboardTitle = new Scanner(System.in);
        System.out.println("Insira o título da vaga: ");
        String title = keyboardTitle.nextLine();
        registration.setTitle(title);
        
        Scanner keyboardDescrip = new Scanner(System.in); 
        System.out.println("Insira a descrição da vaga: ");
        String descrip = keyboardDescrip.nextLine();
        registration.setDescrip(descrip);
        
        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date now = new Date();
        String date = sdfDate.format(now);
        registration.setCreatedAt(date);
        
        Scanner keyboardContact = new Scanner(System.in);
        System.out.println("O contato está disponível?(sim/nao): ");
        String contact = keyboardContact.nextLine();
        if(contact.equals("sim")){
            contact = "true";
        } else contact = "false";
        registration.setIsContactAvailable(contact);
        
        Scanner keyboardActive = new Scanner(System.in); 
        System.out.println("Está ativo?(sim/nao): ");
        String active = keyboardActive.nextLine();
        if(active.equals("sim")){
            active = "true";
        } else active = "false";
        registration.setIsActive(active);
        
        Scanner keyboardIdH = new Scanner(System.in); 
        System.out.println("Insira o ID do contratante: ");
        String idHirer = keyboardIdH.nextLine();
        hirer.setId(idHirer);
        
        Scanner keyboardNameH = new Scanner(System.in); 
        System.out.println("Insira o nome do contratante: ");
        String hirerName = keyboardNameH.nextLine();
        hirer.setName(hirerName);
        
        Scanner keyboardAccType = new Scanner(System.in); 
        System.out.println("O contratante é uma pessoa física(pf) ou jurídica (pj)? ");
        String accType = keyboardAccType.nextLine();
        String company;
        String cnpj;
        if(accType.equals("pj")){
            Scanner keyboardCompany = new Scanner(System.in); 
            System.out.println("Insira o nome da empresa: ");
            company = keyboardCompany.nextLine();
            hirer.setCompanyContactName(company);
            
            Scanner keyboardCnpj = new Scanner(System.in); 
            System.out.println("Insira o CNPJ da empresa: ");
            cnpj = keyboardCnpj.nextLine();
            hirer.setCnpj(cnpj);
        } else{
            company = null;
            hirer.setCompanyContactName(company);
            cnpj = null;
            hirer.setCnpj(cnpj);
        } 
        hirer.setAccountType(accType);
        
        Scanner keyboardPhone = new Scanner(System.in); 
        System.out.println("Insira o telefone do contratante: ");
        String phone = keyboardPhone.nextLine();
        hirer.setPhone(phone);       
        
        Scanner keyboardEmail = new Scanner(System.in); 
        System.out.println("Insira o email do contratante: ");
        String email = keyboardEmail.nextLine();
        hirer.setEmail(email);
        
        Scanner keyboardMobile = new Scanner(System.in); 
        System.out.println("Insira o celular do contratante: ");
        String mobile = keyboardMobile.nextLine();
        hirer.setMobilePhone(mobile);
        
        Scanner keyboardPlan = new Scanner(System.in); 
        System.out.println("O plano do contratante está ativo?(sim/nao): ");
        String plan = keyboardPlan.nextLine();
        if(plan.equals("sim")){
            plan = "true";
        } else plan = "false";
        hirer.setIsPlanActive(plan);
        registration.setHirer(hirer);
        
        Scanner keyboardNeigh = new Scanner(System.in); 
        System.out.println("Insira o bairro do contratante: ");
        String neigh = keyboardNeigh.nextLine();
        location.setNeighborhood(neigh);
        
        Scanner keyboardAddr = new Scanner(System.in); 
        System.out.println("Insira o endereço do contratante: ");
        String addr = keyboardAddr.nextLine();
        location.setAddress(addr);
        
        Scanner keyboardAddrType = new Scanner(System.in); 
        System.out.println("Insira o tipo de endereço: ");
        String addrType = keyboardAddrType.nextLine();
        location.setAddressType(addrType);
        
        String latitude = "-22.9851707";
        location.setLatitude(latitude);
        String longitude = "-43.2071601";
        location.setLongitude(longitude);
        String cityId = "6861";
        location.setCityId(cityId);
        
        Scanner keyboardCity = new Scanner(System.in); 
        System.out.println("Insira o nome da cidade: ");
        String city = keyboardCity.nextLine();
        location.setCity(city);
        
        Scanner keyboardZip = new Scanner(System.in); 
        System.out.println("Insira o CEP: ");
        String zip = keyboardZip.nextLine();
        location.setZipcode(zip);
        
        Scanner keyboardState = new Scanner(System.in); 
        System.out.println("Insira o estado: ");
        String state = keyboardState.nextLine();
        location.setState(state);
        registration.setLocation(location);
        
        Scanner keyboardFreq = new Scanner(System.in); 
        System.out.println("Insira a frequência do serviço: ");
        String freq = keyboardFreq.nextLine();
        registration.setFrequency(freq);
        
        String is_automatic = "false";
        registration.setIsAutomatic(is_automatic);
        String score = "3";
        registration.setScore(score);
        String categoryId = "1";
        category.setId(categoryId);
        String categoryName = "Empregada Dom\\u00e9stica";
        category.setName(categoryName);
        registration.setCategory(category);
        
        Scanner keyboardSalary = new Scanner(System.in); 
        System.out.println("Insira os requisitos de salário: ");
        String salary = keyboardSalary.nextLine();
        registration.setSalaryResearch(salary);
        
        Scanner keyboardStarts = new Scanner(System.in); 
        System.out.println("Insira o início da prestação dos serviços desejado: ");
        String starts = keyboardStarts.nextLine();
        registration.setStarts(starts);
        
        String amount_candidates = "19";
        registration.setAmountCandidates(amount_candidates);
        String amount_visualizations = "58";
        registration.setAmountVisualizations(amount_visualizations);
        String feedback = "";
        registration.setFeedback(feedback);
        String salary_research = "";
        registration.setSalaryResearch(salary_research);
        String relevancy = "";
        registration.setRelevancy(relevancy);
        
        Gson gson = new Gson();
        String json = gson.toJson(registration);
        System.out.println(json);
        
        
     
        //countOpp(json, gson, id);   // fornece o numero de vagas do contratante 'id'     
        
    }
     
    private static String postJson(String url, String json) throws MinhaExcecao{
        
        try {
        // Cria um objeto HttpURLConnection:
        HttpURLConnection request = (HttpURLConnection) new URL(url).openConnection();

        try {
            // Define que a conexão pode enviar informações e obtê-las de volta:
            request.setDoOutput(true);
            request.setDoInput(true);

            // Define o content-type:
            request.setRequestProperty("Content-Type", "application/json");

            // Define o método da requisição:
            request.setRequestMethod("POST");

            // Conecta na URL:
            request.connect();

            // Escreve o objeto JSON usando o OutputStream da requisição:
            try (OutputStream outputStream = request.getOutputStream()) {
                outputStream.write(json.getBytes("UTF-8"));
            }

            // Caso você queira usar o código HTTP para fazer alguma coisa, descomente esta linha.
            //int response = request.getResponseCode();

            return readResponse(request);
        } finally {
            request.disconnect();
        }
        } catch (IOException ex) {
            throw new MinhaExcecao(ex);
       }
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

    private static String readResponse(HttpURLConnection request) throws IOException{
        
        ByteArrayOutputStream os;
        try (InputStream is = request.getInputStream()) {
            os = new ByteArrayOutputStream();
            int b;
            while ((b = is.read()) != -1) {
                os.write(b);
            }
        }
        return new String(os.toByteArray());
    }
    
    public static class MinhaExcecao extends Exception {
        private static final long serialVersionUID = 1L;

        public MinhaExcecao(Throwable cause) {
            super(cause);
        }
    }
}

