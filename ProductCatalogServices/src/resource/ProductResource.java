package resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dao.ProductDao;
import model.ProductSpecification;

@Path("/productInfo")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductResource {
	ProductSpecification product = new ProductSpecification();
	ProductDao productDao = new ProductDao();

	@POST
	public ProductSpecification AddProduct(ProductSpecification product) {
		return productDao.addProduct(product);
	}
	
	@GET
	@Path("/{productId}")
	public List<ProductSpecification> GetProduct(@PathParam("productId") String productId) {
		return productDao.getProductById(productId);
	}

	@PUT
	@Path("/{productId}")
	public ProductSpecification UpdateProduct(@PathParam("productId") String productId,ProductSpecification product) {
		product.setPOID(productId);
		return productDao.updateProduct(product);
	}
}
