package model;

import java.util.List;

public class DataObject {
	String productDescription, productIsBundle, productName, productNumber;
	List<UnitsOfMeasure> unitsOfMeasure;
	List<ProductSpecCharacteristic> productSpecCharacteristics;
	String offeringName, offeringDescription;
	String offeringStartDate, offeringEndDate;
	String conversionFactor;
	String productOfferingPriceName, productOfferingPriceDescription, productOfferingPriceType;
	float productOfferingPriceTaxIncludedAmountValue, productOfferingPriceDutyFreeAmountValue,
			productOfferingPriceTaxRate, productOfferingPricePercentage;
	
	//optoions and attributes....

	public DataObject() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getProductIsBundle() {
		return productIsBundle;
	}

	public void setProductIsBundle(String productIsBundle) {
		this.productIsBundle = productIsBundle;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductNumber() {
		return productNumber;
	}

	public void setProductNumber(String productNumber) {
		this.productNumber = productNumber;
	}

	public List<UnitsOfMeasure> getUnitsOfMeasure() {
		return unitsOfMeasure;
	}

	public void setUnitsOfMeasure(List<UnitsOfMeasure> unitsOfMeasure) {
		this.unitsOfMeasure = unitsOfMeasure;
	}

	public List<ProductSpecCharacteristic> getProductSpecCharacteristics() {
		return productSpecCharacteristics;
	}

	public void setProductSpecCharacteristics(List<ProductSpecCharacteristic> productSpecCharacteristics) {
		this.productSpecCharacteristics = productSpecCharacteristics;
	}

	public String getOfferingName() {
		return offeringName;
	}

	public void setOfferingName(String offeringName) {
		this.offeringName = offeringName;
	}

	public String getOfferingDescription() {
		return offeringDescription;
	}

	public void setOfferingDescription(String offeringDescription) {
		this.offeringDescription = offeringDescription;
	}

	public String getOfferingStartDate() {
		return offeringStartDate;
	}

	public void setOfferingStartDate(String offeringStartDate) {
		this.offeringStartDate = offeringStartDate;
	}

	public String getOfferingEndDate() {
		return offeringEndDate;
	}

	public void setOfferingEndDate(String offeringEndDate) {
		this.offeringEndDate = offeringEndDate;
	}

	public String getConversionFactor() {
		return conversionFactor;
	}

	public void setConversionFactor(String conversionFactor) {
		this.conversionFactor = conversionFactor;
	}

	public String getProductOfferingPriceName() {
		return productOfferingPriceName;
	}

	public void setProductOfferingPriceName(String productOfferingPriceName) {
		this.productOfferingPriceName = productOfferingPriceName;
	}

	public String getProductOfferingPriceDescription() {
		return productOfferingPriceDescription;
	}

	public void setProductOfferingPriceDescription(String productOfferingPriceDescription) {
		this.productOfferingPriceDescription = productOfferingPriceDescription;
	}

	public String getProductOfferingPriceType() {
		return productOfferingPriceType;
	}

	public void setProductOfferingPriceType(String productOfferingPriceType) {
		this.productOfferingPriceType = productOfferingPriceType;
	}

	public float getProductOfferingPriceTaxIncludedAmountValue() {
		return productOfferingPriceTaxIncludedAmountValue;
	}

	public void setProductOfferingPriceTaxIncludedAmountValue(float productOfferingPriceTaxIncludedAmountValue) {
		this.productOfferingPriceTaxIncludedAmountValue = productOfferingPriceTaxIncludedAmountValue;
	}

	public float getProductOfferingPriceDutyFreeAmountValue() {
		return productOfferingPriceDutyFreeAmountValue;
	}

	public void setProductOfferingPriceDutyFreeAmountValue(float productOfferingPriceDutyFreeAmountValue) {
		this.productOfferingPriceDutyFreeAmountValue = productOfferingPriceDutyFreeAmountValue;
	}

	public float getProductOfferingPriceTaxRate() {
		return productOfferingPriceTaxRate;
	}

	public void setProductOfferingPriceTaxRate(float productOfferingPriceTaxRate) {
		this.productOfferingPriceTaxRate = productOfferingPriceTaxRate;
	}

	public float getProductOfferingPricePercentage() {
		return productOfferingPricePercentage;
	}

	public void setProductOfferingPricePercentage(float productOfferingPricePercentage) {
		this.productOfferingPricePercentage = productOfferingPricePercentage;
	}

}
