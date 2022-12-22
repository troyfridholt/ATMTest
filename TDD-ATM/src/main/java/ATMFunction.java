import java.util.Scanner;

public class ATMFunction {
    private static Bank bank;

    public ATMFunction(Bank bank) {
        this.bank = bank;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public int pinCheck(Bank bank) {
        int userInput = 999;
        int pin = bank.getPinCode();
        int pinAttempts = bank.getPinAttempts();
        int counter = 3;
        while (pinAttempts < 3) {

            if (userInput == pin) {
                System.out.println("Choose to either withdrawl or input money" + bank.getUser());
                return pin;
            } else if (counter == pin) {
                System.out.println("3/3 attempts wrong");
                bank.setCardAvailable(false);
                return pin;
            } else {
                pinAttempts++;
                counter--;
                System.out.println(counter + "Attempts used");
            }

        }
        return userInput;
    }

    public boolean cardStatus(Bank bank) {
        if (bank.isCardAvailable() == false) {
            System.out.println("Not locked");
            return false;
        } else {
            System.out.println("Card locked");
            return true;
        }
    }

    public int checkBalance(Bank bank) {
        return bank.getBalance();
    }

    public int depositMoney(Bank bank) {
        return bank.depositMoney(amountDeposit(), bank.getBalance());
    }

    public int amountDeposit() {
        return 20;
    }

    public int amountWithdraw() {
        return 10;
    }

    public int withdrawMoney(Bank bank) {
        return bank.withdrawMoney(amountWithdraw(), bank.getBalance());
    }

    public boolean withdrawAccepted(Bank bank) {
        if (amountDeposit() >= bank.getBalance()) {
            return false;
        } else {
            return true;
        }
    }

    public boolean closeATM() {

        String sc = "Done";
        if (sc.equals("Wait")) {
            System.out.println("Make your choice");
            return false;
        } else {

            return true;
        }
    }

}