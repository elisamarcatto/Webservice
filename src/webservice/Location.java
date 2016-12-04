/* Classe que especifica o campo 'location' da classe 'Registration'
 */

package webservice;

class Location
{
   private String neighborhood;
   private String address;
   private String address_type;
   private String latitude;
   private String longitude;
   private String city_id;
   private String city;
   private String zipcode;
   private String state;

    public String getNeighborhood(){
        return this.neighborhood;
    }

    public void setNeighborhood(String neighborhood){
        this.neighborhood = neighborhood;
    }

    public String getAddress(){
        return this.address;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public String getAddressType(){
        return this.address_type;
    }

    public void setAddressType(String address_type){
        this.address_type = address_type;
    }

    public String getLatitude(){
        return this.latitude;
    }

    public void setLatitude(String latitude){
        this.latitude = latitude;
    }

    public String getLongitude(){
        return this.longitude;
    }

    public void setLongitude(String longitude){
        this.longitude = longitude;
    }

    public String getCity_id(){
        return this.city_id;
    }

    public void setCityId(String city_id){
        this.city_id = city_id;
    }

    public String getCity(){
        return this.city;
    }

    public void setCity(String city){
        this.city = city;
    }

    public String getZipcode(){
        return this.zipcode;
    }

    public void setZipcode(String zipcode){
        this.zipcode = zipcode;
    }

    public String getState(){
        return this.state;
    }

    public void setState(String state){
        this.state = state;
    }
}
