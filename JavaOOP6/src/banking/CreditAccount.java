package banking;

public class CreditAccount extends ValidAccount {
    private final double _limit;
    private final int _commission;

    CreditAccount(Client client, double balance, double limit, int commission) {
        super(client, balance);
        _limit = limit;
        _commission = -commission;
    }

    @Override
    public boolean canWithdraw(double sum) {
        return (getBalance() + getFullSum(sum)) > _limit;
    }

    @Override
    protected double getFullSum(double sum) {
        return sum + (sum < 0 ? _commission : 0);
    }
}
