package banking;

public class Account {

    private Card card;
    private double balance;

    public Account(Card card) {
        this.card = card;
        balance = 0;
    }

    public double getBalance() {
        return balance;
    }

    public boolean checkNumberAndPin(String number, String pin) {
        return card.getNumber().equals(number) && card.getPin().equals(pin);
    }
}
