package ca.uqac.ecommerce.party;

public class Transaction {

    private String sellerName;
    private String buyerName;
    private String productName;
    private Integer quantity;

    public Transaction(String sellerName, String buyerName, String productName, Integer quantity) {
        this.sellerName = sellerName;
        this.buyerName = buyerName;
        this.productName = productName;
        this.quantity = quantity;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
