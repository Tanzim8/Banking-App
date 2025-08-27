package bankingapp;

import java.util.ArrayList;
public class BankAccount {
    private String accountNumber;
    private double balance;
    private String ownerName;
    private ArrayList<Transaction> transactions;

    /**
     * Creates a new bank account.
     *
     * @param accountNumber Unique identifier for the account.
     * @param ownerName     The name of the account holder.
     */

    public BankAccount(String accountNumber, String ownerName) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = 0.0;
        this.transactions = new ArrayList<>();
    }

    //getters
    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }
    public String getOwnerName() {
        return ownerName;
    }

    /**
     * Deposits money into the account.
     *
     * @param amount The amount to deposit. Must be positive.
     * @throws IllegalArgumentException if the amount is not positive.
     */

    public void deposit(double amount) {
       if(amount <= 0) {
           throw new IllegalArgumentException("Amount must be greater than 0");
       }
       balance += amount;
       transactions.add("DEPOSIT", amount, accountNumber, null);
    }

    /**
     * Withdraws money from the account.
     *
     * @param amount The amount to withdraw. Must be positive and less than balance.
     * @throws IllegalArgumentException if the amount is invalid or exceeds balance.
     */
    public void withdraw(double amount) {
        if(amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than 0");
        }
        if(amount > balance) {
            throw new IllegalArgumentException("Insufficient balance");
        }
        balance -= amount;
        transactions.add(new Transaction("WITHDRAW", amount, accountNumber, null));
    }


    /**
     * Transfers money to another account.
     *
     * @param toAccount The target account.
     * @param amount    The amount to transfer.
     * @throws IllegalArgumentException if the transfer is invalid.
     */
    public void transfer(BankAccount toAccount, double amount){
        if(toAccount== null){
            throw new IllegalArgumentException("Target account cant be null!");
        }
        if(amount <= 0){
            throw new IllegalArgumentException("Transfer amount must be positive!")
        }
        if(amount>balance){
            throw new IllegalArgumentException("Insufficient funds for transfer.")
        }

        //withdraw from current account
        balance -= amount;
        transactions.add(new Transaction("TRANSFER_OUT", amount, accountNumber, toAccount.getAccountNumber()));


        //deposit to new account
        toAccount.balance += amount;
        toAccount.transactions.add(new Transaction("TRANSFER_IN", amount, accountNumber, toAccount.getAccountNumber()))
    }

    /**
     * Returns a copy of the transaction history.
     *
     * @return List of transactions.
     */
    public ArrayList<Transaction> getTransactions() {
        return new ArrayList<>(transactions);
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber='" + accountNumber + '\'' +
                ", owner='" + ownerName + '\'' +
                ", balance=" + balance +
                '}';
    }

}
