package pack.model;

import java.util.List;

public interface JikwonInter {
	List<JikwonDto> selectAll();
	List<JikwonDto> groupBuser();
	List<JikwonDto> topBuserPay();
}
