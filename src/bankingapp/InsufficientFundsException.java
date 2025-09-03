package bankingapp;

/**
 * Custom exception thrown when a withdrawal amount
 * exceeds the current account balance.
 */
public class InsufficientFundsException extends Exception{
    public InsufficientFundsException(String message){
        super(message);
    }
}
