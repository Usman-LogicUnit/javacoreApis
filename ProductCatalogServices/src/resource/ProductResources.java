package resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dao.CreateProductDao;
import model.CreateProductReturnModel;
import model.DataObject;
import model.ProductObject;
import model.ProductSpecification;
import model.UnitsOfMeasure;

@Path("/Products")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductResources {
	
	
	CreateProductDao createproductdao=new CreateProductDao();
	
	@POST
	public CreateProductReturnModel newProduct(DataObject dataObject) {
		return createproductdao.createProductWithOrWithoutVarients(dataObject);
	}
	
	@GET
	@Path("/{productId}")
	public ProductObject getProductById(@PathParam("productId") String productId) {
		return createproductdao.getProduct(productId);
	}
	
	@GET
	@Path("/{productId}/unitOfMeasures")
	public List<UnitsOfMeasure> getAllUnitOfMeasures(@PathParam("productId") String productId){
		return  createproductdao.getUnitOfMeasuresOfProduct(productId);
	}
	
	@GET
	@Path("/name/{name}")
	public List<ProductSpecification> SearchByName(@PathParam("name") String name) {
		return createproductdao.searchByName(name);
	}
}
