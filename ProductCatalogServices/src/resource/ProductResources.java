package resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dao.ProductDao;
import model.BarCode;
import model.CreateProductReturnModel;
import model.DataObject;
import model.ProductObject;
import model.ProductSpecification;
import model.UnitsOfMeasure;

@Path("/Products")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductResources {
	
	
	ProductDao productDao=new ProductDao();
	
	@POST
	public CreateProductReturnModel NewProduct(DataObject dataObject) {
		return productDao.createProductWithOrWithoutVarients(dataObject);
	}
	
	@GET
	@Path("/{productId}")
	public ProductObject GetProductById(@PathParam("productId") String productId) {
		return productDao.getProduct(productId);
	}
	
	@GET
	@Path("/{productId}/unitOfMeasures")
	public List<UnitsOfMeasure> GetAllUnitOfMeasures(@PathParam("productId") String productId){
		return  productDao.getUnitOfMeasuresOfProduct(productId);
	}
	
	@GET
	@Path("/{productId}/unitOfMeasure/default")
	public UnitsOfMeasure GetDefaultUnitOfMeasure(@PathParam("productId") String productId) {
		return productDao.getDefaultUnitOfMeasure(productId);
	}
	
	@GET
	@Path("/name/{name}")
	public List<ProductSpecification> SearchByName(@PathParam("name") String name) {
		return productDao.searchByName(name);
	}
	
	@GET
	@Path("/{productId}/barCodes")
	public List<BarCode> GetAllBarCodes(@PathParam("productId") String productId){
		return productDao.getAllBarCodes(productId);
	}
	
	@GET
	@Path("/{productId}/barCode/{barcodeId}")
	public BarCode GetBarCodeById(@PathParam("productId") String productId,@PathParam("barcodeId") String barcodeId){
		return productDao.getBarCodeById(productId,barcodeId);
	}
	
	@GET
	@Path("/barcode/{barcode}")
	public BarCode SearchBarCode(@PathParam("barcode") String searchBarCode) {
		return productDao.SearchBarCode(searchBarCode);
	}
}
