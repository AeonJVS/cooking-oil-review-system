package cookingOilReviewSystem.Project.tests;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import cookingOilReviewSystem.Project.domain.Oil;
import cookingOilReviewSystem.Project.domain.OilRepository;
import cookingOilReviewSystem.Project.domain.OilType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


//@RunWith(SpringRunner.class)  //JUnit4
@ExtendWith(SpringExtension.class)  // JUnit5 || Jupiter
@DataJpaTest
public class OilRepositoryTest {

    @Autowired
    private OilRepository oilrepository;

    @Test
    public void findByTitleShouldReturnCookingOil() {
        List<Oil> oils = oilrepository.findByName("Gran Fruttato");
        
        assertThat(oils).hasSize(1);
        assertThat(oils.get(0).getName()).isEqualTo("Gran Fruttato");
    }
    
    @Test
    public void createSearchAndDeleteNewCookingOil() {
    	// create and save a new cooking oil
    	Oil oil = new Oil("nimi", "Rigolli", 450, "Greece", 4.5, "Tastes good", null);
    	oilrepository.save(oil);
    	assertThat(oil.getId()).isNotNull();
    	
    	// search for the new cooking oil by its id
      	Long oilId = oil.getId();
    	assertThat(oilrepository.findById(oilId)).isNotNull();
    	
    	// delete after successful previous tests
    	oilrepository.deleteById(oilId);
    	assertThat(oilrepository.findById(oilId).isEmpty());
    }
}