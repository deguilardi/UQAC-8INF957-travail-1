package ca.uqac.ecommerce.party;

import java.util.HashMap;

public class Transaction {

    private Spaceship spaceship;
    private String[] productNames;
    private Planet origin;
    private Planet destination;
    private HashMap<String, Integer> quantities = new HashMap<>();
    private State state = State.STARTING;

    public enum State{
        STARTING,
        TRAV_ORIG,
        LOADING,
        TRAV_DEST,
        UNL_HALF,
        COMPLETED,
        ERR_LOAD,
        ERR_UNLOAD
    }

    private Transaction(){}

    public static Transaction factory(Spaceship spaceship, String[] productNames, Planet origin, Planet destination) {
        Transaction instance = new Transaction();
        instance.spaceship = spaceship;
        instance.productNames = productNames;
        instance.origin = origin;
        instance.destination = destination;
        for(String productName : productNames) {
            Container container = spaceship.getContainers().get(productName);
            if(container != null) {
                instance.quantities.put(productName, container.getLoadUnloadMaxCapacity());
            }
            else{
                System.out.println("ERROR. " + spaceship.getName() + " doesn't have a proper container for " + productName + ". Skipping.");
            }
        }

        origin.registerTransaction(instance);
        destination.registerTransaction(instance);
        spaceship.registerTransaction(instance);

        return instance;
    }

    public String[] getProductNames() {
        return productNames;
    }

    public Planet getOrigin() {
        return origin;
    }

    public Planet getDestination() {
        return destination;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder()
                .append(" | ").append(String.format("%-" + 10 + "s", origin.getName()))
                .append(" | ").append(String.format("%-" + 10 + "s", destination.getName()))
                .append(" | ").append(String.format("%-" + 10 + "s", spaceship.getName()))
                .append(" | ").append(String.format("%-" + 10 + "s", state.toString().toLowerCase()));
        int i = 0;
        for(HashMap.Entry<String, Integer> quantity : quantities.entrySet()) {
            if(i > 0){
                sb.append("\r\n                . |            |            |            |           ");
            }
            sb.append(" | ").append(String.format("%-" + 10 + "s", quantity.getKey()));
            sb.append(" | ").append(String.format("%" + 9 + "s", quantity.getValue())).append("T |");
            i++;
        }
        return sb.toString();
    }
}
