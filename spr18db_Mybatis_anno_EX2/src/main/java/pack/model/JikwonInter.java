package pack.model;

import java.util.List;

public interface JikwonInter {
	List<JikwonDto> selectAll();
	List<Object[]> groupBuser();
	List<Object[]> topBuserPay();
}
