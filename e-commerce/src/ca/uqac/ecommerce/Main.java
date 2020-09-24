package ca.uqac.ecommerce;

import static ca.uqac.ecommerce.party.PartyConstants.*;

public class Main {

    public static void main(String[] args){
        CommercialSpace commercialSpace = new CommercialSpace();
        commercialSpace.initialize();
        commercialSpace.performTransaction(MARS, VENUS, ULTRA, GRAVEL);
    }
}
