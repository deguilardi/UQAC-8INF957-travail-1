package ca.uqac.ecommerce.party;

public class Product {

    private String name;
    private Menacing menacing;

    public enum Menacing {
        REGULAR,
        DANGEROUS
    }

    public Product(String name, Menacing menacing) {
        this.name = name;
        this.menacing = menacing;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Menacing getMenacing() {
        return menacing;
    }

    public void setMenacing(Menacing menacing) {
        this.menacing = menacing;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
