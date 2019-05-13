package banking;

public final class CheckingAccount extends ValidAccount {
    private final double _percents;

    CheckingAccount(Client client, double balance, double percents) {
        super(client, balance);
        _percents = percents;
    }

    @Override
    public boolean canWithdraw(double sum) {
        return (getBalance() - sum) >= 0;
    }

    @Override
    protected double getFullSum(double sum) {
        return sum;
    }
}
