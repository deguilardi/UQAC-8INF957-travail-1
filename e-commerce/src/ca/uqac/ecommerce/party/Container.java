package ca.uqac.ecommerce.party;

public class Container {

    private Product product;
    private Integer capacity;
    private Integer load;

    public Container(Product product) {
        this.product = product;
        this.load = 0;
        if(product.getMenacing() == Product.Menacing.REGULAR) {
            this.capacity = 50;
        }
        else{
            this.capacity = 20;
        }
    }

    public Container(Product product, Integer capacity, Integer load) {
        this.product = product;
        this.capacity = capacity;
        this.load = load;
    }

    public Integer loadFrom(Container from){
        if(getCapacityLeft() >= getLoadUnloadMaxCapacity()){
            Integer output = getLoadUnloadMaxCapacity();
            this.load += output;
            from.load -= output;
            return output;
        }
        return 0;
    }

    public Integer getLoadUnloadMaxCapacity(){
        return product.getMenacing() == Product.Menacing.REGULAR ? 25 : 10;
    }

    public Integer getCapacityLeft(){
        return this.capacity - this.load;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public Integer getLoad() {
        return load;
    }

    public Product getProduct(){
        return product;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append(" | ").append(String.format("%-" + 10 + "s", product.getName()))
                .append(" | ").append(String.format("%" + 9 + "s", capacity.toString())).append("T")
                .append(" | ").append(String.format("%" + 9 + "s", load.toString())).append("T |")
                .toString();
    }
}
