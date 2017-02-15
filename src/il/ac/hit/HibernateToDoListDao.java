package il.ac.hit;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import il.ac.hit.model.Factory;
import il.ac.hit.model.ITodoListDao;
import il.ac.hit.tables.Tasks;
import il.ac.hit.tables.Users;

public class HibernateToDoListDao implements ITodoListDao {
/**
 * factory - configuration object that configurates Hibernate and allows a session to be init-ed
 * thread safe - used by all threads in application.
 */
	private SessionFactory factory;
	private Session session;
	/**
	 *  
	 */
	public HibernateToDoListDao(){
		factory = Factory.getSessionFactory();
	}
	/**
	 *  Adding a new user.
	 */
	@Override
	public void addUser(Object item) {
		session = factory.openSession();
		session.beginTransaction();
		session.save(item);
		session.getTransaction().commit();
		session.close();
	}
	/**
	 * deletes a user 
	 * @param item
	 */
	@Override
	public void deleteTask(Object item) {
		session = factory.openSession();
		session.beginTransaction();
		session.delete(item);
		session.getTransaction().commit();
		session.close();
	}
/**
 * updates Task
 * @param item
 * 
 */
	@Override
	public void updateTask(Object item) {
		session = factory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(item);
		session.getTransaction().commit();
		session.close();
	}
/**
 * returns Users
 * @return Users
 * @param password
 */
	@Override
	public Users getUser(String name,String password) {
		session = factory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("FROM users WHERE username='"+name+"' and "+"password='"+password+"'");
		Users userToReturn = (Users)query.uniqueResult();
		session.getTransaction().commit();
		session.close();
		return userToReturn;
	}

	@SuppressWarnings("unchecked")
	@Override
	/**
	 * returns list of users
	 * @return List
	 * @param user
	 */
	public List<Tasks> getTasks(String user) {
		session = factory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("FROM Tasks WHERE user = ?");
		query.setString(0, user);
	    List<Tasks> tasksToReturn = query.list();
		session.getTransaction().commit();
		session.close();
		return (List<Tasks>)tasksToReturn;
	}
/**
 * return 1 task
 * @param id
 * @return Object
 */
	@Override
	public Object getTask(Object id) {
		session = factory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("FROM Tasks WHERE id = ?");
		System.out.println(id.getClass());
		query.setInteger(0, (int) id);
        Tasks taskToReturn = (Tasks) query.uniqueResult();
		session.getTransaction().commit();
		session.close();
		return taskToReturn;
	}

}
