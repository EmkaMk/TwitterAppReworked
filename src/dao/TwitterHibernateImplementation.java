package dao;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entities.Tweet;

public class TwitterHibernateImplementation implements TwitterDao {

	SessionFactory sessionFactory;

	public TwitterHibernateImplementation(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Tweet> read() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Publication");
		List<Tweet> list = query.list();
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public void save(Tweet tweet) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(tweet);
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		} finally {
			session.close();
		}
	}

}
