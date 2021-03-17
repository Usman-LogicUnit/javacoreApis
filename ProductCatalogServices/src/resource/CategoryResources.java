package resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dao.CategoryDao;
import model.Category;

@Path("/Categories")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CategoryResources {

	CategoryDao categoryDao = new CategoryDao();

	@POST
	public Category AddCategory(Category category) {
		return categoryDao.newCategory(category);
	}

}
