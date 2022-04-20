package cookingOilReviewSystem.Project.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface OilTypeRepository extends CrudRepository<OilType, Long> {
	 List<OilType> findByName(String name);
}