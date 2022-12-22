public class Bank {
    private String user;
    private int id;
    private int pinCode;


    public Bank(String user, int id, int pinCode, int pinAttempts, int balance, boolean cardAvailable){
        this.user = user;
        this.id = id;
        this.pinCode = pinCode;
        this.pinAttempts = pinAttempts;
        this.balance = balance;
        this.cardAvailable = cardAvailable;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPinCode() {
        return pinCode;
    }

    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }

    public int getPinAttempts() {
        return pinAttempts;
    }

    public void setPinAttempts(int pinAttempts) {
        this.pinAttempts = pinAttempts;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public boolean isCardAvailable() {
        return cardAvailable;
    }

    public void setCardAvailable(boolean cardAvailable) {
        this.cardAvailable = cardAvailable;
    }

    public static String getBank() {
        return bank;
    }

    public static void setBank(String bank) {
        Bank.bank = bank;
    }
    public int depositMoney(int amount, int balance){
        int total = amount + balance;
        return total;
    }
    public int withdrawMoney(int amount, int balance){
        int total = balance - amount;
        return total;
    }
    public static String bankName(){
        return getBank();
    }

    private int pinAttempts;
    private int balance;
    private boolean cardAvailable;
    private static String bank;

}
