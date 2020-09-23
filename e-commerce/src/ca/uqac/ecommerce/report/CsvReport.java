package ca.uqac.ecommerce.report;

import ca.uqac.ecommerce.party.Party;
import ca.uqac.ecommerce.party.Transaction;

public class CsvReport implements Report{

    @Override
    public void generateReport(Transaction[] transaction) {
        System.out.println("@TODO CsvReport::generateReport");
    }

    @Override
    public void generateReport(Party party) {
        System.out.println("@TODO CsvReport::generateReport");
    }
}
