package ca.uqac.ecommerce.report;

import ca.uqac.ecommerce.party.Party;
import ca.uqac.ecommerce.party.Transaction;

public class ScreenReport implements Report{

    @Override
    public void generateReport(Transaction[] transaction) {
        System.out.println("@TODO ScreenReport::generateReport");
    }

    @Override
    public void generateReport(Party party) {
        party.getContainers().forEach((product, container) -> {
            System.out.println("                . | " + party.getPaddedName(11) + container.toString());
        });
    }
}
