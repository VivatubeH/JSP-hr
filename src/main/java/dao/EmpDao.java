package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import utils.ConnectionUtils;
import vo.Emp;
import vo.EmpSalary;

public class EmpDao {

	/**
	 * 부서 아이디를 통해 해당 부서에 속한 모든 직원 목록을 조회한다.
	 * @param deptId 부서 아이디
	 * @return 부서에 속한 모든 직원 목록
	 * @throws SQLException
	 */
	public List<Emp> getEmployeesByDeptId(int deptId) throws SQLException {
		List<Emp> emps = new ArrayList<Emp>();
		String sql = """
				select *
				from employees
				where department_id = ?
				order by employee_id asc
			""";
		Connection con = ConnectionUtils.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, deptId);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			Emp emp = new Emp();
			emp.setId(rs.getInt("employee_id"));
			emp.setFirstName(rs.getString("first_name"));
			emp.setLastName(rs.getString("last_name"));
			emp.setEmail(rs.getString("email"));
			emp.setPhoneNumber(rs.getString("phone_number"));
			emp.setHireDate(rs.getDate("hire_date"));
			emp.setJobId(rs.getString("job_id"));
			emp.setSalary(rs.getDouble("salary"));
			emp.setCommissionPct(rs.getDouble("commission_pct"));
			emp.setManagerId(rs.getInt("manager_id"));
			emp.setDepartmentId(rs.getInt("department_id"));
			emps.add(emp);
		}
		rs.close();
		pstmt.close();
		con.close();
		
		return emps;
	}
	
	/**
	 * 모든 직원 정보를 조회해서 목록을 반환한다.
	 * @return 모든 직원 정보
	 * @throws SQLException
	 */
	public List<Emp> getAllEmployees() throws SQLException {
		List<Emp> emps = new ArrayList<Emp>();
		String sql = """
				select *
				from employees
				order by employee_id asc
				""";
		Connection con = ConnectionUtils.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			Emp emp = Emp.builder()
			.id(rs.getInt("employee_id"))
			.firstName(rs.getString("first_name"))
			.lastName(rs.getString("last_name"))
			.email(rs.getString("email"))
			.phoneNumber(rs.getString("phone_number"))
			.hireDate(rs.getDate("hire_date"))
			.jobId(rs.getString("job_id"))
			.salary(rs.getDouble("salary"))
			.commissionPct(rs.getDouble("commission_pct"))
			.managerId(rs.getInt("manager_id"))
			.departmentId(rs.getInt("department_id"))
			.build();
			emps.add(emp);
		}
		rs.close();
		pstmt.close();
		con.close();
		
		return emps;
	}
	
	/**
	 * 직원 아이디를 전달받아서 직원 정보가 담긴 객체를 반환한다.
	 * @param id 직원 아이디
	 * @return 직원 정보가 담긴 객체
	 * @throws SQLException
	 */
	public Emp getEmp(int id) throws SQLException {
		String sql = """
			select employee_id
			    , first_name
			    , last_name
			    , email
			    , phone_number
			    , hire_date
			    , job_id
			    , salary
			    , commission_pct
			    , manager_id
			    , department_id
			from employees
			where employee_id = ?
		""";
		Connection con = ConnectionUtils.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, id);
		ResultSet rs = pstmt.executeQuery();
		
		Emp emp = null;
		
		while(rs.next()) {
			emp = new Emp();
			emp.setId(rs.getInt("employee_id"));
			emp.setFirstName(rs.getString("first_name"));
			emp.setLastName(rs.getString("last_name"));
			emp.setEmail(rs.getString("email"));
			emp.setPhoneNumber(rs.getString("phone_number"));
			emp.setHireDate(rs.getDate("hire_date"));
			emp.setJobId(rs.getString("job_id"));
			emp.setSalary(rs.getDouble("salary"));
			emp.setCommissionPct(rs.getDouble("commission_pct"));
			emp.setManagerId(rs.getInt("manager_id"));
			emp.setDepartmentId(rs.getInt("department_id"));
		}
		rs.close();
		pstmt.close();
		con.close();
		
		return emp;
	}
	
	/**
	 * 직원 아이디를 바탕으로 직원의 급여 관련 정보를 조회한다.
	 * @param empId 직원 아이디
	 * @return 직원의 급여 정보가 담긴 객체
	 * @throws SQLException
	 */
	public EmpSalary getEmpSalaryByEmpId(int empId) throws SQLException {
		String sql = """
				select employee_id
				    , salary
				    , commission_pct
				    , salary*12 annual_salary
				    , sal_grade
				from employees e, salary_grades g
				where
				e.employee_id = ?
				and
				e.salary between g.min_salary and g.max_salary
			""";
		Connection con = ConnectionUtils.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, empId);
		ResultSet rs = pstmt.executeQuery();
		EmpSalary empSalary = null;
		
		while(rs.next()) {
			empSalary = new EmpSalary();
			empSalary.setId(rs.getInt("employee_id"));
			empSalary.setSalary(rs.getDouble("salary"));
			empSalary.setCommissionPct(rs.getDouble("commission_pct"));
			empSalary.setAnnualSalary(rs.getDouble("annual_salary"));
			empSalary.setSalgrade(rs.getString("sal_grade"));
		}
		rs.close();
		pstmt.close();
		con.close();
		
		return empSalary;
	}
}
