package pack;

import org.springframework.stereotype.Repository;

@Repository //DB와 연결해서 처리하는 model영역의 클래스임을 선언 (+compnent가 포함)
public class ArticleDao implements ArticleInter {

	@Override
	public void selectAll() {
		System.out.println("테이블 자료 읽기");
	}

}
