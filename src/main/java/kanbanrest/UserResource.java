package kanbanrest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import fr.istic.taa.jaxrs.domain.Pet;
import io.swagger.v3.oas.annotations.Parameter;
import kanbandao.UserDao;
import kanbanjpa.User;




@Path("/user")
@Produces({"application/json", "application/xml"})
public class UserResource {

	@GET
	@Path("/{id}")
	public User getUserById(@PathParam("id") Long UserId)  {
		// return user
		UserDao userDao = new UserDao();
	    return userDao.findOne(UserId);
	}

	@POST
	@Consumes("application/json")
	public Response addUser(
			@Parameter(description = "", required = true) User user) {
	    // add user
		UserDao userDao = new UserDao();
	    userDao.save(user);
		return Response.ok().entity("SUCCESS").build();
	}
			

	@DELETE
	@Path("/{userId}")
	public Response deleteUserById(@PathParam("UserId") Long UserId)  {
		
		UserDao userDao = new UserDao();
		User user = userDao.findOne(UserId);
		if(user == null) {
			return Response.noContent().build();
		}
		else {
			userDao.deleteById(UserId);;
			return Response.ok().build();
		}
	    
	}
}
