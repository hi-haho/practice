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
	public List<MemDto> selectDataAll() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello"); //persistence.xml을 인식함(persistence-unit name과 같다)
		EntityManager em = emf.createEntityManager(); //엔티티의 생명주기를 관리. CRUD를 수행 //내부적 thread를 사용한다.
		EntityTransaction tx = em.getTransaction(); //트랜잭션을 관리하는 interface이다.
		List<MemDto> list = null;
		
		System.out.println("====== 전체 자료 읽기 ====== ");
		list = findAll(em, MemDto.class);
		list.forEach(m -> System.out.println(m.getNum()+" "+m.getName()+" "+m.getAddr()));
		return list;
	}
	
	public<T> List<T> findAll(EntityManager em,Class<T> cla){
		return em.createQuery("select e from " + cla.getName() + " e",cla).getResultList();
		//"select e from " jpql
		//cla.getName() : pack.model.DataDto
		//cla.getSimpleName() : DataDto (해당 객체 네임(MemDto)이 사용된다.)
		//전체 페키지명을 사용해야한다.
	}
}
