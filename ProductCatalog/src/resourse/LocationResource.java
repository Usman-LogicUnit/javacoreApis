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

import dao.LocationDao;
import model.Location;

@Path("/locations")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LocationResource {
	Location location = new Location();
	LocationDao locationDao = new LocationDao();

	@GET
	public List<Location> GetLocation() {
		return locationDao.getLocations();
	}

	@GET
	@Path("/{product_id}")
	public List<Location> GetLocation(@PathParam("product_id") int product_id) {
		return locationDao.getLocationsOfProducts(product_id);
	}

	@POST
	public Location AddLocationOfProduct(Location location) {
		return locationDao.addLocationForProduct(location);
	}
	
	@PUT
	@Path("/{location_id}")
	public Location UpdateLocationById(@PathParam("location_id") int location_id,Location location) {
		location.setLocationId(location_id);
		return locationDao.updateLocation(location);
	}
	
	@DELETE
	@Path("/{location_id}")
	public void DeleteLocationOfProduct(@PathParam("location_id") int location_id) {
		 locationDao.deleteLocationOfProduct(location_id);
	}
	
	
}
