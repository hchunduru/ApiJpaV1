package egen;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {


	@Autowired
	private UserServices service;
	
	@RequestMapping(method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<User> findAll()
	{
		// First request will come here
		// Services has returned a list of Users
		// Since produce = Application_JSON_value and list will be converted to Json and the convertion is done using Jackson and spark Gson is used
		// Hence the entire list will be converted to Java Script Object
		// Json views could be used to hide few properties
		// Swagger is used t document all of our end points so it will be usefull for the UI developers to see all the end points and develop the api
		
		//Reflection is process to manuplating the classs or object or methods in run time without even knowing the name of the class or method is called refelction.
		//This will happen when clsss is loader in the class loader meta data information is also loaded in heap memory hence they can be used by programer, IDE , Debuggers etc.
		// This is called reflection
		
		// Swagger it has swagger core and swagger_ui
		// swagger core will read all JSON file and swagger_ui will display, will show all the end point.
		return service.findAll();
	}
	@RequestMapping(value = "{id}" ,method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public User  findOne(@PathVariable("id") String id ) throws UserNotFoundException 
	{
		return service.findOne(id);
	}
	@RequestMapping(method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public User create(@RequestBody User user) throws BadRequestByUser
	{
		return service.createUser(user);
	}
	@RequestMapping(value = "{id}" , method=RequestMethod.PUT,consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public User update(@PathVariable("id") String id ,@RequestBody User user) throws UserNotFoundException
	{
		return service.update(id, user);
	}
	@RequestMapping(value = "{id}" , method=RequestMethod.DELETE,consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public User delete(@PathVariable("id") String id ) throws UserNotFoundException
	{
		return service.delete(id);
	}

}
