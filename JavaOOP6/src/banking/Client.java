package banking;

import java.util.HashMap;
import java.util.UUID;

public class Client {
    private final String _firstName;
    private final String _lastName;
    private final String _address;
    private final String _passport;
    private final HashMap<UUID, IAccount> _accounts = new HashMap<>();

    private Client(
            String firstName,
            String lastName,
            String address,
            String passport) {
        _firstName = firstName;
        _lastName = lastName;
        _address = address;
        _passport = passport;
    }

    public String getFirstName() {
        return _firstName;
    }

    public String getLastName() {
        return _lastName;
    }

    public String getAddress() {
        return _address;
    }

    public String getPassport() {
        return _passport;
    }

    public void addAccount(IAccount account) {
        _accounts.put(account.getIdentifier(), account);
    }

    public IAccount getAccount(UUID identifier) {
        return _accounts.get(identifier);
    }

    public static class Builder {
        private String _firstName;
        private String _lastName;
        private String _address;
        private String _passport;

        public Builder(String firstName, String lastName) {
            _firstName = firstName;
            _lastName = lastName;
        }

        public Builder firstName(String firstName) {
            _firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            _lastName = lastName;
            return this;
        }

        public Builder address(String address) {
            _address = address;
            return this;
        }

        public Builder passport(String passport) {
            _passport = passport;
            return this;
        }

        public Client build() {
            return new Client(_firstName, _lastName, _address, _passport);
        }
    }
}
