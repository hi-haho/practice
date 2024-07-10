package pack.model;

import java.util.List;

import org.apache.ibatis.annotations.Select;

public interface SqlMapperInter {
	@Select("select * from jikwon j inner join buser b on j.buser_num=b.buser_no")
	List<JikwonDto> selectAll();
	@Select("select buser_name ,count(*) as jikwon_count from jikwon j inner join buser b on j.buser_num=b.buser_no group by buser_num")
	List<Object[]> groupBuser();
	@Select("select buser_name,jikwon_pay,jikwon_name from jikwon j inner join buser b on j.buser_num=b.buser_no where jikwon_pay = (select max(jikwon_pay) from jikwon where buser_num = buser_no group by buser_num)")
	List<Object[]> topBuserPay();
	
	
	/* SELECT buser_name, jikwon_name, jikwon_pay FROM jikwon inner join buser on buser_num = buser_no (SELECT buser_num, MAX(jikwon_pay) maxpay FROM jikwon GROUP BY buser_num) T1 WHERE jikwon.buser_num = T1.buser_num AND jikwon_pay = T1.maxpay")
	
	 SELECT buser_name, jikwon_name, jikwon_pay FROM jikwon AS j INNER JOIN buser AS b ON j.buser_num = b.buser_no WHERE jikwon_pay IN (SELECT MAX(jikwon_pay) FROM jikwon WHERE buser_num = buser_no GROUP BY buser_num) ORDER BY buser_name
	 
	 select buser_name as '부서별',jikwon_pay,jikwon_name from jikwon j inner join buser b on j.buser_num=b.buser_no where jikwon_pay = (select max(jikwon_pay) from jikwon where buser_num = buser_no group by buser_num)
	*/
	

/*
@Select("select count(*) from jikwon where buser_num = #{buser_num}")
int buserCount(String buser_num);

이렇게 값을 받아서 넣을 수 있다.
 */
}
