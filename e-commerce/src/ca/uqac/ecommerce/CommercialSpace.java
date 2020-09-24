package ca.uqac.ecommerce;

import ca.uqac.ecommerce.party.*;

import java.util.ArrayList;

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

    private final ArrayList<Spaceship> spaceships = new ArrayList<>();

    public void initialize(){
        // Set some products
        Product gravel = new Product("gravel", 10, 1.0f, Product.Menacing.REGULAR);
        Product tires = new Product("tires", 3, 12.75f, Product.Menacing.REGULAR);
        Product acid = new Product("acid", 4, 7.5f, Product.Menacing.DANGEROUS);

        // Init spaceships
        // Cruise
        ArrayList<Container> cruiseShipContainers = new ArrayList<>();
        cruiseShipContainers.add(new Container(gravel, 30, 30));
        spaceships.add(new CruiseShip("cruise", cruiseShipContainers));
        // Millenial
        ArrayList<Container> millenialShipContainers = new ArrayList<>();
        millenialShipContainers.add(new Container(tires, 20, 20));
        spaceships.add(new MillenialShip("millenial", millenialShipContainers));
        // Ultra
        ArrayList<Container> ultraShipContainers = new ArrayList<>();
        ultraShipContainers.add(new Container(tires, 20, 20));
        ultraShipContainers.add(new Container(acid, 10, 10));
        spaceships.add(new UltraShip("ultra", ultraShipContainers));

        // Report spaceships
        System.out.println("[Init] spaceships");
        reportSpaceships();

        // Init planets
    }

    private void reportSpaceships(){
        System.out.println("[CommercialSpace] Reporting spaceships");
        spaceships.forEach(Party::report);
    }
}
