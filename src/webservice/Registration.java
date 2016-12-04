/* Classe composta por todos os campos de um cadastro (JSON completo)

*/
package webservice;

public class Registration
{
    private Integer id;
    private String title;
    private String description;  
    private String created_at;
    //private String updated_at;
    private boolean is_contact_available;
    private boolean is_active;
    private Hirer hirer;
    private Location location;
    private String frequency;       
    private boolean is_automatic;
    private Integer score;
    private Category category;   
    private Integer salary_requirements;
    private String characteristics;
    private String starts;
    private Integer amount_candidates;
    private Integer amount_visualizations;
    private String feedback;
    private String salary_research;
    private String relevancy;    
       
    public void setCreatedAt(String created_at){
        this.created_at = created_at;
    }   
    
    public String getCreatedAt(String created_at){
        return this.created_at;
    }
    
    //public void setUpdatedAt(String created_at){
    //    this.updated_at = updated_at;
    //}   
    
    //public String getUpdatedAt(String created_at){
    //    return this.updated_at;
    //}
   
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
   
    public void setId(Integer id){
        this.id = id;
    }   
    
    public Integer getId(){
        return this.id;
    }
    
    public void setTitle(String title){
        this.title = title;
    }   
    
    public String getTitle(){
        return this.title;
    }
    
    public void setDescrip(String descrip){
        this.description = descrip;
    }   
    
    public String getDescrip(){
        return this.description;
    }

    public boolean getIsContactAvailable(){
        return this.is_contact_available;
    }

    public void setIsContactAvailable(boolean is_contact_available){
        this.is_contact_available = is_contact_available;
    }

    public boolean getIsActive(){
        return this.is_active;
    }

    public void setIsActive(boolean is_active){
        this.is_active = is_active;
    }

    public String getFrequency(){
        return this.frequency;
    }

    public void setFrequency(String frequency){
        this.frequency = frequency;
    }

    public boolean getIsAutomatic(){
        return this.is_automatic;
    }

    public void setIsAutomatic(boolean is_automatic){
        this.is_automatic = is_automatic;
    }

    public Integer getScore(){
        return this.score;
    }

    public void setScore(Integer score){
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

    public Integer getAmountCandidates(){
        return this.amount_candidates;
    }

    public void setAmountCandidates(Integer amount_candidates){
        this.amount_candidates = amount_candidates;
    }

    public Integer getAmountVisualizations(){
        return this.amount_visualizations;
    }

    public void setAmountVisualizations(Integer amount_visualizations){
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

    public Integer getSalaryRequirements(){
        return this.salary_requirements;
    }

    public void setSalaryRequirements(Integer salary_requirements){
        this.salary_requirements = salary_requirements;
    }
}

