package ca.uqac.ecommerce;

import ca.uqac.ecommerce.party.CruiseShip;
import ca.uqac.ecommerce.party.MillenialShip;
import ca.uqac.ecommerce.party.UltraShip;
import ca.uqac.ecommerce.CommercialSpace.From;

import static ca.uqac.ecommerce.party.PartyConstants.*;

public class Main {

    public static void main(String[] args){

        // Initialize commercial space
        CommercialSpace commercialSpace = new CommercialSpace();
        commercialSpace.factoryPlanet(VENUS, 3, new String[]{GRAVEL, ACID, GAS}, 200, 100);
        commercialSpace.factoryPlanet(MARS, 3, new String[]{GRAVEL, PAPER, GAS}, 200, 100);
        commercialSpace.factoryPlanet(NEPTUNE, 3, new String[]{TIRES, ACID, GAS}, 200, 100);
        commercialSpace.factoryPlanet(MERCURY, 3, new String[]{TIRES, PAPER}, 200, 100);
        commercialSpace.factoryPlanet(SATURN, 3, new String[]{TIRES, PAPER}, 200, 100);
        commercialSpace.factorySpaceship(CRUISE, CruiseShip.class, new String[]{GRAVEL, GAS, PAPER}, VENUS, MARS);
        commercialSpace.factorySpaceship(MILLENIAL, MillenialShip.class, new String[]{GRAVEL, TIRES, PAPER}, MERCURY, SATURN);
        commercialSpace.factorySpaceship(ULTRA, UltraShip.class, new String[]{TIRES, ACID, GAS}, MARS, NEPTUNE);
//        commercialSpace.report();

        // Cycle
        commercialSpace.nextCycle();
        commercialSpace.dispatchSpaceship(CRUISE, new String[]{GRAVEL, GAS}, From.ORIGIN_TO_DESTINATION);
//        commercialSpace.report();
        commercialSpace.getSpaceshipWithName(CRUISE).report();

//        // Cycle
//        commercialSpace.nextCycle();
//        commercialSpace.dispatchSpaceship(CRUISE, new String[]{GRAVEL, GAS}, From.DESTINATION_TO_ORIGIN);
//        commercialSpace.getPlanetWithName(VENUS).report();
//
//        // Cycle
//        commercialSpace.nextCycle();
//        commercialSpace.dispatchSpaceship(CRUISE, new String[]{GRAVEL, GAS}, From.DESTINATION_TO_ORIGIN);
//        commercialSpace.getPlanetWithName(VENUS).report();

    }
}
