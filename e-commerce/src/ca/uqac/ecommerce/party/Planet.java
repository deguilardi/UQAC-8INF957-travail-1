package ca.uqac.ecommerce.party;

import sun.jvm.hotspot.memory.Space;

import java.util.HashMap;
import java.util.Iterator;
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

    public Boolean dock(Spaceship spaceship) throws TransactionException {
        if(spaceship.isDocked()){
            if(!docks.contains(spaceship)) {
                throw new TransactionException("Couldn't dock " + spaceship.getName() + " on " + getName() + ". "
                        + spaceship.getName() + " is already docked elsewhere");
            }
            return true;
        }
        if(docks.size() > numOfPorts) {
            throw new TransactionException("Couldn't dock "+spaceship.getName()+" on "+getName()+". "
                    +this.getName()+" is full");
        }
        docks.add(spaceship);
        spaceship.setDocked(true);
        return true;
    }

    public Boolean undock(Spaceship spaceship) throws TransactionException {
        if(!spaceship.isDocked()){
            throw new TransactionException("Couldn't undock "+spaceship.getName()+" from "+getName()+". "
                    +spaceship.getName()+" is docked nowhere");
        }
        if(!docks.contains(spaceship)){
            throw new TransactionException("Couldn't undock "+spaceship.getName()+" from "+getName()+". "
                    +spaceship.getName()+" is not docked on"+this.getName());
        }
        docks.remove(spaceship);
        spaceship.setDocked(false);
        return true;
    }

    public void undockAllAndMoveLine() {
        Integer i = 0;
        Iterator<Spaceship> iterator = docks.iterator();
        while(iterator.hasNext() && i < numOfPorts){
            Spaceship spaceship = iterator.next();
            docks.remove(spaceship);
            spaceship.setDocked(false);
            i++;
        }
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
