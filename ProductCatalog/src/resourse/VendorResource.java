package resourse;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dao.VendorDao;
import model.Vendor;

@Path("/vendors")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class VendorResource {

	Vendor vendor = new Vendor();
	VendorDao vendorDao = new VendorDao();

	@GET
	public List<Vendor> GetAllVendors() {
		return vendorDao.getVendors();
	}

	@GET
	@Path("/{product_id}")
	public List<Vendor> GetVendorsForProduct(@PathParam("product_id") int product_id) {
		return vendorDao.getVendorsOfProduct(product_id);
	}

	@POST
	public Vendor AddVendorForProduct(Vendor vendor) {
		return vendorDao.addVendorForProduct(vendor);
	}
	
	@PUT
	@Path("/{vendor_id}")
	public Vendor UpdateVendor(@PathParam("vendor_id") int vendor_id,Vendor vendor)
	{
		vendor.setVendorId(vendor_id);
		return vendorDao.updateVendorById(vendor);
	}

}
