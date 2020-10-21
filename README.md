# Work: Block A - Foundations

8INF957: Advanced object programming

Original french instructions file can be found [here](https://raw.githubusercontent.com/deguilardi/uqac-8INF957-travail-1/master/assets/travail_bloc_A_eCOMMERCE_a2020.pdf).

## Instructions

* Teamwork of 1 or 2
* Submission date: week 6 (October 6)
* Language: Java
* Send on MS Teams
  * A single project, compiled and functional
  * The class diagram of your solution

## eCommerce - Spacial Commerce

In 2500, commerce in space is essential between the planets of the Federation.
Ships travel from planet to planet in an endless cycle.
At each port, various products are loaded and unloaded at the next port.

### A Spaceship

* There are several types (to simplify our example, let's say 3);
* Each ship can carry certain products determined during its creation and has a certain load capacity (For example, shipA can carry 30T of product1, 20T of product2 and 10T of product3). **Ships can't change their products type.**;
* There are two main categories of products (dangerous and regular);
* Each spaceship has its particular route which is set dynamically during its creation and does not change;
* A ship can load products and unload products;
* It can be asked to provide a “transport report” that displays all transactions made;
* A ship trades a certain number of cycles. Subsequently, it quits eCommerce (but will still be included in the balance sheet report);
* You can make additions as needed.

### A planet

* Each planet has different resources (products) varying in quantity/limit defined when loading at **commercial space**;
* A planet sells products that are loaded into ships;
* A planet buys products that are unloaded from ships;
* It can be requested to provide a “transaction report” that displays all transactions made;
* The planets are not related to each other;
* Each planet has between one and three ports and can only accommodate one ship per port (and one in
waiting. To see further);
* Additions can be made as needed.

### Commercial space

* There are several planets (at least 5 in our example);
* Each cycle, new ships may appear to perform eCommerce;
* The cycle is the unit of measurement (a loop revolution in your project?);
* Here is an idea of ​​the project's algorithm (suggestion only)
```
Loading and initialization of planets and containers Reading the number of cycles
FOR each cycle
    Display reports (optional: to help you)
    Arrival/departure of containers
    Move the ships
    Unload the containers
    Load the ships
    (Pause here if necessary)
View reports
```

### Here are some rules to follow

1. A ship / planet cannot load more products than its capacity.
2. We always try to have the greatest quantity of products loaded, unloaded during a transaction
3. Complete transactions with one countainer before moving on to the next one
4. Complete transactions on one planet before moving on to the next
5. If the maximum port capacity of a planet is reached, the ships must remain "on hold" for a place and will be able to access the port in a subsequent cycle
6. A port can accommodate a single countainer and a second can be placed on hold. If the carrying capacity of a planet is exceeded, the ship must abruptly leave commercial space (handled in this case as a commercial exception).
* The duration of operations (there is no partial cycle)
  * Dangerous products
    * Load 20T (1 cycle)
    * Discharge 10T (1 cycle)
  * Regular products
    * Charge 50T (1 cycle)
    * Discharge 25T (1 cycle)
  * Spacing between planets (1 cycle)

### Constraints

* Use of objects (concept);
* Apply the GRASP model (each class has its own responsibility);
* Integrate commercial accident management;
* turn-based management, no graphical interface, only in console but you can use a file if that's easier for you.

### Notes

* The objective of this project is to validate the student's ability to put into practice the concepts of abstraction, cutting objects, management of personalized exeptions but above all your competence to create a safe, reliable and easy to understandable model;
* Provide the class diagram (png / jpg) as well as a functional project;
* Do not hesitate to add proof of operation of your project (screenshots or files), just in case I (prof. Eric) am not able to run it.


## Working examples

![Working example 1](https://raw.githubusercontent.com/deguilardi/uqac-8INF957-travail-2/main/assets/proof it works 1.png)
![Working example 1](https://raw.githubusercontent.com/deguilardi/uqac-8INF957-travail-2/main/assets/proof it works 2.png)