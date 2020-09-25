package ca.uqac.ecommerce.party;

import java.util.HashMap;
import java.util.LinkedHashSet;

/**
 * - Each planet has different resources (products) varying in quantity/limit
 *   defined when loading at commercial space;
 * - A planet sells products that are loaded into ships;
 * - A planet buys products that are unloaded from ships;
 * - It can be requested to provide a “transaction report” that displays
 *   all transactions made;
 * - The planets are not related to each other;
 * - Each planet has between one and three ports and can only accommodate
 *   one ship per port (and one in waiting. To see further);
 * - Additions can be made as needed.
 */
public class Planet extends Party {

    private Integer numOfPorts;
    private LinkedHashSet<Spaceship> docks;

    public Planet(String name, HashMap<String, Container> containers, Integer numOfPorts) {
        super(name, containers);
        this.numOfPorts = numOfPorts;
        this.docks = new LinkedHashSet<>();
    }

    public Boolean dock(Spaceship spaceship){
        if(!spaceship.isDocked() && docks.size() <= numOfPorts) {
            docks.add(spaceship);
            spaceship.setDocked(true);
            return true;
        }
        return false;
    }

    public Boolean undock(Spaceship spaceship){
        if(spaceship.isDocked() && docks.contains(spaceship)){
            docks.remove(spaceship);
            spaceship.setDocked(false);
            return true;
        }
        return false;
    }

    public Boolean sell(Spaceship spaceship, Product product){
        // @TODO
        return true;
    }

    public Boolean buy(Spaceship spaceship, Product product){
        // @TODO
        return true;
    }

    public Integer getNumOfPorts() {
        return numOfPorts;
    }

    public void setNumOfPorts(Integer numOfPorts) {
        this.numOfPorts = numOfPorts;
    }

    public LinkedHashSet<Spaceship> getDocks() {
        return docks;
    }

    public void setDocks(LinkedHashSet<Spaceship> docks) {
        this.docks = docks;
    }
}
