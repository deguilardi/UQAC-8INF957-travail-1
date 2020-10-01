package ca.uqac.ecommerce.party;

import java.util.HashMap;

public class MillenialShip extends Spaceship{

    private Boolean speedlightActive;

    public MillenialShip(String name, HashMap<String, Container> containers, Route route) {
        super(name, containers, route);
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
