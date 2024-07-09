package pack.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import pack.mybatis.SqlMapConfig;

@Repository
public class SangpumImpl implements SangpumInter {
	
	private SqlSessionFactory factory = SqlMapConfig.getSqlSession();
	
	@Override
	public List<SangpumDto> selectDataAll() {
		SqlSession sqlSession = factory.openSession();
		List<SangpumDto> list = null;
		try {
			//sql 어노테이션을 적용한 부분
			SqlMapperInter mapperInter = (SqlMapperInter)sqlSession.getMapper(SqlMapperInter.class);
			list = mapperInter.selectDataAll();
		} catch (Exception e) {
			System.out.println("selectDataAll err : " + e.getMessage());
		} finally {
			if(sqlSession != null) sqlSession.close();
		}
		return list;
	}
}
