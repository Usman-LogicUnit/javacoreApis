package model;

import java.util.ArrayList;
import java.util.List;

public class ProductSpecCharacteristicRef {
	String POID, id, name, description;
	List<ProductSpecCharValueRef> productSpecCharValues = new ArrayList<>();

	public ProductSpecCharacteristicRef() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getPOID() {
		return POID;
	}

	public void setPOID(String pOID) {
		POID = pOID;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<ProductSpecCharValueRef> getProductSpecCharValues() {
		return productSpecCharValues;
	}

	public void setProductSpecCharValues(List<ProductSpecCharValueRef> productSpecCharValues) {
		this.productSpecCharValues = productSpecCharValues;
	}

	@Override
	public String toString() {
		return "ProductSpecCharacteristicRef [POID=" + POID + ", id=" + id + ", name=" + name + ", description="
				+ description + ", productSpecCharValues=" + productSpecCharValues + "]";
	}

}
