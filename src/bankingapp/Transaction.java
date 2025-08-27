package bankingapp;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Represents a single banking transaction such as deposit.
 * withdrawal or transfer each transaction is timestamped.
 */
public class Transaction {
    private String type;
    private double amount;
    private LocalDateTime dateTime;
    private String fromAccount;
    private String toAccount;

    /**
     * Creates a new transaction record
     *
     * @param type Type of transaction (DEPOSIT, WITHDRAW, TRANSFER_IN, TRANSFER_OUT)
     * @param amount Transaction amount
     * @param fromAccount The originating account number (nullable)
     * @param toAccount The destinantion account;
     */

    public Transaction(String type, double amount, String fromAccount, String toAccount){
        this.type = type;
        this.amount = amount;
        this.dateTime = LocalDateTime.now();
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
    }

    //Getters

    public String getType(){
        return type;
    }
    public double getAmount(){
        return amount;
    }
    public LocalDateTime getDateTime(){
        return dateTime;
    }
    public String getFromAccount(){
        return fromAccount;
    }
    public String getToAccount(){
        return toAccount;
    }

    @Override
    public String toString(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDate = dateTime.format(formatter);

        StringBuilder sb = new StringBuilder();
        sb.append("[").append(formattedDate).append("] ");
        sb.append(type).append(" of ").append(amount);

        if(fromAccount != null){
            sb.append(" from ").append(fromAccount);
        }
        if(toAccount != null){
            sb.append( " to ").append(toAccount);
        }

        return sb.toString();
    }
}
