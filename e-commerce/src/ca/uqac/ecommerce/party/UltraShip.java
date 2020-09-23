package ca.uqac.ecommerce.party;

import java.util.ArrayList;

public class UltraShip extends Spaceship{

    private Boolean backwardsActivate;

    public UltraShip(ArrayList<Container> containers) {
        super(containers);
    }

    protected boolean toggleFlyBackwards(){
        backwardsActivate = !backwardsActivate;
        return backwardsActivate;
    }
}
