package ca.uqac.ecommerce.report;

import ca.uqac.ecommerce.party.Party;
import ca.uqac.ecommerce.party.Transaction;

public interface Report {
    public void generateReport(Transaction transaction[]);
    public void generateReport(Party party);
}
