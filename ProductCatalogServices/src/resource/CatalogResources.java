package resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dao.CatalogDao;
import model.Catalog;

@Path("/Catalogs")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CatalogResources {
	
	CatalogDao catalogDao=new CatalogDao();
	
	@POST
	public Catalog AddCatalog(Catalog catalogObject) {
		return catalogDao.newCatalog(catalogObject);
	}
	
	@GET
	@Path("/{catalogId}")
	public List<Catalog> GetCatalog(@PathParam("catalogId") String catalogId ) {
		return catalogDao.getCatalogById(catalogId);
	}
}
