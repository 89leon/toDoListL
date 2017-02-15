package il.ac.hit.tags;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.Path;

/**
 * 
 * @author 89leo
 * This class is example of use of tags
 */
@Path("/helloworld")
public class HelloWorld {

		@GET
		@Produces("text/plain")
		public String getClichedMessage() {
			return "Hello World";
	}
}