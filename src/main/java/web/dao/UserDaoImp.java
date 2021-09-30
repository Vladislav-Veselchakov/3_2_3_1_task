package web.dao;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

//   @Autowired
//   private SessionFactory sessionFactory;

   @PersistenceContext
   EntityManager entityManager;

   @Override
   @Transactional
   public void add(User user) {
      // sessionFactory.getCurrentSession().save(user);
      entityManager.persist(user);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> getUsers() {
      //TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return entityManager.createQuery("SELECT u FROM User u").getResultList();
   }

}
