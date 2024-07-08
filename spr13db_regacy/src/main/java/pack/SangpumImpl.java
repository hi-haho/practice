package pack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

@Repository // 모델 이라는거지, 핵심 로직을 짜겠지
public class SangpumImpl implements SangpumInter {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public SangpumImpl() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (Exception e) {
			System.out.println("driver loadding err: " + e.getMessage());
		}
	}

	@Override
	public ArrayList<SangpumDto> selectAll() {
		ArrayList<SangpumDto> list = new ArrayList<SangpumDto>();
		try {
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/test","root","123");
			String sql = "select * from sangdata";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				SangpumDto dto = new SangpumDto(); //초기화
				dto.setCode(rs.getString("code"));
				dto.setSang(rs.getString("sang"));
				dto.setSu(rs.getString("su"));
				dto.setDan(rs.getString("dan"));
				list.add(dto);
			}
		} catch (Exception e) {
			System.out.println("selectAll err: " + e.getMessage());
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				System.out.println("close err: " + e2.getMessage());
			}
		}
		return list;
	}

}
