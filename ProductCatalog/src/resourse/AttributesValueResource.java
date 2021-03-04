package resourse;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dao.AttributeValueDao;
import model.Values;

@Path("/attributevalues")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AttributesValueResource {

	AttributeValueDao attributeValueDao=new AttributeValueDao();
	Values values=new Values();
	
	@GET
	public List<Values> GetAllAttributeValues(){
		return attributeValueDao.getAllAttributeValues();
	}
	
	@POST
	public Values AddAttributeValueOfAttribute(Values value) {
		return attributeValueDao.addAttributeValue(value);
	}
	
	@GET
	@Path("/{attribute_id}")
	public List<Values> GetAllAttributeValuesByID(@PathParam("attribute_id")int attribute_id){
		return attributeValueDao.getAllAttributeValuesByID(attribute_id);
	}
}
