/* Classe que especifica o campo 'hirer' da classe 'Registration'
 */

package webservice;

class Hirer
{
    private Integer id;
    private String name;
    private String account_type;
    private String cnpj;
    private String company_contact_name;
    private String phone;
    private String email;
    private String mobile_phone;
    private boolean is_plan_active;

    public Integer getId(){
        return this.id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getAccountType(){
        return this.account_type;
    }

    public void setAccountType(String account_type){
        this.account_type = account_type;
    }

    public String getCnpj(){
        return this.cnpj;
    }

    public void setCnpj(String cnpj){
        this.cnpj = cnpj;
    }

    public String getCompanyContactName(){
        return this.company_contact_name;
    }

    public void setCompanyContactName(String company_contact_name){
        this.company_contact_name = company_contact_name;
    }

    public String getPhone(){
        return this.phone;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }

    public String getEmail(){
        return this.email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getMobilePhone(){
        return this.mobile_phone;
    }

    public void setMobilePhone(String mobile_phone){
        this.mobile_phone = mobile_phone;
    }

    public boolean getIs_plan_active(){
        return this.is_plan_active;
    }

    public void setIsPlanActive(boolean is_plan_active){
        this.is_plan_active = is_plan_active;
    }   
}
