package web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import static javax.swing.UIManager.get;

@Repository
public class UserDAOImpl implements UserDAO {


    @PersistenceContext
    private final EntityManager entityManager;

    public UserDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<User> showUsers() {
        return entityManager.createQuery("FROM User", User.class).getResultList();
    }

    @Override
    public User showUserById(int id) {
        return entityManager.find(User.class, id);
    }
    @Override
    public void addUser(User user){
        entityManager.persist(user);
    }

    @Override
    public void updateUser(int id, User user) {
        entityManager.merge(user);
    }

    @Override
    public void deleteUser(int id) {
        entityManager.remove(showUserById(id));
    }
}
