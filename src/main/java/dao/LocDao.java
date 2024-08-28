package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import utils.ConnectionUtils;
import vo.Loc;

public class LocDao {

	/**
	 * 모든 소재지 목록을 반환하는 메소드
	 * @return 모든 소재지 목록
	 * @throws SQLException
	 */
	public List<Loc> getAllLocations() throws SQLException {
		List<Loc> locs = new ArrayList<Loc>();
		String sql = """
				select *
				from locations
				order by location_id asc
				""";
		Connection con = ConnectionUtils.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			Loc loc = Loc.builder()
				.locationId(rs.getInt("location_id"))
				.address(rs.getString("street_address"))
				.postalCode(rs.getString("postal_code"))
				.city(rs.getString("city"))
				.stateProvince(rs.getString("state_province"))
				.countryId(rs.getString("country_id"))
				.build();
			locs.add(loc);
		}
		rs.close();
		pstmt.close();
		con.close();
		
		return locs;
	}
}
