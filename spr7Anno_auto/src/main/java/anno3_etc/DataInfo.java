package anno3_etc;

import org.springframework.stereotype.Component;

@Component
public class DataInfo {
	private String name = "짱구";
	private String part = "주인공";
	public String job = "떡잎방범대";
	
	public String getName() {
		return name;
	}
	public String getPart() {
		return part;
	}
}
