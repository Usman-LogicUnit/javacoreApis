package model;

public class Price {

	int priceId, productId;
	float price;
	String validFrom, validTo;

	public Price() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Price(int priceId, int productId, float price, String validFrom, String validTo) {
		super();
		this.priceId = priceId;
		this.productId = productId;
		this.price = price;
		this.validFrom = validFrom;
		this.validTo = validTo;
	}

	public int getPriceId() {
		return priceId;
	}

	public void setPriceId(int priceId) {
		this.priceId = priceId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getValidFrom() {
		return validFrom;
	}

	public void setValidFrom(String validFrom) {
		this.validFrom = validFrom;
	}

	public String getValidTo() {
		return validTo;
	}

	public void setValidTo(String validTo) {
		this.validTo = validTo;
	}

}
