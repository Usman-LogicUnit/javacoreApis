package resourse;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dao.PriceDao;
import model.Price;


@Path("/prices")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PriceResource {
	Price price=new Price();
	PriceDao pricedao=new PriceDao();
	
	@GET
	public List<Price> GetPrice(){
		return pricedao.getPrices();
	}
	
	@GET
	@Path("/{productId}")
	public List<Price> GetPricesOfProduct(@PathParam("productId") int productId){
		return pricedao.getPricesOfProduct(productId);
	}
	
	@POST
	public Price AddPriceOfProduct(Price price) {
		return pricedao.addPriceForProduct(price);
	}
	
	@DELETE
	@Path("/{priceId}")
	public void DeletePriceOfProduct(@PathParam("priceId") int priceId) {
		pricedao.deletePriceOfProduct(priceId);
	}
}
