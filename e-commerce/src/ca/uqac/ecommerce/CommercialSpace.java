package ca.uqac.ecommerce;

import ca.uqac.ecommerce.party.*;

import java.lang.reflect.InvocationTargetException;
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

    public enum From{
        ORIGIN_TO_DESTINATION,
        DESTINATION_TO_ORIGIN
    }

    private final HashMap<String, Product> products = new HashMap<>();
    private final HashMap<String, Spaceship> spaceships = new HashMap<>();
    private final HashMap<String, Planet> planets = new HashMap<>();
    private Integer cycle = 0;

    public CommercialSpace(){
        // Init products
        // These are the products available in this commercial space
        products.put(GRAVEL, new Product(GRAVEL, Product.Menacing.REGULAR));
        products.put(TIRES, new Product(TIRES, Product.Menacing.REGULAR));
        products.put(PAPER, new Product(PAPER, Product.Menacing.REGULAR));
        products.put(ACID, new Product(ACID, Product.Menacing.DANGEROUS));
        products.put(GAS, new Product(GAS, Product.Menacing.DANGEROUS));
    }

    public void dispatchSpaceship(String spaceshipName, String[] productNames, From from) {
        Spaceship spaceship = spaceships.get(spaceshipName);
        Planet origin, destination;
        if(from.equals(From.ORIGIN_TO_DESTINATION)) {
            origin = spaceship.getRoute().getOrigin();
            destination = spaceship.getRoute().getDestination();
        }
        else{
            origin = spaceship.getRoute().getDestination();
            destination = spaceship.getRoute().getOrigin();
        }

        System.out.println("                . ");
        System.out.println("                . Dispatching spaceship");
        System.out.println("                . ");
        System.out.println("                .              /-------\\     \\\\----------------\\\\      /-------\\");
        StringBuilder sb = new StringBuilder()
                .append("                .             | ")
                .append(origin.getPaddedName(7))
                .append(" |    ||>   ")
                .append(spaceship.getPaddedName(10))
                .append("   >>>   | ")
                .append(destination.getPaddedName(7))
                .append(" |");
        System.out.println(sb);
        System.out.println("                .              \\-------/     //----------------//      \\-------/");
        System.out.println("                . ");

        if(!spaceship.canTrasaction()){
            System.out.println("                . Can't dispatch " + spaceshipName + " as it is not idle.");
            return;
        }

        Transaction.factory(spaceship, productNames, origin, destination);
    }

    public void cycle(){
        cycle++;
        System.out.println("");
        System.out.println("");
        System.out.println("[CommercialSpace] ============================== cycle "+cycle+" ==============================");
        spaceships.forEach((index, spaceship) -> spaceship.cycle());
    }

    public void report(){
        System.out.println("                .");
        System.out.println("                . report for cycle "+cycle);
        System.out.println("                .");
        System.out.println("                .");
        System.out.println("                .");
        spaceships.forEach((index, spaceship) -> spaceship.report());
        System.out.println("                .");
        System.out.println("                .");
        System.out.println("                .");
        planets.forEach((index, planet) -> planet.report());
    }

    public <T extends Spaceship> void factorySpaceship(String name, String className, String[] productNames, String originName, String destinationName){
        Class<T> clazz;
        try {
            clazz = (Class<T>)Class.forName("ca.uqac.ecommerce.party." + className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }

        HashMap<String, Container> containers = new HashMap<>();
        for (String productName : productNames) {
            containers.put(productName, new Container(products.get(productName)));
        }
        Spaceship.Route route = new Spaceship.Route(planets.get(originName), planets.get(destinationName));
        try {
            T spaceshipInstance = clazz.getDeclaredConstructor(String.class, HashMap.class, Spaceship.Route.class).newInstance(name, containers, route);
            spaceships.put(name, spaceshipInstance);
        }
        catch (InstantiationException ignore) {}
        catch (IllegalAccessException ignore) {}
        catch (NoSuchMethodException ignore) {}
        catch (InvocationTargetException ignore) {}
    }

    public void factoryPlanet(String name, Integer numOfPorts, String productNames[], Integer capacity, Integer load){
        HashMap<String, Container> containers = new HashMap<>();
        for (String productName : productNames) {
            containers.put(productName, new Container(products.get(productName), capacity, load));
        }
        planets.put(name, new Planet(name, containers, numOfPorts));
    }

    public Planet getPlanetWithName(String name){
        return planets.get(name);
    }

    public Spaceship getSpaceshipWithName(String name){
        return spaceships.get(name);
    }
}
