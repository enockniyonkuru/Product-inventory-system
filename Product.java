
/**
* Product class representing individual product in the class
* @author Enock Niyonkuru
* @version 1.0 March 30,2021
**/

public class Product implements Comparable {
  // fields
  private String name;
  private int number;
  private String category;
  private boolean availability;

 // Default constructor
  public Product(){
  }
  /**
  * parameterized constructor
  * @param name a string holding the name of the product
  * @param number an integer holding the number of the product
  * @param category a string holding the category of the product
  * @param availability a boolean  holding the status of a product in a stock
  **/
  public Product(String name, int number, String category, boolean availability){
    this.name = name;
    this.number = number;
    this.category = category;
    this.availability = availability;
  }
  /**
  * get method for product name
  * @return name String the product's Name
  * Time Complexity: O(1)
  **/
 public String getName(){
   return name;
 }
 /**
 * get method for product number
 * @return number integer the product's number
 * Time Complexity: O(1)
 **/
 public int getNumber(){
   return number;
 }
 /**
 * get method for product category
 * @return category String the product's category
 * Time Complexity: O(1)
 **/
 public String getCategory(){
   return category;
 }
 /**
 * get method for product availability
 * @return availability boolean of the the product's status of availability
 * Time Complexity: O(1)
 **/
 public boolean getAvailability(){
   return availability;
 }
 /**
 * set method for product name
 * @param name String the product's Name
 * Time Complexity: O(1)
 **/

 public void setName(String name){
   this.name = name;
 }
 /**
 * set method for product number
 * @param number int the product's number
 * Time Complexity: O(1)
 **/
 public void setNumber(int number){
   this.number = number;
 }
 /**
 * set method for product category
 * @param category String the product's category
 * Time Complexity: O(1)
 **/
 public void setCategory(String category){
   this.category = category;
 }
 /**
 * set method for product availability
 * @param availability boolean of the  product's availablility
 * Time Complexity: O(1)
 **/
 public void setAvailability(boolean availability){
   this.availability = availability;
 }
 /**
 * comparable interface implementation
 * @param o Object to be compared with the product
 * @return int returning the difference if the numbers are equal it will return zero
 * Time Complexity: O(1)
 **/
 public int compareTo(Object o){
   Product newProduct = (Product)o;
   return this.getNumber()- newProduct.getNumber();
 }
 /**
 * toString method
 * @return string holding all information of the product created
 *Time Complexity: O(1)
 **/

 public String toString (){
   return "\n" +  "Product Name: " + this.getName() + "\n" + "Product Number: " +  this.getNumber() + "\n"+ "Product Category: " + this.getCategory() +  "\n" + "Product Availability: " + this.getAvailability() + "\n" ;

 }
}
