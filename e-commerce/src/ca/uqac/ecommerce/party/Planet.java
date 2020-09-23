package ca.uqac.ecommerce.party;

public class Planet {

    private Integer numOfPorts;
    private Spaceship line[];

    public Planet(Integer numOfPorts) {
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
