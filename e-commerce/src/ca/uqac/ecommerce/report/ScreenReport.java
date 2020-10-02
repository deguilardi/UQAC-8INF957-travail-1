package ca.uqac.ecommerce.report;

import ca.uqac.ecommerce.party.Party;

public class ScreenReport implements Report{

    @Override
    public void generateReport(Party party) {
        System.out.println("                . |--------------------------------------|");
        System.out.println("                . | "+party.getPaddedName(10)+"                           |");
        System.out.println("                . | product    | capacity   | load       |");
        System.out.println("                . |--------------------------------------|");
        party.getContainers().forEach((product, container) -> {
            System.out.println("                ." + container.toString());
        });
        System.out.println("                . |-----------------------------------------------------------------------------|");
        System.out.println("                . | transactions                                                                |");
        System.out.println("                . | seller     | buyer      | spaceship  | state      | product    | qty        |");
        System.out.println("                . |-----------------------------------------------------------------------------|");
        party.getTransactions().forEach((transaction) -> {
            System.out.println("                ." + transaction.toString());
        });
        System.out.println("                . |-----------------------------------------------------------------------------|");
        System.out.println("                . ");
    }
}
