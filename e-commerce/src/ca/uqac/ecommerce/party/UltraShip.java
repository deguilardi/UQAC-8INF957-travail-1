package ca.uqac.ecommerce.party;

public class UltraShip extends Spaceship{

    private Boolean backwardsActivate;

    public UltraShip(Container[] containers) {
        super(containers);
    }

    protected boolean toggleFlyBackwards(){
        backwardsActivate = !backwardsActivate;
        return backwardsActivate;
    }
}
