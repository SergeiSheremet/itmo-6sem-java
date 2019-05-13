package banking;

import java.util.UUID;

public interface IAccount {
    void withdraw(double sum);
    void recharge(double sum);
    void transfer(UUID accountId, double sum);

    Client getHolder();
    UUID getIdentifier();
    double getBalance();

    boolean canWithdraw(double sum);
}
