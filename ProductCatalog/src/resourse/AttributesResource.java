package resourse;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dao.AttributesDao;
import model.Attributes;

@Path("/attributes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AttributesResource {

	Attributes attribute=new Attributes();
	AttributesDao attributesDao=new AttributesDao();
	
	@GET
	public List<Attributes> GetAllAttributes(){
		return attributesDao.getAllAttributes();
	}
	
	@GET
	@Path("/{product_id}")
	public List<Attributes> GetAttributesOfProduct(@PathParam("product_id") int product_id){
		return attributesDao.getAttributesOfProduct(product_id);
	}
	
	@POST
	public Attributes AddAttributeForProduct(Attributes attribute) {
		return attributesDao.addAttributeOfProduct(attribute);
	}
	
	@PUT
	@Path("/{attribute_id}")
	public Attributes UpdateAttribute(@PathParam("attribute_id") int attribute_id,Attributes attribute) {
		attribute.setId(attribute_id);
		return attributesDao.updateAttribute(attribute);
	}
}
