package ca.uqac.ecommerce;

import ca.uqac.ecommerce.party.*;

import java.util.ArrayList;
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

    public void initialize(){
        // Init products
        products.put(GRAVEL, new Product(GRAVEL, 10, 1.0f, Product.Menacing.REGULAR));
        products.put(TIRES, new Product(TIRES, 3, 12.75f, Product.Menacing.REGULAR));
        products.put(ACID, new Product(ACID, 4, 7.5f, Product.Menacing.DANGEROUS));

        // Init spaceships
        // Cruise
        ArrayList<Container> cruiseShipContainers = new ArrayList<>();
        cruiseShipContainers.add(new Container(products.get(GRAVEL), 10, 0));
        cruiseShipContainers.add(new Container(products.get(ACID), 10, 0));
        spaceships.put(CRUISE, new CruiseShip(CRUISE, cruiseShipContainers));
        // Millenial
        ArrayList<Container> millenialShipContainers = new ArrayList<>();
        millenialShipContainers.add(new Container(products.get(GRAVEL), 10, 0));
        millenialShipContainers.add(new Container(products.get(TIRES), 10, 0));
        spaceships.put(MILLENIAL, new MillenialShip(MILLENIAL, millenialShipContainers));
        // Ultra
        ArrayList<Container> ultraShipContainers = new ArrayList<>();
        ultraShipContainers.add(new Container(products.get(TIRES), 10, 0));
        ultraShipContainers.add(new Container(products.get(ACID), 10, 0));
        spaceships.put(ULTRA, new UltraShip(ULTRA, ultraShipContainers));

        // Init planets
        // Venus
        ArrayList<Container> venusConteiners = new ArrayList<>();
        venusConteiners.add(new Container(products.get(GRAVEL), 20, 10));
        venusConteiners.add(new Container(products.get(ACID), 20, 10));
        planets.put(VENUS, new Planet(VENUS, venusConteiners, 3));
        // Mars
        ArrayList<Container> marsContainers = new ArrayList<>();
        marsContainers.add(new Container(products.get(GRAVEL), 20, 10));
        marsContainers.add(new Container(products.get(TIRES), 20, 10));
        planets.put(MARS, new Planet(MARS, marsContainers, 3));
        // Neptune
        ArrayList<Container> neptuneContainers = new ArrayList<>();
        neptuneContainers.add(new Container(products.get(TIRES), 20, 10));
        neptuneContainers.add(new Container(products.get(ACID), 20, 10));
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
