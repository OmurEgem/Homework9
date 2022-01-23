package peaksoft.dao;

import peaksoft.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static peaksoft.util.Util.connect;

public class UserDaoJdbcImpl implements UserDao {

    public UserDaoJdbcImpl() {

    }

    public void createUsersTable() {
        try(Connection conn = connect();
            Statement stmt = conn.createStatement();
        ) {
            String SQL = "CREATE TABLE IF NOT EXISTS users (id SERIAL not null , name varchar (50) not null,lastName varchar(50) not null,age int not null,PRIMARY KEY (id));";

            stmt.executeUpdate(SQL);
            System.out.println("Таблица кошулду");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void dropUsersTable() {
        try(Connection conn = connect();
            Statement stmt = conn.createStatement();
        )
        {
            String SQL = "DROP TABLE IF EXISTS users";
            stmt.executeUpdate(SQL);
            System.out.println("Таблица алынды");
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public void saveUser(String name, String lastName, int age) {
        String SQL ="INSERT INTO users(name,lastName,age) VALUES(?,?,?)";

        try(Connection conn = connect();
            PreparedStatement prstmt = conn.prepareStatement(SQL)){
            prstmt.setString(1,name);
            prstmt.setString(2,lastName);
            prstmt.setInt(3,age);
            prstmt.executeUpdate();
            System.out.println(name+"  базага кашулду");
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public void removeUserById(long id) {
        try(Connection conn = connect();
            Statement stmt = conn.createStatement();
        )
        {
            String SQL = "Delete  from users where id=1";
            stmt.executeUpdate(SQL);
            System.out.println("Удалили по id");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<User> getAllUsers() {
        List<User> list = new ArrayList<>();
        String SQL = "SELECT * FROM users";
        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQL)) {
            while (rs.next()) {
                User usera = new User();
                usera.setId((long) rs.getInt("id"));
                usera.setName(rs.getString("name"));
                usera.setLastName(rs.getString("lastName"));
                usera.setAge((byte) rs.getInt("age"));
                list.add(usera);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage()); }
        return list;
    }

    public void cleanUsersTable() {
        try(Connection conn = connect();
            Statement stmt = conn.createStatement();
        )
        {
            String SQL = "Delete  from users ";
            stmt.executeUpdate(SQL);
            System.out.println("очистили таблицу");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}