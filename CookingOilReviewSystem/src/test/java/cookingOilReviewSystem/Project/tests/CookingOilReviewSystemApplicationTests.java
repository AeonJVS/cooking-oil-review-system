package cookingOilReviewSystem.Project.tests;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import cookingOilReviewSystem.Project.web.OilController;
import cookingOilReviewSystem.Project.web.OilTypeController;


//@RunWith(SpringRunner.class) // JUnit4
@ExtendWith(SpringExtension.class)   // JUnit5 == Jupiter
@SpringBootTest
public class CookingOilReviewSystemApplicationTests {

	@Autowired
	private OilController oilController;
	
	@Autowired
	private OilTypeController oilTypeController;
	
	@Test
	public void contextLoads() {
		assertThat(oilController).isNotNull();
		assertThat(oilTypeController).isNotNull();
	}

}
