package banking;

import java.time.Duration;
import java.util.Calendar;
import java.util.Date;

public final class DepositAccount extends ValidAccount {
    private final Date _date;
    private final double _percents;

    DepositAccount(Client client, double balance, Duration timespan, double percents) {
        super(client, balance);

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, (int) timespan.toDays());
        _date = calendar.getTime();

        _percents = percents;
    }

    @Override
    public boolean canWithdraw(double sum) {
        return _date.after(Calendar.getInstance().getTime()) && (getBalance() - sum) >= 0;
    }

    @Override
    protected double getFullSum(double sum) {
        return sum;
    }
}
