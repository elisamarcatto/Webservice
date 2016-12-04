/* Classe que especifica o campo 'category' da classe 'Registration'
 */

package webservice;

class Category
{
    private String id;
    private String name;
    
    public void setId(String id){
        this.id = id;
    }
    
    public String getId(){
        return this.id;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getName(){
        return this.name;
    }
}
