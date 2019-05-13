package banking;

import java.util.UUID;

public class UnreliableAccount implements IAccount {
    private IAccount delegate;
    private int limit;

    UnreliableAccount(IAccount account, int limit) {
        delegate = account;
        this.limit = limit;
    }

    @Override
    public void withdraw(double sum) {
        if (canWithdraw(sum))
            delegate.withdraw(sum);
    }

    @Override
    public void recharge(double sum) {
        delegate.recharge(sum);
    }

    @Override
    public void transfer(UUID accountId, double sum) {
        if (canWithdraw(sum))
            delegate.transfer(accountId, sum);
    }

    @Override
    public final Client getHolder() {
        return delegate.getHolder();
    }

    @Override
    public final UUID getIdentifier() {
        return delegate.getIdentifier();
    }

    @Override
    public final double getBalance() {
        return delegate.getBalance();
    }

    @Override
    public boolean canWithdraw(double sum) {
        return sum <= limit;
    }
}
