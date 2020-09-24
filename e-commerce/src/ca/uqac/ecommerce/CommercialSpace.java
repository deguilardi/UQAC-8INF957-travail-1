package ca.uqac.ecommerce;

import ca.uqac.ecommerce.party.*;

import java.util.ArrayList;
import java.util.HashMap;

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
        products.put("gravel", new Product("gravel", 10, 1.0f, Product.Menacing.REGULAR));
        products.put("tires", new Product("tires", 3, 12.75f, Product.Menacing.REGULAR));
        products.put("acid", new Product("acid", 4, 7.5f, Product.Menacing.DANGEROUS));

        // Init spaceships
        // Cruise
        ArrayList<Container> cruiseShipContainers = new ArrayList<>();
        cruiseShipContainers.add(new Container(products.get("gravel"), 10, 0));
        cruiseShipContainers.add(new Container(products.get("acid"), 10, 0));
        spaceships.put("cruise", new CruiseShip("cruise", cruiseShipContainers));
        // Millenial
        ArrayList<Container> millenialShipContainers = new ArrayList<>();
        millenialShipContainers.add(new Container(products.get("gravel"), 10, 0));
        millenialShipContainers.add(new Container(products.get("tires"), 10, 0));
        spaceships.put("millenial", new MillenialShip("millenial", millenialShipContainers));
        // Ultra
        ArrayList<Container> ultraShipContainers = new ArrayList<>();
        ultraShipContainers.add(new Container(products.get("tires"), 10, 0));
        ultraShipContainers.add(new Container(products.get("acid"), 10, 0));
        spaceships.put("ultra", new UltraShip("ultra", ultraShipContainers));

        // Init planets
        // Venus
        ArrayList<Container> venusConteiners = new ArrayList<>();
        venusConteiners.add(new Container(products.get("gravel"), 20, 10));
        venusConteiners.add(new Container(products.get("acid"), 20, 10));
        planets.put("venus", new Planet("venus", venusConteiners, 3));
        // Mars
        ArrayList<Container> marsContainers = new ArrayList<>();
        marsContainers.add(new Container(products.get("gravel"), 20, 10));
        marsContainers.add(new Container(products.get("tires"), 20, 10));
        planets.put("mars", new Planet("mars", marsContainers, 3));
        // Neptune
        ArrayList<Container> neptuneContainers = new ArrayList<>();
        neptuneContainers.add(new Container(products.get("tires"), 20, 10));
        neptuneContainers.add(new Container(products.get("acid"), 20, 10));
        planets.put("neptune", new Planet("neptune", neptuneContainers, 3));

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
