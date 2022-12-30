package ru.gb.springPart1;

import org.hibernate.Session;

import java.util.List;
import java.util.Optional;

public class UserDaoImpl implements UserDao {

    public UserDaoImpl(SessionFactoryUtils sessionFactoryUtils) {
        this.sessionFactoryUtils = sessionFactoryUtils;
    }

    private SessionFactoryUtils sessionFactoryUtils;

    public UserDaoImpl() {
    }

    @Override
    public Optional<User> findById(Long id) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            Optional<User> user = Optional.ofNullable(session.get(User.class, id));
            session.getTransaction().commit();
            return user;
        }
    }

    @Override
    public Optional<User> findByName(String name) {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            Optional<User> user = Optional.ofNullable(session
                    .createQuery("select user from User user where user.name = :name", User.class)
                    .setParameter("name", name)
                    .getSingleResult());

            session.getTransaction().commit();
            return user;
        }
    }


    @Override
    public List<User> findAll() {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            List<User> users = session.createQuery("select u from User u").getResultList();
            session.getTransaction().commit();
            return users;
        }
    }

}
