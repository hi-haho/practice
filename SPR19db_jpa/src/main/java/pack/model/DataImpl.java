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
		
		System.out.println("====== 전체 자료 읽기 (jpql)====== ");
		//찍어보기
		//list = findAll(em, MemDto.class);
		//list.forEach(m -> System.out.println(m.getNum()+" "+m.getName()+" "+m.getAddr()));
		
		list = em.createQuery("select e from MemDto as e",MemDto.class).getResultList();
		//"select e from MemDto as e" -> RDBMS의 종류에 관계없이 공통적으로 사용, persistence.xml의 dialect에 맞춰 sql문 변환
		//jpql을 사용하면 논리적 테이블 명을 사용한다. 별명은 상관없다. 아규먼트에 클래스(class)를 적어줘야한다.
		//Hibernate: /* select e from MemDto as e */ select memdto0_.num as num1_0_, memdto0_.addr as addr2_0_, memdto0_.name as name3_0_ from mem memdto0_
		//우리가 적은 것과 달리 바로 위의 코드로 실행이된다 (어느 벤드사의 RDBMS에 돌아간다.)
		return list;
	}
	
	public<T> List<T> findAll(EntityManager em,Class<T> cla){
		return em.createQuery("select e from " + cla.getSimpleName() + " e",cla).getResultList();
		//"select e from " jpql
		//cla.getName() : pack.model.DataDto
		//cla.getSimpleName() : DataDto (해당 객체 네임(MemDto)이 사용된다.)
		//전체 페키지명을 사용해야한다.
	}
}
