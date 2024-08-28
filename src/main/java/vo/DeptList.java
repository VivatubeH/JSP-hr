package vo;

public class DeptList {

	private int id; // 부서 아이디
	private String departmentName; // 부서명
	private String managerName; // 관리자명
	private String city; // 소재지 도시명
	private int cnt; // 부서 소속 직원수
	
	public DeptList() {} // 기본 생성자

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
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

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	@Override
	public String toString() {
		return "DeptList [id=" + id + ", departmentName=" + departmentName + ", managerName=" + managerName + ", city="
				+ city + ", cnt=" + cnt + "]";
	}
	
}
