package model;

import java.util.ArrayList;
import java.util.List;

public class Attributes {
	String attributeName;
	int productId, id;
	List<Values> values = new ArrayList<>();

	public Attributes() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Attributes(String attributeName, int productId) {
		super();
		this.attributeName = attributeName;
		this.productId = productId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAttributeName() {
		return attributeName;
	}

	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public List<Values> getValues() {
		return values;
	}

	public void setValues(List<Values> values) {
		this.values = values;
	}

}
