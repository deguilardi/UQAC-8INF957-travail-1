package ca.uqac.ecommerce.report;

import ca.uqac.ecommerce.party.Transaction;

public interface Report {
    public void generateReport(Transaction transaction[]);
}
