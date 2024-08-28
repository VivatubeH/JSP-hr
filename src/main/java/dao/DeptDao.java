package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.startup.RealmRuleSet;

import utils.ConnectionUtils;
import vo.Dept;
import vo.DeptDetail;
import vo.DeptList;

public class DeptDao {

	/**
	 * 모든 부서 목록을 반환한다.
	 * @return 모든 부서 목록
	 * @throws SQLException
	 */
	public List<DeptList> getAllDeptLists() throws SQLException {
		List<DeptList> deptlists = new ArrayList<DeptList>();
		String sql = """
				select department_id
					, department_name
					, first_name
					, city
					, cnt
				from dept_detail_view
				order by department_id asc
				""";
		Connection con = ConnectionUtils.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			DeptList deptlist = new DeptList();
			deptlist.setId(rs.getInt("department_id"));
			deptlist.setDepartmentName(rs.getString("department_name"));
			deptlist.setManagerName(rs.getString("first_name"));
			deptlist.setCity(rs.getString("city"));
			deptlist.setCnt(rs.getInt("cnt"));
			deptlists.add(deptlist);
		}
		rs.close();
		pstmt.close();
		con.close();
		
		return deptlists;
	}
	
	/**
	 * 부서 아이디를 전달받아서 해당 부서의 상세정보를 반환한다.
	 * @param deptId
	 * @return 해당 부서의 상세정보
	 * @throws SQLException
	 */
	public DeptDetail getDeptDetail(int deptId) throws SQLException {
		String sql = """
				select department_id
					, department_name
				    , manager_id
				    , first_name
				    , city
				    , country_name
				from dept_detail_view
				where 
					department_id = ?
				""";
		Connection con = ConnectionUtils.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, deptId);
		ResultSet rs = pstmt.executeQuery();
		DeptDetail deptDetail = null;
		while(rs.next()) {
			deptDetail = new DeptDetail();
			
			deptDetail.setDepartmentId(rs.getInt("department_id"));
			deptDetail.setDepartmentName(rs.getString("department_name"));
			deptDetail.setManagerId(rs.getInt("manager_id"));
			deptDetail.setManagerName(rs.getString("first_name"));
			deptDetail.setCity(rs.getString("city"));
			deptDetail.setCountryName(rs.getString("country_name"));
		}
		rs.close();
		pstmt.close();
		con.close();
		
		return deptDetail;
	}
	
	/**
	 * 부서 아이디를 전달받아서 부서 정보를 반환한다.
	 * @param deptId 부서 아이디
	 * @return 부서 정보 
	 * @throws SQLException
	 */
	public Dept getDeptByDeptId(int deptId) throws SQLException {
		String sql = """
			select *
			from departments
			where department_id = ? 
		""";
		Connection con = ConnectionUtils.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, deptId);
		ResultSet rs = pstmt.executeQuery();
		
		Dept dept = null;
		
		while(rs.next()) {
			dept = new Dept();
			dept.setDepartmentId(rs.getInt("department_id"));
			dept.setDepartmentName(rs.getString("department_name"));
			dept.setManagerId(rs.getInt("manager_id"));
			dept.setLocationId(rs.getInt("location_id"));
		}
		rs.close();
		pstmt.close();
		con.close();
		
		return dept;
	}

	/**
	 * 부서 정보를 전달해서 해당 부서 정보를 수정한다.
	 * @param dept 부서
	 * @throws SQLException
	 */
	public void updateDept(Dept dept) throws SQLException {
		String sql = """
				update departments
				set
					department_name = ?
					, manager_id = ?
					, location_id = ?
				where
					department_id = ?
			""";
		Connection con = ConnectionUtils.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, dept.getDepartmentName());
		pstmt.setInt(2, dept.getManagerId());
		pstmt.setInt(3, dept.getLocationId());
		pstmt.setInt(4, dept.getDepartmentId());
		pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
		
		return;
	}
	
	/**
	 * 부서 정보를 전달해서 부서를 DB에 등록시킨다.
	 * @param dept 부서정보
	 * @throws SQLException
	 */
	public void insertDept(Dept dept) throws SQLException {
		String sql = """
			INSERT INTO DEPARTMENTS
			(DEPARTMENT_ID, DEPARTMENT_NAME, MANAGER_ID, LOCATION_ID)
			VALUES
			(DEPARTMENTS_SEQ.NEXTVAL, ?, ?, ?)		
		""";	
	}
}
