package ca.uqac.ecommerce;

import ca.uqac.ecommerce.CommercialSpace.From;

import static ca.uqac.ecommerce.party.PartyConstants.*;

public class Main {

    public static void main(String[] args){

        /**
         * Initialize a commercial space
         *
         * This "main" method won't make use of specific types as,
         * in the future, it might be a controller to pick up user's
         * input (which come as primitives).
         */
        CommercialSpace commercialSpace = new CommercialSpace();
        commercialSpace.factoryPlanet(VENUS, 3, new String[]{GRAVEL, ACID, GAS}, 200, 100);
        commercialSpace.factoryPlanet(MARS, 3, new String[]{GRAVEL, PAPER, GAS}, 200, 100);
        commercialSpace.factoryPlanet(NEPTUNE, 3, new String[]{TIRES, ACID, GAS}, 200, 100);
        commercialSpace.factoryPlanet(MERCURY, 3, new String[]{TIRES, PAPER}, 200, 100);
        commercialSpace.factoryPlanet(SATURN, 3, new String[]{TIRES, PAPER}, 200, 100);
        commercialSpace.factorySpaceship(CRUISE, "CruiseShip", new String[]{GRAVEL, GAS, PAPER}, VENUS, MARS);
        commercialSpace.factorySpaceship(MILLENIAL, "MillenialShip", new String[]{GRAVEL, TIRES, PAPER}, MERCURY, SATURN);
        commercialSpace.factorySpaceship(ULTRA, "UltraShip", new String[]{TIRES, ACID, GAS}, MARS, NEPTUNE);

        /**
         * Cycles and transactions
         *
         * Transactions are state machines controlled by cycles.
         * Each cycle moves all current transactions to the next state.
         *
         * To dispatch a spaceship, call method "dispatchSpaceship"
         * in a commercial space.
         */
        commercialSpace.dispatchSpaceship(CRUISE, new String[]{GRAVEL, GAS}, From.ORIGIN_TO_DESTINATION);
        commercialSpace.dispatchSpaceship(MILLENIAL, new String[]{TIRES, PAPER}, From.ORIGIN_TO_DESTINATION);
        commercialSpace.cycle();
        commercialSpace.cycle();
        commercialSpace.cycle();
        commercialSpace.dispatchSpaceship(ULTRA, new String[]{GRAVEL, GAS}, From.ORIGIN_TO_DESTINATION);
        commercialSpace.cycle();
        commercialSpace.cycle();
        commercialSpace.dispatchSpaceship(CRUISE, new String[]{GRAVEL, GAS}, From.DESTINATION_TO_ORIGIN);
        commercialSpace.cycle();
        commercialSpace.cycle();
        commercialSpace.dispatchSpaceship(MILLENIAL, new String[]{GRAVEL, PAPER}, From.DESTINATION_TO_ORIGIN);
        commercialSpace.cycle();
        commercialSpace.cycle();

        /**
         * Reports
         *
         * Reports can be done at any time, in any cycle.
         * There are tree ways to report:
         *   1) Report a single spaceship
         *      Includes current state and all transactions ever
         *      made. First retrieve a spaceship by its name from
         *      a commercial space, then call method "report".
         *   2) Report a single planet
         *      Includes current state and all transactions ever
         *      made. First retrieve a planet by its name from a
         *      commercial space, then call method "report".
         *   3) Report everything in a commercial space.
         *      Will navigate on all spaceships and planets and
         *      report them all. Call method "report" on a
         *      commercial space.
         */
        // 1) Report a single spaceship
        commercialSpace.getSpaceshipWithName(CRUISE).report();
        // 2) Report a single planet
        commercialSpace.getPlanetWithName(VENUS).report();
        // 3) Report everything in a commercial space.
        commercialSpace.report();


        // More cycles ....
        commercialSpace.cycle();
        commercialSpace.cycle();
        commercialSpace.cycle();
        commercialSpace.cycle();
        commercialSpace.cycle();
        commercialSpace.cycle();
    }
}
