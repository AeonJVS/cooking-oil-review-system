package cookingOilReviewSystem.Project.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface OilRepository extends CrudRepository<Oil, Long> {
	List<Oil> findByName(String name);
}