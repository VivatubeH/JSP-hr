package vo;

import java.util.Date;

public class Emp {

	private int id; // 직원 아이디
	private String firstName; // 직원 이름
	private String lastName; // 직원 성
	private String email; // 직원 이메일
	private String phoneNumber; // 직원 연락처
	private Date hireDate; // 직원 고용일자
	private String jobId; // 직원 직종 아이디
	private double salary; // 직원 월급
	private double commissionPct; // 직원 커미션
	private int managerId; // 해당 직원의 상사 아이디
	private int departmentId; // 해당 직원이 속한 부서의 아이디
	
	public Emp() {}
	
	public Emp(int id, String firstName, String lastName, String email, String phoneNumber, Date hireDate, String jobId,
			double salary, double commissionPct, int managerId, int departmentId) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.hireDate = hireDate;
		this.jobId = jobId;
		this.salary = salary;
		this.commissionPct = commissionPct;
		this.managerId = managerId;
		this.departmentId = departmentId;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Date getHireDate() {
		return hireDate;
	}
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	public String getJobId() {
		return jobId;
	}
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public double getCommissionPct() {
		return commissionPct;
	}
	public void setCommissionPct(double commissionPct) {
		this.commissionPct = commissionPct;
	}
	public int getManagerId() {
		return managerId;
	}
	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	@Override
	public String toString() {
		return "Emp [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", phoneNumber=" + phoneNumber + ", hireDate=" + hireDate + ", jobId=" + jobId + ", salary=" + salary
				+ ", commissionPct=" + commissionPct + ", managerId=" + managerId + ", departmentId=" + departmentId
				+ "]";
	}
	
	/**
	 * Builder 객체를 반환하는 builder() 메서드
	 * @return 새로운 Builder 객체
	 */
	public static Builder builder() {
		return new Builder();
	}
	
	/**
	 * 반환할 Builder 객체가 정의된 클래스
	 */
	public static class Builder {
		private int id; // 직원 아이디
		private String firstName; // 직원 이름
		private String lastName; // 직원 성
		private String email; // 직원 이메일
		private String phoneNumber; // 직원 연락처
		private Date hireDate; // 직원 고용일자
		private String jobId; // 직원 직종 아이디
		private double salary; // 직원 월급
		private double commissionPct; // 직원 커미션
		private int managerId; // 해당 직원의 상사 아이디
		private int departmentId; // 해당 직원이 속한 부서의 아이디
		
		public Builder id(int id) {
			this.id = id;
			return this;
		}
		public Builder firstName(String firstName) {
			this.firstName = firstName;
			return this;
		}
		public Builder lastName(String lastName) {
			this.lastName = lastName;
			return this;
		}
		public Builder email(String email) {
			this.email = email;
			return this;
		}
		public Builder phoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
			return this;
		}
		public Builder hireDate(Date hireDate) {
			this.hireDate = hireDate;
			return this;
		}
		public Builder jobId(String jobId) {
			this.jobId = jobId;
			return this;
		}
		public Builder salary(double salary) {
			this.salary = salary;
			return this;
		}
		public Builder commissionPct(double commissionPct) {
			this.commissionPct = commissionPct;
			return this;
		}
		public Builder managerId(int managerId) {
			this.managerId = managerId;
			return this;
		}
		public Builder departmentId(int departmentId) {
			this.departmentId = departmentId;
			return this;
		}
		public Emp build() {
			Emp emp = new Emp(id, firstName, lastName, email, phoneNumber,
					hireDate, jobId, salary, commissionPct, managerId, departmentId);
			return emp;
		}
	}
}
