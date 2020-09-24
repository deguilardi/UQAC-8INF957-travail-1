package ca.uqac.ecommerce.party;

import java.util.ArrayList;

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
    private Spaceship line[];

    public Planet(String name, ArrayList<Container> containers, Integer numOfPorts) {
        super(name, containers);
        this.numOfPorts = numOfPorts;
    }

    public Boolean dock(Spaceship spaceship){
        // @TODO
        return true;
    }

    public Boolean undock(Spaceship spaceship){
        // @TODO
        return true;
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

    public Spaceship[] getLine() {
        return line;
    }

    public void setLine(Spaceship[] line) {
        this.line = line;
    }
}
