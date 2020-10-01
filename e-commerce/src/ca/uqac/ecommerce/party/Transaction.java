package ca.uqac.ecommerce.party;

public class Transaction {

    private String sellerName;
    private String buyerName;
    private Integer quantity;

    public Transaction(String sellerName, String buyerName, Integer quantity) {
        this.sellerName = sellerName;
        this.buyerName = buyerName;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append(" | ").append(String.format("%-" + 9 + "s", sellerName))
                .append(" | ").append(String.format("%-" + 10 + "s", buyerName))
                .append(" | ").append(String.format("%" + 7 + "s", quantity)).append("T |")
                .toString();
    }
}
