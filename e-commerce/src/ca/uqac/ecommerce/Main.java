package ca.uqac.ecommerce;

import static ca.uqac.ecommerce.party.PartyConstants.*;

public class Main {

    public static void main(String[] args){

        // Initialize commercial space
        CommercialSpace commercialSpace = new CommercialSpace();
        commercialSpace.initialize();

        // Cycle
        commercialSpace.initNewCycle();
        commercialSpace.performTransaction(MARS, VENUS, CRUISE, GRAVEL);
        commercialSpace.performTransaction(VENUS, NEPTUNE, CRUISE, ACID);

        // Cycle
        commercialSpace.initNewCycle();
        commercialSpace.performTransaction(VENUS, MARS, MILLENIAL, GRAVEL);
        commercialSpace.performTransaction(NEPTUNE, VENUS, CRUISE, ACID);
        commercialSpace.report();
    }
}
