import Entity.Account;
import Repository.AccountRepository;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.nio.channels.AcceptPendingException;
import java.sql.SQLException;

public class MainTest {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //var registry = new StandardServiceRegistryBuilder().configure()
                //.build();
                /*var sesianFactory = new MetadataSources(registry)
                .buildMetadata()
                .buildSessionFactory();*/
        AccountRepository accountRepository = new AccountRepository();
        Account account = new Account("12","mojib","111111","1111","1312","jj",0);
        accountRepository.createAccount(account);
    }
}
