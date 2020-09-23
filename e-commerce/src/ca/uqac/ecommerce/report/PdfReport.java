package ca.uqac.ecommerce.report;

import ca.uqac.ecommerce.party.Party;
import ca.uqac.ecommerce.party.Transaction;

public class PdfReport implements Report{

    @Override
    public void generateReport(Transaction[] transaction) {
        System.out.println("@TODO PdfReport::generateReport");
    }

    @Override
    public void generateReport(Party party) {
        System.out.println("@TODO PdfReport::generateReport");
    }
}
