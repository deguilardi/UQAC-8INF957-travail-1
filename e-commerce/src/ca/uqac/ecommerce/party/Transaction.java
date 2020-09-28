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

    @Override
    public String toString() {
        return new StringBuilder()
                .append(" | ").append(String.format("%-" + 8 + "s", sellerName))
                .append(" | ").append(String.format("%" + 7 + "s", buyerName))
                .append(" | ").append(String.format("%" + 9 + "s", productName))
                .append(" | ").append(String.format("%" + 4 + "s", quantity)).append("T |")
                .toString();
    }
}
