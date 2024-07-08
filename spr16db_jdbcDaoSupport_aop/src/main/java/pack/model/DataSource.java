package pack.model;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;
//DriverManagerDataSource : init에서 써야하는 dataSource를 클래스로 만드는 것
@Component //anno 쓰려고
public class DataSource extends DriverManagerDataSource{
	public DataSource() {
		setDriverClassName("org.mariadb.jdbc.Driver");
		setUrl("jdbc:mariadb://localhost:3306/test");
		setUsername("root");
		setPassword("123");
	}
}
