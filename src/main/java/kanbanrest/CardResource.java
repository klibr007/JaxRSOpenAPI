package kanbanrest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import io.swagger.v3.oas.annotations.Parameter;
import kanbandao.CardDao;
import kanbanjpa.Card;



@Path("/card")
@Produces({"application/json", "application/xml"})
public class CardResource {

	
	@GET
	@Path("/{id}")
	public Card getCardById(@PathParam("id") Long cardId)  {
		// return card
		CardDao cardDao = new CardDao();
	    return cardDao.findOne(cardId);
	}
	
	@POST
	@Consumes("application/json")
	public Response addCard(
			@Parameter(description = "", required = true) Card card) {
	    // add user
		CardDao cardDao = new CardDao();
	    cardDao.save(card);
		return Response.ok().entity("SUCCESS").build();
	}
			

	@DELETE
	@Path("/{cardId}")
	public Response deleteUserById(@PathParam("UserId") Long cardId)  {
		
		CardDao cardDao = new CardDao();
		Card card = cardDao.findOne(cardId);
		if(card == null) {
			return Response.noContent().build();
		}
		else {
			cardDao.deleteById(cardId);;
			return Response.ok().build();
		}
	    
	}
}
