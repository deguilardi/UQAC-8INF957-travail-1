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
        StringBuilder sb = new StringBuilder()
                .append("[ScreenReport][party]")
                .append("\r\n  name:")
                .append(party.getName());
        System.out.println(sb);
    }
}
