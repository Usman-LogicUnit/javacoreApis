package dao;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;

import model.ProductSpecification;

public class ProductDao {

	public ProductDao() {
		super();
		// TODO Auto-generated constructor stub

	}

	ClientConfig clientConfig = new ClientConfig();
	Client client = ClientBuilder.newClient(clientConfig);

	public ProductSpecification addProduct(ProductSpecification product) {
		WebTarget webTarget = client.target(
				"http://localhost:8083/Apps/PMS/HULM/7b64206f-1435-438a-8b1c-42aee9d0cec3/ProductCatalogService")
				.path("/productSpecification");
		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON)
				.header(HttpHeaders.AUTHORIZATION, "Bearer usman");
		Response response = invocationBuilder.post(Entity.entity(product, MediaType.APPLICATION_JSON));
		ProductSpecification responseProduct=new ProductSpecification();
		responseProduct = response.readEntity(ProductSpecification.class);
		return responseProduct;
	}

	public List<ProductSpecification> getProductById(String productId) {

		WebTarget webTarget = client.target(
				"http://localhost:8083/Apps/PMS/HULM/7b64206f-1435-438a-8b1c-42aee9d0cec3/ProductCatalogService")
				.path("/productSpecification").path(productId);
		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON)
				.header(HttpHeaders.AUTHORIZATION, "Bearer usman");
		Response response = invocationBuilder.get();
		List<ProductSpecification> products=new ArrayList<ProductSpecification>();
		 products = response.readEntity(new GenericType<List<ProductSpecification>>() {
		});
//		 System.out.println(products.get(0).getUnitsOfMeasure().get(0).ProductSpecification_Id);
		return products;
	}

	public ProductSpecification updateProduct(ProductSpecification product) {
		WebTarget webTarget = client.target(
				"http://localhost:8083/Apps/PMS/HULM/7b64206f-1435-438a-8b1c-42aee9d0cec3/ProductCatalogService")
				.path("/productSpecification").path(product.getPOID());
		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON)
				.header(HttpHeaders.AUTHORIZATION, "Bearer usman");
		Response response = invocationBuilder.put(Entity.entity(product, MediaType.APPLICATION_JSON));
		product = response.readEntity(ProductSpecification.class);
		return product;
	}

}
