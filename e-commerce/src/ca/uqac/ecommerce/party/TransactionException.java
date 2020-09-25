package ca.uqac.ecommerce.party;

public class TransactionException extends Exception{
    String message;
    TransactionException(String message){
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
