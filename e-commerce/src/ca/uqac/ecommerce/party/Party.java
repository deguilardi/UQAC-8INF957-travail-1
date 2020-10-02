package ca.uqac.ecommerce.party;

import ca.uqac.ecommerce.report.Report;
import ca.uqac.ecommerce.report.ScreenReport;

import java.util.ArrayList;
import java.util.HashMap;

public class Party {

    private String name;
    private HashMap<String, Container> containers;
    private ArrayList<Transaction> transactions = new ArrayList<>();
    private Report report;

    public Party(String name, HashMap<String, Container> containers) {
        this.name = name;
        this.containers = containers;
        this.report = new ScreenReport();
    }

    public Integer load(Party from, String productNames[]) {
        Integer output = 0;
        for(String productName : productNames){
            System.out.print("                . Loading " + this.name + " with " + productName + " from " + from.name + ". ");
            Container fromContainer = from.containers.get(productName);
            if(fromContainer == null){
                System.out.println("ERROR. " + from.name + " doesn't have a proper container. Skipping.");
                continue;
            }
            Container toContainer = this.containers.get(productName);
            if(toContainer == null){
                System.out.println("ERROR. " + this.name + " doesn't have a proper container. Skipping.");
                continue;
            }
            Integer load = toContainer.loadFrom(fromContainer);
            output += load;
            if(load == 0){
                System.out.println("ERROR. Not enough space. Need " +fromContainer.getLoadUnloadMaxCapacity()+ "T, has only " + toContainer.getCapacityLeft() + " left. Skipping.");
                if(this instanceof Planet){
                    ((Spaceship) from).banish();
                    System.out.println("                . " + from.name + " banished forever!");
                    System.out.println("                . \\\\    //");
                    System.out.println("                .  \\\\  //");
                    System.out.println("                .   \\\\//");
                    System.out.println("                .   //\\\\");
                    System.out.println("                .  //  \\\\");
                    System.out.println("                . //    \\\\");
                    break;
                }
                continue;
            }
            System.out.println("SUCCESS. loaded "+load+"T.");

        }
        return output;
    }

    public void registerTransaction(Transaction transaction){
        transactions.add(transaction);
    }

    public void report(){
        report.generateReport(this);
    }

    public String getPaddedName(Integer size){
        return String.format("%-" + size + "s", name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashMap<String, Container> getContainers() {
        return containers;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("[party]")
                .append(" name:").append(getPaddedName(10))
                .toString();
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
