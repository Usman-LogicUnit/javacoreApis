package model;

import java.util.List;

public class ProductObject {
	ProductSpecification productSpecification;
	List<ProductOffering> productOffering;

	public ProductObject() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductSpecification getProductSpecification() {
		return productSpecification;
	}

	public void setProductSpecification(ProductSpecification productSpecification) {
		this.productSpecification = productSpecification;
	}

	public List<ProductOffering> getProductOffering() {
		return productOffering;
	}

	public void setProductOffering(List<ProductOffering> productOffering) {
		this.productOffering = productOffering;
	}

}
