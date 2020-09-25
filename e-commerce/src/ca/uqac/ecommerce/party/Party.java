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

    public Boolean load(Product product, Party from){
        Container myContainer = this.containers.get(product.getName());
        Container fromContainer = from.containers.get(product.getName());
        if(myContainer != null && fromContainer != null){
            myContainer.loadFrom(fromContainer);
            return true;
        }
        return false;
    }

    public Boolean unload(Product product, Party to){
        Container myContainer = this.containers.get(product.getName());
        Container toContainer = to.containers.get(product.getName());
        if(myContainer != null && toContainer != null){
            toContainer.loadFrom(myContainer);
            return true;
        }
        return false;
    }

    public void report(){
        report.generateReport(this);
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
                .append(" name:").append(String.format("%-" + 10 + "s", name))
                .toString();
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
