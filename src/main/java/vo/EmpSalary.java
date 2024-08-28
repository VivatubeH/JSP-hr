package vo;

public class EmpSalary {

	private int id; // 직원 아이디
	private double salary; // 직원 급여
	private double commissionPct; // 직원 커미션
	private double annualSalary; // 직원 연봉
	private String salgrade; // 급여 등급
	
	public EmpSalary() {}
	
	public EmpSalary(int id, double salary, double commissionPct, double annualSalary, String salgrade) {
		super();
		this.id = id;
		this.salary = salary;
		this.commissionPct = commissionPct;
		this.annualSalary = annualSalary;
		this.salgrade = salgrade;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public double getAnnualSalary() {
		return annualSalary;
	}
	public void setAnnualSalary(double annualSalary) {
		this.annualSalary = annualSalary;
	}
	public String getSalgrade() {
		return salgrade;
	}
	public void setSalgrade(String salgrade) {
		this.salgrade = salgrade;
	}

	@Override
	public String toString() {
		return "EmpSalary [id=" + id + ", salary=" + salary + ", commissionPct=" + commissionPct + ", annualSalary="
				+ annualSalary + ", salgrade=" + salgrade + "]";
	}
	
	
}
