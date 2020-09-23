package ca.uqac.ecommerce.party;

public class Container {

    private Product product;
    private Integer capacity;
    private Integer load;

    public Container(Product product, Integer capacity, Integer load) {
        this.product = product;
        this.capacity = capacity;
        this.load = load;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Integer getLoad() {
        return load;
    }

    public void setLoad(Integer load) {
        this.load = load;
    }
}
