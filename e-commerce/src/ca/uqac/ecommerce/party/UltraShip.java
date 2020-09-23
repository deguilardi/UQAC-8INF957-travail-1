package ca.uqac.ecommerce.party;

import java.util.ArrayList;

public class UltraShip extends Spaceship{

    private Boolean backwardsActivate;

    public UltraShip(String name, ArrayList<Container> containers) {
        super(name, containers);
    }

    protected boolean toggleFlyBackwards(){
        backwardsActivate = !backwardsActivate;
        return backwardsActivate;
    }
}
