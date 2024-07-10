package pack.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity //실제 db랑 연동
@Table(name="jikwon")
public class JikwonDto {
	@Id
	private int jikwon_no;
	@Column(nullable = true)
	private String jikwon_name; //마찬가지로 이름이 DB 칼럼명과 다르면 카멜표기법으로 사용하면 자동 스네이크로 바뀐다.
	@Column
	private String buser_num;
	@Column
	private String jikwon_ibsail;
}