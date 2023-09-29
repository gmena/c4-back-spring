package connectfour;

import connectfour.controller.ConnectFourController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ConnectFourApplicationTests {

	@Autowired
	private ConnectFourController connectFourController;

	@Test
	void contextLoads() {
		assertThat(connectFourController).isNotNull();
	}
}
