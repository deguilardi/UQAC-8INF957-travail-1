package ca.uqac.ecommerce.report;

import ca.uqac.ecommerce.party.Transaction;

public class PdfReport implements Report{

    @Override
    public void generateReport(Transaction[] transaction) {
        System.out.println("@TODO PdfReport::generateReport");
    }
}
