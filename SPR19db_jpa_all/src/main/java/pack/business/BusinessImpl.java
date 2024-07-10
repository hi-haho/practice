package pack.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pack.model.DataInterface;
import pack.model.MemDto;

@Service
public class BusinessImpl implements BusinessInterface {

	@Autowired
	private DataInterface dataInterface;
	@Override
	public void dataPrint() {
		List<MemDto> mlist = dataInterface.selectDataAll();
		System.out.println("=== mlist ===");
		mlist.forEach(m -> System.out.println(m.getNum()+" "+m.getName()+" "+m.getAddr()));
	}

}
