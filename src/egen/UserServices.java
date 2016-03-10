package egen;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServices {
	
	private String validateName = "[A-Za-z]+";
	private String validateEmail = "[A-Za-z0-9]+(@gmail.com|@yahoo.com|@outlook.com|@mail.com|@inbox.com|@gmail.co.in)";
	
	@Autowired
	UserDAO userDAO;
	
	public List<User> findAll() {/*
		List<User> user = new ArrayList<User>(store.values());
		return user;
	*/
		List<User>  user = userDAO.findAll();
		 return user;
		}

	public User findOne(String id) throws UserNotFoundException {/*
		if (store.containsKey(id)) {
			return store.get(id);
		} else {
			throw new UserNotFoundException();
		}
	*/
		User user = userDAO.findOne(id);
		if(user != null)
		{
			return user;
		}
		else
		{
			throw new UserNotFoundException();
		}
	}

	public User createUser(User user) throws BadRequestByUser {/*
		user.setId(user.hashCode() + "");
		if (user.getFname().matches(validateName)
				&& user.getLname().matches(validateName)
				&& user.getEmail().matches(validateEmail)) {
			store.put(user.getId(), user);
			return user;
		} else {
			throw new BadRequestByUser();
		}

	*/
		user.setId(user.hashCode()+"");
		if(user.getFname().matches(validateName) && user.getLname().matches(validateName)  && user.getEmail().matches(validateEmail) )
		{
			userDAO.createUser(user);
			return user;
		}
		else
		{
			throw new BadRequestByUser();
		}
	}

	public User update(String id, User user) throws UserNotFoundException {/*
		if (store.containsKey(id)) {
			return store.put(id, user);
		} else {
			throw new UserNotFoundException();
		}
	*/
		User user1 = userDAO.findOne(id);
		if(user1 != null)
		{
			return userDAO.update(id,user);
		}
		else
		{
			throw new UserNotFoundException();
		}
	}
	public User delete(String id) throws UserNotFoundException {/*
		if (store.containsKey(id)) {
			return store.remove(id);
		} else {
			throw new UserNotFoundException();
		}
	*/
		User user1 = userDAO.findOne(id);
		if(user1 != null)
		{
			return userDAO.delete(id);
		}
		else
		{
			throw new UserNotFoundException();
		}
	}
}
