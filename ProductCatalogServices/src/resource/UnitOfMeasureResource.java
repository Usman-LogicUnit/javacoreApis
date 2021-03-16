package resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dao.UnitOfMeasureDao;
import model.ProductSpecification;
import model.UnitsOfMeasure;

@Path("/unitsOfMeasure")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UnitOfMeasureResource {
	UnitsOfMeasure unitOfMeasure = new UnitsOfMeasure();
	UnitOfMeasureDao unitOfMeasureDao = new UnitOfMeasureDao();

	@POST
	@Path("/product/{productId}")
	public ProductSpecification AddUnitOfMeasure(@PathParam("productId") String productId,
			ProductSpecification product) {
		return unitOfMeasureDao.addUnitOfMeasure(product, productId);
	}

	@GET
	public String Test() {
		return "working";
	}
}
