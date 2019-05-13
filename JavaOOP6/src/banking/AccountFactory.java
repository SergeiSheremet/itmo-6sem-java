package banking;

import java.time.Duration;

public class AccountFactory implements IAccountFactory {
    private int _limit = 1500;

    public IAccount createChecking(Client client, double balance) {
        CheckingAccount account = new CheckingAccount(client, balance, 3);
        return ValidateAccount(client, account);
    }

    public IAccount createDeposit(Client client, double balance, Duration timespan) {
        DepositAccount account = new DepositAccount(client, balance, timespan, balance >= 10000 ? 5 : 4);
        return ValidateAccount(client, account);
    }

    public IAccount createCredit(Client client, double balance, double limit) {
        CreditAccount account = new CreditAccount(client, balance, limit, 10);
        return ValidateAccount(client, account);
    }

    private IAccount ValidateAccount(Client client, IAccount account) {
        if ((client.getAddress() == null) || (client.getPassport() == null)) {
            account = new UnreliableAccount(account, _limit);
        }

        return account;
    }
}