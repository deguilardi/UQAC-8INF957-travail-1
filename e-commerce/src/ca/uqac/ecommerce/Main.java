package ca.uqac.ecommerce;

import ca.uqac.ecommerce.party.CruiseShip;
import ca.uqac.ecommerce.party.MillenialShip;
import ca.uqac.ecommerce.party.UltraShip;

import static ca.uqac.ecommerce.party.PartyConstants.*;

public class Main {

    public static void main(String[] args){

        // Initialize commercial space
        CommercialSpace commercialSpace = new CommercialSpace();
        commercialSpace.factorySpaceship(CRUISE, CruiseShip.class, new String[]{GRAVEL, ACID, PAPER},140,0);
        commercialSpace.factorySpaceship(MILLENIAL, MillenialShip.class, new String[]{GRAVEL, TIRES, PAPER},140,0);
        commercialSpace.factorySpaceship(ULTRA, UltraShip.class, new String[]{TIRES, ACID, GAS},140,0);
        commercialSpace.factoryPlanet(VENUS, 3, new String[]{GRAVEL, ACID, GAS}, 20, 10);
        commercialSpace.factoryPlanet(MARS, 3, new String[]{GRAVEL, PAPER, GAS}, 20, 10);
        commercialSpace.factoryPlanet(NEPTUNE, 3, new String[]{TIRES, ACID, GAS}, 20, 10);
        commercialSpace.factoryPlanet(MERCURY, 3, new String[]{TIRES, PAPER}, 20, 10);
        commercialSpace.factoryPlanet(SATURN, 3, new String[]{TIRES, PAPER}, 20, 10);
//        commercialSpace.report();

        // Cycle
        commercialSpace.initNewCycle();
        commercialSpace.performTransaction(MARS, VENUS, CRUISE, GRAVEL);
        commercialSpace.performTransaction(VENUS, NEPTUNE, CRUISE, ACID);
//        commercialSpace.report();

        // Cycle
        commercialSpace.initNewCycle();
        commercialSpace.performTransaction(VENUS, MARS, MILLENIAL, GRAVEL);
        commercialSpace.performTransaction(NEPTUNE, VENUS, CRUISE, ACID);
//        commercialSpace.report();
        commercialSpace.getPlanetWithName(VENUS).report();

    }
}
