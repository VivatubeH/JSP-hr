package vo;

public class Loc {

	private int locationId; // 소재지 아이디
	private String address; // 소재지 주소
	private String postalCode; // 소재지 우편번호
	private String city; // 소재지 도시명
	private String stateProvince; // 소재지가 속한 주
	private String countryId; // 소재지 국가 아이디
	
	public Loc() {}
	
	public Loc(int locationId, String address, String postalCode, String city, String stateProvince, String countryId) {
		super();
		this.locationId = locationId;
		this.address = address;
		this.postalCode = postalCode;
		this.city = city;
		this.stateProvince = stateProvince;
		this.countryId = countryId;
	}
	
	public int getLocationId() {
		return locationId;
	}
	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStateProvince() {
		return stateProvince;
	}
	public void setStateProvince(String stateProvince) {
		this.stateProvince = stateProvince;
	}
	public String getCountryId() {
		return countryId;
	}
	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}
	@Override
	public String toString() {
		return "Loc [locationId=" + locationId + ", address=" + address + ", postalCode=" + postalCode + ", city="
				+ city + ", stateProvince=" + stateProvince + ", countryId=" + countryId + "]";
	}
	
	public static Builder builder() {
		return new Builder();
	}
	
	public static class Builder {
		private int locationId; // 소재지 아이디
		private String address; // 소재지 주소
		private String postalCode; // 소재지 우편번호
		private String city; // 소재지 도시명
		private String stateProvince; // 소재지가 속한 주
		private String countryId; // 소재지 국가 아이디
		
		public Builder locationId(int locationId) {
			this.locationId = locationId;
			return this;
		}
		public Builder address(String address) {
			this.address = address;
			return this;
		}
		public Builder postalCode(String postalCode) {
			this.postalCode = postalCode;
			return this;
		}
		public Builder city(String city) {
			this.city = city;
			return this;
		}
		public Builder stateProvince(String stateProvince) {
			this.stateProvince = stateProvince;
			return this;
		}
		public Builder countryId(String countryId) {
			this.countryId = countryId;
			return this;
		}
		public Loc build() {
			Loc loc = new Loc(locationId, address, postalCode, city, stateProvince, countryId);
			return loc;
		}
	}
}
