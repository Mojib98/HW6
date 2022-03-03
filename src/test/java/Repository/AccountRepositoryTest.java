package Repository;

import Entity.Account;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class AccountRepositoryTest {
  static   AccountRepository accountRepository;
     static SessionFactory sessionFactory;
    Account accountT;
    @BeforeAll
    public static void connection() throws SQLException, ClassNotFoundException {

         sessionFactory = SessionFactorySingleton.getInstance();
         accountRepository = new AccountRepository();


    }
    @BeforeEach
    public void create(){
         accountT = new Account("13","majid","14","mashad","12","ACtive",10);

        try (var session = sessionFactory.openSession()) {
            var transaction = session.beginTransaction();
            session.save(accountT);
            transaction.commit();
        }
    }
    @AfterEach
    public void clear(){
        try (var session = sessionFactory.openSession()) {
            var transaction = session.beginTransaction();
            session.delete(accountT);
            transaction.commit();
        }

    }




    @Test
    void createAccount() {
        Account account = new Account("12","mojib","13","mashad","ss","active",10);
        accountRepository.createAccount(account);
        String id = account.getId();
        Account accpunt;
        try (var session = sessionFactory.openSession()) {
            var transaction = session.beginTransaction();
                 accpunt= session.find(Account.class,id);
                System.out.println(accpunt);
        }
        assertEquals(account.getId(),accpunt.getId());

    }

    @Test
    void deposit() throws SQLException {

        Long before = accountT.getAmount();
        String id = accountT.getId();
        accountRepository.deposit(10,id);
        Account accpunt;
        try (var session = sessionFactory.openSession()) {
            accpunt= session.find(Account.class,id);
        }
        System.out.println(accountT.getAmount()+" "+accpunt.getAmount());
        assertEquals(accountT.getAmount()+10,accpunt.getAmount());

    }

    @Test
    void withdraw() throws SQLException {

        Long before = accountT.getAmount();
        String id = accountT.getId();
        accountRepository.withdraw(accountT.getAmount(),accountT.getId());
        Account accpunt;
        try (var session = sessionFactory.openSession()) {
            accpunt= session.find(Account.class,id);
        }
        System.out.println(accountT.getAmount()+" "+accpunt.getAmount());
        assertEquals(0,accpunt.getAmount());
    }

    @Test
    void howMuchHave() throws SQLException {
        String id = accountT.getId();
       Long howe= accountRepository.howMuchHave(accountT.getId());
        Account accpunt;
        try (var session = sessionFactory.openSession()) {
            accpunt= session.find(Account.class,id);
        }
        System.out.println(accountT.getAmount()+" "+accpunt.getAmount());
        assertEquals(howe,accountT.getAmount());
    }

    }
