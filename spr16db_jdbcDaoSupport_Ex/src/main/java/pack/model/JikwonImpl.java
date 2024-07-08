package pack.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import pack.model.JikwonImpl.JikwonMapper;
@Repository
public class JikwonImpl extends JdbcDaoSupport implements JikwonInter {
	@Autowired
	private DataSource dataSource; //JdbcDaoSupport
	@PostConstruct
	public void Jikwon() {
		setDataSource(dataSource);
	}
	
	@Override
	public List<JikwonDto> selectOen(String gogek_num, String gogek_name) throws DataAccessException {
		RowMapper mapper = new JikwonMapper();
		String sql = "select jikwon_gen,jikwon_name,jikwon_jik"
				+ " from jikwon inner join gogek"
				+ " on jikwon.jikwon_no = gogek.gogek_damsano"
				+ " where gogek_no="+gogek_num;
		
		return getJdbcTemplate().query(sql, mapper);
	}
	
	class JikwonMapper implements RowMapper{
		@Override
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new JikwonDto(){
				{ //무명클래스
					setJikwon_name(rs.getString("jikwon_name"));
					setJikwon_jik(rs.getString("jikwon_jik"));
					setJikwon_gen(rs.getString("jikwon_gen"));
				}
			};
		}
	}
	
}
