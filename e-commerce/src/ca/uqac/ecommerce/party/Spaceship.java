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

    private Route route;
    private Boolean docked = false;

    public static class Route{
        private Planet origin;
        private Planet destination;

        public Route(Planet origin, Planet destination){
            this.origin = origin;
            this.destination = destination;
        }

        public Planet getOrigin() {
            return origin;
        }

        public Planet getDestination() {
            return destination;
        }
    }

    public Spaceship(String name, HashMap<String, Container> containers, Route route) {
        super(name, containers);
        this.route = route;
    }

    public Boolean isDocked() {
        return docked;
    }

    public void setDocked(Boolean docked) {
        this.docked = docked;
    }

    public Route getRoute() {
        return route;
    }
}
