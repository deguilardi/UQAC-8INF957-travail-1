package ca.uqac.ecommerce;

import ca.uqac.ecommerce.party.*;

import java.util.HashMap;

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

    public void performTransaction(String sellerName, String buyerName, String spaceshipName, String productName){
        Planet seller = planets.get(sellerName);
        Planet buyer = planets.get(buyerName);
        Product product = products.get(productName);
        Spaceship spaceship = spaceships.get(spaceshipName);

        System.out.println("[CommercialSpace] performing transaction");
        System.out.println("    [transaction] "+String.format("%-" + 7 + "s", productName));
        System.out.println("                               /-------\\     \\\\----------------\\\\      /-------\\");
        StringBuilder sb = new StringBuilder()
                .append("                              | ")
                .append(seller.getPaddedName(7))
                .append(" |    ||>   ")
                .append(spaceship.getPaddedName(10))
                .append("   >>>   | ")
                .append(buyer.getPaddedName(7))
                .append(" |");
        System.out.println(sb);
        System.out.println("                               \\-------/     //----------------//      \\-------/");

        Transaction transaction = null;
        try {
            seller.dock(spaceship);
            spaceship.load(product, seller);
            seller.undock(spaceship);
            buyer.dock(spaceship);
            Integer unloaded = spaceship.unload(product, buyer);
            transaction = new Transaction(sellerName, buyerName, productName, unloaded);
            System.out.println("        [success]");
        }
        catch(TransactionException e){
            System.out.println("        [exception] " + e);
        }

        // Register transaction
        if(transaction != null) {
            seller.registerTransaction(transaction);
            buyer.registerTransaction(transaction);
            spaceship.registerTransaction(transaction);
        }
    }

    public void initialize(){
        // Init products
        products.put(GRAVEL, new Product(GRAVEL, 10, 1.0f, Product.Menacing.REGULAR));
        products.put(TIRES, new Product(TIRES, 3, 12.75f, Product.Menacing.REGULAR));
        products.put(ACID, new Product(ACID, 4, 7.5f, Product.Menacing.DANGEROUS));

        // Init spaceships
        // Cruise
        HashMap<String, Container> cruiseShipContainers = new HashMap<>();
        cruiseShipContainers.put(GRAVEL, new Container(products.get(GRAVEL), 10, 0));
        cruiseShipContainers.put(ACID, new Container(products.get(ACID), 10, 0));
        spaceships.put(CRUISE, new CruiseShip(CRUISE, cruiseShipContainers));
        // Millenial
        HashMap<String, Container> millenialShipContainers = new HashMap<>();
        millenialShipContainers.put(GRAVEL, new Container(products.get(GRAVEL), 10, 0));
        millenialShipContainers.put(TIRES, new Container(products.get(TIRES), 10, 0));
        spaceships.put(MILLENIAL, new MillenialShip(MILLENIAL, millenialShipContainers));
        // Ultra
        HashMap<String, Container> ultraShipContainers = new HashMap<>();
        ultraShipContainers.put(TIRES, new Container(products.get(TIRES), 10, 0));
        ultraShipContainers.put(ACID, new Container(products.get(ACID), 10, 0));
        spaceships.put(ULTRA, new UltraShip(ULTRA, ultraShipContainers));

        // Init planets
        // Venus
        HashMap<String, Container> venusConteiners = new HashMap<>();
        venusConteiners.put(GRAVEL, new Container(products.get(GRAVEL), 20, 10));
        venusConteiners.put(ACID, new Container(products.get(ACID), 20, 10));
        planets.put(VENUS, new Planet(VENUS, venusConteiners, 3));
        // Mars
        HashMap<String, Container> marsContainers = new HashMap<>();
        marsContainers.put(GRAVEL, new Container(products.get(GRAVEL), 20, 10));
        marsContainers.put(TIRES, new Container(products.get(TIRES), 20, 10));
        planets.put(MARS, new Planet(MARS, marsContainers, 3));
        // Neptune
        HashMap<String, Container> neptuneContainers = new HashMap<>();
        neptuneContainers.put(TIRES, new Container(products.get(TIRES), 20, 10));
        neptuneContainers.put(ACID, new Container(products.get(ACID), 20, 10));
        planets.put(NEPTUNE, new Planet(NEPTUNE, neptuneContainers, 3));

        // Report
        System.out.println("[CommercialSpace] initialization finished");
        reportAll();
    }

    private void reportSpaceships(){
        System.out.println("[CommercialSpace] Reporting spaceships");
        spaceships.forEach((index, spaceship) -> spaceship.report());
    }

    private void reportPlanets(){
        System.out.println("[CommercialSpace] Reporting planets");
        planets.forEach((index, planet) -> planet.report());
    }

    private void reportAll(){
        reportSpaceships();
        reportPlanets();
    }
}
