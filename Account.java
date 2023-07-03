public class Account {
    private static int counter = 0;
    private int id;
    private int balance;

    Account() {
        this.id = ++counter;
    }

    public int getId() {
        return this.id;
    }

    public void putCoins(int amount) {
        try {
            this.putCoinsInside(amount);

        } catch (InvalidAmountException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void putCoinsInside(int amount) throws InvalidAmountException {
        if (amount < 0) {
            throw new InvalidAmountException("Invalid transaction amount");
        } else {
            this.balance += amount;
        }
    }

    public void getCoins(int amount) throws InsufficientFundsException, InvalidAmountException {
        if (amount < 0) {
            throw new InvalidAmountException("Invalid transaction amount");
        } else if (this.balance < amount) {
            throw new InsufficientFundsException("Insufficient funds");
        } else {
            this.balance -= amount;
        }
    }
}
