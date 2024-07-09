package pack.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import pack.mybatis.SqlMapConfig;

@Repository
public class jikwonImpl implements JikwonInter {
	
	private SqlSessionFactory factory = SqlMapConfig.getSqlSession();
	
	@Override
	public List<JikwonDto> selectAll() {
		SqlSession session = factory.openSession();
		List<JikwonDto> list = null;
		try {
			SqlMapperInter mapperInter = (SqlMapperInter)session.getMapper(SqlMapperInter.class);
			list = mapperInter.selectAll();
		} catch (Exception e) {
			System.out.println("selectDataAll err : " + e.getMessage());
		} finally {
			if(session != null) session.close();
		}
		return list;
	}

	@Override
	public List<JikwonDto> groupBuser() {
		SqlSession session = factory.openSession();
		List<JikwonDto> list = null;
		try {
			
			SqlMapperInter mapperInter = (SqlMapperInter)session.getMapper(SqlMapperInter.class);
			list = mapperInter.groupBuser();
		} catch (Exception e) {
			System.out.println("selectDataAll err : " + e.getMessage());
		} finally {
			if(session != null) session.close();
		}
		return list;
	}

	@Override
	public List<JikwonDto> topBuserPay() {
		SqlSession session = factory.openSession();
		List<JikwonDto> list = null;
		try {
			
			SqlMapperInter mapperInter = (SqlMapperInter)session.getMapper(SqlMapperInter.class);
			list = mapperInter.topBuserPay();
		} catch (Exception e) {
			System.out.println("selectDataAll err : " + e.getMessage());
		} finally {
			if(session != null) session.close();
		}
		return list;
	}

}
