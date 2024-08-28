package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import utils.ConnectionUtils;
import vo.Job;

public class JobDao {

	/**
	 * 모든 직종 목록들을 반환하는 메소드
	 * @return 모든 직종 목록
	 * @throws SQLException
	 */
	public List<Job> getAllJobLists() throws SQLException {
		List<Job> jobs = new ArrayList<Job>();
		String sql = """
			select job_id
				    , job_title
				    , min_salary
				    , max_salary
			from jobs
			order by job_id asc
			""";
		Connection con = ConnectionUtils.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			Job job = new Job();
			job.setJobId(rs.getString("job_id"));
			job.setJobTitle(rs.getString("job_title"));
			job.setMinSalary(rs.getInt("min_salary"));
			job.setMaxSalary(rs.getInt("max_salary"));
			jobs.add(job);
		}
		rs.close();
		pstmt.close();
		con.close();
		
		return jobs;
	} 
}
