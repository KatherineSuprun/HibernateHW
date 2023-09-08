package dao;

import entity.User;

public interface UserDao {

    void saveUser(User user);

    User getUserById(long id);

}