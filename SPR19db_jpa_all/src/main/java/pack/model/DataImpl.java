package pack.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;//jpa 표준안의 구현체인 hibernate, 추후에 배울 spring data jpa엔 안해도된다. + 
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

@Repository
public class DataImpl implements DataInterface {
	
	
	@Override
	public List<MemDto> selectDataAll() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello"); //persistence.xml을 인식함(persistence-unit name과 같다)
		EntityManager em = emf.createEntityManager(); //엔티티의 생명주기를 관리. CRUD를 수행 //내부적 thread를 사용한다.
		EntityTransaction tx = em.getTransaction(); //트랜잭션을 관리하는 interface이다.
		List<MemDto> list = null;
		
		try {
			/*
			System.out.println("====== 레코드 추가 ====== ");
			tx.begin();
			MemDto dto1 = new MemDto();
			dto1.setNum(4);
			dto1.setName("신형만");
			dto1.setAddr("떡잎마을 빨간 주택");
			em.persist(dto1); //persist = insert
			tx.commit();
			
			//Hibernate:/ insert pack.model.MemDto / (insert는 1개씩만 가능! 즉, return값은 0아니면 1)
			//실제 sql 처리 : insert into mem (addr, name, num) values (?, ?, ?)
			*/
			/*
			System.out.println("====== 레코드 수정 ====== ");
			tx.begin();
			MemDto dto2 = em.find(MemDto.class, 4); //대상을 읽음
			dto2.setName("신짱구"); //바꾸고 싶은 것만 변경
			tx.commit();
			
			//Hibernate: select memdto0_.num as num1_0_0_, memdto0_.addr as addr2_0_0_, memdto0_.name as name3_0_0_ from mem memdto0_ where memdto0_.num=?
			//Hibernate: / update pack.model.MemDto / update mem set addr=?, name=? where num=?
			*/
			/*
			System.out.println("====== 레코드 삭제 ====== ");
			tx.begin();
			MemDto dto2 = em.find(MemDto.class, 4); //대상을 읽음
			em.remove(dto2);;
			tx.commit();
			*/
			
			System.out.println("====== 부분 자료 읽기( 복수 entity : like .. ) ====== ");
			
			List<MemDto> listpart = findByAddr(em, "강남");
			listpart.forEach(m -> System.out.println(m.getNum()+" "+m.getName()+" "+m.getAddr()));
			// SELECT m FROM MemDto m WHERE m.addr LIKE :ss
			//select memdto0_.num as num1_0_, memdto0_.addr as addr2_0_, memdto0_.name as name3_0_ from mem memdto0_ where memdto0_.addr like ?
			
			System.out.println("\n====== 단일 자료 읽기 find()====== ");
			//public find(Class<T> entityClass, Object pk)
			MemDto mdto = em.find(MemDto.class, 2);
			System.out.println(mdto.getNum()+" "+mdto.getName()+" "+mdto.getAddr());
			
			System.out.println("====== 전체 자료 읽기 (jpql)====== ");
			//찍어보기
			//list = findAll(em, MemDto.class);
			//list.forEach(m -> System.out.println(m.getNum()+" "+m.getName()+" "+m.getAddr()));
			
			list = em.createQuery("select e from MemDto as e",MemDto.class).getResultList();
			
			
		} catch (Exception e) {
			tx.rollback();
			System.out.println("selectDataAll err: " + e.getMessage());
		}finally {
			em.close();
			emf.close();
			//모두 종료되면 응용프로그램도 종료된다.
		}
		
		return list;
	}
	
	public List<MemDto> findByAddr(EntityManager em,String ss){
		//addr 필드가 특정 접두사로 시작하는 레코드 읽기
		String jpql = "SELECT m FROM MemDto m WHERE m.addr LIKE :ss";//addr이 ss로 시작
		TypedQuery<MemDto> query = em.createQuery(jpql,MemDto.class);
		//TypedQuery<entity> query = em.createQuery(jpql,entity클래스)
		//jpql을 작성하고 실행하는 역할
		query.setParameter("ss",ss+"%");// sql의 list 연산 검색문자 % 수행		
		return query.getResultList();
	}
	
	public<T> List<T> findAll(EntityManager em,Class<T> cla){
		return em.createQuery("select e from " + cla.getSimpleName() + " e",cla).getResultList();
	}
}
