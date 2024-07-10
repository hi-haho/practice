package pack;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class Main {
	public static void main(String[] args) {
		// join
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		EntityManager em = emf.createEntityManager();
		try {
			// jpql 사용
			//String jpql = "select j.jikwonNo,j.jikwonName,b.buserName,SUBSTRING(j.jikwonIsail,1,4) "
			String jpql = "select j.jikwonNo,j.jikwonName,b.buserName,j.jikwonIsail "
					+ "from Jikwon j join j.buser b";
			// select jikwon0_.jikwon_no as col_0_0_, jikwon0_.jikwon_name as col_1_0_,
			// buser1_.buser_name as col_2_0_, jikwon0_.jikwon_ibsail as col_3_0_ from
			// jikwon jikwon0_ inner join buser buser1_ on
			// jikwon0_.buser_num=buser1_.buser_no
			TypedQuery<Object[]> query = em.createQuery(jpql, Object[].class);
			List<Object[]> results = query.getResultList();

			//results.forEach(res -> System.out.println(res[0] + "\t" + res[1] + "\t" + res[2] + "\t" + res[3]));

			results.forEach(res -> {
				int year = getYearMy((Date)res[3]);
				System.out.println(res[0] + "\t" + res[1] + "\t" + res[2] + "\t" + year);
			});

			// native SQL 사용
			System.out.println("--------");
			String sql = "select jikwon_no,jikwon_name,buser_name,year(jikwon_ibsail) from jikwon j join buser b"
					+ " on j.buser_num = b.buser_no";
			Query query2 = em.createNativeQuery(sql);

			List<Object[]> results2 = query2.getResultList();
			results2.forEach(res -> System.out.println(res[0] + "\t" + res[1] + "\t" + res[2] + "\t" + res[3]));

			// jpql 사용하면 더 빠를 처리가 가능하다. native를 사용하면 jpa의 장점(벤더사 변환시 해당 쿼리문를 수정하지 않아도 된다.)을
			// 가져가지 못한다.

		} catch (Exception e) {
			System.out.println(" main err: " + e.getMessage());
		} finally {
			em.close();
			emf.close();
		}
	}

	private static int getYearMy(Date date) {
		Calendar calendar = Calendar.getInstance(); //자체적 싱글톤
		calendar.setTime(date);
		return calendar.get(calendar.YEAR);
	}

}
