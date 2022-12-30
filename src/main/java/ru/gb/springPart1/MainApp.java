package ru.gb.springPart1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class MainApp {

//      Запрос №1
//    public static void main(String[] args) {
//        SessionFactory factory = new Configuration()
//                .configure("hibernate.cfg.xml")
//                .buildSessionFactory();
//
//        Session session = null;
//        try {
//            session = factory.getCurrentSession();
//            session.beginTransaction();
//            User oldUser = session.get(User.class, 1L);
//            System.out.println(oldUser);
//            session.beginTransaction().commit();
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            if (session != null) {
//                session.close();
//            }
//            if (factory != null) {
//                factory.close();
//            }
//        }
//    }



//     Запрос №2
//        EntityManagerFactory emFactory = new Configuration()
//                .configure("hibernate.cfg.xml")
//                .buildSessionFactory();
//
//        EntityManager em = emFactory.createEntityManager();
//        // INSERT
//        em.getTransaction().begin();
//
//  ///////////////////////////////////////////////////////////////////

//        User user2 = new User("user2");
//        User user3 = new User("user3");

//        em.persist(user2);
//        em.persist(user3);

    // Select
//        User user = em.find(User.class, 1L);
//  /////////////////////////////////////////////////////////
//        em.getTransaction().commit();
//        em.close();


//    Запрс №3
//    private static SessionFactory factory;
//
//    public static void init() {
//        factory = new Configuration()
//                .configure("hibernate.cfg.xml")
//                .buildSessionFactory();
//    }
//
//    public static void shutdown() {
//        if (factory != null) {
//            factory.close();
//        }
//    }
//
//    public static void main(String[] args) {
//        try {
//            init();
//
//            // SELECT
//            Session session = factory.getCurrentSession();
//            session.beginTransaction();
//            User oldUser = session.get(User.class, 2L);
//            oldUser.print();
//            session.getTransaction().commit();
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            shutdown();
//        }
//    }

    public static void main(String[] args) {

        SessionFactoryUtils sessionFactoryUtils = new SessionFactoryUtils();
        sessionFactoryUtils.init();


        try {
            UserDao userDao = new UserDaoImpl(sessionFactoryUtils);

            System.out.println(userDao.findByName("Jack2").get());

//            User user = userDao.findById(3L);
//            user.print();

//            System.out.println(userDao.findAll());
//
//            Session session = factory.getCurrentSession();
//            session.beginTransaction();
//            User oldUser = session.get(User.class, 2L);
//            oldUser.print();
//            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sessionFactoryUtils.shutdown();
        }
    }

}
