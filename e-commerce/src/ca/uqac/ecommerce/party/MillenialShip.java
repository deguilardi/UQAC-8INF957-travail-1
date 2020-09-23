package ca.uqac.ecommerce.party;

import java.util.ArrayList;

public class MillenialShip extends Spaceship{

    private Boolean speedlightActive;

    public MillenialShip(ArrayList<Container> containers) {
        super(containers);
    }

    protected Boolean activateSpeedlight(){
        speedlightActive = true;
        return true;
    }

    protected Boolean deactivateSpeedlight(){
        speedlightActive = false;
        return false;
    }
}
