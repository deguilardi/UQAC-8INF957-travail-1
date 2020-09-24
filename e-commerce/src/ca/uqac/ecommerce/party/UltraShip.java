package ca.uqac.ecommerce.party;

import java.util.HashMap;

public class UltraShip extends Spaceship{

    private Boolean backwardsActivate;

    public UltraShip(String name, HashMap<String, Container> containers) {
        super(name, containers);
    }

    protected boolean toggleFlyBackwards(){
        backwardsActivate = !backwardsActivate;
        return backwardsActivate;
    }
}
