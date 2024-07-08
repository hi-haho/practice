package pack;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
@Repository
public class SangpumImpl extends JdbcDaoSupport implements SangpumInter {
	@Autowired
	public SangpumImpl(DataSource dataSource) {
		setDataSource(dataSource);
	}
	
	@Override //db가져오는것을 만들었음
	public ArrayList<SangpumDto> selectAll() {
		RowMapper rowMapper = new SangpumRowMapper(); //List 형식 반환
		
		return (ArrayList)getJdbcTemplate().query("select * from sangdata", rowMapper); //Return the JdbcTemplate for this DAO,pre-initialized with the DataSource or set explicitly.
	}
	
	//내부 클래스
	class SangpumRowMapper implements RowMapper{ // The type SangpumImpl.SangpumRowMapper must implement the inherited abstract method RowMapper.mapRow(ResultSet, int)
		@Override
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			//내부적으로 실행된 PreparedStatement에 의해 select의 실행결과가 mapRow로 전달. rs.next()를 쓸 필요없다.(PreparedStatement도)
			SangpumDto dto = new SangpumDto();
			dto.setCode(rs.getString("code"));
			dto.setSang(rs.getString("sang"));
			dto.setSu(rs.getString("su"));
			dto.setDan(rs.getString("dan"));
			return dto;
			//rowMapper에 의해 (레코드 자료가 소진될때까지) dto가 List 컬렉션에 저장.
		}
		
	}
}
