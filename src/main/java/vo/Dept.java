package vo;

public class Dept {

	private int departmentId; // 부서 아이디
	private String departmentName; // 부서명
	private int managerId; // 관리자 아이디
	private int locationId; // 소재지 아이디
	
	public Dept() {}

	public Dept(int departmentId, String departmentName, int managerId, int locationId) {
		super();
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.managerId = managerId;
		this.locationId = locationId;
	}

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

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	@Override
	public String toString() {
		return "Dept [departmentId=" + departmentId + ", departmentName=" + departmentName + ", managerId=" + managerId
				+ ", locationId=" + locationId + "]";
	}
	
	public static Builder builder() {
		return new Builder();
	}
	
	public static class Builder {
		private int departmentId; // 부서 아이디
		private String departmentName; // 부서명
		private int managerId; // 관리자 아이디
		private int locationId; // 소재지 아이디
		
		public Builder departmentId(int departmentId) {
			this.departmentId = departmentId;
			return this;
		}
		public Builder departmentName(String departmentName) {
			this.departmentName = departmentName;
			return this;
		}
		public Builder managerId(int managerId) {
			this.managerId = managerId;
			return this;
		}
		public Builder locationId(int locationId) {
			this.locationId = locationId;
			return this;
		}
		public Dept build() {
			Dept dept = new Dept(departmentId, departmentName
					, managerId, locationId);
			return dept;
		}
	}
}
