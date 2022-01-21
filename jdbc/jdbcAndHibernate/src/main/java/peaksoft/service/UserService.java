package peaksoft.service;

import peaksoft.dao.UserDao;
import peaksoft.dao.UserDaoJdbcImpl;
import peaksoft.model.User;

import java.util.List;

public interface UserService {


    void createUsersTable();

    void dropUsersTable();

    void saveUser(String name, String lastName, byte age);


    void removeUserById(long id);

    List<User> getAllUsers();

    void cleanUsersTable();
}

