package egen;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class UserDAO {

	@PersistenceContext
	private EntityManager entityManager;
	public List<User> findAll() {
		TypedQuery<User> query1 = entityManager.createQuery(
				"SELECT u FROM User u", User.class); // User is case sensitive
		List<User> userslist = query1.getResultList();
		return userslist;
	}

	public User findOne(String id) throws UserNotFoundException {
		return entityManager.find(User.class, id);
	}

	public User createUser(User user) throws BadRequestByUser {
		entityManager.persist(user);
		return user;
	}

	public User update(String id, User user) throws UserNotFoundException {
		return entityManager.merge(user);
	}
	public User delete(String id) throws UserNotFoundException {
		User user = entityManager.find(User.class, id);
		entityManager.remove(user);
		return user;
	}
}
