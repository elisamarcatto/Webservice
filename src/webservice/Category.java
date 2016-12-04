/* Classe que especifica o campo 'category' da classe 'Registration'
 */

package webservice;

class Category
{
    private Integer id;
    private String name;
    
    public void setId(Integer id){
        this.id = id;
    }
    
    public Integer getId(){
        return this.id;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getName(){
        return this.name;
    }
}
