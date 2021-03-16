package model;

import java.util.ArrayList;
import java.util.List;

public class ProductOffering {
	String POID, id, name, description;
	TimePeriod validFor;
	List<ProductSpecificationRef> productSpecifications = new ArrayList<>();
	List<ProductOfferingPrice> productOfferingPrices = new ArrayList<>();
	List<ProductSpecCharacteristicRef> productSpecCharacteristicRefs = new ArrayList<>();

	public ProductOffering() {
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

	public TimePeriod getValidFor() {
		return validFor;
	}

	public void setValidFor(TimePeriod validFor) {
		this.validFor = validFor;
	}

	public List<ProductSpecificationRef> getProductSpecifications() {
		return productSpecifications;
	}

	public void setProductSpecifications(List<ProductSpecificationRef> productSpecifications) {
		this.productSpecifications = productSpecifications;
	}

	public List<ProductOfferingPrice> getProductOfferingPrices() {
		return productOfferingPrices;
	}

	public void setProductOfferingPrices(List<ProductOfferingPrice> productOfferingPrices) {
		this.productOfferingPrices = productOfferingPrices;
	}

	public List<ProductSpecCharacteristicRef> getProductSpecCharacteristicRefs() {
		return productSpecCharacteristicRefs;
	}

	public void setProductSpecCharacteristicRefs(List<ProductSpecCharacteristicRef> productSpecCharacteristicRefs) {
		this.productSpecCharacteristicRefs = productSpecCharacteristicRefs;
	}

	@Override
	public String toString() {
		return "ProductOffering [POID=" + POID + ", id=" + id + ", name=" + name + ", description=" + description
				+ ", validFor=" + validFor + ", productSpecifications=" + productSpecifications
				+ ", productOfferingPrices=" + productOfferingPrices + ", productSpecCharacteristicRefs="
				+ productSpecCharacteristicRefs + "]";
	}

}
