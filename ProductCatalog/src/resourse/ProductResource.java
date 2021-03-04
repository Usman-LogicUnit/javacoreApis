package resourse;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dao.ProductDao;
import model.Product;

@Path("/products")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductResource {

	Product product = new Product();
	ProductDao productDao = new ProductDao();

	@POST
	public Product AddProduct(Product product) {
		return productDao.addNewProduct(product);
	}

	@GET
	public List<Product> AllProducts() {
		return productDao.getallProducts();
	}

	@GET
	@Path("/{productId}")
	public List<Product> Product(@PathParam("productId") int productId) {
		return productDao.getProductById(productId);
	}

	@PUT
	@Path("/{productId}")
	public Product UpdateProductById(@PathParam("productId") int productId, Product product) {
		product.setProductId(productId);
		return productDao.updateProduct(product);

	}

	@DELETE
	@Path("/{productId}")
	public void DeleteProductById(@PathParam("productId") int productId) {
		productDao.deleteProduct(productId);
	}
}
