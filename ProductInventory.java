
/**
* ProductInventory class collects and displays the information about inventory of procuts in STOCK
* @author Enock Niyonkuru
* @version 1.0 March 30,2021
**/

import java.util.Iterator;
import java.util.*;

public class ProductInventory{
  //fields
private String companyName;   //companyName string stores the name of the company
PositionalList<Product> list;  // initializing a positionlist of Product type
Deque<Product> recent;        // initializing a Deque

//default constructor
public ProductInventory(){
}
/**
* parameterized constructor
* @param companyName a string holding the name of the company
*
**/
public ProductInventory(String companyName ){
  this.companyName = companyName;
  list = new LinkedPositionalList<>();
  recent = new DoublyLinkedList <>();
}
/**
* get method for company name
* @return String the company's Name
* Time Complexity: O(1)
**/
public String getCompanyName(){
  return companyName;
}

/**
* set method for company name
* @param companyName String which holds the company's Name
* Time Complexity: O(1)
**/
public void setCompanyName(String companyName){
  this.companyName = companyName;
}
/**
* get method for Position list which holds the products in the stock
* @return list a PositionalList holding the products in the stock
* Time Complexity: O(1)
**/

public PositionalList<Product> getPositionalList(){
  return list;
}


/**
* insert a product product1 in the PositionalList
* @param e is a new product to be inserted in the STOCK
* @throws IllegalStateException when the product to be inserted already exists in the STOCK
* Time Complexity: O(n)
**/

public void insert(Product e) throws IllegalStateException{
  Position <Product> p = list.first();
 Iterator<Product> it = list.iterator();  //implimenting an iterator object
 while ((it.hasNext()) && (e.compareTo(it.next()) == 0)){ // checking whether the product to be inserted already exist

 }
  if(list.isEmpty()) {  //check whether the stock is empty
     list.addFirst(e);  // add the incoming product on the first position of the list
     System.out.println(" ");
     System.out.println("The product has been successfully inserted ! ");
  }else if(e.getNumber() == p.getElement().getNumber()){
    System.out.println(" ");
    System.out.println("This Product already existed ");
    return;
  }
  else {
   //initializing a new position in the list
    while(p != null){
    if(e.getNumber() < p.getElement().getNumber()){ //checking whether the incoming product is less than the element next to it
      list.addBefore(p, e); // add the product to the list according to ascending order according to their numbers
      return;
    }
    p = list.after(p);
  }
   list.addLast(e);
   System.out.println("The product has been successfully inserted ! ");
  }



}
/**
* private helper method to be return whether the product of certain number exists in the stock or not
* @param int e is a new product's number to be checked whether it exist or not
* @return boolean as a decision whether the product exist or not in the stock
* Time Complexity: O(n)
**/

private boolean exist(int e){
  boolean exists = false;
  Iterator<Product> it = list.iterator();
  while(it.hasNext()) {
    if(it.next().getNumber() == e){
      exists = true;
     }
    }
  return exists;
  }

/**
* remove a product by using product number
* @param int e is a new product's number to be removed from the stock
* @throws IllegalStateException when the product to be removed does not exists in the STOCK and if the stock is empty
* Time Complexity: O(n)
**/

public void remove(int e) throws IllegalStateException {
  Position <Product> p = list.first();  //initializing a new position of Product in list
  if (p == null){throw new IllegalStateException("nothing to remove");} // throw error when the stock is empty
  else if(this.exist(e) == false){
    System.out.println(" ");
    System.out.println("This Product does not exist in the Stock ");
   }
  while(p != null ){
    if (p.getElement().getNumber() == e){
       list.remove(p);
       System.out.println(" ");
       System.out.println("The product has been successfully removed ! ");
       break;
    }
    p = list.after(p);
  }

}

 /**
 * Display all the products by their product numbers
 * Time Complexity: O(n)
 **/

public void display (){
  System.out.println(" ");
  System.out.println(" TOTAL PRODUCTS: ");
  Iterator<Product> it = list.iterator(); //implimenting an iterator object
  while(it.hasNext()) { // while loop to display all the elements in the stock
    System.out.print(it.next());
  }

}

/**
* Display the available products, total number of available products, and total number of products
* Time Complexity: O(n)
*/

public void displayAvailable (){
  int count = 0;
  Iterator<Product> it = list.iterator(); //implimenting an iterator object
  System.out.println(" ");
System.out.println(" TOTAL AVAILABLE PRODUCTS IN STOCK: ");
  while(it.hasNext()) {
    Product a = it.next();
    if(a.getAvailability()== true){ // check all the products in the stock which are available
      System.out.print(a);
      count ++; //counter for the available products in the
    }

  }

  System.out.println(" ");
  System.out.println ("Total available products are :" + count); //print the total number of products available in the stock
  System.out.println ("Total number of products are : " + list.size()); // print the total products in the stock

}

/**
* find method to find whether a product is in the stock
* @param int e is a new product's number to be found from the stock
* @return product a, is the details of the product with number e
* @throws IllegalStateException when the product to be removed does not exists in the STOCK and if the stock is empty
* Time Complexity: O(n)
*/

public Product find(int e)throws IllegalStateException {

  Position <Product> p = list.first();
  if (p == null){throw new IllegalStateException("The stock is empty");} // throws an error when the stock is empty
  else if(this.exist(e) == false){
    throw new IllegalStateException("The product does not exist"); // throws an error when the producuct to be found does not exist in the stock
}

  Iterator<Product> it = list.iterator(); //implimenting an iterator object
  Product a = null;   // set the product a to null
  while(it.hasNext()) {
    a = it.next();
    if(a.getNumber() == e) {
      if(recent.size() <5 ){  //if the stock has less than 5 products, it will add the product found on the first position of a deque recent
        recent.addFirst(a);

      } else {      // if the stock has more than 5 products, it will remove the last element, and stores the current searched on the first postion of a deque
        recent.removeLast();
        recent.addFirst(a);

      }

        break;
       }

     }
       System.out.println(" PRODUCT FOUND : ");
  return a;

}
 /**
 * List top 5 recently searched product
 * Time Complexity: O(1)
 **/

 public void topSearched(){
     System.out.println(" TOP 5 RESCENT SEARCHED: ");
     System.out.println(recent);
 }


 /**
 * Main method to test ProductInventory class
 **/
public static void main(String args[]) {
  System.out.println("Welcome to the Inventory");
try{
  ProductInventory productInventory1 = new ProductInventory("Trinity College");
  Product product1 = new Product ("Table",10,"Classroom",true);
  productInventory1.insert(product1);
  System.out.println(productInventory1.getPositionalList());
  Product product2 = new Product ("Table",30,"Classroom",true);
  productInventory1.insert(product2);
  System.out.println(productInventory1.getPositionalList());
  Product product3 = new Product ("Table",1,"Classroom",true);
  productInventory1.insert(product3);
  System.out.println(productInventory1.getPositionalList());
  Product product4 = new Product ("Banana",20,"Fruit",true);
  productInventory1.insert(product4);
  Product product5 = new Product ("Potato",50,"Energy",true);
  productInventory1.insert(product5);
  productInventory1.display();
  Product product6 = new Product ("Beans",70,"Energy",false);
  productInventory1.insert(product6);
  productInventory1.displayAvailable();
  productInventory1.remove(10);
  productInventory1.display();
  System.out.println(productInventory1.find(20));
  productInventory1.topSearched();
  System.out.println(productInventory1.find(1));
  productInventory1.topSearched();
  System.out.println(productInventory1.find(50));
  productInventory1.topSearched();
  System.out.println(productInventory1.find(70));
  System.out.println(productInventory1.find(1));
  System.out.println(productInventory1.find(30));
  System.out.println(productInventory1.find(50));
  productInventory1.topSearched();
  Product product7 = new Product ("Mango",1,"Energy",true);
  productInventory1.insert(product7);
  productInventory1.display();
  productInventory1.remove(90);
  productInventory1.displayAvailable();
}catch(IllegalStateException e){
  System.out.println("Invalid Input, try again !");

}
  }

}

/**
* Main method to test ProductInventory class Extra Credit Part
**/

// public static void main(String args[]) {
//
//   System.out.println("WELCOME TO THE INVENTORY SYSTEM ");
//   System.out.println("");
//   Scanner sc= new Scanner(System.in);
//
//   System.out.print("Enter the name of the company : ");
//   String campanyName = sc.nextLine();
//   ProductInventory productInventory1 = new ProductInventory(campanyName); // creating a new object of ProductInventory

// try{
//   while(true){
//     System.out.println("");
//     System.out.println("");
//     System.out.println("CHOOSE THE OPERATION YOU WANT TO PERFORM: ");
//     System.out.println(" 1: Inserting a new product ");
//     System.out.println(" 2: Removing a product ");
//     System.out.println(" 3: Display  all products ");
//     System.out.println(" 4: Display all available products ");
//     System.out.println(" 5: Find a product ");
//     System.out.println(" 6: List 5 recent top searched products ");
//     System.out.println(" 7: Quit ");
//
//     int choice = sc.nextInt();
//
//     if (choice <= 7 ){
//       if (choice == 1){ // when the user selects to insert a product, and inserts details of the products
//            Scanner py = new Scanner(System.in);
//             System.out.println ("Enter the details of the product you want to insert ");
//             System.out.println("");
//             System.out.print("Enter the product's Name: ");
//             String name = py.nextLine();
//             System.out.println("");
//             System.out.print("Enter the product's Number: ");
//             int number = sc.nextInt();
//             System.out.println("");
//             System.out.print("Enter the product's Category: ");
//             String category = py.nextLine();
//             System.out.println("");
//             System.out.print("Enter the product's Availability (True/False): ");
//             boolean availability = sc.nextBoolean();
//             Product product1 = new Product (name, number, category, availability);
//             productInventory1.insert(product1);
//
//             System.out.println("");
//           }
//
//       else if (choice == 2){ // when the user selects to remove a product by its number
//             System.out.print("Enter the number of a product you want to remove:");
//             int numberToBeRemoved = sc.nextInt();
//             productInventory1.remove(numberToBeRemoved);
//             System.out.println("");
//
//       }
//       else if (choice == 3){ // when the user selects to display all products
//           System.out.println("LIST OF ALL PRODUCTS ");
//           productInventory1.display();
//       }
//       else if (choice == 4){ //when the user selects to display all available products
//           System.out.println("LIST OF ALL AVAILABLE PRODUCTS IN THE STOCK ");
//           productInventory1.displayAvailable();
//       }
//       else if (choice == 5){ //when the user selects to find a product by number
//         System.out.print("Enter the number of a product you want to find:");
//         int numberToBeFound = sc.nextInt();
//         System.out.println(productInventory1.find(numberToBeFound));
//       }
//       else if (choice == 6){ //when the user selects to find top 5 recent searched products
//         System.out.println("LIST OF 5 TOP RECENT SEARCHED PRODUCTS ");
//         productInventory1.topSearched();
//       }
//
//       else if (choice == 7){ //when the user selects to quit the program
//         break;
//       }
//     }
//   else { System.out.println("Invalid input, Number selected out of range. Try again! ");} // throw this error when a use selects a number which is above 7
//
//     }
//   }
//   catch (InputMismatchException e) {
//               System.out.println("Invalid input, Please try again "); //throw this error when the user inserts unexpected choice
//           }
//
//   }
// }
