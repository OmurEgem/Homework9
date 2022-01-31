package peaksoft.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import peaksoft.model.User;
import peaksoft.util.Util;

import java.util.ArrayList;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    private Session session;
    private Transaction transaction;

    public UserDaoHibernateImpl() {

    }

    public Session getSession() {
        return session;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public Session openSession() {
        return Util.getSessionFactory().openSession();
    }

    public Session openTransactionSession() {
        session = openSession();
        transaction = session.beginTransaction();
        return session;
    }

    public void closeSession() {
        session.close();
    }

    public void closeTransactionSesstion() {
        transaction.commit();
        closeSession();
    }

    @Override
    public void createUsersTable() {
        try {
            openTransactionSession();
            session.createSQLQuery("").executeUpdate();
            closeTransactionSesstion();
            System.out.println("Таблица курулду");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void dropUsersTable() {
        try {
            openTransactionSession();
            session.createSQLQuery("DROP TABLE users").executeUpdate();
            closeTransactionSesstion();
            System.out.println("Таблица жок болду");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        try {
            openTransactionSession();
            Session session = getSession();
            User user = new User();
            user.setName(name);
            user.setLastName(lastName);
            user.setAge(age);
            session.save(user);
            closeTransactionSesstion();

            System.out.println("Юзер кошулду");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void removeUserById(long id) {
        try {
            openTransactionSession();
            User user = (User) session.get(User.class, id);
            session.delete(user);
            closeTransactionSesstion();
            System.out.println("Юзер ушундай " + id + " жок болду");
        } catch (Exception e) {
            System.out.println("мындай id жок");
        }
    }

    @Override
    public List<User> getAllUsers() {
        List users = new ArrayList<User>();
        try {
            openTransactionSession();
            Session session = getSession();

            users = session.createQuery("from User ").list();
            closeTransactionSesstion();
            System.out.println("Баары " + users.size() + " юзерлер");
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
        return users;

    }

    @Override
    public void cleanUsersTable() {
        try {
            openTransactionSession();
            session.createQuery("delete User").executeUpdate();
            closeTransactionSesstion();
            System.out.println("Таблица тазаланды");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

