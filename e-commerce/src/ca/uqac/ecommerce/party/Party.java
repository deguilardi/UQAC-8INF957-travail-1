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

    public Integer load(Product product, Party from){
        Container myContainer = this.containers.get(product.getName());
        Container fromContainer = from.containers.get(product.getName());
        if(myContainer != null && fromContainer != null){
            return myContainer.loadFrom(fromContainer);
        }
        return 0;
    }

    public Integer unload(Product product, Party to){
        Container myContainer = this.containers.get(product.getName());
        Container toContainer = to.containers.get(product.getName());
        if(myContainer != null && toContainer != null){
            return toContainer.loadFrom(myContainer);
        }
        return 0;
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
