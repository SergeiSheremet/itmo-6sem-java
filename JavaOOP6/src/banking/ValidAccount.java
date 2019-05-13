package banking;

import java.util.UUID;

public abstract class ValidAccount implements IAccount {
    private final Client _holder;
    private final UUID _identifier;
    private double _balance;

    protected ValidAccount(Client client, double balance) {
        _holder = client;
        _balance = balance;

        _identifier = UUID.randomUUID();
    }

    @Override
    public final Client getHolder() {
        return _holder;
    }

    @Override
    public final UUID getIdentifier() {
        return _identifier;
    }

    @Override
    public final double getBalance() {
        return _balance;
    }

    @Override
    public final void withdraw(double sum) {
        sum = -sum;

        if (canWithdraw(sum)) {
            _balance += getFullSum(sum);
        }
    }

    @Override
    public final void recharge(double sum) {
        _balance += sum + getFullSum(sum);
    }

    @Override
    public final void transfer(UUID accountId, double sum) {
        IAccount account = _holder.getAccount(accountId);

        if (account != null) {
            withdraw(sum);
            account.recharge(sum);
        }
    }


    @Override
    public abstract boolean canWithdraw(double sum);

    protected abstract double getFullSum(double sum);
}
