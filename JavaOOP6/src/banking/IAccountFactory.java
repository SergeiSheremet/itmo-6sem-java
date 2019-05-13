package banking;

import java.time.Duration;

public interface IAccountFactory {
    IAccount createChecking(Client client, double balance);

    IAccount createDeposit(Client client, double balance, Duration time);

    IAccount createCredit(Client client, double balance, double limit);
}
