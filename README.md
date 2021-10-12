# Product-inventory-system


 **In this project, you will design and implement a simple product inventory system. This  program will allow to manage products by providing the following operations:**

- insert(): Add a new product. Products should be identified by unique product numbers. There should not be two products with the same product number. 
- remove(): Remove a product by using its product number.
- display(): List all products by their product number.  Maintains the list of products ordered by their product numbers.
- displayAvailable(): List all available (in stock) products along with the total number of products and the total number of available products.
- find(): Look up a product by its product number. 
- topSearched(): List top 5 recently searched products (not product numbers).

The program allow a user to continuously perform the above operations (by specifying the operation they want to perform, for example, 1 to add a product, 2 to remove a product, etc.) until the user specifically requests to end the program (for example, by entering ’quit’ or ’q’).



## Class called Product represents an individual product. 

It includes: 

- Appropriate instance variables to keep track of the product’s name, number, category, and availability as well as other instance variables (if needed) to support operations described in Part 1. 
- Define default and parametrized constructors. 
- Include appropriate methods, setters and getters to support operations described in Part 1. 
- Implement the Comparable interface so products can be compared using their product number. 
- Provide toString() method to properly display a product by listing its product number, name, and category. 
- Declare all helper methods as private. 
- Include Javadoc and in-line comments.


## Class called ProductInventory to represent a collection of individual products. 

It includes: 

- The use the PositionalList ADT. 
- Appropriate instance variables to support operations described in Part 1. 
- Include a variable to store the name of the company using your inventory system. 
- Define default and parametrized cProonstructors. 
- Include appropriate methods to provide operations described in Part 1. 
- Include a main() method to test your program. This method should include your text-based menu that accepts input from the user. 
- Handle error conditions, both for your program and the text-based menu.
- Make use of an Iterator to traverse your collection of products.
- Provide toString() method to display all products. 
- Declare all helper methods as private.


