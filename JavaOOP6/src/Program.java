import banking.*;

public class Program {
    public static void main(String[] args) {
        Client c = new Client.Builder("a", "a")
                .lastName("b")
                .address("Pushkin st., Kolotushkin's house")
                .passport("1337 228322")
                .build();

        IAccountFactory factory = new AccountFactory();

        IAccount a1 = factory.createChecking(c, 15000);
        IAccount a2 = factory.createCredit(c, 2000, 5000);

        c.addAccount(a1);
        c.addAccount(a2);
    }
}
