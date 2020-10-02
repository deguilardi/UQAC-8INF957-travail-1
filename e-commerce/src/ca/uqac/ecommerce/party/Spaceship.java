package ca.uqac.ecommerce.party;

import java.util.HashMap;

import static ca.uqac.ecommerce.party.Transaction.State.*;

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
    private Transaction currentTransaction;

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

    public void cycle(){
        if(currentTransaction == null){
            System.out.println("[Spaceship] " + getName() + " is idle.");
            return;
        }
        switch (currentTransaction.getState()){
            case STARTING:
                System.out.println("[Spaceship] " + getName() + " is traveling to " + currentTransaction.getOrigin().getName());
                currentTransaction.setState(TRAV_ORIG);
                break;
            case TRAV_ORIG:
                System.out.println("[Spaceship] " + getName() + " is docking and loading from " + currentTransaction.getOrigin().getName() + ".");
                currentTransaction.setState(LOADING);
                try {
                    currentTransaction.getOrigin().dock(this);
                    load(currentTransaction.getOrigin(), currentTransaction.getProductNames());
                    currentTransaction.getOrigin().undock(this);
                } catch (TransactionException e) {
                    System.out.println("                . Exception: " + e);
                    currentTransaction.setState(ERR_LOAD);
                    currentTransaction = null;
                }
                break;
            case LOADING:
                System.out.println("[Spaceship] " + getName() + " is traveling to " + currentTransaction.getDestination().getName() + ".");
                currentTransaction.setState(TRAV_DEST);
                break;
            case TRAV_DEST:
                System.out.println("[Spaceship] " + getName() + " is docking and unloading 1st half in " + currentTransaction.getDestination().getName() + ".");
                currentTransaction.setState(UNL_HALF);
                try {
                    currentTransaction.getDestination().dock(this);
                    currentTransaction.getDestination().load(this, currentTransaction.getProductNames());
                } catch (TransactionException e) {
                    System.out.println("                . Exception: " + e);
                    currentTransaction.setState(ERR_UNLOAD);
                    currentTransaction = null;
                }
                break;
            case UNL_HALF:
                System.out.println("[Spaceship] " + getName() + " is unloading 2nd half in " + currentTransaction.getDestination().getName() + ".");
                currentTransaction.getDestination().load(this, currentTransaction.getProductNames());
                currentTransaction.setState(COMPLETED);
                currentTransaction = null;
                break;
        }
    }

    public Boolean canTrasaction(){
        return currentTransaction == null;
    }

    @Override
    public void registerTransaction(Transaction transaction) {
        super.registerTransaction(transaction);
        currentTransaction = transaction;
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
