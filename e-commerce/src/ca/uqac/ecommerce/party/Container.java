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

    public Boolean loadFrom(Container from){
        if(this.capacity - this.load >= from.load){
            this.load += from.load;
            from.load = 0;
        }
        return false;
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

    @Override
    public String toString() {
        return new StringBuilder()
                .append("[container]")
                .append(" product:").append(product.getName())
                .append(", capacity:").append(capacity.toString()).append("T")
                .append(", load:").append(load.toString()).append("T")
                .toString();
    }
}
