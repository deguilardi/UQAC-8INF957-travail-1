package ca.uqac.ecommerce.party;

public class Product {

    private String name;
    private Integer weight;
    private Float price;
    private Menacing menacing;

    enum Menacing {
        REGULAR,
        DANGEROUS
    }

    public Product(String name, Integer weight, Float price, Menacing menacing) {
        this.name = name;
        this.weight = weight;
        this.price = price;
        this.menacing = menacing;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Menacing getMenacing() {
        return menacing;
    }

    public void setMenacing(Menacing menacing) {
        this.menacing = menacing;
    }
}
