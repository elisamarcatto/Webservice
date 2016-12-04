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
        
        String URL = "http://ec2-35-164-223-211.us-west-2.compute.amazonaws.com/opportunities"; 
         
        Registration registration = new Registration();
        Category category = new Category();
        Hirer hirer = new Hirer();          
        Location location = new Location();
        
        // Para testar o programa sem precisar inserir entradas
        //String json = "{\"created_at\":\"2016-07-01 19:06:12\",\"updated_at\":\"2016-11-21 15:21:07\",\"category\":{\"id\":\"1\",\"name\":\"Empregada Dom\\u00e9stica\"},\"hirer\":{\"id\":13901,\"name\":\"Felipe Matos Dos Santos\",\"account_type\":\"pf\",\"cnpj\":null,\"company_contact_name\":null,\"phone\":\"(21) 99870-0327\",\"email\":\"felipe_med@yahoo.com.br\",\"mobile_phone\":\"(21) 93234-8378\",\"is_plan_active\":true},\"location\":{\"neighborhood\":\"Ipanema\",\"address\":\"Prudente de Morais\",\"address_type\":\"Rua\",\"latitude\":-22.9851707,\"longitude\":-43.2071601,\"city_id\":\"6861\",\"city\":\"Rio de Janeiro\",\"zipcode\":\"22420043\",\"state\":\"RJ\"},\"id\":98765,\"title\":\"Vaga para Empregada Dom\\u00e9stica\",\"description\":\"Casal sem filhos e sem animais dom\\u00e9sticos  procura empregada \\n            dom\\u00e9stica para cuidar de um apartamento duplex. Limpar, cozinhar, lavar e \\n            passar roupas. In\\u00edcio a partir de 20 de julho\",\"is_contact_available\":true,\"is_active\":true,\"frequency\":\"mensalista_2x\",\"is_automatic\":false,\"score\":3,\"salary_requirements\":1100,\"characteristics\":[],\"starts\":\"esse_mes\",\"amount_candidates\":19,\"amount_visualizations\":58,\"feedback\":\"\",\"salary_research\":\"\",\"relevancy\":\"\"}";
        
        String json = receiveInput(registration, category, hirer, location);
        System.out.println(json);    
        
        String request = postJson(URL, json);        
     
        //countOpp(json, gson, id);   // fornece o numero de vagas do contratante 'id'     
        
        System.out.println(json);
        System.out.println(request);
    }
    
    private static String receiveInput(Registration registration, Category category, Hirer hirer, Location location){
        
        System.out.println("** ADICIONAR OPORTUNIDADE **");
        
        Scanner keyboardId = new Scanner(System.in); 
        System.out.println("Insira o ID da oportunidade: ");
        String id = keyboardId.nextLine();
        registration.setId(Integer.parseInt(id));
        
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
            registration.setIsContactAvailable(true);
        } else registration.setIsContactAvailable(false);
        
        Scanner keyboardActive = new Scanner(System.in); 
        System.out.println("Está ativo?(sim/nao): ");
        String active = keyboardActive.nextLine();
        if(active.equals("sim")){
            registration.setIsActive(true);
        } else registration.setIsActive(false);
        
        Scanner keyboardIdH = new Scanner(System.in); 
        System.out.println("Insira o ID do contratante: ");
        String idHirer = keyboardIdH.nextLine();
        hirer.setId(Integer.parseInt(idHirer));
        
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
            company = "null";
            hirer.setCompanyContactName(company);
            cnpj = "null";
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
            hirer.setIsPlanActive(true);
        } else hirer.setIsPlanActive(false);
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
        
        Double latitude = -22.9851707;
        location.setLatitude(latitude);
        Double longitude = -43.2071601;
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
        
        boolean is_automatic = false;
        registration.setIsAutomatic(is_automatic);
        
        Scanner keyboardScore = new Scanner(System.in); 
        System.out.println("Insira a pontuação do serviço: ");
        String score = keyboardScore.nextLine();
        registration.setScore(Integer.parseInt(score));
        
        Scanner keyboardCatId = new Scanner(System.in); 
        System.out.println("Insira o ID da categoria do serviço: ");
        String categoryId = keyboardCatId.nextLine();
        category.setId(Integer.parseInt(categoryId));
        
        Scanner keyboardCatName = new Scanner(System.in); 
        System.out.println("Insira o nome da cateogoria do serviço: ");
        String categoryName = keyboardCatName.nextLine();
        category.setName(categoryName);
        registration.setCategory(category);
        
        Scanner keyboardSalary = new Scanner(System.in); 
        System.out.println("Insira os requisitos de salário: ");
        String salary = keyboardSalary.nextLine();
        registration.setSalaryRequirements(Integer.parseInt(salary));
        
        String characteristics = "";
        registration.setCharacteristics(characteristics);
        
        Scanner keyboardStarts = new Scanner(System.in); 
        System.out.println("Insira o início da prestação dos serviços desejado: ");
        String starts = keyboardStarts.nextLine();
        registration.setStarts(starts);
        
        Scanner keyboardAmountCand = new Scanner(System.in); 
        System.out.println("Insira o número de candidatos: ");
        String amount_candidates = keyboardAmountCand.nextLine();
        registration.setAmountCandidates(Integer.parseInt(amount_candidates));
        
        Scanner keyboardAmountVisu = new Scanner(System.in); 
        System.out.println("Insira o número de visualizações: ");
        String amount_visualizations = keyboardAmountVisu.nextLine();
        registration.setAmountVisualizations(Integer.parseInt(amount_visualizations));
        
        Scanner keyboardFeedback = new Scanner(System.in); 
        System.out.println("Qual o feedback do serviço?: ");
        String feedback = keyboardFeedback.nextLine();
        registration.setFeedback(feedback);
        
        Scanner keyboardSalResearch = new Scanner(System.in); 
        System.out.println("Insira o salário de pesquisa: ");
        String salary_research = keyboardSalResearch.nextLine();
        registration.setSalaryResearch(salary_research);
        
        Scanner keyboardRelevancy = new Scanner(System.in); 
        System.out.println("Insira a relevância do serviço: ");
        String relevancy = keyboardRelevancy.nextLine();
        registration.setRelevancy(relevancy);        
        
        Gson gson = new Gson();
        String json = gson.toJson(registration);                                                              
              
        return json;
    }
     
    private static String postJson(String url, String json) throws MyException{
        
        try {        
        HttpURLConnection request = (HttpURLConnection) new URL(url).openConnection();

        try {
            request.setDoOutput(true);
            request.setDoInput(true);
            
            request.setRequestProperty("Content-Type", "application/json");

            request.setRequestMethod("POST");

            request.connect();

            try (OutputStream outputStream = request.getOutputStream()) {
                outputStream.write(json.getBytes("UTF-8"));
            }
            return readResponse(request);
        } finally {
            request.disconnect();
        }
        } catch (IOException ex) {
            throw new MyException(ex);
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
    
    public static class MyException extends Exception {
        private static final long serialVersionUID = 1L;

        public MyException(Throwable cause) {
            super(cause);
        }
    }
}

