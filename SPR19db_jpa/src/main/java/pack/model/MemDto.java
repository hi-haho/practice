package pack.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder //arg가 없고, 있는 생성자를 필요로한다.
//--↑ lombok   ↓ hibernate ----------
@Entity(name = "mem") //DB의 특정 테이블과 mapping된다.
public class MemDto { //지정을 안해주면 hibernate가 MEM_DTO라고 알아듣는다(카멜케이스를 기준으로 _(언더스코어 네이밍 컨벤션, underScoer naming convention)를 자동으로 변환)

	@Id //pk칼럼에 붙인다. 마찬가지로 db와 칼럼명이 다르면 @column을 사용(name="")을 사용하자.
	private int num;
	@Column(name="name",nullable = true)
	private String name; //마찬가지로 이름이 DB 칼럼명과 다르면 카멜표기법으로 사용하면 자동 스네이크로 바뀐다.
	private String addr;
}
