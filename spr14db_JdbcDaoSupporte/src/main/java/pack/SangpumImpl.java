package pack;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class SangpumImpl extends JdbcDaoSupport implements SangpumInter {
/*
  JdbcDaoSupport 클래스는 Spring 프레임워크에서 제공하는 추상 클래스로,
  데이터베이스와 상호 작용하는 DAO를 개발할 때 편리한 기능을 제공합니다.
  이 클래스는 JdbcTemplate을 사용하여 데이터베이스 작업을 처리하고,
  템플릿 메소드 패턴을 활용하여 일반적인 데이터 액세스 작업을 구현합니다.
  JdbcDaoSupport의 멤버 메소드에는 getJdbcTemplate('da가져오기'),setDataSource('연결정보')가 있다.
 */
	
	@Override //db가져오는것을 만들었음 (연결정보 x)
	public ArrayList<SangpumDto> selectAll() {
		RowMapper rowMapper = new SangpumRowMapper(); //List 형식 반환
		
		return (ArrayList)getJdbcTemplate().query("select * from sangdata", rowMapper); //Return the JdbcTemplate for this DAO,pre-initialized with the DataSource or set explicitly.
	}
	
	//내부 클래스
	class SangpumRowMapper implements RowMapper{ // The type SangpumImpl.SangpumRowMapper must implement the inherited abstract method RowMapper.mapRow(ResultSet, int)
		@Override
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			//내부적으로 실행된 PreparedStatement에 의해 select의 실행결과가 mapRow로 전달. rs.next()를 쓸 필요없다.(PreparedStatement도)
			//System.out.println("rowNum: "+rowNum);
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
