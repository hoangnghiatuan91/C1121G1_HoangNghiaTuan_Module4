package image.repository.impl;

import image.model.ImageOfDay;
import image.repository.ImageOfDayRepository;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ImageOfDayRepositoryImpl implements ImageOfDayRepository {

    private static SessionFactory sessionFactory;
    private static EntityManager entityManager;

    static {
        try {
            sessionFactory = new Configuration().configure("hibernate.conf.xml").buildSessionFactory();
//            sessionFactory.close();
            entityManager = sessionFactory.createEntityManager();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<ImageOfDay> findAll() {
        String queryString = "select i from ImageOfDay as i";
        TypedQuery<ImageOfDay> query = entityManager.createQuery(queryString, ImageOfDay.class);
        return query.getResultList();
    }

    @Override
    public ImageOfDay findById(Long id) {
        String queryString = "select i from ImageOfDay as i where i.id = :id";
        TypedQuery<ImageOfDay> query = entityManager.createQuery(queryString, ImageOfDay.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public void save(ImageOfDay imageOfDay) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            imageOfDay.setLikeTotal(0);
            session.saveOrUpdate(imageOfDay);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public ImageOfDay update(ImageOfDay imageOfDay) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            ImageOfDay origin = findById(imageOfDay.getId());
            origin.setRating(imageOfDay.getRating());
            origin.setAuthor(imageOfDay.getAuthor());
            origin.setMessage(imageOfDay.getMessage());
            session.saveOrUpdate(origin);
            transaction.commit();
            return origin;
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return null;
    }

    @Override
    public ImageOfDay like(Long id) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            ImageOfDay origin = findById(id);
            origin.setLikeTotal(origin.getLikeTotal() + 1);
            session.saveOrUpdate(origin);
            transaction.commit();
            return origin;
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return null;
    }

}
