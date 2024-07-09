package pack.model;

import java.util.List;

import org.springframework.dao.DataAccessException;

public interface JikwonInter {
	public JikwonDto selectOen(String gogek_num,String gogek_name) throws DataAccessException;
}
