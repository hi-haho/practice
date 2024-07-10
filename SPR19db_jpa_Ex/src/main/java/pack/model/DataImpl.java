package pack.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;//jpa 표준안의 구현체인 hibernate, 추후에 배울 spring data jpa엔 안해도된다. + 
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.stereotype.Repository;

@Repository
public class DataImpl implements DataInterface {
	
	
	@Override
	public List<JikwonDto> selectDataAll() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello"); //persistence.xml을 인식함(persistence-unit name과 같다)
		EntityManager em = emf.createEntityManager(); //엔티티의 생명주기를 관리. CRUD를 수행 //내부적 thread를 사용한다.
		List<JikwonDto> list = null;
		
		try {
			list = em.createQuery("select e from JikwonDto as e",JikwonDto.class).getResultList();
		} catch (Exception e) {
			System.out.println("selectDataAll err: " + e.getMessage());
		}finally {
			em.close();
			emf.close();
		}
		
		return list;
	}
	
	@Override
	public List<Object[]> buserCount() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		EntityManager em = emf.createEntityManager();
		List<Object[]> list = null;

		try {
			String jpql = "select e.buser_num, count(e) from JikwonDto as e group by e.buser_num";
			//여기에서 바로 별명줄수없다!
			list = em.createQuery(jpql,Object[].class).getResultList();
			
		} catch (Exception e) {
			System.out.println("buserCount err: " + e.getMessage());
		}finally {
			em.close();
			emf.close();
		}
		
		return list;
	}
	
	public<T> List<T> findAll(EntityManager em,Class<T> cla){
		return em.createQuery("select e from " + cla.getSimpleName() + " e",cla).getResultList();
	}
}
