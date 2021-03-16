package model;

public class CreateProductReturnModel {
	ProductSpecification productSpecification;
	ProductOffering productOffering;

	public CreateProductReturnModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductSpecification getProductSpecification() {
		return productSpecification;
	}

	public void setProductSpecification(ProductSpecification productSpecification) {
		this.productSpecification = productSpecification;
	}

	public ProductOffering getProductOffering() {
		return productOffering;
	}

	public void setProductOffering(ProductOffering productOffering) {
		this.productOffering = productOffering;
	}

}
