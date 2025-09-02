package bankingapp;

import java.util.ArrayList;

public class Customer {
    private String customerId;
    private String name;
    private String email;
    private String phone;
    private ArrayList<BankAccount> accounts;

    /**
     * Creates a new Customer.
     *
     * @param customerId Unique identifier
     * @param name       Customer's full name
     * @param email      Customer's email address
     * @param phone      Customer's phone number
     */
    public Customer(String customerId, String name, String email, String phone){
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.accounts = new ArrayList<>();
    }

    //Getters
    public String getCustomerId(){
        return customerId;
    }

    public String getName(){
        return name;
    }

    public String getEmail(){
        return email;
    }

    public String getPhone(){
        return phone;
    }

    public ArrayList<BankAccount> getAccounts(){
        return new ArrayList<>(accounts);
    }

    /**
     * Adds a new bank account to this customer.
     *
     * @param account The BankAccount object to add
     */
    public void addAccount(BankAccount account){
        accounts.add(account);
    }

    /**
     * Finds a bank account by account number.
     *
     * @param accountNumber The account number to search for
     * @return The BankAccount if found, otherwise null
     */
    public BankAccount findAccount(String accountNumber){
        for(BankAccount account : accounts){
            if(account.getAccountNumber().equals(accountNumber)){
                return account;
            }
        }
        return null;
    }

    /**
     * Removes a bank account from the customer.
     *
     * @param accountNumber The account number to remove
     * @return true if removed, false if not found
     */
    public Boolean removeAccount(String accountNumber){
        BankAccount toRemove = findAccount(accountNumber);
        if(toRemove != null){
            accounts.remove(toRemove);
            return true;
        }
        return false;
    }

    /**
     * Returns a string representation of the customer and their accounts.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Customer{")
                .append("ID='").append(customerId).append('\'')
                .append(", Name='").append(name).append('\'')
                .append(", Email='").append(email).append('\'')
                .append(", Phone='").append(phone).append('\'')
                .append(", Accounts=").append(accounts.size())
                .append("}");
        return sb.toString();
    }
}
