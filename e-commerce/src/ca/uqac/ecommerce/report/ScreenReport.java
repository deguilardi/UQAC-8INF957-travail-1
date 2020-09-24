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
                .append("    ").append(party.toString());
        party.getContainers().forEach(container -> {
            sb.append("\r\n        ");
            sb.append(container.toString());
        });
        System.out.println(sb);
    }
}
