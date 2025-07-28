package bankingapp;

import java.util.ArrayList;

public class Bank {
    private ArrayList<BankAccount> accounts;

    //constructor
    public Bank() {
        accounts = new ArrayList<>();
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
     * @retun An ArrayList of BankAccount objects.
     */
    public ArrayList<BankAccount> getAllAccounts(){
        return accounts;
    }
}
