package peaksoft.util;


import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Util {
//    private static final String url = "jdbc:postgresql://localhost:5432/postgres";
//    private static final String user = "postgres";
//    private static final String password = "1234";
//    private static SessionFactory session = buildSessionFactory();
//
//    public static Connection connect() {
//        Connection conn = null;
//        try {
//            conn = DriverManager.getConnection(url, user, password);
//            System.out.println("Конекшен болду");
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//        return conn;
//    }
//    private static SessionFactory buildSessionFactory() {
//        try {
//
//            return new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
//        } catch (Throwable ex) {
//            System.out.println("Session not created : " + ex);
//
//            throw new ExceptionInInitializerError(ex);
//        }
//    }
//
//    public static SessionFactory getSession(){
//        return session;
//    }
//
//    public static void shutDown(){
//        getSession().close();
//    }

    private static SessionFactory buildSessionFactory() {
        Properties properties = new Properties();

        properties.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
        properties.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/postgres");
        properties.setProperty("hibernate.connection.username", "postgres");
        properties.setProperty("hibernate.connection.password", "1234");
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        properties.setProperty("hibernate.show_sql", "true");
        properties.setProperty("hibernate.hbm2ddl.auto", "update");
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(peaksoft.model.User.class);
        configuration.setProperties(properties);
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        System.out.println("Хибернейтке кошулду");

        return configuration.buildSessionFactory(serviceRegistry);
    }

    public static SessionFactory getSessionFactory() {
        return buildSessionFactory();
    }

    public static void shutDown() {
        getSessionFactory().close();
    }
}
