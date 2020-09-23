package ca.uqac.ecommerce.party;

public class MillenialShip extends Spaceship{

    private Boolean speedlightActive;

    public MillenialShip(Container[] containers) {
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
