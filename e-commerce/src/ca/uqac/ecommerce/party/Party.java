package ca.uqac.ecommerce.party;

public class Party {

    private String name;
    private Container containers[];
    private Transaction transactions[];

    public Party(Container[] containers) {
        this.containers = containers;
    }

    public Boolean load(Product product){
        // @TODO
        return true;
    }

    public Boolean unload(Product product){
        // @TODO
        return true;
    }

    public void report(){
        // @TODO
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Container[] getContainers() {
        return containers;
    }

    public void setContainers(Container[] containers) {
        this.containers = containers;
    }
}
