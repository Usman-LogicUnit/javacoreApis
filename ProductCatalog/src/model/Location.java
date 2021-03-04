package model;

public class Location {

	int locationId, productId;
	String locationName, city, state, address, phoneNumber;

	public Location() {
		super();
	}

	public Location(int locationId, int productId, String locationName, String city, String state, String address,
			String phoneNumber) {
		super();
		this.locationId = locationId;
		this.productId = productId;
		this.locationName = locationName;
		this.city = city;
		this.state = state;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
