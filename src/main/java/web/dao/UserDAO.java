package web.dao;

import web.entity.User;

import java.util.List;

public interface UserDAO {
    public List<User> showUsers();

    public User showUserById(int id);

    public void addUser(User user);

    public void updateUser(int id, User user);

    public void deleteUser(int id);

}
