package ca.uqac.ecommerce.party;

import ca.uqac.ecommerce.report.Report;
import ca.uqac.ecommerce.report.ScreenReport;

import java.util.ArrayList;

public class Party {

    private String name;
    private ArrayList<Container> containers;
    private Transaction transactions[];
    private Report report;

    public Party(String name, ArrayList<Container> containers) {
        this.name = name;
        this.containers = containers;
        this.report = new ScreenReport();
    }

    public Boolean load(Product product){
        // @TODO
        return true;
    }

    public Boolean unload(Product product){
        // @TODO
        return true;
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

    public ArrayList<Container> getContainers() {
        return containers;
    }

    public void setContainers(ArrayList<Container> containers) {
        this.containers = containers;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("[party]")
                .append(" name:").append(name)
                .toString();
    }
}
