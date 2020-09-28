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

    public Integer load(Product product, Party from) throws TransactionException {
        Container fromContainer = from.containers.get(product.getName());
        if(fromContainer == null){
            throw new TransactionException("Couldn't load "+this.name+". "
                    +from.name+" doesn't have a container for "+product.getName());
        }
        Container toContainer = this.containers.get(product.getName());
        if(toContainer == null){
            throw new TransactionException("Couldn't load "+this.name+". "
                    +this.name+" doesn't have a container for "+product.getName());
        }
        Integer output = toContainer.loadFrom(fromContainer);
        if(output == 0){
            throw new TransactionException("Couldn't load "+this.name+". "
                    +this.name+" can't load "+fromContainer.getCapacity()+"T of "+product.getName()
                    +", it has only "+(toContainer.getCapacity() - toContainer.getLoad())+"T left.");
        }
        return output;
    }

    public Integer unload(Product product, Party to) throws TransactionException {
        Container fromContainer = this.containers.get(product.getName());
        if(fromContainer == null){
            throw new TransactionException("Couldn't unload "+this.name+". "
                    +this.name+" doesn't have a container for "+product.getName());
        }
        Container toContainer = to.containers.get(product.getName());
        if(toContainer == null){
            throw new TransactionException("Couldn't unload "+this.name+". "
                    +to.name+" doesn't have a container for "+product.getName());
        }
        Integer output = toContainer.loadFrom(fromContainer);
        if(output == 0){
            throw new TransactionException("Couldn't unload "+this.name+". "
                    +to.name+" can't load "+fromContainer.getCapacity()+"T of "+product.getName()
                    +", it has only "+(toContainer.getCapacity() - toContainer.getLoad())+"T left.");
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
