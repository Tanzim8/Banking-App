package bankingapp;
    /**
     * Custom exception thrown when a negative or invalid amount
     * is used for deposit or withdrawal.
     */
    public class IllegalAmountException extends Exception{
        public IllegalAmountException(String message){
            super(message);
        }


}
