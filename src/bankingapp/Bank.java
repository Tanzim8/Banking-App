package bankingapp;

import java.util.ArrayList;

public class Bank {
    private ArrayList<BankAccount> accounts;
    private ArrayList<Customer> customers;

    //constructor
    public Bank() {
        accounts = new ArrayList<>();
        customers = new ArrayList<>();
    }

    /**
     * Adds a new account to the banl
     * @param account The BankAccount object to add
     */
    public void addAccount(BankAccount account){
        accounts.add(account);
    }

    /**
     * Finds and returns an account by its account number.
     * @param accountNumber the account number to search
     * @return The BankAccount if found, or null if not.
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
     * Removes an account from the bank using the account number.
     * @param accountNumber The account number to remove
     * @return true if removed, false if account not found
     */
    public boolean removeAccount(String accountNumber){
        BankAccount toRemove = findAccount(accountNumber);
        if(toRemove != null){
            accounts.remove(toRemove);
            return true;
        }
        return false;
    }
    /**
     * Returns the list of all accounts
     * @return An ArrayList of BankAccount objects.
     */
    public ArrayList<BankAccount> getAllAccounts(){
        return accounts;
    }

    public void printAllAccounts(){
        if(accounts.isEmpty()){
            System.out.println("No accounts in the Bank.");
            return;
        }
        for(BankAccount account : accounts){
            System.out.println(account);
        }
    }

    // -------------------------
    // Customer management
    // -------------------------
    public void addCustomer(Customer customer){
        customers.add(customer);
    }

    public Customer findCustomer(String customerId){
        for(Customer customer : customers){
            if(customer.getCustomerId().equals(customerId)){
                return customer;
            }
        }
        return null;
    }

    public boolean removeCustomer(String customerId){
        Customer toRemove = findCustomer(customerId);
        if(toRemove != null){
            customers.remove(toRemove);
            return true;
        }
        return false;
    }

    public ArrayList<Customer> getAllCustomers() {
        return customers;
    }

    public void printAllCustomers() {
        if (customers.isEmpty()) {
            System.out.println("No customers in the bank.");
            return;
        }
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }
}
