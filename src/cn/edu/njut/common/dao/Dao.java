package cn.edu.njut.common.dao;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Dao implements IDao {
	private static Configuration configuration;
	private static SessionFactory sessionFactory;
	private Session session;
	static {
		configuration = new Configuration();
		sessionFactory = configuration.configure().buildSessionFactory();
	}

	public void finalize() {
		if (session != null)
			session.close();
	}

	public <T> boolean save(T model) { // 鎸佷箙鍖栧璞�
		boolean bool = false;
		session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(model);
			tx.commit();
			bool = true;
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
				bool = false;
			}
		}
		if (session != null)
			session.close();
		return bool; // true-鎿嶄綔鎴愬姛 false-鎿嶄綔澶辫触
	}

	public <T> boolean update(T model) { // 鏇存柊�?硅薄
		boolean bool = false;
		session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.saveOrUpdate(model);
			tx.commit();
			bool = true;
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
				bool = false;
			}
		}
		return bool; // true-鎿嶄綔鎴愬姛 false-鎿嶄綔澶辫触
	}

	public <T> boolean delete(T model) { // 鍒犻櫎�?硅薄
		boolean bool = false;
		session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.delete(model);
			tx.commit();
			bool = true;
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
				bool = false;
			}
		}
		return bool; // true-鎿嶄綔鎴愬姛 false-鎿嶄綔澶辫触
	}

	public List getByHql(String hql) // 閫氳繃hql璇彞鏌ヨ
	{
		session = sessionFactory.openSession();
		List list = null;
		try {
			Query q = session.createQuery(hql);
			list = q.list();
		} catch (Exception e) {
			e.printStackTrace();
			list = null;
		}
		if (session != null)
			session.close();
		return list;
	}

	public <T, PK extends Serializable> Object get(Class<T> entityClass, PK id) { // 鑾峰彇�?硅薄
		Object object = null;
		session = sessionFactory.openSession();
		try {
			object = session.get(entityClass, id);
		} catch (Exception e) {
			object = null;
		}
		return object;
	}

	public Object getOne(String hql) { // 鑾峰彇涓�釜瀵硅�?
		Object object = null;
		session = sessionFactory.openSession();
		try {
			Query q = session.createQuery(hql);
			Iterator iter = q.list().iterator();
			object = iter.next();
		} catch (Exception e) {
			object = null;
		}
		if (session != null)
			session.close();
		return object;
	}
	
	public List findBySQL(String sql) {
		session = sessionFactory.openSession();
		List list = null;
		try{
			list = session.createSQLQuery(sql).list();
		} catch(Exception e) {
			list = null;
			e.printStackTrace();
		}
		if(session != null)
			session.close();
		return list;
	}
}













