public class Transaction {
    public void proceed(Account source, Account receiver, int amount) {
        try {
            source.getCoins(amount);
            receiver.putCoins(amount);
        } catch (InsufficientFundsException | InvalidAmountException e) {
            System.out.println(e.getMessage());
        }
    }
}
