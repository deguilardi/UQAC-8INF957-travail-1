package ca.uqac.ecommerce;

import ca.uqac.ecommerce.party.*;
import sun.jvm.hotspot.memory.Space;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.function.Supplier;

import static ca.uqac.ecommerce.party.PartyConstants.*;

/**
 * - There are several planets (at least 5 in our example);
 * - Each cycle, new ships may appear to perform eCommerce;
 * - The cycle is the unit of measurement (a loop revolution in your project?);
 * - Here is an idea of the project's algorithm (suggestion only)
 * Loading and initialization of planets and containers Reading the number of cycles
 * FOR each cycle
 *     Display reports (optional: to help you)
 *     Arrival/departure of containers
 *     Move the ships
 *     Unload the containers
 *     Load the ships
 *     (Pause here if necessary)
 * View reports
 */
public class CommercialSpace {

    private final HashMap<String, Product> products = new HashMap<>();
    private final HashMap<String, Spaceship> spaceships = new HashMap<>();
    private final HashMap<String, Planet> planets = new HashMap<>();
    private Integer cycle = 0;

    public CommercialSpace(){
        // Init products
        // These are the products available in this commercial space
        products.put(GRAVEL, new Product(GRAVEL, 10, 1.0f, Product.Menacing.REGULAR));
        products.put(TIRES, new Product(TIRES, 3, 12.75f, Product.Menacing.REGULAR));
        products.put(PAPER, new Product(PAPER, 7, 4.9f, Product.Menacing.REGULAR));
        products.put(ACID, new Product(ACID, 4, 13.9f, Product.Menacing.DANGEROUS));
        products.put(GAS, new Product(GAS, 1, 7.5f, Product.Menacing.DANGEROUS));
    }

    public void performTransaction(String sellerName, String buyerName, String spaceshipName, String productName){
        Planet seller = planets.get(sellerName);
        Planet buyer = planets.get(buyerName);
        Product product = products.get(productName);
        Spaceship spaceship = spaceships.get(spaceshipName);

        System.out.println("                . ");
        System.out.println("                . performing transaction. selling "+productName);
        System.out.println("                . ");
        System.out.println("                .              /-------\\     \\\\----------------\\\\      /-------\\");
        StringBuilder sb = new StringBuilder()
                .append("                .             | ")
                .append(seller.getPaddedName(7))
                .append(" |    ||>   ")
                .append(spaceship.getPaddedName(10))
                .append("   >>>   | ")
                .append(buyer.getPaddedName(7))
                .append(" |");
        System.out.println(sb);
        System.out.println("                .              \\-------/     //----------------//      \\-------/");
        System.out.println("                . ");

        Transaction transaction = null;
        try {
            seller.dock(spaceship);
            spaceship.load(product, seller);
            seller.undock(spaceship);
            buyer.dock(spaceship);
            Integer unloaded = spaceship.unload(product, buyer);
            transaction = new Transaction(sellerName, buyerName, productName, unloaded);
            System.out.println("                . Success!");
        }
        catch(TransactionException e){
            System.out.println("                . Exception: " + e);
        }
        System.out.println("                .");

        // Register transaction
        if(transaction != null) {
            seller.registerTransaction(transaction);
            buyer.registerTransaction(transaction);
            spaceship.registerTransaction(transaction);
        }
    }

    public void initNewCycle(){
        cycle++;
        System.out.println("");
        System.out.println("");
        System.out.println("[CommercialSpace] ========================= initializing cycle "+cycle+" =========================");
        planets.forEach((index, planet) -> planet.undockAllAndMoveLine());
    }

    public void report(){
        System.out.println("                .");
        System.out.println("                . report for cycle "+cycle);
        System.out.println("                .");
        System.out.println("                . |-----------------------------------------------|");
        System.out.println("                . |                  SPACESHIPS                   |");
        System.out.println("                . |-----------------------------------------------|");
        System.out.println("                . |  spaceship  |  product  | capacity |   load   |");
        System.out.println("                . |-----------------------------------------------|");
        spaceships.forEach((index, spaceship) -> spaceship.report());
        System.out.println("                . |-----------------------------------------------|");
        System.out.println("                .");
        System.out.println("                . |-----------------------------------------------|");
        System.out.println("                . |                    PLANETS                    |");
        System.out.println("                . |-----------------------------------------------|");
        System.out.println("                . |   planet    |  product  | capacity |   load   |");
        System.out.println("                . |-----------------------------------------------|");
        planets.forEach((index, planet) -> planet.report());
        System.out.println("                . |-----------------------------------------------|");
    }

    public <T extends Spaceship> void factorySpaceship(String name, Class<T> clazz, String[] productNames, Integer defCapacity, Integer defLoad){
        HashMap<String, Container> containers = new HashMap<>();
        for (String productName : productNames) {
            containers.put(productName, new Container(products.get(productName), defCapacity, defLoad));
        }
        try {
            T spaceshipInstance = clazz.getDeclaredConstructor(String.class, HashMap.class).newInstance(name, containers);
            spaceships.put(name, spaceshipInstance);
        }
        catch (InstantiationException ignore) {}
        catch (IllegalAccessException ignore) {}
        catch (NoSuchMethodException ignore) {}
        catch (InvocationTargetException ignore) {}
    }

    public void factoryPlanet(String name, Integer numOfPorts, String productNames[], Integer defCapacity, Integer defLoad){
        HashMap<String, Container> containers = new HashMap<>();
        for (String productName : productNames) {
            containers.put(productName, new Container(products.get(productName), defCapacity, defLoad));
        }
        planets.put(name, new Planet(name, containers, numOfPorts));
    }
}
