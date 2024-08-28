package vo;

public class DeptDetail {

	private int departmentId; // 부서 아이디
	private String departmentName; // 부서명
	private int managerId; // 관리자 아이디
	private String managerName; // 관리자명
	private String city; // 도시명
	private String countryName; // 국가명
	
	public DeptDetail() {}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	@Override
	public String toString() {
		return "DeptDetail [departmentId=" + departmentId + ", departmentName=" + departmentName + ", managerId="
				+ managerId + ", managerName=" + managerName + ", city=" + city + ", countryName=" + countryName + "]";
	}
	
}
