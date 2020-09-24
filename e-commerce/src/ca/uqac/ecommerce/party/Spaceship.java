package ca.uqac.ecommerce.party;

import java.util.HashMap;

/**
 * - There are several types (to simplify our example, let's say 3);
 * - Each ship can carry certain products determined during its creation
 *   and has a certain load capacity (For example, shipA can carry 30T of
 *   product1, 20T of product2 and 10T of product3). Ships can't change
 *   their products type.;
 * - There are two main categories of products (dangerous and regular);
 * - Each spaceship has its particular route which is set dynamically
 *   during its creation and does not change;
 * - A ship can load products and unload products;
 * - It can be asked to provide a “transport report” that displays all
 *   transactions made;
 * - A ship trades a certain number of cycles. Subsequently, it quits
 *   eCommerce (but will still be included in the balance sheet report);
 * - You can make additions as needed.
 */
public class Spaceship extends Party {

    private Integer totalCapacity;
    private Integer currentLoad;
    private Route route;

    public class Route{
        private Planet origin;
        private Planet destination;

        public Planet getOrigin() {
            return origin;
        }

        public void setOrigin(Planet origin) {
            this.origin = origin;
        }

        public Planet getDestination() {
            return destination;
        }

        public void setDestination(Planet destination) {
            this.destination = destination;
        }
    }

    public Spaceship(String name, HashMap<String, Container> containers) {
        super(name, containers);
    }

    private Integer calculateTotalCapacity(){
        // @TODO
        return totalCapacity;
    }

    private Integer calculateCurrentLoadCapacity(){
        // @TODO
        return currentLoad;
    }

    public Integer getTotalCapacity() {
        return totalCapacity;
    }

    public void setTotalCapacity(Integer totalCapacity) {
        this.totalCapacity = totalCapacity;
    }

    public Integer getCurrentLoad() {
        return currentLoad;
    }

    public void setCurrentLoad(Integer currentLoad) {
        this.currentLoad = currentLoad;
    }

    public void setRoute(Route route) {
        this.route = route;
    }
}
