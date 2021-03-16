package dao;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;

import model.ProductSpecification;

public class UnitOfMeasureDao {

	public UnitOfMeasureDao() {
		super();
		// TODO Auto-generated constructor stub
	}

	ClientConfig clientConfig = new ClientConfig();
	Client client = ClientBuilder.newClient(clientConfig);
	ProductSpecification product = new ProductSpecification();

	public ProductSpecification addUnitOfMeasure(ProductSpecification product, String productId) {
		WebTarget webTarget = client.target(
				"http://localhost:8083/Apps/PMS/HULM/7b64206f-1435-438a-8b1c-42aee9d0cec3/ProductCatalogService")
				.path("/productSpecification").path(productId);
		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON)
				.header(HttpHeaders.AUTHORIZATION, "Bearer usman");
		Response response = invocationBuilder.put(Entity.entity(product, MediaType.APPLICATION_JSON));
		System.out.println(response);

		return product;
	}
}
