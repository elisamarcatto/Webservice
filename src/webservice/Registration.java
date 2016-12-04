/* Classe composta por todos os campos de um cadastro (JSON completo)

*/
package webservice;

public class Registration
{
    private String created_at;
    private String updated_at;
    private Category category;        
    private Hirer hirer;
    private Location location;
    private String id;
    private String title;
    private String description;   
    private String is_contact_available;
    private String is_active;
    private String frequency;
    private String is_automatic;
    private String score;
    private String characteristics;
    private String starts;
    private String amount_candidates;
    private String amount_visualizations;
    private String feedback;
    private String salary_research;
    private String relevancy;
    
    
       
    public void setCreatedAt(String created_at){
        this.created_at = created_at;
    }   
    
    public String getCreatedAt(String created_at){
        return this.created_at;
    }
    
    public void setUpdatedAt(String created_at){
        this.updated_at = updated_at;
    }   
    
    public String getUpdatedAt(String created_at){
        return this.updated_at;
    }
   
    public void setCategory(Category category){
        this.category = category;
    }
    
    public Category getCategory(){
        return this.category;
    }
   
    public void setHirer(Hirer hirer){
        this.hirer = hirer;
    }
    
    public Hirer getHirer(){
        return this.hirer;
    }
   
    public void setLocation(Location location){
        this.location = location;
    }
    
    public Location getLocation(){
        return this.location;
    }
   
    public void setId(String id){
        this.id = id;
    }   
    
    public String getId(String id){
        return this.id;
    }
    
    public void setTitle(String title){
        this.title = title;
    }   
    
    public String getTitle(String title){
        return this.title;
    }
    
    public void setDescrip(String descrip){
        this.description = descrip;
    }   
    
    public String getDescrip(String descrip){
        return this.description;
    }

    public String getIsContactAvailable(){
        return this.is_contact_available;
    }

    public void setIsContactAvailable(String is_contact_available){
        this.is_contact_available = is_contact_available;
    }

    public String getIsActive(){
        return this.is_active;
    }

    public void setIsActive(String is_active){
        this.is_active = is_active;
    }

    public String getFrequency(){
        return this.frequency;
    }

    public void setFrequency(String frequency){
        this.frequency = frequency;
    }

    public String getIsAutomatic(){
        return this.is_automatic;
    }

    public void setIsAutomatic(String is_automatic){
        this.is_automatic = is_automatic;
    }

    public String getScore(){
        return this.score;
    }

    public void setScore(String score){
        this.score = score;
    }

    public String getCharacteristics(){
        return this.characteristics;
    }

    public void setCharacteristics(String characteristics){
        this.characteristics = characteristics;
    }

    public String getStarts(){
        return this.starts;
    }

    public void setStarts(String starts){
        this.starts = starts;
    }

    public String getAmountCandidates(){
        return this.amount_candidates;
    }

    public void setAmountCandidates(String amount_candidates){
        this.amount_candidates = amount_candidates;
    }

    public String getAmountVisualizations(){
        return this.amount_visualizations;
    }

    public void setAmountVisualizations(String amount_visualizations){
        this.amount_visualizations = amount_visualizations;
    }

    public String getFeedback(){
        return this.feedback;
    }

    public void setFeedback(String feedback){
        this.feedback = feedback;
    }

    public String getSalaryResearch(){
        return this.salary_research;
    }

    public void setSalaryResearch(String salary_research){
        this.salary_research = salary_research;
    }

    public String getRelevancy(){
        return relevancy;
    }

    public void setRelevancy(String relevancy){
        this.relevancy = relevancy;
    }
}

